package org.tju.ebs.persistence;

import java.util.List;

import org.tju.ebs.entity.Account;

public interface AccountMapper {

	/**Get Account By Id*/
	Account getAccountById(Integer id);
	
	/**Get All Accounts*/
	List<Account> getAccountList();
}
