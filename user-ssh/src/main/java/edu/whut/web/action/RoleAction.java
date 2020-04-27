package edu.whut.web.action;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.whut.web.domain.Organization;
import edu.whut.web.domain.Role;
import edu.whut.web.exception.BaseException;
import edu.whut.web.service.UserService;

public class RoleAction extends ActionSupport implements ModelDriven<Role>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2747370951399213667L;
	private UserService userService;
	private Role role = new Role();

	public String execute() throws Exception
	{
		return SUCCESS;
	}
	
	public String addRole() throws SQLException {
		userService.createRole(role);
		return SUCCESS;
	}
	
	public String showRole() throws BaseException {
		Role roleShow = userService.getRole(role.getId());
		ActionContext.getContext().put("role", roleShow);
		return INPUT;
	}
	
	public String updateRole() throws BaseException {
		userService.updateRole(role);
		return SUCCESS;
	}
	
	public String deleteRole() throws BaseException {
		userService.deleteRole(role);
		return SUCCESS;
	}	

	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Role getModel() {
		return role; 
	}
}