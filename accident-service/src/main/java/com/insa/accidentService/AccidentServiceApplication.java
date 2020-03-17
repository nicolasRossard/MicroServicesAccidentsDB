package com.insa.accidentService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.insa.accidentService.dao.AccidentRepository;
import com.insa.accidentService.entities.Accident;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableSwagger2
public class AccidentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccidentServiceApplication.class, args);
	}
	
	// DATA BASE FOR ACCIDENT
	@Bean
	CommandLineRunner Start(AccidentRepository accidentRepository) {
		System.out.println("AAAieee");
		return args->{
			accidentRepository.save(new Accident(1, 2016, 2, 8));
			accidentRepository.save(new Accident(2, 2005, 2, 5));
			accidentRepository.save(new Accident(3, 2016, 1, 2));
			accidentRepository.save(new Accident(4, 2013, 1, 5));
			accidentRepository.findAll().forEach(System.out::println);
		};

	}
}
