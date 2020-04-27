package edu.whut.web.domain;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Set;

public class Role {

	private long id;

	private String name;

	private String description;

	private Set<User> users;

	public Role() {
		super();
		name = "";
		description = "";
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj != null) {
			if (!(obj instanceof Role))
				return false;
			return this.getId() == ((Role) obj).getId();
		}
		return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		int result = 17;
		result = 31 * result + (int) (this.id ^ (this.id >>> 32));
		return result;
	}	
	
	public static final int MAX_NUMBER = 5;	
}
