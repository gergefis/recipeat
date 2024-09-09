package com.mysite.demo.app.recipeat.service;

import com.mysite.demo.app.recipeat.dto.MealResponse;
import com.mysite.demo.app.recipeat.entity.Recipe;
import org.springframework.stereotype.Service;

//@Service
public interface RecipeDBService {
Recipe save(MealResponse.Meal theMeal);
}
