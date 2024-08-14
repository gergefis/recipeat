package com.mysite.demo.app.recipeat.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryResponse {

	private List<Category> categories;

	// Default Constructor
	public CategoryResponse() {
	}

	// Constructor
	public CategoryResponse(List<Category> categories) {
		this.categories = categories;
	}

	// Getters / Setters
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Category {
		// Fields
		private String strCategory;

		// Default Constructor
		public Category() {
		}

		// Constructor
		public Category(String strCategory) {
			this.strCategory = strCategory;
		}

		// Getters / Setters
		public String getStrCategory() {
			return strCategory;
		}

		public void setStrCategory(String strCategory) {
			this.strCategory = strCategory;
		}
	}
}

