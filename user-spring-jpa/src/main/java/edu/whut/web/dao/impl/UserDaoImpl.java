package edu.whut.web.dao.impl;

import edu.whut.web.dao.UserDao;
import edu.whut.web.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public User findByName(String name) {
        List<User> users = em.createQuery("SELECT e " +
                "FROM User e " +
                "WHERE e.name = :name")
                .setParameter("name", name)
                .getResultList();
        if (users != null && users.size() > 0)
            return users.get(0);
        return null;
    }

}
