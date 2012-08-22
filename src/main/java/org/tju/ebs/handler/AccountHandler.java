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

import com.mysql.jdbc.StringUtils;


@Controller
@RequestMapping("/account/")
public class AccountHandler extends AbstractHandler{
	
	@Autowired
	private AccountService accountService;
	
	private List<Account> accountList;

	@RequestMapping(value="showHome/{pageNo}", method=RequestMethod.GET)
	public ModelAndView showAccountHome(@PathVariable Integer pageNo) {
		accountList = this.accountService.getAccountList(pageNo, this.PAGE_SIZE);
		return new ModelAndView("account_home", "accountList", accountList);
	}
	
	@RequestMapping(value="edit/{accountId}", method=RequestMethod.GET)
	public ModelAndView editAccount(
			@PathVariable String accountId, 
            HttpServletRequest request,
            HttpServletResponse response){
		Account  account = null;
		
		if (StringUtils.isNullOrEmpty(accountId)) {
			account = new Account();
		} else {
			account = this.accountService.getAccountById(accountId);
		}
		return new ModelAndView("edit_account", "account", account);
	}
	
	@RequestMapping(value="save", method=RequestMethod.POST)
	public ModelAndView saveAccount(
			@ModelAttribute("account") Account account,
			HttpServletRequest request,
            HttpServletResponse response) {
		this.accountService.saveAccount(account);
		return this.showAccountHome(0);
	}
	
}
