package com.brunosouza.snackbar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brunosouza.snackbar.exception.ExceptionAlreadyExists;
import com.brunosouza.snackbar.messages.ResponseMessage;
import com.brunosouza.snackbar.model.Snack;
import com.brunosouza.snackbar.service.SnackService;

@RestController
@RequestMapping("/snack")
public class SnackController {

	@Autowired
	SnackService snackservice;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Snack> getAllsnacks(@RequestParam(value = "description", required = false) String description) {
		if (description == null) {
			return snackservice.getAllsnacks();
		}
		return snackservice.getSnackByDescription(description);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Snack getSnackById(@PathVariable("id") int id) {
		return snackservice.getSnackById(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseMessage insertSnack(@RequestBody Snack snack) {
		try {
			snackservice.insertSnack(snack);
			return new ResponseMessage("Success", "Snack "+ snack.getId() + " inserted successfully" );
		} catch(ExceptionAlreadyExists e) {
			return new ResponseMessage("Error", "Snack Already exists");
		}
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseMessage updateSnack(@RequestBody Snack snack) {
		try {
			snackservice.updateSnack(snack);
			return new ResponseMessage("Success", "Snack " + snack.getId() + " updated successfully" );
		} catch(ExceptionAlreadyExists e) {
			return new ResponseMessage("Error", "Snack Already exists");
		}
		
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void removeSnackById(@PathVariable("id") int id) {
		snackservice.removeSnackById(id);
	}

}
