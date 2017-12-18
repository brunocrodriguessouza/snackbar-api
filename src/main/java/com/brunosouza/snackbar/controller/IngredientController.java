package com.brunosouza.snackbar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brunosouza.snackbar.model.Ingredient;
import com.brunosouza.snackbar.service.IngredientService;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

	@Autowired
	IngredientService ingredientService;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Ingredient> getAllIngredients(@RequestParam(value = "description", required=false) String description) {
		if (description == null) {
			return ingredientService.getAllIngredients();
		}
		return ingredientService.getIngredientByDescription(description);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Ingredient getIngredientById(@PathVariable("id") int id) {
		return ingredientService.getIngredientById(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertIngredient(@RequestBody Ingredient ingredient) {
		ingredientService.insertIngredient(ingredient);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateIngredient(@RequestBody Ingredient ingredient) {
		ingredientService.updateIngredient(ingredient);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void removeIngredientById(@PathVariable("id") int id) {
		ingredientService.removeIngredientById(id);
	}
}
