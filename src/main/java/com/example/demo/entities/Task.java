package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class Task {
	@Id
	@GeneratedValue
	private Long id;
	@NotEmpty
	private String date;
	@NotEmpty
	private String starttime;
	@NotEmpty
	private String stopTime;
	@NotEmpty
	private String description;
	@ManyToOne()
	@JoinColumn(name = "EMAIL_USER")
	private User user;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getStopTime() {
		return stopTime;
	}
	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Task(String date, String starttime, String stopTime, String description, User user) {
	
		this.date = date;
		this.starttime = starttime;
		this.stopTime = stopTime;
		this.description = description;
		this.user = user;
	}
	public Task(String date, String starttime, String stopTime, String description) {
		super();
		this.date = date;
		this.starttime = starttime;
		this.stopTime = stopTime;
		this.description = description;
	}
	public Task() {
		
	}
	
	
}
