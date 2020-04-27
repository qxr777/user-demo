package edu.whut.web.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.annotations.JSON;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import edu.whut.web.domain.Message;
import edu.whut.web.domain.Organization;
import edu.whut.web.domain.User;
import edu.whut.web.exception.BaseException;
import edu.whut.web.service.UserService;

public class UserExtAction extends ActionSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5854764543619117481L;
	private UserService userService;
	private Message message;
	
	public String execute() throws Exception
	{
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
	
	public String saveUsers() throws IOException, BaseException, JSONException {
		message = new Message();
		
		String jsonString = this.extractJson();
		
		Gson gson = new Gson();
		User[] users = null;
		if(jsonString.startsWith("[")){
			users = gson.fromJson(jsonString, User[].class);
		} else {
			users = new User[1];
			users[0] = gson.fromJson(jsonString, User.class);
		}
				
		
		for(User user : users){
//			if(user.getOrgId() != null && user.getOrgId().trim().length() > 0){
//				Organization organization = userService.getOrganization(Long.parseLong(user.getOrgId()));
//				user.setOrganization(organization);
//			}
			userService.updateUser(user);
		}
		
		return "message";
	}
	
	public String extractJson() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		// read content
		BufferedReader bufferReader = new BufferedReader(request.getReader());
		String line;
		StringBuilder buffer = new StringBuilder();

		while ((line = bufferReader.readLine()) != null) {
			buffer.append(line);
		}
		
		return buffer.toString();
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

}