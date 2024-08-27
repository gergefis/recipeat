package com.mysite.demo.app.recipeat.service;

import com.mysite.demo.app.recipeat.rest.CategoryResponse;
import com.mysite.demo.app.recipeat.rest.MealResponse;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

	public RecipeService(RestTemplate theRestTemplate) {
		restTemplate = theRestTemplate;
	}

//	Logging info
private void logApiResponse(Object response) {
	log.info("Output for API: {}", response);
}

	//	public ResponseEntity<MealResponse> getRecipesByName(@RequestParam String name) {
	public MealResponse getRecipesByName(@RequestParam String name) {
// Βασικό URI του API
		String baseUri = "https://www.themealdb.com/api/json/v1/1/search.php?s=";
		String fullUri = baseUri + name;

		try {
			// Κλήση του εξωτερικού API και αποθήκευση των δεδομένων σε μεταβλητή
//			ResponseEntity<MealResponse>  jsonResponse = restTemplate.getForEntity(fullUri, MealResponse.class);
//			******* Επιλέγω ποια στοιχεία θα φέρω μέσα από την κλάση MealResponse
			MealResponse jsonResponse = restTemplate.getForObject(fullUri, MealResponse.class);
//			********
			logApiResponse(jsonResponse);
			// Επιστροφή των αποτελεσμάτων
			return jsonResponse;
		} catch (Exception e) {
			log.error(" - Something goes wrong while getting value from API -",e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Exception while calling endpoint of API", e);
		}
	}

public CategoryResponse getCategory() {
		try {
// Δημιουργία URI categories
			String catFullUri = "https://www.themealdb.com/api/json/v1/1/categories.php";

			// Κλήση του εξωτερικού API
			CategoryResponse jsonResponse = restTemplate.getForObject(catFullUri, CategoryResponse.class);
//			******* Επιλέγω ποια στοιχεία θα φέρω μέσα από την κλάση MealResponse
			logApiResponse(jsonResponse);

			// Επιστροφή των αποτελεσμάτων
			return jsonResponse;
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
			MealResponse jsonResponse = restTemplate.getForObject(searchFullUri, MealResponse.class);
			logApiResponse(jsonResponse);

			// Επιστροφή των αποτελεσμάτων
			return jsonResponse;
		} catch (Exception e) {
			log.error(" - Something goes wrong while getting value from API -",e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Exception while calling endpoint of API", e);
		}
	}
}