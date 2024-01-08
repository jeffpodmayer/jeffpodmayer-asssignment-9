package com.coderscampus.a9.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.coderscampus.a9.domain.Recipe;

@Service
public class FileService {
	List<Recipe> recipeList = new ArrayList<>();
	
	public List<Recipe> readFile() throws IOException {
		Reader readRecipes = new FileReader("recipes.txt");
		Iterable<CSVRecord> recipes = CSVFormat.DEFAULT.withSkipHeaderRecord().withIgnoreSurroundingSpaces().parse(readRecipes);
		
		for (CSVRecord recipe : recipes) {
			Recipe newRecipe = new Recipe(
					Integer.parseInt(recipe.get(0)),
					Boolean.parseBoolean(recipe.get(1)),
					Boolean.parseBoolean(recipe.get(2)),
					recipe.get(3),
					Double.parseDouble(recipe.get(4)),
					Double.parseDouble(recipe.get(5)),
					Integer.parseInt(recipe.get(6)),
					Integer.parseInt(recipe.get(7)),
					Double.parseDouble(recipe.get(8)),
					recipe.get(9),
					Boolean.parseBoolean(recipe.get(10)),
					Boolean.parseBoolean(recipe.get(11))
			);
			
			recipeList.add(newRecipe);
		}
		
		
		return recipeList;	
	}
}
