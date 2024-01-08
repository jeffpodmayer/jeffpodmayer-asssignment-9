package com.coderscampus.a9.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.stream.StreamSupport;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

@Service
public class FileService {

	public List<CSVRecord> readFile() throws IOException {
		Reader in = new FileReader("recipes.txt");

		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withIgnoreSurroundingSpaces().parse(in);

		for (CSVRecord record : records) {
			Integer cookingMinutes = Integer.parseInt(record.get(0));
			Boolean dairyFree = Boolean.parseBoolean(record.get(1));
			Boolean glutenFree = Boolean.parseBoolean(record.get(2));
			String instructions = record.get(3);
			Double prepMinutes = Double.parseDouble(record.get(4));
			Double pricePerServing = Double.parseDouble(record.get(5));
			Integer readyInMinutes = Integer.parseInt(record.get(6));
			Integer servings = Integer.parseInt(record.get(7));
			Double spoonacularScore = Double.parseDouble(record.get(8));
			String title = record.get(9);
			Boolean vegan = Boolean.parseBoolean(record.get(10));
			Boolean vegetarian = Boolean.parseBoolean(record.get(11));
		}
		
		List<CSVRecord> collection = StreamSupport.stream(records.spliterator(), false)
													.toList();	
		return 	collection;	
	}
}
