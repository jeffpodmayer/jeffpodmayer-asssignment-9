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

	public List<Recipe> filterRecipes(Predicate<Recipe> filter) {
		return recipes.stream().filter(filter).collect(Collectors.toList());
	}

	public List<Recipe> allRecipes() throws IOException {
		return recipes;
	}

	public List<Recipe> getGlutenFreeRecipes() throws IOException {
		return filterRecipes(Recipe::getGlutenFree);
	}

	public List<Recipe> getVeganRecipes() throws IOException {
		return filterRecipes(Recipe::getVegan);
	}

	public List<Recipe> getVeganAndGlutenFreeRecipes() throws IOException {
		return recipes.stream().filter(gf -> gf.getGlutenFree()).filter(vegan -> vegan.getVegan())
				.collect(Collectors.toList());
	}

	public List<Recipe> getVegetarianRecipes() throws IOException {
		return filterRecipes(Recipe::getVegetarian);
	}

}
