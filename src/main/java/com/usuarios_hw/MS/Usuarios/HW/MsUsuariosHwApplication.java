package com.usuarios_hw.MS.Usuarios.HW;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;



@SpringBootApplication
@EnableFeignClients
public class MsUsuariosHwApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsUsuariosHwApplication.class, args);
	}

	

}
