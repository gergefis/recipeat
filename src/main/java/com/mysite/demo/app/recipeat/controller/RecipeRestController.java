package com.mysite.demo.app.recipeat.controller;

// TODO - Άχρηστη κλάση


import com.mysite.demo.app.recipeat.rest.CategoryResponse;
import com.mysite.demo.app.recipeat.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor  //Lombok: δηλώνει τον Constructor kai ta final field
public class RecipeRestController {

	@Autowired
	private final RecipeService recipeService;

	/*@GetMapping("/recipes")
	public ResponseEntity<?> callEndpointData(@RequestParam("meal") String mealName, Model model){
		// Κλήση της μεθόδου του service για να ανακτηθούν τα αποτελέσματα της αναζήτησης
		return ResponseEntity.ok(recipeService.getRecipesByName(mealName));
	}*/

	@GetMapping("/categories")
	@ResponseBody
	public String getCategories() {
		CategoryResponse categoryResponse = recipeService.getCategory();
		return "categories";
	}


//	TODO Create mapping for CRUD
@PostMapping("save-meal")
public String saveMeals() {
	// Κλήση της μεθόδου του service για την αποθήκευση των δεδομένων
	// Μπορείτε να τροποποιήσετε τη μέθοδο getRecipesByName για να καλείτε αυτή τη μέθοδο

	return "redirect:/api/recipes"; // Ανακατευθύνετε πίσω στη σελίδα των αποτελεσμάτων
}
}