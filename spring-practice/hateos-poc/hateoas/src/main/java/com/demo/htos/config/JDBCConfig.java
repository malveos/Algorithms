package com.demo.htos.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
public class JDBCConfig {

	@Bean(name = "JdbcTemplateForDMSI")
	public JdbcTemplate oracleJdbcTemplates() {
		return new JdbcTemplate(getDataSource());
	}

	@Bean(name = "NamedJdbcTemplateForDMSI")
	public NamedParameterJdbcTemplate namedJdbcTemplates() {
		return new NamedParameterJdbcTemplate(getDataSource());
	}

	@Bean(name = "DMSDataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@172.16.157.15:1529:DMSiDEV1");
		dataSource.setUsername("qsn_user");
		dataSource.setPassword("dms0radev");
		return dataSource;
	}
}
