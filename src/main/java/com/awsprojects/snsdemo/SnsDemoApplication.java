package com.awsprojects.snsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Demo API to subscribe / publish news-letters / blogs
 *
 * Uses AWS SNS feature to notify and publish the end use regarding subscription over email Id
 *
 * More information about <a href="https://aws.amazon.com/sns/features/">SNS</a>
 *
 * */
@SpringBootApplication
public class SnsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnsDemoApplication.class, args);
	}

}
