package edu.whut.web.domain;

import java.util.Set;

public class Organization {
	private long id;
	private String name;
	private String description;
	private Set<User> users;
	
	public Organization() {
		this.name = "";
		this.description = "";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
   
}
