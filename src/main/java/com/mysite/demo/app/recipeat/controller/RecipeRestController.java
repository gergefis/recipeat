package com.mysite.demo.app.recipeat.controller;


import com.mysite.demo.app.recipeat.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor  //Lombok: δηλώνει τον Constructor kai ta final field
public class RecipeRestController {


	private final RecipeService recipeService;



	@GetMapping("/recipes")
	public ResponseEntity<?> callEndpointData(){
		return ResponseEntity.ok(recipeService.getData());
	}

//	TODO Create mapping for CRUD
}
