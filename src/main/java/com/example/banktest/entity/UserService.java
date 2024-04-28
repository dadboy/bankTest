package com.example.banktest.entity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author despinoza
 *
 */

@Service
public class UserService {
	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public Optional<User> findById(UUID id) {
		return userRepository.findById(id);
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public void deleteById(UUID id) {
		userRepository.deleteById(id);
	}

	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
