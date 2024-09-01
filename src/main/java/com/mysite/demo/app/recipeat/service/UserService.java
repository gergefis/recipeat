package com.mysite.demo.app.recipeat.service;

import com.mysite.demo.app.recipeat.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
	void save(User theUser);
}
