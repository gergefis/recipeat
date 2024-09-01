package com.mysite.demo.app.recipeat.service;

import com.mysite.demo.app.recipeat.entity.Recipe;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RecipeService {
	void save(Recipe theRecipe);

	List<Recipe> findAll();

}
