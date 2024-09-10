package com.mysite.demo.app.recipeat.recipe.controller;

import com.mysite.demo.app.recipeat.recipe.dto.MealResponse;
import com.mysite.demo.app.recipeat.recipe.service.RecipeDBService;
import com.mysite.demo.app.recipeat.recipe.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@Slf4j
@RequestMapping("/recipes")
public class RecipeController {

	private final RecipeService recipeService;
	private final RecipeDBService recipeDBService;

	private MealResponse mealResponse;

	@Autowired
	public RecipeController(RecipeService recipeService, RecipeDBService recipeDBService) {
		this.recipeService = recipeService;
		this.recipeDBService = recipeDBService;
	}


	public String localTimeStamp(){
		LocalDateTime currentDate = java.time.LocalDateTime.now();
		String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy 'on' HH:mm"));
		return formattedDate;
	}

	// Call the external API to fetch the meal
	public void fetchMeals(String mealName) {
		mealResponse = recipeService.getRecipesByName(mealName);
	}

	/**
	 * Handles POST requests to process a form that submits a meal name.
	 * The method retrieves recipes based on the provided meal name, formats the current date and meal title,
	 * and adds these attributes to the model to be used in the view.
	 *
	 * @param mealName The name of the meal entered in the form. This is retrieved via the request parameter.
	 * @param model    The {@code Model} object used to pass data to the view.
	 * @return         The name of the view template ("meal") to be rendered.
	 *
	 * @throws ResponseStatusException If the meal is not found, it throws a {@code ResponseStatusException} with a NOT_FOUND status.
	 * @throws ResponseStatusException If there is an internal server error during data processing, it throws a {@code ResponseStatusException} with an INTERNAL_SERVER_ERROR status.
	 */
	@PostMapping("/processForm")
	public String processForm(@RequestParam("mealName") String mealName, Model model) {
//Shows the Local server time
		model.addAttribute("theDate", localTimeStamp());

		fetchMeals(mealName);

		if (mealResponse == null || mealResponse.getMeals().isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, " -- Meal not found -- ");

		try {
			String theTitle = mealName.toUpperCase();
			model.addAttribute("theTitle", theTitle);
			model.addAttribute("theMeal", mealResponse.getMeals());

			return "recipes/meal";
		} catch (Exception e) {
			recipeService.logErrors(e);
			return null;
		}
	}

	@PostMapping("/saveRecipe")
	public String saveMeal(Model model) {

		if (mealResponse != null && !mealResponse.getMeals().isEmpty()) {
			mealResponse.getMeals().forEach(recipeDBService::save);
			model.addAttribute("message", "Meal saved successfully!");
		} else {
			model.addAttribute("message", "Meal not found.");
		}
		return "result";
	}
}
