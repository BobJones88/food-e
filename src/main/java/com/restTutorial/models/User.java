package com.restTutorial.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "firstName", length = 45)
	private String firstName;
	
	@Column(name = "lastName", length = 45)
	private String lastName;
	
	@Column(name = "userName", length = 45)
	private String userName;
	
	public User(){}
	
	public User(Long id, String firstName, String lastName, String userName){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Long getId(){ return this.id; }
	public void setId(Long id) { this.id = id; }
	
	public String getFirstName() { return this.firstName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }
	
	public String getLastName() { return this.lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	
	public String getUserName() { return this.userName; }
	public void setUserName(String userName) { this.userName = userName; }
}
