package com.jamcracker.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class SQLUtil {

	
	static Properties props = new Properties();

	static {

		try {
			Class.forName("org.postgresql.Driver");
			loadConfig();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	static void loadConfig() {
		
		File configFile = new File("ConfigFile/db.properties");
		FileInputStream fs;

		try {
			fs = new FileInputStream(configFile);
			props.load(fs);
			fs.close();
			System.out.println("file loaded");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws Exception {
		String username = props.getProperty("username");
		String password = props.getProperty("password");

		String url = props.getProperty("url");

		System.out.println("\n Connecting to url = " + url + "\n Username = "
				+ username + props);

		Connection conn = DriverManager.getConnection(url, username, password);

		return conn;

	}

	public static void closeConnection(Connection con) throws Exception {
		
		if (con != null) {

			try {
				con.close();
			} catch (SQLException sq) {

			}
		}
	}
	
	public static void closePreparedStatement(PreparedStatement statement) throws Exception {
		
		if (statement != null) {

			try {
				statement.close();
			} catch (SQLException sq) {

			}
		}
	}
	public static void closeResultSet(ResultSet resultSet) throws Exception {
		
		if (resultSet != null) {

			try {
				resultSet.close();
			} catch (SQLException sq) {

			}
		}
	}
}