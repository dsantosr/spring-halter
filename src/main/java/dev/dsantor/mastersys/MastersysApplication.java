package dev.dsantor.mastersys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MastersysApplication {

	public static void main(String[] args) {
		SpringApplication.run(MastersysApplication.class, args);
	}

}
