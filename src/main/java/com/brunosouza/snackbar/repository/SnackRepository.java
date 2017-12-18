package com.brunosouza.snackbar.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.brunosouza.snackbar.model.Snack;

public interface SnackRepository extends CrudRepository<Snack, Integer>{
	
	public Snack findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Snack> findByDescriptionContaining(String description);

}
