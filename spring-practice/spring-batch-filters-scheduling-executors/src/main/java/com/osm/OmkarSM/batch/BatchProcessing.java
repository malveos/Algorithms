package com.osm.OmkarSM.batch;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.osm.OmkarSM.domain.PersonDTO;

@Configuration
@EnableBatchProcessing
public class BatchProcessing {

	private static Logger logger = LoggerFactory.getLogger(BatchProcessing.class);

	@Autowired
	private JobBuilderFactory jobs;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private ApplicationContext appContext;

	@Autowired
	@Qualifier("DMSDataSource")
	protected DataSource DMSDataSource = null;

	@Bean
	public Job newJob() {
		return this.jobs.get("newJob")
				// .listener(protocolListener()) // this will be as AOP
				.incrementer(new RunIdIncrementer()) // This will change the job parameter.
				.start(step()).build();
	}

	@Bean
	public Step step() {
		return this.stepBuilderFactory.get("step").<PersonDTO, PersonDTO>chunk(1) // This will be small batch to process
				.reader(reader()) // Extraction
				.processor(processor()) // Transaction
				.writer(writer()) // Loading
				// .listener(logProcessListener())// this will be as AOP
				.faultTolerant()
				// .skipLimit(10) // default is set to 0
				.build();
	}

	@Bean
	public ItemReader<PersonDTO> reader() {
		FlatFileItemReader<PersonDTO> reader = new FlatFileItemReader<PersonDTO>();
		reader.setLinesToSkip(0); // first line is title definition
		reader.setResource(new ClassPathResource("samplePersonsToRead.txt"));
		reader.setLineMapper(lineMapper());
		return reader;
	}

	@Bean
	public LineMapper<PersonDTO> lineMapper() {
		DefaultLineMapper<PersonDTO> lineMapper = new DefaultLineMapper<PersonDTO>();

		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(";");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(new String[] {"NAME" });

		BeanWrapperFieldSetMapper<PersonDTO> fieldSetMapper = new BeanWrapperFieldSetMapper<PersonDTO>();
		fieldSetMapper.setTargetType(PersonDTO.class);

		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(PersonFieldSetMapper());
		return lineMapper;
	}

	@Bean
	public PersonFieldSetMapper PersonFieldSetMapper() {
		return new PersonFieldSetMapper();
	}

	/** configure the processor related stuff */
	@Bean
	public ItemProcessor<PersonDTO, PersonDTO> processor() {
		return new PersonItemProcessor();
	}

	@Bean
	public ItemWriter<PersonDTO> writer() {
		return new Writer();
	}

	private JobRepository getJobRepository() throws Exception {
		JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
		factory.setDataSource(DMSDataSource);
		factory.setTransactionManager(getTransactionManager());
		factory.afterPropertiesSet();
		return (JobRepository) factory.getObject();
	}

	private PlatformTransactionManager getTransactionManager() {
		return new ResourcelessTransactionManager();
	}

	public JobLauncher getJobLauncher() throws Exception {
		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
		jobLauncher.setJobRepository(getJobRepository());
		jobLauncher.afterPropertiesSet();
		return jobLauncher;
	}

	public void executeJob() {
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		Marker marker  = null;
		//Logger logger = null;
		if (stacktrace[2].getMethodName().contains("JobRun")) {
			marker = MarkerFactory.getMarker("SCHEDULE");
			//logger = LoggerFactory.getLogger("SCH");
		} else if (stacktrace[2].getMethodName().contains("apiJob")) {
			marker = MarkerFactory.getMarker("API");
			//logger = LoggerFactory.getLogger("API");
		}
		try {
			logger.info(marker, "This is schedule");
			logger.info(marker, "Getting a job instance");
			//logger.API("Getting a job instance");
			JobLauncher jobLauncher = getJobLauncher();
			Job job = (Job) appContext.getBean("newJob");

			logger.info(marker, "Starting the batch job");

			JobParametersBuilder jobBuilder = new JobParametersBuilder();
			jobBuilder.addString("time", System.currentTimeMillis() + "");
			JobParameters jobParameters = jobBuilder.toJobParameters();
			logger.info(marker, "jobParameters:" + jobParameters);

			JobExecution execution = jobLauncher.run(job, jobParameters);

			logger.info(marker, "Job Status : " + execution.getStatus());
			logger.info(marker, "Job completed");

			logger.info("NO marker");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(marker, "Job failed");
		}
	}
}
