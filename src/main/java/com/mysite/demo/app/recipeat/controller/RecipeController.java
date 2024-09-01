package com.mysite.demo.app.recipeat.controller;

import com.mysite.demo.app.recipeat.entity.Recipe;
import com.mysite.demo.app.recipeat.service.RecipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@Slf4j
@RequestMapping("/recipes")
@RequiredArgsConstructor
public class RecipeController {

	private final RecipeService recipeService;

//	TODO Create mapping for CRUD
@Transactional
@PostMapping("/saveRecipe")
public String addRecipe(@ModelAttribute("theRecipe") Recipe theRecipe, Model model) { //@ModelAttribute("theRecipe")
	// Κλήση της μεθόδου του service για την αποθήκευση των δεδομένων
//	theRecipe.getIdMeal();

	try {
		System.out.println("Recipe object: " + theRecipe);

//		recipeService.save(theRecipe);
		model.addAttribute("theRecipe", theRecipe);

		return "recipes/test";
	}catch(Exception e){
		log.error(" - Something goes wrong while RETURN Json Object of recipes -",e); // Αυτό θα εμφανίσει το σφάλμα στα logs
		throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
				"Exception while saving recipe", e);
	}
}
}