package com.mysite.demo.app.recipeat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@ComponentScan(basePackages = {"com.mysite.demo.app.recipeat"})
public class RecipeatApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeatApplication.class, args);
	}

}
