package com.mysite.demo.app.recipeat.service;

import com.mysite.demo.app.recipeat.dao.RecipeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mysite.demo.app.recipeat.entity.Recipe;


import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
//	define filed
	private RecipeDAO recipeDAO;

//	Create Constructor
@Autowired
	public EmployeeServiceImpl(RecipeDAO theRecipeDAO) {
		recipeDAO = theRecipeDAO;
	}

//	inject RecipeDAO
	@Override
	public List<Recipe> findAll() {
		return recipeDAO.findAll();
	}
}
