package com.example.banktest.config;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.banktest.entity.Phone;
import com.example.banktest.entity.User;
import com.example.banktest.entity.UserRepository;

/**
 *
 * @author despinoza
 *
 */
@Component
public class DataLoader implements CommandLineRunner {

	private final UserRepository userRepository;

	@Autowired
	public DataLoader(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... args) {
		// Verifica si ya hay usuarios en la base de datos
		if (userRepository.count() == 0) {
			// Si no hay usuarios, crea 10 usuarios por defecto
			List<User> defaultUsers = createDefaultUsers();
			userRepository.saveAll(defaultUsers);
		}
	}

	private List<User> createDefaultUsers() {
		return IntStream.rangeClosed(1, 10).mapToObj(i -> {
			User user = new User();
			user.setName("User" + i);
			user.setEmail("user" + i + "@example.com");
			user.setPassword("password" + i);

			List<Phone> userPhones = new ArrayList<>();

			Phone phone = new Phone();
			phone.setCityCode("10" + i);
			phone.setCountryCode("20" + i);
			phone.setNumber(incrementLastDigit("9903766043"));
			phone.setUser(user);

			userPhones.add(phone);
			user.setPhones(userPhones);

			// Agrega otros valores según tus necesidades
			return user;
		}).collect(Collectors.toList());
	}

	private String incrementLastDigit(String number) {
		// Verifica si el último dígito es '3', y si es así, cámbialo a '4'
		if (number.endsWith("3")) {
			return number.substring(0, number.length() - 1) + "4";
		} else {
			// Si el último dígito no es '3', simplemente retorna el número sin cambios
			return number;
		}
	}
}