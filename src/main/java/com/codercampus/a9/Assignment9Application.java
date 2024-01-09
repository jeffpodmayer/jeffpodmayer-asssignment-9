package com.codercampus.a9;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Assignment9Application {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Assignment9Application.class, args);
	}

	
	//TO DO FOR TOMORROW:
	//-> create a recipeService class for sorting - don't forget to use the @Service annotation
		//-> use streams to sort data and call the getAllRecipes method to use the streams
		//-> look up correct data types to use within all of the methods
	//-> call all appropriate methods within the recipeController
	//-> Look up how to use a java repository class to store all of the recipe objects. use the @repository annotation
		//-> possibly attempt to refactor with repository
	
}
