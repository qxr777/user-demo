package edu.whut.web.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.whut.web.exception.BaseException;
import edu.whut.web.exception.NoUserException;


public class User extends BaseDAO{
	private int id;
	private String name;
	private String password;
	private String password2;
	private String email;
	private Organization organization;
	
	private int organizationId;
	
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
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	public User insert(User user) throws BaseException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            conn = getConnection();
            pstmt = conn.prepareStatement("insert into user (USER_NAME,USER_PASSWORD,USER_EMAIL,USER_ORGANIZATION_ID) values (?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getEmail());
            pstmt.setInt(4, user.getOrganizationId());
            int rt = pstmt.executeUpdate();
            if (rt > 0)
            {
                rs = pstmt.getGeneratedKeys();
                if (rs.next())
                {
                	user.setId(rs.getInt(1));
                }
            }
            return user;
        }catch(SQLException exception){
        	throw new NoUserException();        
        }
        finally
        {
            closeResultSet(rs);
            closeStatement(pstmt);
            closeConnection(conn);
        }		
	}

    public User update(User user) throws BaseException
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try
        {
            conn = getConnection();
            pstmt = conn.prepareStatement("update user set USER_NAME=?,USER_EMAIL=?,USER_ORGANIZATION_ID=? where USER_ID=?");
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setInt(3, user.getOrganizationId());
            pstmt.setInt(4, user.getId());
            int rt = pstmt.executeUpdate();
            if (rt > 0)
            {
                return user;
            }
            else
            {
                return null;
            }
        }catch(SQLException exception){
        	throw new NoUserException();
        }
        finally
        {
            closeStatement(pstmt);
            closeConnection(conn);
        }
    }	
	
    public User delete(User user) throws BaseException
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try
        {
            conn = getConnection();
            pstmt = conn.prepareStatement("delete from user where USER_ID=?");
            pstmt.setInt(1, user.getId());
            int rt = pstmt.executeUpdate();
            if (rt > 0)
            {
                return user;
            }
            else
            {
                return null;
            }
        }catch(SQLException exception){
        	throw new NoUserException();
        }
        finally
        {
            closeStatement(pstmt);
            closeConnection(conn);
        }
    }	    
    
    public User findById(int id) throws BaseException
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            conn = getConnection();
            pstmt = conn.prepareStatement("select * from user where USER_ID=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next())
            {
                User user = new User();
                user.setName(rs.getString("USER_NAME"));
                user.setPassword(rs.getString("USER_PASSWORD"));
                user.setEmail(rs.getString("USER_EMAIL"));
                Organization organization = new Organization();
                organization = organization.findById(rs.getInt("USER_ORGANIZATION_ID"));
                user.setOrganization(organization);
                user.setId(id);
                return user;
            }
        }catch(SQLException exception){
        	throw new NoUserException();
        }
        finally
        {
            closeResultSet(rs);
            closeStatement(pstmt);
            closeConnection(conn);
        }
        return null;
    }    
    
    public User findByName(String name) throws BaseException
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            conn = getConnection();
            pstmt = conn.prepareStatement("select * from user where USER_NAME=?");
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            if (rs.next())
            {
                User user = new User();
                user.setName(rs.getString("USER_NAME"));
                user.setPassword(rs.getString("USER_PASSWORD"));
                user.setEmail(rs.getString("USER_EMAIL"));
                Organization organization = new Organization();
                organization = organization.findById(rs.getInt("USER_ORGANIZATION_ID"));
                user.setOrganization(organization);
                user.setId(rs.getInt("USER_ID"));
                return user;
            }
        }catch(SQLException exception){
        	throw new NoUserException();
        }
        finally
        {
            closeResultSet(rs);
            closeStatement(pstmt);
            closeConnection(conn);
        }
        return null;
    }      
    
    public List<User> findAllUsers() throws BaseException
    {
        List<User> users = new ArrayList<User>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            conn = getConnection();
            pstmt = conn.prepareStatement("select * from user");
            rs = pstmt.executeQuery();
            while (rs.next())
            {
                User user = new User();
                user.setId(rs.getInt("USER_ID"));
                user.setName(rs.getString("USER_NAME"));
                user.setEmail(rs.getString("USER_EMAIL"));
                user.setPassword(rs.getString("USER_PASSWORD"));
                Organization organization = new Organization();
                organization = organization.findById(rs.getInt("USER_ORGANIZATION_ID"));
                user.setOrganization(organization);
                users.add(user);
            }
            return users;
        }catch(SQLException exception){
        	throw new NoUserException();            
        }
        finally
        {
            closeResultSet(rs);
            closeStatement(pstmt);
            closeConnection(conn);
        }
    }
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}    
}
