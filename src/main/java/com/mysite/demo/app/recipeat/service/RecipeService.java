package com.mysite.demo.app.recipeat.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

// 		I will create the endpoint
@Service
@Slf4j
public class RecipeService {

//	@Value("{recipe.search}")

		private   String XRapidApiKey = "5dfsfdf7as8gd5gd6f2as07";
		private final String api_url = "www.themealdb.com/api/json/v1/1/search.php?s=Arrabiata";
//		private final RecipeRepository repository;

	@Autowired
		private  RestTemplate restTemplate;

		public RecipeService(RestTemplate theRestTemplate) {
			restTemplate = theRestTemplate;
		}

	public Object getData() {
			try {
//				Header value is set to (if that exist)
//				HttpHeaders headers =new HttpHeaders();
//				headers.set("X-RapidAPi-Key", "XRapidApiKey");
//				headers.set("null", "null");

//				Call to the API endpoint
				ResponseEntity<String> response = restTemplate.exchange(api_url, HttpMethod.GET, null,/*new HttpEntity<>(headers),*/ String.class);

				log.info("Output for a API: {}", response.getBody());

				return response.getBody();
			} catch (Exception e) {
				log.error(" - Something goes wrong while getting value from API -",e);
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
						"Exception while calling endpoint of API", e);
			}

	}
}

