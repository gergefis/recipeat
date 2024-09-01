package com.mysite.demo.app.recipeat.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreType -- TODO -- ignore when field is empty??
@Data
@Table(name = "recipes")
public class Recipe {
	@Id
	@JsonProperty("idMeal")
	@Column(name = "idMeal")
	private String idMeal;

	@JsonProperty("strMeal")
	@Column(name = "strMeal")
	private String strMeal;

	@JsonProperty("strDrinkAlternate")
	@Column(name = "strDrinkAlternate")
	private String strDrinkAlternate;

	@JsonProperty("strCategory")
	@Column(name = "strCategory")
	private String strCategory;

	@JsonProperty("strArea")
	@Column(name = "strArea")
	private String strArea;

	@JsonProperty("strInstructions")
	@Column(name = "strInstructions")
	private String strInstructions;

	@JsonProperty("strMealThumb")
	@Column(name = "strMealThumb")
	private String strMealThumb;

	@JsonProperty("strYoutube")
	@Column(name = "strYoutube")
	private String strYoutube;

	@JsonProperty("strIngredient1")
	@Column(name = "strIngredient1")
	private String strIngredient1;

	@JsonProperty("strIngredient2")
	@Column(name = "strIngredient2")
	private String strIngredient2;

	@JsonProperty("strIngredient3")
	@Column(name = "strIngredient3")
	private String strIngredient3;

	@JsonProperty("strIngredient4")
	@Column(name = "strIngredient4")
	private String strIngredient4;

	@JsonProperty("strIngredient5")
	@Column(name = "strIngredient5")
	private String strIngredient5;

	@JsonProperty("strIngredient6")
	@Column(name = "strIngredient6")
	private String strIngredient6;

	@JsonProperty("strIngredient7")
	@Column(name = "strIngredient7")
	private String strIngredient7;

	@JsonProperty("strIngredient8")
	@Column(name = "strIngredient8")
	private String strIngredient8;

	@JsonProperty("strMeasure1")
	@Column(name = "strMeasure1")
	private String strMeasure1;

	@JsonProperty("strMeasure2")
	@Column(name = "strMeasure2")
	private String strMeasure2;

	@JsonProperty("strMeasure3")
	@Column(name = "strMeasure3")
	private String strMeasure3;

	@JsonProperty("strMeasure4")
	@Column(name = "strMeasure4")
	private String strMeasure4;

	@JsonProperty("strMeasure5")
	@Column(name = "strMeasure5")
	private String strMeasure5;

	@JsonProperty("strMeasure6")
	@Column(name = "strMeasure6")
	private String strMeasure6;

	@JsonProperty("strMeasure7")
	@Column(name = "strMeasure7")
	private String strMeasure7;

	@JsonProperty("strMeasure8")
	@Column(name = "strMeasure8")
	private String strMeasure8;
}