package common;

import java.sql.*;

/**
 * 数据库公共类
 * @author 张桃洪
 *@data 2019-4-1
 */

public class DB {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	public DB() {
		String className="com.mysql.jdbc.Driver";
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据加载程序找不到");
		}
	}

	public Connection getConn() {
		String url = "jdbc:mysql://localhost:3306/test_db?characterEncoding=utf-8"; //数据库服务器地址
		String user = "root"; //用户登陆数据库服务器的用户名
		String rootpassword = "123456789"; //用户登陆数据库服务器的用户密码
		try {
			conn = DriverManager.getConnection(url, user, rootpassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
	public Statement getStmt() {
		try {
			if(conn == null) {
				conn = getConn();
			}
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
	}

	public ResultSet executeQuery(String sql) {
		try {
			if(stmt == null) {
				stmt = getStmt();
			}
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public int executeUpdate(String sql) {
		int row = -1;
		try {
			if(stmt == null) {
				stmt = getStmt();
			}
			row = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
	
	public void closeDB() {
		try{
			if(rs != null){
				rs.close();
			}
			if(stmt != null){
				stmt.close();
			}
			if(conn != null){
				conn.close();
			}
			
		}catch(SQLException e){
			System.out.println("关闭异常");
		}
	}
	
}
