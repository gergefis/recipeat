package com.mysite.demo.app.recipeat.controller;


import com.mysite.demo.app.recipeat.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor  //Lombok: δηλώνει τον Constructor kai ta final field
public class RecipeRestController {

	@Autowired
	private final RecipeService recipeService;

	@GetMapping("/recipes")
	public ResponseEntity<?> callEndpointData(@RequestParam("meal") String mealName, Model model){
		return ResponseEntity.ok(recipeService.getRecipesByName(mealName));
	}

//	TODO Create mapping for CRUD
}