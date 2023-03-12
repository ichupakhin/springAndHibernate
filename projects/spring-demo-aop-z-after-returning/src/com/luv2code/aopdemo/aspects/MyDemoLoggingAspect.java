package com.luv2code.aopdemo.aspects;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	//add related advices for logging
	
	@AfterReturning(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result"
			)
	public void afterReturningFindAccountsAdvice(JoinPoint theJointPoint, List<Account> result) {
		String method = theJointPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);
		System.out.println("\n=====>>> result is: " + result);
		
		//Dangerous!: Modify result
		convertAccountNamesToUpperCase(result);

	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		for(Account account : result) {
			if(account.getName() != null) {
				account.setName(account.getName().toUpperCase());
			}
		}
		
	}

	@Before("com.luv2code.aopdemo.aspects.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n=======>>> Execution @Before advice on addAccount()");
		
	//display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodSig);
	
	//display method arguments
		
	Object[] args = theJoinPoint.getArgs();
	
	for(Object obj: args) {
		System.out.println(obj);
		
		if(obj instanceof Account) {
			Account theAccount = (Account) obj;
			System.out.println("account name: " + theAccount.getName());
			System.out.println("account level: " + theAccount.getLevel());
		}
	}
	
	}
	
}
