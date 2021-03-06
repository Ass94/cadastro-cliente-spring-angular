package br.com.devpleno.cadastro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.devpleno.cadastro.service.DBService;

@Configuration
@Profile("Dev")
public class DevConfig {
	
	@Autowired
	private DBService service;
	
	@Bean
	public void initialize() {
		service.inicializateDataBase();
	}

}
