package com.hcl.cqrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@EnableDiscoveryClient
public class CommandSideApplication {
	private static final Logger LOG = LoggerFactory.getLogger(CommandSideApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CommandSideApplication.class, args);
		LOG.info("Starting the COMMAND-SIDE PCF Axon CQRS Demo using SpringBoot.");
	}

}
