package edu.whut.web.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Organization extends BaseDAO{
	private int id;
	private String name;
	private String description;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Organization insert(Organization organization) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            conn = getConnection();
            pstmt = conn.prepareStatement("insert into organization (ORGANIZATION_NAME,ORGANIZATION_DESCRIPTION) values (?,?)",
                Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, organization.getName());
            pstmt.setString(2, organization.getDescription());
            int rt = pstmt.executeUpdate();
            if (rt > 0)
            {
                rs = pstmt.getGeneratedKeys();
                if (rs.next())
                {
                	organization.setId(rs.getInt(1));
                }
            }
            return organization;
        }
        finally
        {
            closeResultSet(rs);
            closeStatement(pstmt);
            closeConnection(conn);
        }		
	}

    public Organization update(Organization organization) throws SQLException
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try
        {
            conn = getConnection();
            pstmt = conn.prepareStatement("update organization set ORGANIZATION_NAME=?,ORGANIZATION_DESCRIPTION=? where ORGANIZATION_ID=?");
            pstmt.setString(1, organization.getName());
            pstmt.setString(2, organization.getDescription());
            pstmt.setInt(3, organization.getId());
            int rt = pstmt.executeUpdate();
            if (rt > 0)
            {
                return organization;
            }
            else
            {
                return null;
            }

        }
        finally
        {
            closeStatement(pstmt);
            closeConnection(conn);
        }
    }	
	
    public Organization delete(Organization organization) throws SQLException
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try
        {
            conn = getConnection();
            pstmt = conn.prepareStatement("delete from organization where ORGANIZATION_ID=?");
            pstmt.setInt(1, organization.getId());
            int rt = pstmt.executeUpdate();
            if (rt > 0)
            {
                return organization;
            }
            else
            {
                return null;
            }

        }
        finally
        {
            closeStatement(pstmt);
            closeConnection(conn);
        }
    }	    
    
    public Organization findById(int id) throws SQLException
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            conn = getConnection();
            pstmt = conn.prepareStatement("select * from organization where ORGANIZATION_ID=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next())
            {
                Organization organization = new Organization();
                organization.setName(rs.getString("ORGANIZATION_NAME"));
                organization.setDescription(rs.getString("ORGANIZATION_DESCRIPTION"));
                organization.setId(rs.getInt("ORGANIZATION_ID"));
                return organization;
            }
        }
        finally
        {
            closeResultSet(rs);
            closeStatement(pstmt);
            closeConnection(conn);
        }
        return null;
    }  
    
    public List<Organization> findAllOrganizations() throws SQLException
    {
        List<Organization> organizations = new ArrayList<Organization>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            conn = getConnection();
            pstmt = conn.prepareStatement("select * from organization");
            rs = pstmt.executeQuery();
            while (rs.next())
            {
                Organization organization = new Organization();
                organization.setId(rs.getInt("ORGANIZATION_ID"));
                organization.setName(rs.getString("ORGANIZATION_NAME"));
                organization.setDescription(rs.getString("ORGANIZATION_DESCRIPTION"));
                organizations.add(organization);
            }
            return organizations;
        }
        finally
        {
            closeResultSet(rs);
            closeStatement(pstmt);
            closeConnection(conn);
        }
    }      
}
