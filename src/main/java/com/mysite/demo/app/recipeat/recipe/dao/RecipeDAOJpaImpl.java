package com.mysite.demo.app.recipeat.recipe.dao;

import com.mysite.demo.app.recipeat.recipe.entity.Recipe;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RecipeDAOJpaImpl implements RecipeDAO {
	private final EntityManager entityManager;

	@Autowired
	public RecipeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Recipe save(Recipe theRecipe) {
		return entityManager.merge(theRecipe);
	}
}
