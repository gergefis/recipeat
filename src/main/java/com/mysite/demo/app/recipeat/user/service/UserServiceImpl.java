package com.mysite.demo.app.recipeat.user.service;

import com.mysite.demo.app.recipeat.user.dao.UserDAO;
import com.mysite.demo.app.recipeat.user.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
	private final UserDAO userDAO;

	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public List<User> findAll(){
		return userDAO.findAll();
	}

	@Override
	public User findById(int userId) {
		return userDAO.findById(userId);
	}

	@Transactional
	@Override
	public void save(User theUser) {
		userDAO.save(theUser);
	}

	@Override
	public void update(User theUser)  throws RuntimeException{
			userDAO.update(theUser);
	}

	@Transactional
	@Override
	public void delete(int theId) {
		userDAO.deleteById(theId);
	}
}
