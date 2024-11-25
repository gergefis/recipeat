package com.mysite.demo.app.recipeat.recipe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "recipes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Recipe {

	@Id
	@Column(name = "id_meal")
	private String idMeal;

	@Column(name = "str_meal")
	private String strMeal;

	@Column(name = "str_drink_alternate")
	private String drinkAlternate;

	@Column(name = "str_category")
	private String category;

	@Column(name = "str_area")
	private String area;

	@Column(name = "str_instructions")
	private String instruction;

	@Column(name = "str_meal_thumb")
	private String mealThumb;

	@Column(name = "str_youtube")
	private String youtube;

	@Column(name = "str_ingredient1")
	private String ingredient1;
	@Column(name = "str_ingredient2")
	private String ingredient2;
	@Column(name = "str_ingredient3")
	private String ingredient3;
	@Column(name = "str_ingredient4")
	private String ingredient4;
	@Column(name = "str_ingredient5")
	private String ingredient5;
	@Column(name = "str_ingredient6")
	private String ingredient6;
	@Column(name = "str_ingredient7")
	private String ingredient7;
	@Column(name = "str_ingredient8")
	private String ingredient8;

	@Column(name = "str_measure1")
	private String measure1;
	@Column(name = "str_measure2")
	private String measure2;
	@Column(name = "str_measure3")
	private String measure3;
	@Column(name = "str_measure4")
	private String measure4;
	@Column(name = "str_measure5")
	private String measure5;
	@Column(name = "str_measure6")
	private String measure6;
	@Column(name = "str_measure7")
	private String measure7;
	@Column(name = "str_measure8")
	private String measure8;
}
