package com.mysite.demo.app.recipeat.service;

import com.mysite.demo.app.recipeat.rest.CategoryResponse;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;

// 		I will create the endpoint
@Service
@Slf4j
public class RecipeService {
	//**************** Get the meal from client
//		** Τα Headers
//		private   String XRapidApiKey = "5dfsfdf7as8gd5gd6f2as07";
	// Βασικό URI του API
//		private final RecipeRepository repository;

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private final RestTemplate restTemplate;

	// Βασικό URI του API
	private final String baseUri = "https://www.themealdb.com/api/json/v1/1/search.php?s=";
	private String fullUri;

	public RecipeService(RestTemplate theRestTemplate) {
		restTemplate = theRestTemplate;
	}

	//	public ResponseEntity<MealResponse> getRecipesByName(@RequestParam String name) {
	public Object getRecipesByName(@RequestParam String name) {
//				Header value is set to (if that exist)
//				HttpHeaders headers =new HttpHeaders();
//				headers.set("X-RapidAPi-Key", "XRapidApiKey");
//				headers.set("null", "null");
		try {
// Δημιουργία πλήρους URI
			fullUri = baseUri + name;

			// Κλήση του εξωτερικού API
			Object jsonResponse = restTemplate.getForObject(fullUri, Object.class);
//			******* Επιλέγω ποια στοιχεία θα φέρω μέσα από την κλλάση MealResponse
//			ResponseEntity<MealResponse> jsonResponse = restTemplate.getForEntity(fullUri, MealResponse.class);
//			********
			log.info("Output for a API: {}", jsonResponse);

			// Επιστροφή των αποτελεσμάτων
			return Collections.singletonList(jsonResponse);
		} catch (Exception e) {
			log.error(" - Something goes wrong while getting value from API -",e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Exception while calling endpoint of API", e);
		}
	}

public CategoryResponse getRecipesByCategory() {
		try {
// Δημιουργία URI categories
			String catBaseUri = "https://www.themealdb.com/api/json/v1/1/categories.php";

			// Κλήση του εξωτερικού API
			ResponseEntity<CategoryResponse> jsonResponse = restTemplate.getForEntity(catBaseUri, CategoryResponse.class);
//			******* Επιλέγω ποια στοιχεία θα φέρω μέσα από την κλάση MealResponse
			log.info("Output for API: {}", jsonResponse.getBody());

			// Επιστροφή των αποτελεσμάτων
			return jsonResponse.getBody();
		} catch (Exception e) {
			log.error(" - Something goes wrong while getting value from API -",e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Exception while calling endpoint of API", e);
		}
	}
}