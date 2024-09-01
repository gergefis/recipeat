package com.mysite.demo.app.recipeat.controller;

import com.mysite.demo.app.recipeat.entity.Recipe;
import com.mysite.demo.app.recipeat.model.RecipeMapper;
import com.mysite.demo.app.recipeat.model.RecipeRestService;
import com.mysite.demo.app.recipeat.rest.CategoryResponse;
import com.mysite.demo.app.recipeat.rest.CategoryResponse.Category;
import com.mysite.demo.app.recipeat.rest.MealResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor  //Lombok: δηλώνει τον Constructor kai ta final field
@Slf4j
public class HomeController {

	private final RecipeRestService recipeRestService;
	private final RecipeMapper	recipeMapper;

//	TODO - Na αφαιρέσω τα διπλότυπα func index και categories
	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("categories", getCategories());

		return "index";
	}
// BEGIN - Fetch the categories name to drop-down list
	@GetMapping("/categories")
	public String categories(Model model) {

		model.addAttribute("categories", getCategories());

			return "categories";
	}
	// END - Fetch the categories name to drop-down list

	public List<Category> getCategories(){
		// Παίρνουμε τις κατηγορίες μέσω του service
		CategoryResponse categoryResponse = recipeRestService.getCategory();
		return categoryResponse.getCategories();
	}

	@PostMapping("/processForm")
	public String processForm(@RequestParam("mealName") String mealName, Model model) {
		MealResponse mealResponse = recipeRestService.getRecipesByName(mealName);

		try {
			LocalDateTime currentDate = java.time.LocalDateTime.now();
			String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy 'on' HH:mm"));
			model.addAttribute("theDate", formattedDate);

			// Προσθήκη του τίτλου στο model
			String theTitle = mealName.toUpperCase();
			model.addAttribute("theTitle", theTitle);

			// MealResponse.Meal to Recipe
			List<Recipe> recipes = mealResponse.getMeals().stream()
					.map(recipeMapper::mapMealToRecipe)
					.collect(Collectors.toList());

			model.addAttribute("theMeal", recipes /*mealResponse.getMeals()*/);

			return "meal";

		} catch (Exception e) {
			log.error(" - Something goes wrong while RETURNING Json Object of recipes -", e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Exception while returning json Object to Model \"meal.html\"", e);
		}
	}


	@PostMapping("/fetchMealNameByCategory")
	public String fetchMealNameByCategory(
			@RequestParam("strCategory") String strCategory,
			@RequestParam("source") String source,
			Model model) {

		// Παίρνουμε τις κατηγορίες για προβολή μέσω της Func getCategories()
		model.addAttribute("categories", getCategories());
//		##################################################################################

		MealResponse strMealResponse = recipeRestService.getRecipesByCategory(strCategory);
			// Προσθέτω τη συνταγή στο model για να τις χρησιμοποιήσουμε στο template
			model.addAttribute("mealsResults", strMealResponse.getMeals());

			if ("index".equals(source)) {
				return "index";
			} else if ("categories".equals(source)) {
				return "categories";
			} else {
				throw new IllegalArgumentException("Invalid source parameter");
			}
	}

}
