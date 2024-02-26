package com.example.banktest.dto;

public class UserResponse {

	private Long id;

	private String created;

	private String modified;

	private String laslogin;

	private String token;

	private String isActive;

	// Constructor
	public UserResponse(Long id, String created, String modified, String laslogin, String token, String isActive) {
		this.id = id;
		this.created = created;
		this.modified = modified;
		this.laslogin = laslogin;
		this.token = token;
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

}
