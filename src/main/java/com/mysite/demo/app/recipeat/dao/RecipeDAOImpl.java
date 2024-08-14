package com.mysite.demo.app.recipeat.dao;

import com.mysite.demo.app.recipeat.entity.MealEntity;
import com.mysite.demo.app.recipeat.rest.MealResponse;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

public class RecipeDAOImpl implements RecipeDao {
	private final EntityManager entityManager;

	public RecipeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(MealEntity mealEntity) {
		entityManager.persist(mealEntity);
	}
}
