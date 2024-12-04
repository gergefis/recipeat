package com.mysite.demo.app.recipeat.user.dao;

import com.mysite.demo.app.recipeat.user.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDAOJpaImpl implements UserDAO {
	private final EntityManager entityManager;

	@Autowired
	public UserDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<User> findAll() {
//		Create query
		TypedQuery<User> theQuery = entityManager.createQuery("FROM User", User.class);
// 		return query results
		return theQuery.getResultList();
	}

	@Override
	public User findById(int userId) {
		return entityManager.find(User.class, userId);
	}

	@Override
	@Transactional
	public void save(User theUser) {
		entityManager.persist(theUser);
	}

	@Override
	@Transactional
	public void update(User theUser) {
		entityManager.merge(theUser);
	}

	@Override
	@Transactional
	public void deleteById(int userId) {
		User user = entityManager.find(User.class, userId);
		entityManager.remove(user);
	}
}
