package org.tju.ebs.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tju.ebs.entity.Account;

public class AccountServiceTest {
	
	private ApplicationContext context = null;
	private AccountService accountService;
	
	
	@Before
	public void before() {
		//context = new ClassPathXmlApplicationContext(new String[] { "classpath:applicationContext.xml"});
		//accountService = (AccountService) context.getBean("accountService");
	}
	
	@Test
	public void test() {
		//List<Account> accountList = accountService.getAccountList();
		//System.out.print("========="+accountList.size()+"=============");
	}
	
}
