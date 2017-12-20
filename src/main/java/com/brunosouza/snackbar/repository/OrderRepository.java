package com.brunosouza.snackbar.repository;

import org.springframework.data.repository.CrudRepository;

import com.brunosouza.snackbar.model.Order;

public interface OrderRepository extends CrudRepository<Order, Integer>{

	Iterable<Order> findByDescriptionContaining(String description);

	Order findById(Integer id);

}
