package com.mysite.demo.app.recipeat.recipe.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//BEGIN - Update class with Lombok to decrease boilerplate
//...

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MealResponse {

	private List<Meal> meals;

	@JsonIgnoreProperties(ignoreUnknown = true)
	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	@Setter
	public static class Meal {

		private String idMeal;

		private String strMeal;
		private String strDrinkAlternate;
		private String strCategory;
		private String strArea;
		private String strInstructions;
		private String strMealThumb;
		private String strYoutube;
		private String strIngredient1;
		private String strIngredient2;
		private String strIngredient3;
		private String strIngredient4;
		private String strIngredient5;
		private String strIngredient6;
		private String strIngredient7;
		private String strIngredient8;
		private String strMeasure1;
		private String strMeasure2;
		private String strMeasure3;
		private String strMeasure4;
		private String strMeasure5;
		private String strMeasure6;
		private String strMeasure7;
		private String strMeasure8;
		// Όλα τα άλλα πεδία μέχρι strIngredient20 και strMeasure20
	}
}
