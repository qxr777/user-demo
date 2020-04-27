package edu.whut.web.dao.impl;

import java.util.List;

import edu.whut.web.dao.UserDao;
import edu.whut.web.domain.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User findByName(String name){
		String hql = "from User as model where model.name = ?";
		Object[] value = {name};
		List<User> users = (List<User>)getHibernateTemplate().find(hql, value);
		if(users != null && users.size() > 0)
			return users.get(0);
		return null;
	}

}
