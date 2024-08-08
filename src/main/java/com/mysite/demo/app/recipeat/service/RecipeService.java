package com.mysite.demo.app.recipeat.service;

import com.mysite.demo.app.recipeat.entity.MealResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
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

//**************** Get the meal from client
//		private   String XRapidApiKey = "5dfsfdf7as8gd5gd6f2as07";
	// Βασικό URI του API
//		private final RecipeRepository repository;

	@Autowired
		private  RestTemplate restTemplate;

		public RecipeService(RestTemplate theRestTemplate) {
			restTemplate = theRestTemplate;
		}

//	public ResponseEntity<MealResponse> getRecipesByName(@RequestParam String name) {
	public Object getRecipesByName(@RequestParam String name) {
		// Βασικό URI του API
		// Δημιουργία πλήρους URI
		//		private   String XRapidApiKey = "5dfsfdf7as8gd5gd6f2as07";
		// Βασικό URI του API
		try {
			String baseUri = "https://www.themealdb.com/api/json/v1/1/search.php?s=";
			String fullUri = baseUri + name;

			// Κλήση του εξωτερικού API
			ResponseEntity<MealResponse> jsonResponse = restTemplate.getForEntity(fullUri, MealResponse.class);
			log.info("Output for a API: {}", jsonResponse.getBody());
			// Επιστροφή των αποτελεσμάτων
			return jsonResponse.getBody();
		} catch (Exception e) {
			log.error(" - Something goes wrong while getting value from API -",e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Exception while calling endpoint of API", e);

		}
	}

	public Object getData() {
			try {
//				Header value is set to (if that exist)
//				HttpHeaders headers =new HttpHeaders();
//				headers.set("X-RapidAPi-Key", "XRapidApiKey");
//				headers.set("null", "null");

//				SET full URI from
//				...
				String baseUri = "https://www.themealdb.com/api/json/v1/1/search.php?s=Saganaki";

//				Call to the API endpoint
//				ResponseEntity<String> response = restTemplate.exchange(api_url, HttpMethod.GET, new HttpEntity<>(headers), String.class);
				ResponseEntity<MealResponse> jsonResponse = restTemplate.getForEntity(baseUri, MealResponse.class);
				log.info("Output for an API: {}", jsonResponse.getBody());

				return jsonResponse;
			} catch (Exception e) {
				log.error(" - Something goes wrong while getting value from API -",e);
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
						"Exception while calling endpoint of API", e);
			}

	}
}

