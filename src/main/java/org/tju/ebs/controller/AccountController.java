package org.tju.ebs.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.tju.ebs.entity.Account;
import org.tju.ebs.service.AccountService;


@Controller
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	private List<Account> accountList;

	@RequestMapping("/account/showAccountHome.do")
	public ModelAndView showAccountHome() {
		accountList = this.accountService.getAccountList();
		return new ModelAndView("account_home", "accountList", accountList);
	}
	
}
