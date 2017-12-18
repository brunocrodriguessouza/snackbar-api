package com.brunosouza.snackbar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunosouza.snackbar.model.Ingredient;
import com.brunosouza.snackbar.repository.IngredientRepository;

@Service
public class IngredientService {
	
	@Autowired
	IngredientRepository ingredientRepository;

	public Iterable<Ingredient> getAllIngredients() {
		return ingredientRepository.findAll();
	}
	
	public Ingredient getIngredientById(int id) {
		return ingredientRepository.findById(id);
	}

	public void insertIngredient(Ingredient ingredient) {
		ingredientRepository.save(ingredient);
	}

	public void removeIngredientById(int id) {
		ingredientRepository.delete(id);
	}

	public void updateIngredient(Ingredient ingredient) {
		ingredientRepository.save(ingredient);
	}

	public Iterable<Ingredient> getIngredientByDescription(String description) {
		return ingredientRepository.findByDescriptionContaining(description);
	}
}
