package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {

		//reading spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);	
		
		List<Account> theAccounts = theAccountDAO.findAccounts();
		
		System.out.println("\n\nMain Program: AfterReturningDemoApp\n----\n" +  theAccounts);
		
		//close the context
		context.close();

	}

}
