package edu.whut.web.service;

import java.util.List;

import edu.whut.web.domain.Organization;
import edu.whut.web.domain.Role;
import edu.whut.web.domain.User;
import edu.whut.web.exception.BaseException;
import edu.whut.web.exception.NoUserException;
import edu.whut.web.exception.OverflowException;
import edu.whut.web.exception.PasswordErrorException;

public interface UserService {
	public Organization enroll(Organization organization, User user) throws OverflowException;

	public Organization createOrganization(Organization organization);

	public Organization updateOrganization(Organization organization);

	public Organization deleteOrganization(Organization organization);
	
	public User createUser(User user) throws BaseException;
	
	public User updateUser(User user) throws BaseException;
	
	public User deleteUser(User user);

	public Role createRole(Role role);

	public Role updateRole(Role role);

	public Role deleteRole(Role role);

	public List<Role> getAllRoles();
	
	public Role getRole(long id);

	public List<Organization> getAllOrganizations();

	public Organization getOrganization(long id);

	public List<User> getAllUsers();

	public User getUser(long id);
	
	public boolean valid(String userName, String password) throws NoUserException, PasswordErrorException;
	
//	public User assign(User user, Role role);

}
