package edu.whut.web.junit;

import edu.whut.web.domain.Organization;
import edu.whut.web.domain.Role;
import edu.whut.web.domain.User;
import edu.whut.web.exception.BaseException;
import edu.whut.web.exception.OverflowException;
import edu.whut.web.service.UserService;
import edu.whut.web.util.MD5;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class UserServiceTest {
	static UserService userService;
	User user = null;
	Organization organization = null;
	Role role = null;
	static long userId = 2;
	
	@BeforeClass
	public static void before() {
		String[] configLocations = { "classpath:bean.xml"};
		ApplicationContext context = new FileSystemXmlApplicationContext(
				configLocations);
		userService = (UserService) context.getBean("userService");
	}

	@AfterClass
	public static void after() {
	}
	
	@Test
	public void test3Enroll() {
		User user = new User();
		user.setId(userId);
		Organization organization = new Organization();
		organization.setId(3);
		try {
			organization = userService.enroll(organization, user);
		} catch (OverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(organization.getUsers().size()>0);
	}

	@Test
	public void test1CreateUser(){
		user = new User();
		user.setName("qxr777");
		user.setEmail("eee@163.com");
		MD5 md5 = new MD5();
		user.setPassword("888");
		user.setPassword2("888");
		Organization organization = new Organization();
		organization.setId(1);
		user.setOrganization(organization);
		Set<Role> roles = new HashSet<Role>();
		Role role1 = new Role();
		role1.setId(1);
		roles.add(role1);
//		Role role2 = new Role();
//		role2.setId(2);
//		roles.add(role2);
		user.setRoles(roles);
		try {
			user = userService.createUser(user);
			userId = user.getId();
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(user);		
	}
	
	@Test
	public void test2UpdateUser(){
		user = userService.getUser(userId);
		user.setName("qxr777");
		user.setEmail("tommy@163.com");
		MD5 md5 = new MD5();
		user.setPassword(md5.getMD5ofStr("123456"));
		Organization organization = new Organization();
		organization.setId(1);
		user.setOrganization(organization);
		Set<Role> roles = new HashSet<Role>();
		Role role1 = new Role();
		role1.setId(1);
		roles.add(role1);
//		Role role2 = new Role();
//		role2.setId(2);
//		roles.add(role2);
		user.getRoles().clear();
		user.setRoles(roles);
		try {
			user = userService.updateUser(user);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(user);		
	}	

}
