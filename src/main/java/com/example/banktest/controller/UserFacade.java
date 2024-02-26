package com.example.banktest.controller;

import java.util.List;
import java.util.Optional;
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
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                .body(new UserResponseError("El correo ya está registrado"));
	        }
		User savedUser = userRepository.save(user);

		// Crear un objeto UserResponseDTO con la información requerida
		UserResponse responseDTO = 
					new UserResponse(savedUser.getId(), 
									savedUser.getCreated().toString(),
									savedUser.getModified().toString(), 
									savedUser.getLaslogin().toString(),
									savedUser.getToken(), 
									"true" // Reemplaza esto con la lógica para determinar el estado activo

		);
		return ResponseEntity.ok(responseDTO);

	}

	public ResponseEntity<List<User>> findAll() {

		List<User> users = userRepository.findAll();

		return ResponseEntity.ok(users);

//		return (ResponseEntity<User>) userRepository.findAll();

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
			phone.setCitycode(phoneDTO.getCitycode());
			phone.setContrycode(phoneDTO.getContrycode());
			return phone;
		}
	}
}
