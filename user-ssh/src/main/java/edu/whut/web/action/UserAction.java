package edu.whut.web.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import edu.whut.web.domain.dto.UserDTO;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.whut.web.domain.Message;
import edu.whut.web.domain.Organization;
import edu.whut.web.domain.Role;
import edu.whut.web.domain.User;
import edu.whut.web.exception.BaseException;
import edu.whut.web.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5854764543619117481L;
	private UserService userService;
	private User user = new User();
	private Message message;
	
	public String execute() throws Exception
	{
		return SUCCESS;
	}
	
	public String deleteUser() throws BaseException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String idStr = request.getParameter("id");
		if(idStr!=null){
			user.setId(Integer.parseInt(idStr));
		}
		userService.deleteUser(user);
		return SUCCESS;
	}

	public String registerUser() throws BaseException {
		userService.createUser(user);
		return SUCCESS;
	}
	public void validateRegisterUser(){
		if(!user.getPassword().equals(user.getPassword2()))
			addFieldError("user","密码不匹配！");
	}

	public String updateUser() throws BaseException {
		userService.updateUser(user);
		return SUCCESS;
	}

	public String showAllUser() throws BaseException {
		List<User> users = userService.getAllUsers();
		List<Organization> organizations = userService.getAllOrganizations();
		List<Role> roles = userService.getAllRoles();
		ActionContext.getContext().put("users", users);
		ActionContext.getContext().put("organizations", organizations);
		ActionContext.getContext().put("roles", roles);
		return SUCCESS;
	}
	
	@JSON(name = "message")
	public Message getMessage() {
		return message;
	}
	
	public String listUser() {
		message = new Message();
		List<User> users = userService.getAllUsers();
		message.setObject(users);

		return "message";
	}
	
	public String editUser() throws IOException, BaseException {
		message = new Message();
		
//		if(user.getOrgId() != null && user.getOrgId().trim().length() > 0){
//			Organization organization = userService.getOrganization(Long.parseLong(user.getOrgId()));
//			user.setOrganization(organization);
//		}
		
		userService.updateUser(user);
		
		return "message";
	}
	
	public String destroyUser() throws BaseException {
		message = new Message();
		userService.deleteUser(user);
		return "message";
	}
	
	public String showUser() throws BaseException {
		User userShow = userService.getUser(user.getId());
		ActionContext.getContext().getSession().put("editUser", userShow);
		return INPUT;
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

	public User getModel() {
		return user; 
	}

}