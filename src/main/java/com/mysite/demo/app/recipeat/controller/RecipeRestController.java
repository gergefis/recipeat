package com.mysite.demo.app.recipeat.controller;


import com.mysite.demo.app.recipeat.rest.CategoryResponse;
import com.mysite.demo.app.recipeat.rest.MealResponse;
import com.mysite.demo.app.recipeat.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor  //Lombok: δηλώνει τον Constructor kai ta final field
public class RecipeRestController {

	@Autowired
	private final RecipeService recipeService;

	@GetMapping("/recipes")
	public ResponseEntity<?> callEndpointData(@RequestParam("meal") String mealName, Model model){
		// Κλήση της μεθόδου του service για να ανακτηθούν τα αποτελέσματα της αναζήτησης
		return ResponseEntity.ok(recipeService.getRecipesByName(mealName));
	}

	/*@GetMapping("/categories")
	public ResponseEntity<?> callEndpointCatData(){
		// Κλήση της μεθόδου του service για να ανακτηθούν τα αποτελέσματα της αναζήτησης
		return ResponseEntity.ok(recipeService.getRecipesByCategory());
	}*/

	@GetMapping("/categories")
	@ResponseBody
	public String getCategories() {
		CategoryResponse categoryResponse = recipeService.getRecipesByCategory();
		StringBuilder htmlBuilder = new StringBuilder();

		htmlBuilder.append("<!DOCTYPE html>")
				.append("<html lang='en'><head>")
				.append("<meta charset='UTF-8'>")
				.append("<meta name='viewport' content='width=device-width, initial-scale=1.0'>")
				.append("<title>Categories</title></head><body>")
				.append("<h1>Πατήστε για να δείτε τις κατηγορίες</h1>")
				.append("<form action='#' method='get'>")
				.append("<label for='category-select'>Επιλέξτε κατηγορία:</label>")
				.append("<select name='category' id='category-select'>")
				.append("<option value=''>--Παρακαλώ επιλέξτε--</option>");

		for (CategoryResponse.Category category : categoryResponse.getCategories()) {
			htmlBuilder.append("<option value='").append(category.getStrCategory()).append("'>")
					.append(category.getStrCategory())
					.append("</option>");
		}

		htmlBuilder.append("</select>")
				.append("<button type='submit'>Υποβολή</button>")
				.append("</form></body></html>");

		return htmlBuilder.toString();
	}


//	TODO Create mapping for CRUD
@PostMapping("save-meal")
public String saveMeals() {
	// Κλήση της μεθόδου του service για την αποθήκευση των δεδομένων
	// Μπορείτε να τροποποιήσετε την μέθοδο getRecipesByName για να καλείτε αυτή την μέθοδο

	return "redirect:/api/recipes"; // Ανακατευθύνετε πίσω στη σελίδα των αποτελεσμάτων
}
}