package com.osm.OmkarSM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.osm.OmkarSM.batch.BatchProcessing;
import com.osm.OmkarSM.ee.ExecutorServiceImpl;
import com.osm.OmkarSM.scheduling.CustomSchedularConfigurer;

@RestController
public class Controller {

	@Autowired
	private BatchProcessing bpro;

	@Autowired
	private ExecutorServiceImpl mes;

	@Autowired
	private CustomSchedularConfigurer st;

	@Autowired
	@Qualifier("NamedJdbcTemplateForDMSI")
	private NamedParameterJdbcTemplate  namedJDBCTemplate;

	@RequestMapping(value = "/testjob", method = RequestMethod.GET)
	public ResponseEntity<String> getJobRun() {
		bpro.executeJob();
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}

	@GetMapping(value = "/chkNull")
	public ResponseEntity<String> checkNullable() {

		Map<String, Object> map = new HashMap<>();
		List<Integer> ls = new ArrayList<>();
		ls.add(1000);
		ls.add(1010);
		map.put("k", ls);
		int cct = namedJDBCTemplate.query("SELECT * FROM tx_vendor WHERE " + 
				" (COALESCE(:k, NULL) IS NULL OR CLIENT_KEY2TX_CLIENT IN (:k))",map , rse->{
					int ct =0 ;
					while(rse.next()) {
						ct+=1;
					}
					return ct;
				});

		map.put("k", null);
		int cct2 = namedJDBCTemplate.query("SELECT * FROM tx_vendor WHERE " + 
				" (COALESCE(:k, NULL) IS NULL OR CLIENT_KEY2TX_CLIENT IN (:k) )",map , rse->{
					int ct =0 ;
					while(rse.next()) {
						ct+=1;
					}
					return ct;
				});
		return new ResponseEntity<>("Success-"+cct+","+ cct2, HttpStatus.OK);
	}

	@RequestMapping(value = "/testapijob", method = RequestMethod.GET)
	public ResponseEntity<String> apiJob() {
		bpro.executeJob();
		return new ResponseEntity<>("Success_API", HttpStatus.OK);
	}

	@RequestMapping("/test/ee")
	public String eeMES() throws InterruptedException {
		mes.callExecutorService();
		return "Process finished";
	}

	@RequestMapping(value = "/get/cron", method = RequestMethod.POST)
	public String getCronExp(@RequestBody Map<String, Object> configMap) throws InterruptedException {
		return st.getCronExp(configMap) +"";
	}
}
