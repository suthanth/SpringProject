package com.src.serviceImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.src.service.DbConnection;
import com.src.service.DbOperations;

public class DbOpearationsImpl implements DbOperations {
	private DbConnection DbConnection;
	
	public void setaner(DbConnection dbConnection){
		this.DbConnection=dbConnection;
	}
	
	@Override
	public void createTable() {
			Connection con = DbConnection.getConnection();
		try {
			Statement stat = con.createStatement();
			try{
				String sql = "create table Suthanth(id int, name varchar(20))";
				stat.execute(sql);
			}
			catch(Exception e){
				String sql = "Drop table Suthanth";
				stat.execute(sql);
			    sql = "create table Suthanth(id int, name varchar(20))";
				stat.execute(sql);
			}
			
			System.out.println("Table created successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void insertValues() {
		Connection con = DbConnection.getConnection();
		try {
			Statement stat = con.createStatement();
			String sql = "insert into Suthanth values(1,'suthanth')";
			stat.execute(sql);
			System.out.println("Values inserted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void showTable() {
		Connection con = DbConnection.getConnection();
		try {
			Statement stat = con.createStatement();
			String sql = "select * from Suthanth";
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getInt(1)+" "+ rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
