package com.mysite.demo.app.recipeat.service;

import com.mysite.demo.app.recipeat.dto.CategoryResponse;
import com.mysite.demo.app.recipeat.dto.CategoryResponse.*;
import com.mysite.demo.app.recipeat.dto.MealResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Slf4j
public class CategoryService {
	private final RestTemplate restTemplate;
	private final RecipeService recipeService;

	private CategoryResponse catJsonResponse;

	@Autowired
	public CategoryService(RestTemplate restTemplate, RecipeService recipeService) {
		this.restTemplate = restTemplate;
		this.recipeService = recipeService;
	}

	public List<Category> getCategoryList(){
		CategoryResponse categoryResponse = getListCategories();
		return categoryResponse.getCategories();
	}

	public void catJsonResponse(){
		String catFullUri = "https://www.themealdb.com/api/json/v1/1/categories.php";
		catJsonResponse = restTemplate.getForObject(catFullUri, CategoryResponse.class);
	}

	private void logApiResponse(Object response) {
		log.info("Output for API: {}", response);
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
	public CategoryResponse getListCategories() {
		try {
//			Call for category Object
			catJsonResponse();

			logApiResponse(catJsonResponse);

			return catJsonResponse;

		} catch (Exception e) {
			log.error(" - Something goes wrong while getting value from API 2-",e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Exception while calling endpoint of API", e);
		}
	}

	/**
	 * Retrieves a list of recipes filtered by the given category name.
	 *
	 * This method queries the underlying data source (e.g., database, external API) to find all recipes
	 * that are associated with the specified category.
	 *
	 * @param categoryName The unique identifier of the category.
	 * @return A list of Recipe objects by their Name representing the filtered recipes.
	 * @throws ResponseStatusException If the specified category is not found.
	 */
	public MealResponse filterByCategory(@RequestParam String categoryName) {
		try {

			String searchBaseUri = "https://www.themealdb.com/api/json/v1/1/filter.php?c=";
			String searchFullUri = searchBaseUri + categoryName;

			MealResponse jsonResponse = recipeService.jsonResponse(searchFullUri);
			logApiResponse(jsonResponse);

			return jsonResponse;

		} catch (Exception e) {
			log.error(" - Something goes wrong while getting value from API 3-",e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Exception while calling endpoint of API", e);
		}
	}
}
