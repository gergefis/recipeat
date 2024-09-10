package com.mysite.demo.app.recipeat.recipe.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryResponse {

	private List<Category> categories;

	public CategoryResponse() {
	}

	public CategoryResponse(List<Category> categories) {
		this.categories = categories;
	}

	// Getter
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Category {

		private String strCategory;

		public Category() {
		}

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

