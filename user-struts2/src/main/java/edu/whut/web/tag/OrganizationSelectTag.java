package edu.whut.web.tag;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import edu.whut.web.bean.Organization;

public class OrganizationSelectTag extends SimpleTagSupport {
	
	private int selectedId;

	@Override
	public void doTag() throws JspException, IOException {
		
		getJspContext().getOut().write("<select name=\"organizationId\">");
		Organization org = new Organization();
		try {
			List<Organization> organizations = org.findAllOrganizations();
			for(Organization organization: organizations){
				String selected = "";
//				if((selectedId!=null)&&Integer.parseInt(selectedId)==organization.getId())
				if(selectedId==organization.getId())
					selected = " selected ";
				getJspContext().getOut().write("<option value="+organization.getId()+selected+">"+organization.getName()+"</option>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getJspContext().getOut().write("</select>");
	}

	public int getSelectedId() {
		return selectedId;
	}

	public void setSelectedId(int selectedId) {
		this.selectedId = selectedId;
	}

}
