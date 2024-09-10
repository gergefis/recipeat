package com.mysite.demo.app.recipeat.user.controller;

import com.mysite.demo.app.recipeat.user.entity.User;
import com.mysite.demo.app.recipeat.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	@Autowired
	private UserService userService;


	@GetMapping("/register")
	public String userRegister(Model model) {
		User theUser = new User();

		model.addAttribute("user", theUser);

		return "users/user-register";
	}

	@RequestMapping("/saveUser")
	public String processUserRegister(@ModelAttribute("user") User theUser, Model model) {

		model.addAttribute("username", theUser.getUsername().toUpperCase());
		System.out.println(theUser.getUsername() + ", " + theUser.getEmail());

		// Add new employee
		userService.save(theUser);

		return "users/user-confirmation";
	}
}
