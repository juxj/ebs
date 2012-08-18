package org.tju.ebs.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tju.ebs.entity.Account;
import org.tju.ebs.entity.AccountExample;
import org.tju.ebs.persistence.AccountMapper;

@Service
public class AccountDAO {
	
	@Autowired
	private AccountMapper accountMapper;
	
	public Account getAccountById(Integer id) {
		return this.accountMapper.selectByPrimaryKey(id);
	}
	
	public List<Account> getAccountList(){
		AccountExample accountExample = new AccountExample();
		return this.accountMapper.selectByExample(accountExample);
	}
	
	
	public void save(Account account) {
		if (account.getId() == null) {
			this.accountMapper.insert(account);
		} else {
			this.accountMapper.updateByPrimaryKey(account);
		}
	}
}
