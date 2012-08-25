package org.tju.ebs.persistence;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.tju.ebs.entity.Account;
import org.tju.ebs.entity.AccountExample;

public interface AccountMapper extends AbstractMapper<Account, AccountExample>{
    int countByExample(AccountExample example);

    int deleteByExample(AccountExample example);

    int deleteByPrimaryKey(String id);

    int insert(Account record);

    int insertSelective(Account record);

    List<Account> selectByExample(AccountExample example);

    Account selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}