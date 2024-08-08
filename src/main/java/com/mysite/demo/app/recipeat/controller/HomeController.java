package com.mysite.demo.app.recipeat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String showIndex() {
		// Επιστρέφει το όνομα του template χωρίς την επέκταση .html
		return "redirect:/index.html";
	}
}
