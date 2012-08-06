package org.tju.ebs.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tju.ebs.entity.Account;
import org.tju.ebs.entity.Category;
import org.tju.ebs.persistence.AccountMapper;
import org.tju.ebs.persistence.CategoryMapper;

@Service
public class AccountService {

	private static final Logger log = LoggerFactory.getLogger(AccountService.class);
	
	@Autowired
	private AccountMapper accountMapper;
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	public Account getAccountById(Integer id) {
		return this.accountMapper.getAccountById(id);
	}
	
	public List<Account> getAccountList() {
		List<Account> result= this.accountMapper.getAccountList();
		return result;
	}
	
	public List<Category> getCategoryList() {
		return this.categoryMapper.getCategoryList();
	}

}
