package org.tju.ebs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tju.ebs.dao.AccountDAO;
import org.tju.ebs.dao.RegistrationDAO;
import org.tju.ebs.entity.Account;
import org.tju.ebs.entity.Registration;
import org.tju.ebs.utils.Pagination;

@Service
public class AccountService  extends BaseService {

	@Autowired
	private AccountDAO accountDAO;
	
	@Autowired
	private RegistrationDAO registrationDAO;
	
	public Account getAccountById(String id) {
		return accountDAO.get(id);
	}
	
	public List<Account> getAccountList(int pageNo, int pageSize) {
		Pagination<Account> p = this.accountDAO.getAccountList(1, pageNo, pageSize);
		System.out.println(p.getRecordCount());
		return p.getData();
	}
	
	public void saveAccount(Account account){
		this.accountDAO.save(account);
	}
	
	public void saveRegistration(Registration registration) {
		this.registrationDAO.save(registration);
	}
	
	
}
