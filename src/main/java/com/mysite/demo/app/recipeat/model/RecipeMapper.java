package com.mysite.demo.app.recipeat.model;

import com.mysite.demo.app.recipeat.entity.Recipe;
import com.mysite.demo.app.recipeat.rest.MealResponse.Meal;
import org.springframework.stereotype.Component;

@Component
public class RecipeMapper {

	public Recipe mapMealToRecipe(Meal meal) {
		Recipe recipe = new Recipe();

		// Mapping fields from MealResponse.Meal to Recipe:
		recipe.setIdMeal(meal.getIdMeal());
		recipe.setStrMeal(meal.getStrMeal());
		recipe.setStrDrinkAlternate(meal.getStrDrinkAlternate());
		recipe.setStrCategory(meal.getStrCategory());
		recipe.setStrArea(meal.getStrArea());
		recipe.setStrInstructions(meal.getStrInstructions());
		recipe.setStrMealThumb(meal.getStrMealThumb());
		recipe.setStrYoutube(meal.getStrYoutube());
		recipe.setStrIngredient1(meal.getStrIngredient1());
		recipe.setStrIngredient2(meal.getStrIngredient2());
		recipe.setStrIngredient3(meal.getStrIngredient3());
		recipe.setStrIngredient4(meal.getStrIngredient4());
		recipe.setStrIngredient5(meal.getStrIngredient5());
		recipe.setStrIngredient6(meal.getStrIngredient6());
		recipe.setStrIngredient7(meal.getStrIngredient7());
		recipe.setStrIngredient8(meal.getStrIngredient8());
		recipe.setStrMeasure1(meal.getStrMeasure1());
		recipe.setStrMeasure2(meal.getStrMeasure2());
		recipe.setStrMeasure3(meal.getStrMeasure3());
		recipe.setStrMeasure4(meal.getStrMeasure4());
		recipe.setStrMeasure5(meal.getStrMeasure5());
		recipe.setStrMeasure6(meal.getStrMeasure6());
		recipe.setStrMeasure7(meal.getStrMeasure7());
		recipe.setStrMeasure8(meal.getStrMeasure8());

		return recipe;
	}
}
