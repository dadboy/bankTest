package com.example.banktest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author despinoza
 *
 */

@Entity
@Table(name = "phones")
public class Phone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String number;
	private String cityCode;
	private String countryCode;

	// Relación ManyToOne con User
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore // Evita la referencia cíclica al serializar a JSON
	private User user;

	// Getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String citycode) {
		this.cityCode = citycode;
	}

	public String getCuontryCode() {
		return countryCode;
	}

	public void setCountryCode(String contrycode) {
		this.countryCode = contrycode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}