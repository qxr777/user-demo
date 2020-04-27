package edu.whut.web.service.impl;

import java.util.List;

import edu.whut.web.dao.OrganizationDao;
import edu.whut.web.dao.RoleDao;
import edu.whut.web.dao.UserDao;
import edu.whut.web.domain.Organization;
import edu.whut.web.domain.Role;
import edu.whut.web.domain.User;
import edu.whut.web.exception.BaseException;
import edu.whut.web.exception.HaveExistException;
import edu.whut.web.exception.NoUserException;
import edu.whut.web.exception.OverflowException;
import edu.whut.web.exception.PasswordErrorException;
import edu.whut.web.exception.PasswordMatchException;
import edu.whut.web.service.UserService;
import edu.whut.web.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private OrganizationDao organizationDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private MD5 md5;

	@Override
	public Organization enroll(Organization organization, User user) throws OverflowException {
		organization = organizationDao.findById(organization.getId());
		user = userDao.findById(user.getId());
		if(organization.getUsers().size() >= Organization.MAX_NUMBER)
			throw new OverflowException(user.getName());
		else{
			organization.getUsers().add(user);
			organizationDao.update(organization);
//			user.setOrganization(organization);
//			userDao.update(user);
		}			
		return organization;
	}
	
	@Override
	public Organization createOrganization(Organization organization){
		return organizationDao.insert(organization);
	}
	
	@Override
	public Organization updateOrganization(Organization organization){
		return organizationDao.update(organization);
	}
	
	@Override
	public Organization deleteOrganization(Organization organization){
		return organizationDao.delete(organization);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * @return the organizationDao
	 */
	public OrganizationDao getOrganizationDao() {
		return organizationDao;
	}

	/**
	 * @param organizationDao the organizationDao to set
	 */
	public void setOrganizationDao(OrganizationDao organizationDao) {
		this.organizationDao = organizationDao;
	}

	/**
	 * @return the roleDao
	 */
	public RoleDao getRoleDao() {
		return roleDao;
	}

	/**
	 * @param roleDao the roleDao to set
	 */
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	/**
	 * @return the md5
	 */
	public MD5 getMd5() {
		return md5;
	}

	/**
	 * @param md5 the md5 to set
	 */
	public void setMd5(MD5 md5) {
		this.md5 = md5;
	}

	@Override
	public User createUser(User user) throws BaseException {
		if (!user.getPassword().equals(user.getPassword2()))
			throw new PasswordMatchException();
		if (userDao.findByName(user.getName()) != null) {
			throw new HaveExistException(user.getName());
		}

		preparedCheck(user);		
		user.setPassword(md5.getMD5ofStr(user.getPassword()));
		return userDao.insert(user);
	}

	@Override
	public User updateUser(User user) throws BaseException {
//		preparedCheck(user);		
		return userDao.merge(user);
	}
	
	private void preparedCheck(User user) throws BaseException{
		long organizationId = user.getOrganization().getId();
		Organization organization = organizationDao.findById(organizationId);
		if (organization.getUsers().size() >= Organization.MAX_NUMBER)
			throw new OverflowException(organization.getName());
		if (user.getRoles() != null) {
			for (Role role : user.getRoles()) {
				if (role != null) {
					role = roleDao.findById(role.getId());
					if (role.getUsers().size() >= Role.MAX_NUMBER)
						throw new OverflowException(role.getName());
				}
			}
		}		
	}

	@Override
	public User deleteUser(User user) {
		return userDao.delete(user);
	}
	
	@Override
	public User getUser(long id){
		return userDao.findById(id);
	}
	
	@Override
	public List<User> getAllUsers(){
		return userDao.findAllOnes();
	}
	
	@Override
	public Organization getOrganization(long id){
		return organizationDao.findById(id);
	}
	
	@Override
	public List<Organization> getAllOrganizations(){
		return organizationDao.findAllOnes();
	}
	
	@Override
	public List<Role> getAllRoles(){
		return roleDao.findAllOnes();
	}
	
	@Override
	public Role createRole(Role role){
		return roleDao.insert(role);
	}
	
	@Override
	public Role updateRole(Role role){
		return roleDao.update(role);
	}
	
	@Override
	public Role deleteRole(Role role){
		return roleDao.delete(role);
	}

	@Override
	public boolean valid(String userName, String password) throws NoUserException, PasswordErrorException {
		User userInDB = userDao.findByName(userName);
		if (userInDB == null)
			throw new NoUserException();
		if (userInDB != null
				&& !userInDB.getPassword()
				.equals(md5.getMD5ofStr(password)))
			throw new PasswordErrorException();
		return true;
	}

	@Override
	public Role getRole(long id) {
		return roleDao.findById(id);
	}

//	@Override
//	public User assign(User user, Role role) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
