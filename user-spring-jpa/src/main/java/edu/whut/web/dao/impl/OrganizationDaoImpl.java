package edu.whut.web.dao.impl;

import edu.whut.web.dao.OrganizationDao;
import edu.whut.web.domain.Organization;
import org.springframework.stereotype.Repository;

@Repository("organizationDao")
public class OrganizationDaoImpl extends BaseDaoImpl<Organization> implements OrganizationDao {

}
