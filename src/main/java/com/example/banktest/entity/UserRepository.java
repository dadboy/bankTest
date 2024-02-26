package com.example.banktest.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author despinoza
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);
}
