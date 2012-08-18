package org.tju.ebs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tju.ebs.dao.AccountDAO;
import org.tju.ebs.entity.Account;

@Service
public class AccountService {

	@Autowired
	private AccountDAO accountDAO;
	
	public Account getAccountById(Integer id) {
		return accountDAO.getAccountById(id);
	}
	
	public List<Account> getAccountList() {
		return this.accountDAO.getAccountList();
	}
	
	public void saveAccount(Account account){
		this.accountDAO.save(account);
	}
}
