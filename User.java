package com.example.demo.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mongodb.BasicDBObject;


@Document( collection = "users")
public class User {

  @Id
  private String id;

  @Indexed
  private String name;

  @Indexed
  private String email;
  
  @Indexed
  private String password;
  
  @Field("forms")
  private List<Object> form;
  
  @Field("responses")
  private List<Object> response;
 

  public User() {};
  
	public User(String id, String name, String email, String password, List<Object> form , List<Object> response) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.form = form;
		this.response = response;
	}
	
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public List<Object> getForm() {
		return form;
	}
	
	public void setForm(List<Object> form) {
		this.form = form;
	}

	public List<Object> getResponse() {
		return response;
	}

	public void setResponse(List<Object> response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", form=" + form
				+ ", response=" + response + "]";
	}
	

  

}
