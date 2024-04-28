package com.example.banktest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.banktest.dto.UserRequest;
import com.example.banktest.entity.User;

/**
 *
 * @author despinoza
 *
 */

@RestController
@RequestMapping("/api/v1/users")
@Validated
public class UserController {

	@Autowired
	private UserFacade userFacade;

	@PostMapping(value = "/", consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@Valid @RequestBody UserRequest userRequest,
			@RequestHeader(value = "x-auth-token") String xAuthToken) {

		ResponseEntity<?> response = userFacade.save(userRequest, xAuthToken);

		return ResponseEntity.ok(response.getBody());
	}

	@GetMapping
	public ResponseEntity<List<User>> findAll(@RequestHeader(value = "x-auth-token") String xAuthToken) {

		ResponseEntity<List<User>> usersResponse = userFacade.findAll();

		List<User> users = usersResponse.getBody();

		if (users == null || users.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(users);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable String id,
			@RequestHeader(value = "x-auth-token") String xAuthToken) {

		ResponseEntity<?> usersResponse = userFacade.findById(id);

		return ResponseEntity.ok(usersResponse.getBody());
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable String id, @Valid @RequestBody UserRequest userRequest,
			@RequestHeader(value = "x-auth-token") String xAuthToken) {

		ResponseEntity<?> response = userFacade.update(userRequest, xAuthToken, id);

		return ResponseEntity.ok(response.getBody());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable String id, @RequestHeader(value = "x-auth-token") String xAuthToken) {

		ResponseEntity<?> response = userFacade.delete(id);

		if (response.getStatusCode() == HttpStatus.OK) {
			return ResponseEntity.accepted().build();
		} else if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
			return ResponseEntity.notFound().build();
		} else {
			return response;
		}
	}

}
