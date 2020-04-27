package edu.whut.web.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class BaseDAO
{
	private String driver = "com.mysql.jdbc.Driver";
	
    private String sConnStr = "jdbc:mysql://localhost:3306/users?useUnicode=true&characterEncoding=utf-8&autoReconnect=true";

    private String user = "root";

    private String password = "123456";

    protected Connection getConnection() throws SQLException
    {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return DriverManager.getConnection(sConnStr, user, password);
    }

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