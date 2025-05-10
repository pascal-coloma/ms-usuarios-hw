package com.usuarios_hw.MS.Usuarios.HW;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class MsUsuariosHwApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsUsuariosHwApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
