package org.tju.ebs.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.tju.ebs.entity.Account;
import org.tju.ebs.service.AccountService;


@Controller
@RequestMapping("/account/")
public class AccountHandler {
	
	@Autowired
	private AccountService accountService;
	
	private List<Account> accountList;

	@RequestMapping(value="showHome", method=RequestMethod.GET)
	public ModelAndView showAccountHome() {
		accountList = this.accountService.getAccountList();
		return new ModelAndView("account_home", "accountList", accountList);
	}
	
	@RequestMapping(value="edit/{accountId}", method=RequestMethod.GET)
	public ModelAndView editAccount(
			@PathVariable Integer accountId, 
            HttpServletRequest request,
            HttpServletResponse response){
		Account  account = null;
		
		if (accountId != null && accountId>0) {
			account = this.accountService.getAccountById(accountId);
		} else {
			account = new Account();
		}
		return new ModelAndView("edit_account", "account", account);
	}
	
	@RequestMapping(value="save", method=RequestMethod.POST)
	public ModelAndView saveAccount(
			@ModelAttribute("account") Account account,
			HttpServletRequest request,
            HttpServletResponse response) {
		this.accountService.saveAccount(account);
		return this.showAccountHome();
	}
	
}
