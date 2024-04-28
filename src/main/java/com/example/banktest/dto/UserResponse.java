package com.example.banktest.dto;

import java.util.UUID;

/**
 *
 * @author despinoza
 *
 */
public class UserResponse {

	private UUID id;

	private String created;

	private String modified;

	private String laslogin;

	private String token;

	private String isActive;

	// Constructor
	public UserResponse(UUID uuid, String created, String modified, String laslogin, String token, String isActive) {
		this.setId(uuid);
		this.created = created;
		this.modified = modified;
		this.laslogin = laslogin;
		this.token = token;
		this.isActive = isActive;
	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public String getLaslogin() {
		return laslogin;
	}

	public void setLaslogin(String laslogin) {
		this.laslogin = laslogin;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

}
