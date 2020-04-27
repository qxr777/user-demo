package edu.whut.web.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public abstract class BaseDAO
{
	private String driver = "com.mysql.jdbc.Driver";
	
    private String sConnStr = "jdbc:mysql://localhost:3306/users?useUnicode=true&characterEncoding=utf-8&autoReconnect=true";

    private String user = "root";

    private String password = "123456";

    protected Connection getConnection() throws SQLException
    {
    	try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        return DriverManager.getConnection(sConnStr, user, password);
    }
    
//    protected Connection getConnection() throws SQLException
//    {
//    	Connection conn = null;
//    	try {
//			Context env = new InitialContext();
//			DataSource pool = (DataSource) env.lookup("java:comp/env/jdbc/users");
//			if (pool == null)
//				throw new Exception("jdbc/users is an unknown DataSource");
//			conn = pool.getConnection();
//		} catch (Exception e) {
//			System.out.println("naming:" + e.getMessage());
//		}
//    	return conn;
//    }

    protected void closeConnection(Connection conn)
    {
        if (conn != null)
        {
            try
            {
                conn.close();
            }
            catch (SQLException e)
            {
            }
            conn = null;
        }
    }

    protected void closeResultSet(ResultSet rs)
    {
        if (rs != null)
        {
            try
            {
                rs.close();
            }
            catch (SQLException e)
            {
            }
            rs = null;
        }
    }

    protected void closeStatement(Statement st)
    {
        if (st != null)
        {
            try
            {
                st.close();
            }
            catch (SQLException e)
            {
            }
            st = null;
        }
    }
}