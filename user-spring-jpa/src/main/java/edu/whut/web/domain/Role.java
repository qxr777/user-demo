package edu.whut.web.domain;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="role")
@Proxy(lazy = false)
public class Role {
	@Id
	@Column(name = "ROLE_ID")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;

	@Column(name="ROLE_NAME")
	private String name;

	@Column(name="ROLE_DESCRIPTION")
	private String description;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "roles")
//	@JoinTable(name = "user_role",
//			joinColumns = { @JoinColumn(name = "USER_ROLE_ROLE_ID") },
//			inverseJoinColumns = { @JoinColumn(name = "USER_ROLE_USER_ID") })
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
