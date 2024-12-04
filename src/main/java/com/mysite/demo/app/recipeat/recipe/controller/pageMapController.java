package com.mysite.demo.app.recipeat.recipe.controller;

import com.mysite.demo.app.recipeat.recipe.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pageMapController {
	public final CategoryService categoryService;

	@Autowired
	public pageMapController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	//	Return the categories names into drop-down list at Index Page
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("categories", categoryService.getCategoryList());
		return "index";
	}

	//	Return the categories names into drop-down list to Category Page
	@GetMapping("/category")
	public String categories(Model model) {
		model.addAttribute("categories", categoryService.getCategoryList());
		return "categories";
	}

}
