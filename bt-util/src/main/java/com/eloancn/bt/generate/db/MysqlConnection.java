package com.eloancn.bt.generate.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class MysqlConnection {

	static Connection conn = null;



	/**
	 * 创建数据库连接
	 * @return
	 */
	public static Connection newConnection(String urlValue, String userNameValue, String passWordValue) {
		try {
			if (conn == null) {
				conn = DriverManager.getConnection(urlValue, userNameValue, passWordValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 关闭数据库连接
	 */
	public static void closeConnection() {
		if(conn != null){
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	public static boolean closeConnection(Connection conn) {

		return closeConnection(conn, null, null);
	}

	public static boolean closeConnection(Connection conn, Statement pamStatement,
			ResultSet rs) {
		boolean flag = true;
		try {

			if (rs != null)
				rs.close();
			if (pamStatement != null)
				pamStatement.close();

		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		} 
		return flag;
	}
}
