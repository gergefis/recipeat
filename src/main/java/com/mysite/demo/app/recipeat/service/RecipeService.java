package com.mysite.demo.app.recipeat.service;

import com.mysite.demo.app.recipeat.rest.CategoryResponse;
import com.mysite.demo.app.recipeat.rest.MealResponse;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

// 		I will create the endpoint
@Service
@Slf4j
public class RecipeService {
	//**************** Get the meal

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private final RestTemplate restTemplate;

	// Βασικό URI του API
	private final String baseUri = "https://www.themealdb.com/api/json/v1/1/search.php?s=";

	public RecipeService(RestTemplate theRestTemplate) {
		restTemplate = theRestTemplate;
	}

	//	public ResponseEntity<MealResponse> getRecipesByName(@RequestParam String name) {
	public MealResponse getRecipesByName(@RequestParam String name) {

		String fullUri = baseUri + name;

		try {
			// Κλήση του εξωτερικού API και αποθήκευση των δεδομένων σε μεταβλητή
			ResponseEntity<MealResponse>  jsonResponse = restTemplate.getForEntity(fullUri, MealResponse.class);
//			******* Επιλέγω ποια στοιχεία θα φέρω μέσα από την κλάση MealResponse
//			ResponseEntity<MealResponse> jsonResponse = restTemplate.getForEntity(fullUri, MealResponse.class);
//			********
			log.info("Output for a API: {}", jsonResponse.getBody());
			// Επιστροφή των αποτελεσμάτων
			return jsonResponse.getBody();
		} catch (Exception e) {
			log.error(" - Something goes wrong while getting value from API -",e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Exception while calling endpoint of API", e);
		}
	}

public CategoryResponse getCategory() {
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

	public MealResponse getRecipesByCategory(@RequestParam String name) {
		try {
// Δημιουργία URI categories
			String searchBaseUri = "https://www.themealdb.com/api/json/v1/1/filter.php?c=";
			String searchFullUri = searchBaseUri + name;

			// Κλήση του εξωτερικού API
			MealResponse jsonResponse = restTemplate.getForObject(searchBaseUri, MealResponse.class);
//			******* Θα Επιλέξω ποια στοιχεία θα φέρω μέσα από την κλάση MealResponse
			log.info("Output for API: {}", jsonResponse);

			// Επιστροφή των αποτελεσμάτων
			return jsonResponse;
		} catch (Exception e) {
			log.error(" - Something goes wrong while getting value from API -",e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Exception while calling endpoint of API", e);
		}
	}
}