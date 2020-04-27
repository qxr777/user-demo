package edu.whut.web.action;

import java.sql.SQLException;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.whut.web.domain.Message;
import edu.whut.web.domain.Organization;
import edu.whut.web.domain.User;
import edu.whut.web.exception.BaseException;
import edu.whut.web.service.UserService;

public class OrganizationAction extends ActionSupport implements ModelDriven<Organization>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2747370951399213667L;
	private UserService userService;
	private Organization organization = new Organization();
	private Message message;

	public String execute() throws Exception
	{
		return SUCCESS;
	}
	
	public String addOrganization() throws SQLException {
		userService.createOrganization(organization);
		return SUCCESS;
	}
	
	public String showOrganization() throws BaseException {
		Organization organizationShow = userService.getOrganization(organization.getId());
		ActionContext.getContext().put("organization", organizationShow);
		return INPUT;
	}
	
	public String updateOrganization() throws BaseException {
		userService.updateOrganization(organization);
		return SUCCESS;
	}
	
	public String deleteOrganization() throws BaseException {
		userService.deleteOrganization(organization);
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

	@Override
	public Organization getModel() {
		return organization; 
	}
	
	@JSON(name = "message")
	public Message getMessage() {
		return message;
	}
	
	public String listOrganization() {
		message = new Message();
		List<Organization> organizations = userService.getAllOrganizations();
		message.setObject(organizations);

		return "message";
	}
}