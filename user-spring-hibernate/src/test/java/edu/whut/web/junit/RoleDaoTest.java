package edu.whut.web.junit;

import edu.whut.web.dao.RoleDao;
import edu.whut.web.dao.impl.RoleDaoImpl;
import edu.whut.web.domain.Role;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoleDaoTest {
	static RoleDao roleDao;
	static long roleId = 1;
	Role role = null;
	
	@BeforeClass
	public static void before() {
		roleDao = new RoleDaoImpl();
	}

	@AfterClass
	public static void after() {
	}
	@Test
	public void test1FindAllRoles() {
		List<Role> roles = roleDao.findAllOnes();
		assertTrue(roles.size()>0);
	}

	@Test
	public void test2Insert() {
		role = new Role();
		role.setName("硕士研究生");
		role.setDescription("准备得到硕士学位");
		role = roleDao.insert(role);
		roleId = role.getId();
		assertTrue(roleId > 0);
	}

	@Test
	public void test3FindById() {
		role = roleDao.findById(roleId);
		assertTrue(roleId > 0);
	}

	@Test
	public void test4Update() {
		role = roleDao.findById(roleId);
		role.setName("专业硕士研究生");
		role = roleDao.update(role);
		assertNotNull(role);
	}

	@Test
	public void test5Delete() {
		role = roleDao.findById(roleId);
		role = roleDao.delete(role);
		assertNotNull(role);
	}


	
}
