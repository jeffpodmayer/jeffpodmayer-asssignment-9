package com.codercampus.a9.service;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.a9.domain.Recipe;

import jakarta.annotation.PostConstruct;

@Service
public class RecipeService {

	@Autowired
	private FileService fileService;

	private List<Recipe> recipes;

	@PostConstruct
	public void createRecipeList() throws IOException {
		recipes = fileService.readFile();
	}

	public List<Recipe> filterRecipes(Predicate<Recipe> filterForRecipe) {
		return recipes.stream().filter(filterForRecipe).collect(Collectors.toList());
	}

	public List<Recipe> allRecipes(){
		return recipes;
	}

	public List<Recipe> getGlutenFreeRecipes(){
		return filterRecipes(Recipe::getGlutenFree);
	}

	public List<Recipe> getVeganRecipes(){
		return filterRecipes(Recipe::getVegan);
	}

	public List<Recipe> getVeganAndGlutenFreeRecipes(){
		return recipes.stream().filter(gf -> gf.getGlutenFree()).filter(vegan -> vegan.getVegan())
				.collect(Collectors.toList());
	}

	public List<Recipe> getVegetarianRecipes(){
		return filterRecipes(Recipe::getVegetarian);
	}

	public List<Recipe> getDairyFreeRecipes(){
		return filterRecipes(Recipe::getDairyFree);
	}

	
	//methods below count the number of recipes - used this to double check for correct functionality
	// 100 total recipes
	// 42 Dairy Free recipes
	public long countDairyFreeRecipes(){ 
		return recipes.stream().filter(recipe -> recipe.getDairyFree()).count();
	}

	// 55 gf recipes
	public long countGlutenFreeRecipes(){
		return recipes.stream().filter(recipe -> recipe.getGlutenFree()).count();
	}

	// 14 vegan recipes
	public long countVeganRecipes(){
		return recipes.stream().filter(recipe -> recipe.getVegan()).count();
	}

	// 13 vegan and gluten free recipes
	public long countVeganAndGlutenFreeRecipes(){
		return recipes.stream().filter(gf -> gf.getGlutenFree()).filter(vegan -> vegan.getVegan()).count();
	}
	
	// 49 vegetarian recipes
	public long countVegetarianRecipes(){
		return recipes.stream().filter(recipe -> recipe.getVegetarian()).count();
	}
}
