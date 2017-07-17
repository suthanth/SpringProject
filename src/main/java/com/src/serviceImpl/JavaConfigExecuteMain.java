package com.src.serviceImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.src.service.DbConnection;
import com.src.service.DbOperations;

public class JavaConfigExecuteMain {

	public static ApplicationContext applicationContext;
	
	static{
		applicationContext = new AnnotationConfigApplicationContext(ConfigurationClass.class);
	}
	public static void main(String[] args) {
		DbOperations dbOpearation = (DbOperations)applicationContext.getBean("DbOpearation");
		DbConnection dbConnection = (DbConnection)applicationContext.getBean("DbConnection");
		//dbOpearation.setaner(dbConnection);
		dbOpearation.createTable();
		dbOpearation.insertValues();
		dbOpearation.showTable();
	}

}
