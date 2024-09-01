package com.mysite.demo.app.recipeat.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

//BEGIN - Update entity class with Lombok to decrease boilerplate
//...

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MealResponse {

	private List<Meal> meals;

	@JsonIgnoreProperties(ignoreUnknown = true)
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Meal {

		/*@Id*/
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
//	END - Update entity class to Lombok to decrease boilerplate



/*
package com.mysite.demo.app.recipeat.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MealResponse {

	private List<Meal> meals;

	// Getters and setters
	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
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
		// (Όλα τα άλλα πεδία μέχρι strIngredient20 και strMeasure20)

		public Meal() {
		}

		public String getIdMeal() {
			return idMeal;
		}

		public Meal(String idMeal, String strMeal, String strDrinkAlternate, String strCategory,
					String strArea, String strInstructions, String strMealThumb, String strYoutube,
					String strIngredient1, String strIngredient2, String strIngredient3, String strIngredient4,
					String strIngredient5, String strIngredient6, String strIngredient7, String strIngredient8,
					String strMeasure1, String strMeasure2, String strMeasure3, String strMeasure4, String strMeasure5,
					String strMeasure6, String strMeasure7, String strMeasure8) {
			this.idMeal = idMeal;
			this.strMeal = strMeal;
			this.strDrinkAlternate = strDrinkAlternate;
			this.strCategory = strCategory;
			this.strArea = strArea;
			this.strInstructions = strInstructions;
			this.strMealThumb = strMealThumb;
			this.strYoutube = strYoutube;
			this.strIngredient1 = strIngredient1;
			this.strIngredient2 = strIngredient2;
			this.strIngredient3 = strIngredient3;
			this.strIngredient4 = strIngredient4;
			this.strIngredient5 = strIngredient5;
			this.strIngredient6 = strIngredient6;
			this.strIngredient7 = strIngredient7;
			this.strIngredient8 = strIngredient8;
			this.strMeasure1 = strMeasure1;
			this.strMeasure2 = strMeasure2;
			this.strMeasure3 = strMeasure3;
			this.strMeasure4 = strMeasure4;
			this.strMeasure5 = strMeasure5;
			this.strMeasure6 = strMeasure6;
			this.strMeasure7 = strMeasure7;
			this.strMeasure8 = strMeasure8;
		}

		// Getters and setters για όλα τα πεδία
		// ...
		public void setIdMeal(String idMeal) {
			this.idMeal = idMeal;
		}

		public String getStrMeal() {
			return strMeal;
		}

		public void setStrMeal(String strMeal) {
			this.strMeal = strMeal;
		}

		public String getStrDrinkAlternate() {
			return strDrinkAlternate;
		}

		public void setStrDrinkAlternate(String strDrinkAlternate) {
			this.strDrinkAlternate = strDrinkAlternate;
		}

		public String getStrCategory() {
			return strCategory;
		}

		public void setStrCategory(String strCategory) {
			this.strCategory = strCategory;
		}

		public String getStrArea() {
			return strArea;
		}

		public void setStrArea(String strArea) {
			this.strArea = strArea;
		}

		public String getStrInstructions() {
			return strInstructions;
		}

		public void setStrInstructions(String strInstructions) {
			this.strInstructions = strInstructions;
		}

		public String getStrMealThumb() {
			return strMealThumb;
		}

		public void setStrMealThumb(String strMealThumb) {
			this.strMealThumb = strMealThumb;
		}

		public String getStrYoutube() {
			return strYoutube;
		}

		public void setStrYoutube(String strYoutube) {
			this.strYoutube = strYoutube;
		}

		public String getStrIngredient1() {
			return strIngredient1;
		}

		public void setStrIngredient1(String strIngredient1) {
			this.strIngredient1 = strIngredient1;
		}

		public String getStrIngredient2() {
			return strIngredient2;
		}

		public void setStrIngredient2(String strIngredient2) {
			this.strIngredient2 = strIngredient2;
		}

		public String getStrIngredient3() {
			return strIngredient3;
		}

		public void setStrIngredient3(String strIngredient3) {
			this.strIngredient3 = strIngredient3;
		}

		public String getStrIngredient4() {
			return strIngredient4;
		}

		public void setStrIngredient4(String strIngredient4) {
			this.strIngredient4 = strIngredient4;
		}

		public String getStrIngredient5() {
			return strIngredient5;
		}

		public void setStrIngredient5(String strIngredient5) {
			this.strIngredient5 = strIngredient5;
		}

		public String getStrIngredient6() {
			return strIngredient6;
		}

		public void setStrIngredient6(String strIngredient6) {
			this.strIngredient6 = strIngredient6;
		}

		public String getStrIngredient7() {
			return strIngredient7;
		}

		public void setStrIngredient7(String strIngredient7) {
			this.strIngredient7 = strIngredient7;
		}

		public String getStrIngredient8() {
			return strIngredient8;
		}

		public void setStrIngredient8(String strIngredient8) {
			this.strIngredient8 = strIngredient8;
		}

		public String getStrMeasure1() {
			return strMeasure1;
		}

		public void setStrMeasure1(String strMeasure1) {
			this.strMeasure1 = strMeasure1;
		}

		public String getStrMeasure2() {
			return strMeasure2;
		}

		public void setStrMeasure2(String strMeasure2) {
			this.strMeasure2 = strMeasure2;
		}

		public String getStrMeasure3() {
			return strMeasure3;
		}

		public void setStrMeasure3(String strMeasure3) {
			this.strMeasure3 = strMeasure3;
		}

		public String getStrMeasure4() {
			return strMeasure4;
		}

		public void setStrMeasure4(String strMeasure4) {
			this.strMeasure4 = strMeasure4;
		}

		public String getStrMeasure5() {
			return strMeasure5;
		}

		public void setStrMeasure5(String strMeasure5) {
			this.strMeasure5 = strMeasure5;
		}

		public String getStrMeasure6() {
			return strMeasure6;
		}

		public void setStrMeasure6(String strMeasure6) {
			this.strMeasure6 = strMeasure6;
		}

		public String getStrMeasure7() {
			return strMeasure7;
		}

		public void setStrMeasure7(String strMeasure7) {
			this.strMeasure7 = strMeasure7;
		}

		public String getStrMeasure8() {
			return strMeasure8;
		}

		public void setStrMeasure8(String strMeasure8) {
			this.strMeasure8 = strMeasure8;
		}

	}
}
*/

//*********************************************
//***********************************************

