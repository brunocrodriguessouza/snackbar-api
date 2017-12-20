package com.brunosouza.snackbar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunosouza.snackbar.exception.ExceptionAlreadyExists;
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

	public void insertSnack(Snack snack) throws ExceptionAlreadyExists{
		checkSnacksAlreadyExists(snack);
		snackRepository.save(snack);
	}

	public void removeSnackById(int id) {
		snackRepository.delete(id);
	}

	public void updateSnack(Snack snack) throws ExceptionAlreadyExists{
		snackRepository.save(snack);
	}

	public void checkSnacksAlreadyExists(Snack snack) throws ExceptionAlreadyExists {

		List<Snack> listSnackAlreadyExists = snackRepository.findByDescription(snack.getDescription());

		if (!listSnackAlreadyExists.isEmpty()
				&& (snack.getId() == null || listSnackAlreadyExists.get(0).getId().compareTo(snack.getId()) != 0)) {
			throw new ExceptionAlreadyExists();
		}
	}
}
