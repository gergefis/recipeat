package com.mysite.demo.app.recipeat.dao;

import com.mysite.demo.app.recipeat.entity.Recipe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class RecipeDAOJpaImpl implements RecipeDao {
	// define field for entityManager
	private final EntityManager entityManager;

	@Autowired
	public RecipeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void save(Recipe theRecipe) {
		if (theRecipe.getIdMeal() == null || theRecipe.getIdMeal().isEmpty()) {
			// Insert new recipe
			entityManager.persist(theRecipe);
		} else {
			// Update existing recipe
			entityManager.merge(theRecipe);
		}
	}

	@Override
	public List<Recipe> findAll() {

		// create a query
		TypedQuery<Recipe> theQuery = entityManager.createQuery("from Recipe", Recipe.class);

		// execute query and get result list
		List<Recipe> recipes = theQuery.getResultList();

		// return the results
		return recipes;
	}
}
