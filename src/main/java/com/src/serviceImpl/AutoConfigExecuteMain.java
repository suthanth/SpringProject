package com.src.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.src.service.DbOperations;

@Component("auto")
public class AutoConfigExecuteMain {

	public static ApplicationContext applicationContext;
	@Autowired
	private  DbOperations dbOperations;
	static{
		applicationContext = new AnnotationConfigApplicationContext(ConfigurationClass.class);
	}
	public void execute(){
		System.out.println(dbOperations);
		dbOperations.createTable();
		dbOperations.insertValues();
		dbOperations.showTable();
	}
	public static void main(String[] args) {
		AutoConfigExecuteMain main=(AutoConfigExecuteMain) applicationContext.getBean("auto");
		main.execute();
	}

}
