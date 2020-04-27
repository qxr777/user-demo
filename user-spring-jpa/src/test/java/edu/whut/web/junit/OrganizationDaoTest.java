package edu.whut.web.junit;

import edu.whut.web.config.AppConfig;
import edu.whut.web.dao.OrganizationDao;
import edu.whut.web.domain.Organization;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrganizationDaoTest {

	static OrganizationDao organizationDao;

	static long organizationId = 1;
	Organization organization = null;
	
	@BeforeClass
	public static void before() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);
		organizationDao = context.getBean(OrganizationDao.class);
	}

	@AfterClass
	public static void after() {
	}
	@Test
	public void test1FindAllOnes() {
		List<Organization> organizations = organizationDao.findAllOnes();
		assertTrue(organizations.size()>0);
	}

	@Test
	public void test3FindById() {
		organization = organizationDao.findById(organizationId);
		assertNotNull(organization);
	}

	@Test
	public void test4Update() {
		organization = organizationDao.findById(organizationId);
		organization.setName("软件工程1908班");
		organization = organizationDao.update(organization);
		assertNotNull(organization);
	}

	@Test
	public void test5Delete() {
		organization = organizationDao.findById(organizationId);
		organization = organizationDao.delete(organization);
		assertNotNull(organization);
	}


	
}
