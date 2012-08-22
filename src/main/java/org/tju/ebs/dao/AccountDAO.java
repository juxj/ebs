package org.tju.ebs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tju.ebs.entity.Account;
import org.tju.ebs.entity.AccountExample;
import org.tju.ebs.entity.AccountExample.Criteria;
import org.tju.ebs.persistence.AbstractMapper;
import org.tju.ebs.persistence.AccountMapper;
import org.tju.ebs.utils.Pagination;

@Service
public class AccountDAO extends AbstractDAO <Account, AccountExample> {
	
	
	@Autowired
	private AccountMapper accountMapper;

	@Override
	protected AbstractMapper<Account, AccountExample> getMapper() {
		return this.accountMapper;
	}
	
	public Pagination<Account> getAccountList(int sequence, int pageNo, int pageSize) {
		AccountExample example = new AccountExample();
		Criteria c = example.createCriteria();
		c.andSequenceGreaterThan(sequence);
		return this.getByExample(example, pageNo, pageSize);
	}
	
	
}
