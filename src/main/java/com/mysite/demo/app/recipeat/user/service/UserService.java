package com.mysite.demo.app.recipeat.user.service;

import com.mysite.demo.app.recipeat.user.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
	void save(User theUser);
}
