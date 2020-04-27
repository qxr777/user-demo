package edu.whut.web.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.web.context.support.WebApplicationContextUtils;

import edu.whut.web.domain.Organization;
import edu.whut.web.service.UserService;

public class OrganizationSelectTag extends TagSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2725976552977432785L;

	private UserService userService;
	
	private long selectedId;

	@Override
	public int doStartTag() throws JspException {
		 ServletContext servletContext = pageContext.getServletContext();
		userService = (UserService)WebApplicationContextUtils.getWebApplicationContext(servletContext).getBean("userService");

		try{
		//pageContext.getOut().write("<select name=\"organizationId\">");
		pageContext.getOut().write("<select name=\"organization.id\">");
		List<Organization> organizations = userService.getAllOrganizations();
		for (Organization organization : organizations) {
			String selected = "";
			if (selectedId == organization.getId())
				selected = " selected ";
			pageContext.getOut().write(
					"<option value=" + organization.getId() + selected + ">"
							+ organization.getName() + "</option>");
		}
		pageContext.getOut().write("</select>");
		}catch(IOException e){
			e.printStackTrace();
		}
		return super.doStartTag();
	}

	public long getSelectedId() {
		return selectedId;
	}

	public void setSelectedId(long selectedId) {
		this.selectedId = selectedId;
	}

}
