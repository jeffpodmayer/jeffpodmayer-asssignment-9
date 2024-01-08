package com.codercampus.a9.web;

import java.io.IOException;
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
	public List<Recipe> getAllRecipes() throws IOException{
		return fileService.readFile();
		
		
	}
}


