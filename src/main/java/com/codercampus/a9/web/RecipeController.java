package com.codercampus.a9.web;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codercampus.a9.domain.Recipe;
import com.codercampus.a9.service.RecipeService;

@RestController
public class RecipeController {

	@Autowired
	RecipeService recipeService;

	@GetMapping("/all-recipes")
	public List<Recipe> showAllRecipes() throws IOException {
		return recipeService.allRecipes();
	}

	@GetMapping("/gluten-free")
	public List<Recipe> sortGlutenFree() throws IOException {
		return recipeService.getGlutenFree();
	}

	@GetMapping("/vegan")
	public List<Recipe> getVegan() throws IOException {
		return recipeService.getVegan();
	}

	@GetMapping("/vegan-and-gluten-free")
	public List<Recipe> getVeganAndGlutenFree() throws IOException {
		return recipeService.getVeganAndGlutenFree();
	}

	@GetMapping("/vegetarian")
	public List<Recipe> getVegetarian() throws IOException {
		return recipeService.getVegetarian();
	}

}
