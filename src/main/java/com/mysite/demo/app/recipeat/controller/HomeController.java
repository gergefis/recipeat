package com.mysite.demo.app.recipeat.controller;

import com.mysite.demo.app.recipeat.rest.CategoryResponse;
import com.mysite.demo.app.recipeat.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor  //Lombok: δηλώνει τον Constructor kai ta final field
public class HomeController {

	@Autowired
	private final RecipeService recipeService;

	@GetMapping("/")
	public String index(Model model) {
		CategoryResponse categoryResponse = recipeService.getRecipesByCategory();

		// Προσθέτουμε τις κατηγορίες στο μοντέλο για να τις χρησιμοποιήσουμε στο template
		model.addAttribute("categories", categoryResponse.getCategories());
		// Επιστρέφει το όνομα του template χωρίς την επέκταση .html
		return "index";
	}

	@GetMapping("/recipes")
	public String sayHello(Model theModel) {
		LocalDateTime currentDate = java.time.LocalDateTime.now();
		theModel.addAttribute("theDate", currentDate);

		return "recipes";
	}

	@GetMapping("/categories")
	public String getCategories(Model model) {
		// Παίρνουμε τις κατηγορίες μέσω του service
		CategoryResponse categoryResponse = recipeService.getRecipesByCategory();

		// Προσθέτουμε τις κατηγορίες στο μοντέλο για να τις δούμε στη σελίδα
		model.addAttribute("categories", categoryResponse.getCategories());

		// Επιστρέφουμε το όνομα του template χωρίς την επέκταση .html
		return "categories";
	}
}
