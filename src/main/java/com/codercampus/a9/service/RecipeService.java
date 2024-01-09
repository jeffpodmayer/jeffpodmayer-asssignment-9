package com.codercampus.a9.service;

import java.io.IOException;
import java.util.List;
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
	
	public List<Recipe> allRecipes() throws IOException {
		return recipes;
		
	}
	
	public List<Recipe> getGlutenFree() throws IOException {
		return recipes.stream()
					  .filter(gf -> gf.getGlutenFree())
					  .collect(Collectors.toList());
	}
	
	public List<Recipe> getVegan() throws IOException {
		return recipes.stream()
					  .filter(vegan -> vegan.getVegan())
					  .collect(Collectors.toList());
	}

	public List<Recipe> getVeganAndGlutenFree() throws IOException {
		return recipes.stream()
					  .filter(gf -> gf.getGlutenFree())
					  .filter(gf -> gf.getVegan())
					  .collect(Collectors.toList());
	}
	
	public List<Recipe> getVegetarian() throws IOException {
		return recipes.stream()
					  .filter(veggie -> veggie.getVegetarian())
					  .collect(Collectors.toList());
	}


	
}
