package com.mysite.demo.app.recipeat.controller;

import com.mysite.demo.app.recipeat.entity.User;
import com.mysite.demo.app.recipeat.rest.CategoryResponse;
import com.mysite.demo.app.recipeat.rest.CategoryResponse.Category;
import com.mysite.demo.app.recipeat.rest.MealResponse;
import com.mysite.demo.app.recipeat.service.RecipeService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequiredArgsConstructor  //Lombok: δηλώνει τον Constructor kai ta final field
@Slf4j
public class HomeController {

	@Autowired
	private final RecipeService recipeService;

//	TODO - Na αφαιρέσω τα διπλότυπα func index και categories
	@GetMapping("/")
	public String index(Model model) {
		// Προσθέτουμε τις κατηγορίες στο μοντέλο για να τις χρησιμοποιήσουμε στο template
		model.addAttribute("categories", getCategories());

		// Επιστρέφει το όνομα του template χωρίς την επέκταση .html
		return "index";
	}
// BEGIN - Fetch the categories name to drop-down list
	@GetMapping("/categories")
	public String categories(Model model) {

		// Προσθέτουμε τις κατηγορίες στο μοντέλο για να τις δούμε στη σελίδα
		model.addAttribute("categories", getCategories());

			return "categories";
	}
	// END - Fetch the categories name to drop-down list

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "user-register";
	}

	public List<Category> getCategories(){
		// Παίρνουμε τις κατηγορίες μέσω του service
		CategoryResponse categoryResponse = recipeService.getCategory();
		return categoryResponse.getCategories();
	}

	@RequestMapping("/processForm")
	public String processForm(@RequestParam("mealName") String mealName,
							  Model model) {
		MealResponse mealResponse = recipeService.getRecipesByName(mealName);

		try {
			LocalDateTime currentDate = java.time.LocalDateTime.now();
			String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy 'on' HH:mm"));
			model.addAttribute("theDate",formattedDate);

			// Προσθέτουμε τη συνταγή στο μοντέλο για να τις χρησιμοποιήσουμε στο template
			// read the request parameter from the HTML form
			String theTitle = mealName.toUpperCase();
			model.addAttribute("theTitle", theTitle);

//			Add Meal to the model
			model.addAttribute("theMeal", mealResponse.getMeals());

			return "meal";
		} catch (Exception e) {
			log.error(" - Something goes wrong while RETURN Json Object of recipes -",e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Exception while RETURN json Object to Model \"categories.html\"", e);
		}
	}


	@GetMapping("/fetchMealNameByCategory")
	public String fetchMealNameByCategory(
			@RequestParam("strCategory") String strCategory,
			@RequestParam("source") String source,
			Model model) {
		// Παίρνουμε τις κατηγορίες μέσω της Func Categories
		model.addAttribute("categories", getCategories());
//		##################################################################################

		MealResponse strMealResponse = recipeService.getRecipesByCategory(strCategory);
			// Προσθέτουμε τη συνταγή στο μοντέλο για να τις χρησιμοποιήσουμε στο template
			model.addAttribute("mealsResults", strMealResponse.getMeals());

			if ("index".equals(source)) {
				return "index";
			} else if ("categories".equals(source)) {
				return "categories";
			} else {
				throw new IllegalArgumentException("Invalid source parameter");
			}
	}

/*	@PostMapping("/saveFormData")
	public String processForm() {
		return null;
	}*/
}
