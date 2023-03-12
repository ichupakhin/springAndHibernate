package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public String addAccount() {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");
		return null;
	}
	
	public boolean goToSleep() {
		System.out.println(getClass() + ": Go to sleep");
		
		return true;
	}
}
