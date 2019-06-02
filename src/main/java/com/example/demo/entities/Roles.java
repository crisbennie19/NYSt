package com.example.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Roles {
    @Id
	private String name;
	@ManyToMany(mappedBy = "role")
	private List<User> user;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	public Roles(String name, List<User> user) {
		this.name = name;
		this.user = user;
	}
	public Roles(String name) {
		this.name = name;
	}
	public Roles() {

	}
	
	
}
