package com.crud.cadastro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.crud.cadastro")
@EntityScan(basePackages = "com.crud.cadastro.model")
public class CadastroApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroApplication.class, args);
	}

}
