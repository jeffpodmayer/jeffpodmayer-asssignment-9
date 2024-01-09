package com.codercampus.a9.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codercampus.a9.domain.Recipe;
import com.codercampus.a9.service.FileService;

@RestController
public class RecipeController {
	
	@Autowired
	FileService fileService;
	
	@GetMapping("/all-recipes")
	public List<Recipe> getAllRecipes() throws Exception{
		List<Recipe> recipeList = fileService.readFile();
		return recipeList; 
	}
	
	@GetMapping("/gluten-free")
	public List<Recipe> getGlutenFree() throws IOException{
		List<Recipe> recipeList = fileService.readFile();
		
		List<Recipe> glutenFree = new ArrayList<>();
	
		for(Recipe recipe : recipeList) {
			if(recipe.getGlutenFree() == true) {
				glutenFree.add(recipe);
			}
		}
		return glutenFree ; 
	}
	
	@GetMapping("/vegan")
	public List<Recipe> getVegan() throws IOException{
		List<Recipe> recipeList = fileService.readFile();
		
		List<Recipe> vegan = new ArrayList<>();
		
		for(Recipe recipe : recipeList) {
			if(recipe.getVegan() == true) {
				vegan.add(recipe);
			}
		}
		return vegan;
	}

	@GetMapping("/vegan-and-gluten-free")
	public List<Recipe> getVeganAndGlutenFree() throws IOException{
		List<Recipe> recipeList = fileService.readFile();
		
		List<Recipe> veganAndGlutenFree = new ArrayList<>();
		
		for(Recipe recipe : recipeList) {
			if(recipe.getGlutenFree() == true && recipe.getVegan() == true) {
				veganAndGlutenFree.add(recipe);
			}
		}
		return veganAndGlutenFree;
	}

	@GetMapping("/vegetarian")
	public List<Recipe> getVegetarian() throws IOException{
		List<Recipe> recipeList = fileService.readFile();
		
		List<Recipe> vegetarian = new ArrayList<>();
		
		for(Recipe recipe : recipeList) {
			if(recipe.getVegetarian() == true) {
				vegetarian.add(recipe);
			}
		}
		return vegetarian;
	}
	
}


