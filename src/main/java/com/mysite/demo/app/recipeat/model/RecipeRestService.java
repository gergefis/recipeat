package com.mysite.demo.app.recipeat.model;

import com.mysite.demo.app.recipeat.entity.Recipe;
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

import java.util.List;

@Service
@Slf4j
public class RecipeRestService {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private final RestTemplate restTemplate;

	public RecipeRestService(RestTemplate theRestTemplate) {

		restTemplate = theRestTemplate;
	}

//
private void logApiResponse(Object response) {
	log.info("Output for API: {}", response);
}

	/**
	 * Searches for a recipe based on the user's query.
	 *
	 * @param recipeName The search query provided by the user.
	 * @return The recipe that matches the query, or null if no match is found.
	 */
	public MealResponse getRecipesByName(@RequestParam String recipeName) {
//	Can I also return a (public ResponseEntity<MealResponse> getRecipesByName(@RequestParam String name) {})

		String baseUri = "https://www.themealdb.com/api/json/v1/1/search.php?s=";
		String fullUri = baseUri + recipeName;

		try {

			MealResponse jsonResponse = restTemplate.getForObject(fullUri, MealResponse.class);

			logApiResponse(jsonResponse);

			return jsonResponse;

		} catch (Exception e) {
			log.error(" - Something goes wrong while getting value from API 1 -",e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Exception while calling endpoint of API", e);
		}
	}

	/**
	 * Fetches a list of categories from the API.
	 *
	 * This method calls the '/categories' endpoint of the API to retrieve a list of all categories.
	 * The response is parsed into a list of Category objects.
	 *
	 * @return A list of Category objects, or an empty list if no categories are found.
	 * @throws ResponseStatusException If an error occurs while fetching the categories.
	 */
public CategoryResponse getCategory() {
		try {

			String catFullUri = "https://www.themealdb.com/api/json/v1/1/categories.php";

			CategoryResponse jsonResponse = restTemplate.getForObject(catFullUri, CategoryResponse.class);
			logApiResponse(jsonResponse);

			return jsonResponse;

		} catch (Exception e) {
			log.error(" - Something goes wrong while getting value from API 2-",e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Exception while calling endpoint of API", e);
		}
	}

	/**
	 * Retrieves a list of recipes filtered by the given category ID.
	 *
	 * This method queries the underlying data source (e.g., database, external API) to find all recipes
	 * that are associated with the specified category.
	 *
	 * @param categoryName The unique identifier of the category.
	 * @return A list of Recipe objects by their Name representing the filtered recipes.
	 * @throws ResponseStatusException If the specified category is not found.
	 */
	public MealResponse getRecipesByCategory(@RequestParam String categoryName) {
		try {

			String searchBaseUri = "https://www.themealdb.com/api/json/v1/1/filter.php?c=";
			String searchFullUri = searchBaseUri + categoryName;

			MealResponse jsonResponse = restTemplate.getForObject(searchFullUri, MealResponse.class);
			logApiResponse(jsonResponse);

			return jsonResponse;

		} catch (Exception e) {
			log.error(" - Something goes wrong while getting value from API 3-",e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Exception while calling endpoint of API", e);
		}
	}
}