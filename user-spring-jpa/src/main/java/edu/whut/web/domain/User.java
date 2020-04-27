package edu.whut.web.domain;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="user")
@Proxy(lazy = false)
public class User {
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;

	@Column(name="USER_NAME")
	private String name;

	@Column(name="USER_PASSWORD")
	private String password;

	@Transient
	private String password2;

	@Column(name="USER_EMAIL")
	private String email;

	@Transient
	private long organizationId;

	@ManyToOne
	@JoinColumn(name = "USER_ORGANIZATION_ID")
	private Organization organization;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "user_role",
			joinColumns = { @JoinColumn(name = "USER_ROLE_USER_ID") },
			inverseJoinColumns = { @JoinColumn(name = "USER_ROLE_ROLE_ID") })
	private Set<Role> roles;
	

	
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
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}	
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}    
}
