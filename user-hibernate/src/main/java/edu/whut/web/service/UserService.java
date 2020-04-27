package edu.whut.web.service;

import edu.whut.web.domain.Organization;
import edu.whut.web.domain.Role;
import edu.whut.web.domain.User;

public interface UserService {
	public User enroll(Organization organization, User user);
	
	public User assign(User user, Role role);

}
