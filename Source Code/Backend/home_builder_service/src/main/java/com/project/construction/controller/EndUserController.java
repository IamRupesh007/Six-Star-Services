package com.project.construction.controller;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.construction.entity.Role;
import com.project.construction.modal.AllUserModal;
import com.project.construction.modal.EndUserData;
import com.project.construction.modal.EndUserModal;
import com.project.construction.service.EndUserService;

@RestController
@RequestMapping(value = "user")
@RestControllerAdvice
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EndUserController {

	@Autowired
	private EndUserService endUserService;

	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public Map<String, String> createUser(@RequestBody EndUserData endUserData) {
		Integer id = endUserService.createUser(endUserData.getUser(), endUserData.getPassword());
		Map<String, String> response = new HashMap<>();
		response.put("message",  "User created with id " + id);
		
		return response;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/get/{id}")
	public EndUserModal getUser(@PathVariable Integer id) {
		return endUserService.getUser(id);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Map<String, String>> handleException(ConstraintViolationException e) {
		Map<String, String> message = new HashMap<>();
		message.put("message", "User with this email already exists");
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/login/{email}/{password}")
	public EndUserModal login(@PathVariable String email, @PathVariable String password) throws Exception {
		EndUserModal user = endUserService.login(email, password);
		if(user.getRole().equals(Role.SERVICE_PROVIDER)) {
			throw new Exception("Invalid login, please go to login/service to login");
		}
		return user;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/all")
	public AllUserModal getAllUsers() {
		return endUserService.getAllUsers();

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/remove/{id}")
	public Map<String, String> deleteUser(@PathVariable Integer id) {
		Integer deletedId = endUserService.deleteUser(id);
		Map<String, String> response = new HashMap<>();
		response.put("message",  "User deleted with Id "+deletedId);
		return response;
	}

}
