package edu.whut.web.dao.impl;

import edu.whut.web.dao.RoleDao;
import edu.whut.web.domain.Role;
import org.springframework.stereotype.Repository;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

}
