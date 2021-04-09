package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionHeroku {
	private static String userName = "xuujwovxiuslgi";
	private static String password = "0ae0d587750e67e80fcb5b12163a1300618338d7246127f77f93f75496aadfb1";
	private static String DriverClass = "org.postgresql.Driver";
	private static String connectionURL = "jdbc:postgresql://ec2-54-167-168-52.compute-1.amazonaws.com:5432/dbtff2mjf3ahq5?sslmode=require";

	public static Connection getConnection() {

		Connection conn = null;

		try {
			Class.forName(DriverClass);

			conn = DriverManager.getConnection(connectionURL, userName, password);

			if (conn != null) {

				System.out.println("connected to database..");
			} else {

				System.out.println("something went wrong..");

			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) {

		getConnection();
	}

}
