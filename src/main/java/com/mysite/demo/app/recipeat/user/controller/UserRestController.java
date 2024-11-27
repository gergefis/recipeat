package com.mysite.demo.app.recipeat.user.controller;

import com.mysite.demo.app.recipeat.user.entity.User;
import com.mysite.demo.app.recipeat.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserRestController {

	@Autowired
	private final UserService userService;

	@GetMapping("/getUsers")
	public List<User> getUser(){
		return userService.findAll();
	}

	@PostMapping("/registerUser")
	public void registerUser(@RequestBody User theUser) {
		userService.save(theUser);
	}

	@PutMapping("/updateUser/{userId}")
	public void updateUser(@RequestBody User theUser){
		 userService.update(theUser);
	}

	@DeleteMapping("/deleteUser/{userId}")
	public String deleteUserById(@PathVariable int userId) {
		User tempUser = userService.findById(userId);

		if(tempUser == null)
			throw new RuntimeException("User id not found - " + userId);

		userService.delete(userId);

		return "Deleted employee id - " + userId;
	}

}
