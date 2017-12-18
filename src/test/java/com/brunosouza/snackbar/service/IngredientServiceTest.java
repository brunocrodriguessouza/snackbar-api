package com.brunosouza.snackbar.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.brunosouza.snackbar.model.EIngredient;
import com.brunosouza.snackbar.model.Ingredient;

public class IngredientServiceTest {
	
	@Autowired
	IngredientService ingredientService;
	
	
	@Test
	public void createTest() {
		
		Ingredient ingredient = new Ingredient();
		ingredient.setDescription(EIngredient.BACON.getDescription());
		ingredient.setValue(EIngredient.BACON.getPrice());
		
		ingredientService.insertIngredient(ingredient);
		
	}

}
