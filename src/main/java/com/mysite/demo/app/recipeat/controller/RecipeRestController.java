package com.mysite.demo.app.recipeat.controller;


import com.mysite.demo.app.recipeat.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RecipeRestController {


	private final RecipeService recipeService;

	//	inject Recipe Service (use constructor injection)
//	@Autowired
//	public RecipeRestController(RecipeService theRecipeService, RestTemplate theRestTemplate) {
//		recipeService = theRecipeService;
//	}


	@GetMapping("/recipes")
	public ResponseEntity<?> callEndpointData(){
		return ResponseEntity.ok(recipeService.getData());
	}

//	TODO Create mapping for CRUD
}
