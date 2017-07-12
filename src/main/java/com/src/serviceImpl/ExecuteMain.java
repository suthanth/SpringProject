package com.src.serviceImpl;

public class ExecuteMain {
	public static void main(String args[]){
		DbOpearationsImpl exc = new DbOpearationsImpl();
		exc.createTable();
		exc.insertValues();
		exc.showTable();
	}

}
