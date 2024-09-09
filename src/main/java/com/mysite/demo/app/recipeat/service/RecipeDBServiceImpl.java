package com.mysite.demo.app.recipeat.service;

import com.mysite.demo.app.recipeat.dao.RecipeDAO;
import com.mysite.demo.app.recipeat.dto.MealResponse;
import com.mysite.demo.app.recipeat.entity.Recipe;
import jakarta.persistence.PersistenceContext;
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
		// Using EntityManager
		return recipeDAO.save(recipeEntity);

	}
}
