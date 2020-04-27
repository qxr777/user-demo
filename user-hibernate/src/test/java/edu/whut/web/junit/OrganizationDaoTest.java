package edu.whut.web.junit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;

import edu.whut.web.dao.OrganizationDao;
import edu.whut.web.dao.impl.OrganizationDaoImpl;
import edu.whut.web.domain.Organization;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrganizationDaoTest {
	static OrganizationDao organizationDao;
	static long organizationId = 1;
	Organization organization = null;
	
	@BeforeClass
	public static void before() {
		organizationDao = new OrganizationDaoImpl();
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
	public void test2Insert() {
		organization = new Organization();
		organization.setName("计算机1803班");
		organization.setDescription("计算机18级实验班");
		organization = organizationDao.insert(organization);
		organizationId = organization.getId();
		assertTrue(organizationId > 0);
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
