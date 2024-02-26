package com.example.banktest.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.banktest.dto.UserResponse;
import com.example.banktest.entity.User;
import com.example.banktest.entity.UserService;

/**
 *
 * @author despinoza
 *
 */

@RestController
@RequestMapping("/api/v1/users")
@Validated
public class UserController {

	private final UserService userService;

	@Autowired
	private UserFacade userFacade;

	// TODO; eliminar
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping(value = "/", consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@Valid @RequestBody UserRequest userRequest, 
			 @RequestHeader(value = "x-auth-token") String xAuthToken) {

		ResponseEntity<?> response = userFacade.save(userRequest,xAuthToken);

		return ResponseEntity.ok(response.getBody());
//		return userFacade.save(userRequest);
	}

	@GetMapping
	public ResponseEntity<List<User>> findAll() {

		ResponseEntity<List<User>> usersResponse = userFacade.findAll();
		// Obtén la lista de usuarios del ResponseEntity
		List<User> users = usersResponse.getBody();
		// Verifica si la lista de usuarios está vacía
		if (users == null || users.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(users);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		Optional<User> product = userService.findById(id);

		return ResponseEntity.ok(userService.findById(id).get());
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @Valid @RequestBody User user) {
		return ResponseEntity.accepted().body(userService.save(user));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		userService.deleteById(id);

		return ResponseEntity.accepted().build();
	}

//    @GetMapping("/public")
//    public String publicEndpoint() {
//        return "Public Endpoint";
//    }
//
//    @GetMapping("/secure")
//    @PreAuthorize("hasRole('ROLE_USER')")
//    public String secureEndpoint() {
//        return "Secure Endpoint";
//    }

}
