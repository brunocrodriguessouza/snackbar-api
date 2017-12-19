package com.brunosouza.snackbar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brunosouza.snackbar.messages.ResponseMessage;
import com.brunosouza.snackbar.model.Order;
import com.brunosouza.snackbar.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Order> getAllsnacks(@RequestParam(value = "description", required = false) String description) {
		if (description == null) {
			return orderService.getAllOrders();
		}
		return orderService.getOrderByDescription(description);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Order getOrderById(@PathVariable("id") int id) {
		return orderService.getOrderById(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseMessage insertOrder(@RequestBody Order order) {
		orderService.insertOrder(order);
		return new ResponseMessage("Success", "Order " + order.getId() + " inserted successfully");
	}

}
