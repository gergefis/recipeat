package com.mysite.demo.app.recipeat.user.service;

import com.mysite.demo.app.recipeat.user.dao.UserDAO;
import com.mysite.demo.app.recipeat.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{
	private UserDAO userDAO;

	//	Constructors
	public UserServiceImpl() {
	}

	@Autowired
	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
//	END - Constructors

	@Transactional
	@Override
	public void save(User theUser) {
		userDAO.save(theUser);
	}
}
