package com.test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.opensearch.jdbc.OpenSearchDataSource;

public class OpenSearchSqlManager {
	public static void openSearchDBConnection() {
//		String url = "jdbc:opensearch://localhost:9200";
		String url = "jdbc:opensearch://https://localhost:9200";
		String user = "admin";
		String password = "estT1@2a#b";

		OpenSearchDataSource ds = new OpenSearchDataSource();

		Properties properties = new Properties();
//		properties.put("useSSL", "true");
		properties.put("trustSelfSigned", "true");
//		properties.put("user", user);
//		properties.put("password", password);

		// uncomment below to turn off hostname verification
		// properties.put("hostnameVerification", "false");

		Connection con;
		try {
//			con =  DriverManager.getConnection(url, properties);

			ds.setUrl(url);
			ds.setProperties(properties);
			con = ds.getConnection(user, password);
//			con = ds.getConnection(url, properties);
//			con = ds.getConnection(url);

			Statement st = con.createStatement();

//			//con = DriverManager.getConnection(url, user, password);
//			con = DriverManager.getConnection(url, properties);
//			Statement st = con.createStatement();
			// use the connection
			System.out.println("test1 open~~~~");

			// close connection
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
