package com.codercampus.a9.web;

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
	public List<Recipe> showAllRecipes() {
		return recipeService.allRecipes();
	}

	@GetMapping("/gluten-free")
	public List<Recipe> sortGlutenFree() {
		return recipeService.getGlutenFreeRecipes();
	}

	@GetMapping("/vegan")
	public List<Recipe> getVegan(){
		return recipeService.getVeganRecipes();
	}

	@GetMapping("/vegan-and-gluten-free")
	public List<Recipe> getVeganAndGlutenFree(){
		return recipeService.getVeganAndGlutenFreeRecipes();
	}

	@GetMapping("/vegetarian")
	public List<Recipe> getVegetarian(){
		return recipeService.getVegetarianRecipes();
	}
	
	@GetMapping("/dairy-free")
	public List<Recipe> getDairyFree(){
		return recipeService.getDairyFreeRecipes();
	}

}
