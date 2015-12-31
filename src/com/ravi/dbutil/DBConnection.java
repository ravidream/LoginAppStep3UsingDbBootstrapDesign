package com.ravi.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 
 * @author Ravi Thapa
 *
 */
public class DBConnection {
	Connection connection = null;
	// JDBC driver name and database URL
	static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static String DB_URL = "jdbc:mysql://localhost/test";

	// Database credentials
	static String USER = "root";
	static String PASS = "ravi";

	/*
	 * public Connection getConnection() throws NamingException, SQLException {
	 * Context initContext = new InitialContext(); Context envContext =
	 * (Context) initContext.lookup("java:/comp/env"); DataSource ds =
	 * (DataSource) envContext.lookup("jdbc/mydb"); connection = (Connection)
	 * ds.getConnection(); return connection; }
	 */
	public Connection getConnection() {

		try {
			// STEP 1: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			// STEP 2: Open a connection
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

	public static void close(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement st) {
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection connection) {
		try {
			if (connection != null) {
				connection.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeAll(ResultSet rs, PreparedStatement ps, Connection con) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
			}
		if (ps != null)
			try {
				ps.close();
			} catch (SQLException e) {
			}
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
			}
	}
}
