package com.mysite.demo.app.recipeat.recipe.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build(); //Todo -  Ambiguous Error
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}


}
