package com.luv2code.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	//add related advices for logging
	
	//@Before("execution(public void addAccount())")
	//@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
	//@Before("execution(public void add*())")
	//@Before("execution(public void add*())")
	//@Before("execution(public * add*())")
	//@Before("execution(public * add*())") //no args
	//@Before("execution(public * add*(*))") //one arg of any type
	//@Before("execution(public * add*(..))") //no or more arguments of any type
	//@Before("execution(public * add*(com.luv2code.aopdemo.Account))") //one argument of particular type
	//@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))") //all methods in particular package
	//@Before("execution(* add*(com.luv2code.aopdemo.Account))") //all methods with particular arg type
	//@Before("execution(* add*(com.luv2code.aopdemo.Account, ..))") //all methods with particular args type
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))") //all methods in a particular package
	public void beforeAddAccountAdvice() {
		System.out.println("\n=======>>> Execution @Before advice on addAccount()");
	}
}
