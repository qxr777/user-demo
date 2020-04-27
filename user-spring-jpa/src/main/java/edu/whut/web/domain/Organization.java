package edu.whut.web.domain;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="organization")
@Proxy(lazy = false)
public class Organization {
	@Id
	@Column(name = "ORGANIZATION_ID")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;

	@Column(name="ORGANIZATION_NAME")
	private String name;

	@Column(name="ORGANIZATION_DESCRIPTION")
	private String description;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="USER_ORGANIZATION_ID")
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
   
	public static final int MAX_NUMBER = 5;
}
