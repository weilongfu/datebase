package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static final String DRIVER;
	private static final String URL;
	private static final String USER ;
	private static final String PWD;

	// 静态块加载驱动
	static {
		PropertiesManager instance=PropertiesManager.getInstance();
		DRIVER=instance.getValue("jdbc.driver");
		URL=instance.getValue("jdbc.url");
		USER=instance.
				getValue("jdbc.user");
		PWD=instance.getValue("jdbc.pwd");
		try {			
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 得到连接对象
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PWD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * 释放资源
	 * 
	 * @param con
	 * @param stmt
	 * @param rs
	 */
	public static void closeAll(Connection con, Statement stmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
