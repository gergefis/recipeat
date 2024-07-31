package com.mysite.demo.app.recipeat.dao;

import com.mysite.demo.app.recipeat.entity.Recipe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class RecipeDAOImpl implements RecipeDAO{

	//	Define field for EntityManager
	private EntityManager entityManager;

//	set up Constructor injection
	@Autowired
	public RecipeDAOImpl(EntityManager theEntityManager) {

		entityManager = theEntityManager;
	}

	@Override
	public void save(Recipe theRecipe) {

		entityManager.persist(theRecipe);
	}

	@Override
	public List<Recipe> findAll() {
		//		Create query
		String query = "FROM Recipe"; // WHERE firstName= 'dimitris' order by id desc";
		TypedQuery<Recipe> theQuery = entityManager.createQuery(query, Recipe.class);

//		 execute  query, get return the result list
		return theQuery.getResultList();
		
	}
}
