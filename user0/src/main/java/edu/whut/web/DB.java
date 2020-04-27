package edu.whut.web;

import java.sql.*;

public class DB {
	//一个连接
	private Connection conn;
	//Statement用于执行静态 SQL 语句并返回它所生成结果的对象。
	private Statement stmt;
	//一个结果集
	private ResultSet rst;

	//创建一个数据库连接
	private void init(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbUrl="jdbc:mysql://localhost:3306/users?useUnicode=true&characterEncoding=utf-8&autoReconnect=true";
			String dbName="root";
			String dbPassword="123456";
			try {
				conn = DriverManager.getConnection(dbUrl, dbName, dbPassword);
				stmt = conn.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}


	//从数据连接池得到一个数据库连接
//	private void init(){
//		try {
//			Context env = new InitialContext();
//			DataSource pool = (DataSource) env.lookup("java:comp/env/jdbc/users");
//			if (pool == null)
//				throw new Exception("jdbc/users is an unknown DataSource");
//			conn = pool.getConnection();
//			stmt = conn.createStatement();
//		} catch (Exception e) {
//			System.out.println("naming:" + e.getMessage());
//		}
//
//	}

	//构造Connection一个连接
	public DB(){
		init();
	}

	//执行数据库查询语句
	public ResultSet excuteQuery(String s){
		if(stmt!=null){
			try {
				rst=stmt.executeQuery(s);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rst;
	}
	public int excuteUpdata(String s){
		int status=0;
		if(stmt!=null){
			try {
				status=stmt.executeUpdate(s);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return status;
	}
	public boolean next(){
		try {
			return rst.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//以下是赋值方法
	public int getInt(int i) throws Exception{
		return rst.getInt(i);
	}
	public String getString(String s) throws Exception{
		return rst.getString(s);
	}
	public void close(){
		try {
			if(conn!=null)	conn.close();
			if(stmt!=null)	stmt.close();
			if(rst!=null)	rst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
