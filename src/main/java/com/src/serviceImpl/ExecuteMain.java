package com.src.serviceImpl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.src.service.DbConnection;
import com.src.service.DbOperations;

public class ExecuteMain {
	private static ClassPathXmlApplicationContext applicationContext;
	
	static{
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	public static void main(String args[]){
		//DbOpearationsImpl exc = new DbOpearationsImpl();
		DbOperations dbOperation = (DbOperations)applicationContext.getBean("DbOperations");
		DbConnection dbConnection = (DbConnection)applicationContext.getBean("DbConnection");
		dbOperation.setaner(dbConnection);
		dbOperation.createTable();
		dbOperation.insertValues();
		dbOperation.showTable();
	}

}
