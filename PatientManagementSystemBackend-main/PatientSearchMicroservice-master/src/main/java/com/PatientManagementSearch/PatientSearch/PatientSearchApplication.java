package com.PatientManagementSearch.PatientSearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.PatientManagementSearch.PatientSearch.searchrepo")
@EnableJpaRepositories(basePackages = "com.PatientManagementSearch.PatientSearch.repository")
public class PatientSearchApplication {

	public static void main(String[] args) {

		SpringApplication.run(PatientSearchApplication.class, args);
	}
}
