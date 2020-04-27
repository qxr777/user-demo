package edu.whut.web.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.web.context.support.WebApplicationContextUtils;

import edu.whut.web.domain.Role;
import edu.whut.web.service.UserService;

public class RolesCheckTag extends TagSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2725976552977432785L;

	private UserService userService;
	
	private long userId;

	@Override
	public int doStartTag() throws JspException {
		ServletContext servletContext = pageContext.getServletContext();
		userService = (UserService) WebApplicationContextUtils
				.getWebApplicationContext(servletContext)
				.getBean("userService");

		try {
			List<Role> allRoles = userService.getAllRoles();
			Set<Role> userRoles = userId>0? userService.getUser(userId).getRoles() :new HashSet<Role>();
			
			for(int i=0;i<allRoles.size(); i++){
				Role role = allRoles.get(i);
				String checked = "";
				if(userRoles.contains(role))
					checked = "checked=\"checked\"";
				pageContext.getOut().write("<input type=checkbox name=\"roles["+i+"].id\" value=\""+role.getId()+"\" "+checked+">" +role.getName());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}
