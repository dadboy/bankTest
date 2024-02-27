package com.example.banktest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.banktest.dto.PhoneDTO;
import com.example.banktest.dto.UserRequest;
import com.example.banktest.dto.UserResponse;
import com.example.banktest.dto.UserResponseError;
import com.example.banktest.entity.Phone;
import com.example.banktest.entity.User;
import com.example.banktest.entity.UserRepository;

/**
 *
 * @author despinoza
 *
 */
@Service
public class UserFacade {

	@Autowired
	private UserRepository userRepository;

	public ResponseEntity<?> save(UserRequest userDTO, String xAuthToken) {

		User user = UserMapper.convertToEntity(userDTO, xAuthToken);

		Optional<User> existingUser = userRepository.findByEmail(userDTO.getEmail());
		if (existingUser.isPresent()) {

			Map<String, String> responseBody = new HashMap<>();
			responseBody.put("error", "El correo ya está registrado");
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body(new UserResponseError("El correo ya está registrado"));
		}
		User savedUser = userRepository.save(user);

		// Crear un objeto UserResponseDTO con la información requerida
		UserResponse responseDTO = new UserResponse(savedUser.getId(), savedUser.getCreated().toString(),
				savedUser.getModified().toString(), savedUser.getLastLogin().toString(), savedUser.getToken(), "true"

		);
		return ResponseEntity.ok(responseDTO);

	}

	public ResponseEntity<List<User>> findAll() {

		List<User> users = userRepository.findAll();
		return ResponseEntity.ok(users);

	}

	public ResponseEntity<?> findById( String id) {

		UUID userId = null;
		try {
			// Convierte el String a UUID
			userId = UUID.fromString(id);

		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body("Invalid UUID format");
		}

		Optional<User> userList = userRepository.findById(userId);

		return ResponseEntity.ok(userList);

	}
	
	public ResponseEntity<?> delete(String id) {
		UUID userId = null;
		try {
			// Convierte el String a UUID
			userId = UUID.fromString(id);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body("Invalid UUID format");
		}

		Optional<User> optionalUser = userRepository.findById(userId);

		if (optionalUser.isPresent()) {
			User deletedUser = optionalUser.get();

			// Elimina el usuario de la base de datos
			userRepository.deleteById(userId);

			return ResponseEntity.ok(deletedUser);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	public ResponseEntity<?> update(UserRequest userDTO, String xAuthToken, String id) {
		UUID userId = null;
		try {
			// Convierte el String a UUID
			userId = UUID.fromString(id);

		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body("Invalid UUID format");
		}

		Optional<User> optionalUser = userRepository.findById(userId);

		// Verifica si el usuario existe
		if (optionalUser.isPresent()) {
			User existingUser = optionalUser.get();

			existingUser.setName(userDTO.getName());
			existingUser.setEmail(userDTO.getEmail());
			existingUser.setPassword(userDTO.getPassword());

			 // Actualiza los teléfonos del usuario
            List<Phone> updatedPhones = updatePhones(existingUser.getPhones(), userDTO.getPhones());
            existingUser.setPhones(updatedPhones);
            
			User savedUser = userRepository.save(existingUser);

			return ResponseEntity.ok(savedUser);
		} else {

			return ResponseEntity.notFound().build();
		}
	}

	public class UserMapper {
		public static User convertToEntity(UserRequest userDTO, String xAuthToken) {
			User user = new User();
			user.setName(userDTO.getName());
			user.setEmail(userDTO.getEmail());
			user.setPassword(userDTO.getPassword());
			user.setToken(xAuthToken);
			List<Phone> phones = userDTO.getPhones().stream().map(PhoneMapper::convertToEntity)
					.collect(Collectors.toList());

			user.setPhones(phones);

			return user;
		}
	}

	public class PhoneMapper {
		public static Phone convertToEntity(PhoneDTO phoneDTO) {
			Phone phone = new Phone();
			phone.setNumber(phoneDTO.getNumber());
			phone.setCityCode(phoneDTO.getCitycode());
			phone.setCityCode(phoneDTO.getContrycode());
			return phone;
		}
	}
	
	private List<Phone> updatePhones(List<Phone> existingPhones, List<PhoneDTO> newPhones) {
		int minSize = Math.min(existingPhones.size(), newPhones.size());

		for (int i = 0; i < minSize; i++) {
			Phone existingPhone = existingPhones.get(i);
			PhoneDTO newPhoneDTO = newPhones.get(i);

			existingPhone.setCityCode(newPhoneDTO.getCitycode());
			existingPhone.setCountryCode(newPhoneDTO.getContrycode());
			existingPhone.setNumber(newPhoneDTO.getNumber());

		}

		for (int i = minSize; i < newPhones.size(); i++) {
			PhoneDTO newPhoneDTO = newPhones.get(i);

			// Crea un nuevo teléfono con la información de newPhoneDTO
			Phone newPhone = new Phone();
			newPhone.setCityCode(newPhoneDTO.getCitycode());
			newPhone.setCountryCode(newPhoneDTO.getContrycode());
			newPhone.setNumber(newPhoneDTO.getNumber());

			existingPhones.add(newPhone);
		}

		return existingPhones;
	}
}
