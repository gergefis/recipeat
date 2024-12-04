package com.mysite.demo.app.recipeat.recipe.service;

import com.mysite.demo.app.recipeat.recipe.dto.MealResponse;
import com.mysite.demo.app.recipeat.recipe.entity.Recipe;
import org.springframework.stereotype.Service;

public interface RecipeDBService {
	Recipe save(MealResponse.Meal theMeal);
}
