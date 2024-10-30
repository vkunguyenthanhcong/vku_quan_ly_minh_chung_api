package com.example.qlmc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class QlmdApplication {

	public static void main(String[] args) {
		SpringApplication.run(QlmdApplication.class, args);
	}

}