package com.mysite.demo.app.recipeat;

import com.mysite.demo.app.recipeat.dao.RecipeDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
//@ComponentScan(basePackages = {"com.mysite.demo.app.recipeat"})
public class RecipeatApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeatApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
		return restTemplateBuilder.build();
	}

	private void createMeal(RecipeDao recipeDao){
/*// create the student object
		Object tempMeal = recipeDao.save();
// save the student object
		System.out.println("Saving the student...");
		recipeDao.save(tempMeal);
// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());*/
	}

}
