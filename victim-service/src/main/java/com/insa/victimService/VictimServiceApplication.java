package com.insa.victimService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;


import com.insa.victimService.dao.VictimRepository;
import com.insa.victimService.entities.Victim;

@SpringBootApplication
@EnableDiscoveryClient
public class VictimServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VictimServiceApplication.class, args);
	}
	// DATA BASE FOR VICTIMS
	@Bean
	CommandLineRunner Start(VictimRepository victimRepository) {

		return args->{
			victimRepository.save(new Victim(1,1, "A", 1, 2, 1, 1990));
			victimRepository.save(new Victim(2,1, "B", 1, 2, 2, 1990));
			victimRepository.save(new Victim(3,2, "A", 1, 2, 1, 1967));
			victimRepository.save(new Victim(4,2, null, 3, 3, 1, 1998));
			victimRepository.findAll().forEach(System.out::println);
		};

	}
}
