package org.tju.ebs.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tju.ebs.domain.account.Account;
import org.tju.ebs.ds.DataSourceContextHolder;
import org.tju.ebs.ds.DataSourceName;
import org.tju.ebs.ds.DataSourceRouter;
import org.tju.ebs.persistence.AccountMapper;

@Service
public class AccountService {

	private static final Logger log = LoggerFactory.getLogger(AccountService.class);
	
	@Autowired
	private AccountMapper accountMapper;
	
	public Account getAccountById(Integer id) {
		return this.accountMapper.getAccountById(id);
	}
	
	public List<Account> getAccountList() {
		DataSourceContextHolder.setCurrentDataSource(DataSourceName.DS_PRODUCT_0);
		List<Account> result= this.accountMapper.getAccountList();
		log.debug("you got the size of :"+ Integer.toString(result.size()));
		return result;
	}
}
