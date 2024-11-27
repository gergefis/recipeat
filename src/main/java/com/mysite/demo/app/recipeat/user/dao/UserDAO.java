package com.mysite.demo.app.recipeat.user.dao;

import com.mysite.demo.app.recipeat.user.entity.User;
import jakarta.persistence.TypedQuery;

import java.util.List;

public interface UserDAO {

	List<User> findAll();
	User findById(int userId);
	void save(User theUser);
	void update(User theUser);
	void deleteById(int userId);
}
