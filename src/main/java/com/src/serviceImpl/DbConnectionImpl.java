package com.src.serviceImpl;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Component;

import com.src.service.DbConnection;
@Component("DbConnection")
public class DbConnectionImpl implements DbConnection{

	@Override
	public Connection getConnection() {
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://trainingdb.c4hhsbxtkfor.ap-south-1.rds.amazonaws.com:3306/trainingTable","root","mypassword");
		}
		catch(Exception e){
			System.out.println("Error in connecting database "+e);
		}
		return con;
	}
}
