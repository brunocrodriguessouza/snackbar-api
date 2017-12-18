package com.brunosouza.snackbar.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.brunosouza.snackbar.model.Ingredient;


public interface IngredientRepository extends CrudRepository<Ingredient, Integer>{
	
	Ingredient findById(Integer id);
	
	void delete(Integer id);
	
	public List<Ingredient> findByDescriptionContaining(String description);
}
