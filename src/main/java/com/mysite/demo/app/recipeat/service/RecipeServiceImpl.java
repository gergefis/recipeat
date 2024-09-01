package com.mysite.demo.app.recipeat.service;

import com.mysite.demo.app.recipeat.dao.RecipeDao;
import com.mysite.demo.app.recipeat.entity.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService{
	private RecipeDao recipeDao;

	//	Constructors
	@Autowired
	public RecipeServiceImpl() {
	}

	public RecipeServiceImpl(RecipeDao recipeDao) {
		this.recipeDao = recipeDao;
	}
	//	END - Constructors

	@Transactional
	@Override
	public void save(Recipe theRecipe) {
		 recipeDao.save(theRecipe);
	}

	@Override
	public List<Recipe> findAll() {
		return recipeDao.findAll();
	}

}
