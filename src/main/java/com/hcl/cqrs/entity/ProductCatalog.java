package com.hcl.cqrs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductCatalog {

	@Id
	private String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;

	public ProductCatalog() {

	}

	public ProductCatalog(String id, String name) {
		this.id = id;
		this.name = name;
	}

}
