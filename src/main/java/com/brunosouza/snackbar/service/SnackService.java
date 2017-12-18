package com.brunosouza.snackbar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunosouza.snackbar.model.Ingredient;
import com.brunosouza.snackbar.model.Snack;
import com.brunosouza.snackbar.repository.SnackRepository;

@Service
public class SnackService {
	
	@Autowired
	SnackRepository snackRepository;

	public Iterable<Snack> getAllsnacks() {
		return snackRepository.findAll();
	}
	
	public Snack getSnackById(int id) {
		return snackRepository.findById(id);
	}

	public Iterable<Snack> getSnackByDescription(String description) {
		return snackRepository.findByDescriptionContaining(description);
	}
	
	public void insertSnack(Snack snack) {
		snackRepository.save(snack);
	}
	
	public void removeSnackById(int id) {
		snackRepository.delete(id);
	}

	public void updateSnack(Snack snack) {
		snackRepository.save(snack);
	}

}
