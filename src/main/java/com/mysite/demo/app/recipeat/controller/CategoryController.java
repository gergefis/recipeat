package com.mysite.demo.app.recipeat.controller;

import com.mysite.demo.app.recipeat.dto.MealResponse;
import com.mysite.demo.app.recipeat.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoryController {

	private final CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	/**
	 * Fetches a list of meal names based on the specified category.

	 * @param strCategory The category name to filter by.
	 * @param source The source parameter indicating the page to be rendered.
	 * @param model The model object to add attributes to.
	 * @return The view name to be rendered.
	 */
	@PostMapping("/fetchMealNameByCategory")
	public String fetchMealNameByCategory(
			@RequestParam("strCategory") String strCategory,
			@RequestParam("source") String source,
			Model model) {


		model.addAttribute("categories", categoryService.getCategoryList());
//		Shows the param category
		model.addAttribute("selectedCategory", strCategory);

		MealResponse mealsResponse = categoryService.filterByCategory(strCategory);
		model.addAttribute("mealsResults", mealsResponse.getMeals());
		return checkResultPage(source);
	}

	/**
	 * Checks the given source parameter and returns the corresponding view name on the appropriate page.
	 *
	 * @param source The source parameter value.
	 * @return The view name to be rendered.
	 * @throws IllegalArgumentException If the source parameter is invalid.
	 */
	public String checkResultPage(String source) {
		if ("index".equals(source)) {
			return "index";
		} else if ("categories".equals(source)) {
			return "categories";
		} else {
			throw new IllegalArgumentException("Invalid source parameter");
		}
	}

}
