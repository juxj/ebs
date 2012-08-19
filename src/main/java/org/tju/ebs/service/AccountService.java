package org.tju.ebs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tju.ebs.dao.AccountDAO;
import org.tju.ebs.entity.Account;
import org.tju.ebs.utils.Pagination;

@Service
public class AccountService {

	@Autowired
	private AccountDAO accountDAO;
	
	public Account getAccountById(String id) {
		return accountDAO.get(id);
	}
	
	public List<Account> getAccountList() {
		Pagination<Account> p = this.accountDAO.getAccountList(1);
		System.out.println(p.getRecordCount());
		return p.getData();
	}
	
	public void saveAccount(Account account){
		this.accountDAO.save(account);
	}
}
