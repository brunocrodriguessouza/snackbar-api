package com.brunosouza.snackbar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunosouza.snackbar.model.Order;
import com.brunosouza.snackbar.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;

	public Iterable<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	public Iterable<Order> getOrderByDescription(String description) {
		return orderRepository.findByDescriptionContaining(description);
	}

	public Order getOrderById(int id) {
		return orderRepository.findById(id);
	}

	public void insertOrder(Order order){
		orderRepository.save(order);
	}

}
