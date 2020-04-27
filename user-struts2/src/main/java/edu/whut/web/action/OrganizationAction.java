package edu.whut.web.action;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.whut.web.bean.Organization;

public class OrganizationAction extends ActionSupport implements ModelDriven<Organization>
{
	private Organization organization = new Organization();
//	private int id;
//	private String name;
//	private String description;
	public String execute() throws Exception
	{
		return SUCCESS;
	}
	
	public String addOrganization() throws SQLException {
//		Organization organization = new Organization();
//		organization.setName(name);
//		organization.setDescription(description);
		organization.insert(organization);
		return SUCCESS;
	}
	
//	public String updateOrganization() throws SQLException {
//		organization.update(organization);
//		return SUCCESS;
//	}

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}	

	@Override
	public Organization getModel() {
		return organization; 
	}
}