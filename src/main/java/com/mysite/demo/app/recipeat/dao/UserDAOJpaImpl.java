package com.mysite.demo.app.recipeat.dao;

import com.mysite.demo.app.recipeat.entity.User;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOJpaImpl implements UserDAO{
	private final EntityManager entityManager;

	@Autowired
	public UserDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void save(User theUser) {
		entityManager.persist(theUser);
		}

}
