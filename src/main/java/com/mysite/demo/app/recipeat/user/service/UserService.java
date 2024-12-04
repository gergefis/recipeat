package com.mysite.demo.app.recipeat.user.service;

import com.mysite.demo.app.recipeat.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

	List<User> findAll();
	User findById(int userId);
	void save(User theUser);
	void update(User theUser);
	void delete(int theId);
}
