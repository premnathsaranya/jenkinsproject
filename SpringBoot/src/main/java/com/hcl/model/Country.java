package com.hcl.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Country {
	@Id
	private int id;
	private String code;
	private String name;

	public int getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

}
