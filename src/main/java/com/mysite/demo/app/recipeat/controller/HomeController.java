package com.mysite.demo.app.recipeat.controller;

import com.mysite.demo.app.recipeat.rest.CategoryResponse;
import com.mysite.demo.app.recipeat.rest.MealResponse;
import com.mysite.demo.app.recipeat.rest.RecipeNameByCategoryResponse;
import com.mysite.demo.app.recipeat.service.RecipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor  //Lombok: δηλώνει τον Constructor kai ta final field
@Slf4j
public class HomeController {

	@Autowired
	private final RecipeService recipeService;

	@GetMapping("/")
	public String index(Model model) {
		CategoryResponse categoryResponse = recipeService.getCategory();

		// Προσθέτουμε τις κατηγορίες στο μοντέλο για να τις χρησιμοποιήσουμε στο template
		model.addAttribute("categories", categoryResponse.getCategories());

		// Επιστρέφει το όνομα του template χωρίς την επέκταση .html
		return "index";
	}

	@GetMapping("/categories")
	public String getCategories(Model model) {
		// Παίρνουμε τις κατηγορίες μέσω του service
		CategoryResponse categoryResponse = recipeService.getCategory();

		// Προσθέτουμε τις κατηγορίες στο μοντέλο για να τις δούμε στη σελίδα
		model.addAttribute("categories", categoryResponse.getCategories());

		// Επιστρέφουμε το όνομα του template χωρίς την επέκταση .html
		return "categories";
	}

	@RequestMapping("/showForm")
	public String showForm() {
		return "index";
	}

	@RequestMapping("/processForm")
	public String processForm(@RequestParam("mealName") String mealName, Model model) {
		MealResponse mealResponse = recipeService.getRecipesByName(mealName);

		try {
			LocalDateTime currentDate = java.time.LocalDateTime.now();
			model.addAttribute("theDate", currentDate);

			// Προσθέτουμε τη συνταγή στο μοντέλο για να τις χρησιμοποιήσουμε στο template
				model.addAttribute("theMeal", mealResponse.getMeals());

			return "meal";
		} catch (Exception e) {
			log.error(" - Something goes wrong while RETURN Json Object of recipes -",e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Exception while RETURN json Object to Model \"meal.html\"", e);
		}
	}
	@RequestMapping("/fetchMealNameByCategory")
	public String fetchMealNameFromCategory(@RequestParam("strMeal") String strMeal, Model model) {
		MealResponse strMealResponse = recipeService.getRecipesByCategory(strMeal);

		try {
			// Προσθέτουμε τη συνταγή στο μοντέλο για να τις χρησιμοποιήσουμε στο template
			model.addAttribute("strMeal", strMealResponse);

			return "categories";
		}catch (Exception e) {
			log.error(" - Something goes wrong while getting value from Category Drop-Down menu -",e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Exception while RETURN json Object to Model \"index.html\"", e);
		}
	}
}
