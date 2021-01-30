package com.osm.OmkarSM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling
@ComponentScan("com.osm.OmkarSM")
public class OmkarSmApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmkarSmApplication.class, args);
	}

}
