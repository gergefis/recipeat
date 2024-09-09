package com.mysite.demo.app.recipeat.service;

import com.mysite.demo.app.recipeat.dto.MealResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class RecipeService {

	private final RestTemplate restTemplate;

	public RecipeService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public MealResponse jsonResponse(String fullUri){
		return restTemplate.getForObject(fullUri, MealResponse.class);
	}

	/**
	 * Searches for a recipe based on the user's query.
	 *
	 * @param mealName The search query provided by the user.
	 * @return The recipe that matches the query, or null if no match is found.
	 */
	public MealResponse getRecipesByName(@RequestParam String mealName) {

		String baseUri = "https://www.themealdb.com/api/json/v1/1/search.php?s=";
		String fullUri = baseUri + mealName;

		try {
			MealResponse jsonResponse = jsonResponse(fullUri);

			log.error(String.valueOf(jsonResponse));

			return jsonResponse;
		} catch (Exception e) {
			log.error(" - Something goes wrong while getting value from API 1 -",e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Exception while calling endpoint of API", e);
		}
	}
}
