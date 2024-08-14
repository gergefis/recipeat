package com.mysite.demo.app.recipeat.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "meal")
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MealEntity{
	@Id
	@Column(name = "idMeal")
	private String idMeal;

	@Column(name = "strMeal")
	private String strMeal;

	@Column(name = "strDrinkAlternate")
	private String strDrinkAlternate;

	@Column(name = "strCategory")
	private String strCategory;

	@Column(name = "strArea")
	private String strArea;

	@Column(name = "strInstructions")
	private String strInstructions;

	@Column(name = "strMealThumb")
	private String strMealThumb;

	@Column(name = "strYoutube")
	private String strYoutube;

	@Column(name = "strIngredient1")
	private String strIngredient1;

	@Column(name = "strIngredient2")
	private String strIngredient2;

	@Column(name = "strIngredient3")
	private String strIngredient3;

	@Column(name = "strIngredient4")
	private String strIngredient4;

	@Column(name = "strIngredient5")
	private String strIngredient5;

	@Column(name = "strIngredient6")
	private String strIngredient6;

	@Column(name = "strIngredient7")
	private String strIngredient7;

	@Column(name = "strIngredient8")
	private String strIngredient8;

	@Column(name = "strMeasure1")
	private String strMeasure1;

	@Column(name = "strMeasure2")
	private String strMeasure2;

	@Column(name = "strMeasure3")
	private String strMeasure3;

	@Column(name = "strMeasure4")
	private String strMeasure4;

	@Column(name = "strMeasure5")
	private String strMeasure5;

	@Column(name = "strMeasure6")
	private String strMeasure6;

	@Column(name = "strMeasure7")
	private String strMeasure7;

	@Column(name = "strMeasure8")
	private String strMeasure8;
}