package com.mysite.demo.app.recipeat.recipe.service;

import com.mysite.demo.app.recipeat.recipe.dao.RecipeDAO;
import com.mysite.demo.app.recipeat.recipe.dto.MealResponse;
import com.mysite.demo.app.recipeat.recipe.entity.Recipe;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecipeDBServiceImpl implements RecipeDBService{

	private final ModelMapper modelMapper;
	private final RecipeDAO recipeDAO;

	public RecipeDBServiceImpl(ModelMapper modelMapper, RecipeDAO recipeDAO) {
		this.modelMapper = modelMapper;
		this.recipeDAO = recipeDAO;
	}

	@Transactional
	@Override
	public Recipe save(MealResponse.Meal theMeal) {
		// Create a new Recipe Entity based on the MealResponse
		Recipe recipeEntity = modelMapper.map(theMeal, Recipe.class);

		return recipeDAO.save(recipeEntity);

	}
}
