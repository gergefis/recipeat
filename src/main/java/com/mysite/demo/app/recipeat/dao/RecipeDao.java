package com.mysite.demo.app.recipeat.dao;

import com.mysite.demo.app.recipeat.entity.Recipe;

import java.util.List;

public interface RecipeDao {
	void save(Recipe theRecipe);

	List<Recipe> findAll();
}
