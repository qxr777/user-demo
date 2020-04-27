package edu.whut.web.dao;

import edu.whut.web.domain.User;

public interface UserDao extends BaseDao<User> {

	public User findByName(String name);
}
