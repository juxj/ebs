package org.tju.ebs.persistence;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.tju.ebs.entity.AccountProduct;
import org.tju.ebs.entity.AccountProductExample;

public interface AccountProductMapper {
    int countByExample(AccountProductExample example);

    int deleteByExample(AccountProductExample example);

    int deleteByPrimaryKey(String id);

    int insert(AccountProduct record);

    int insertSelective(AccountProduct record);

    List<AccountProduct> selectByExample(AccountProductExample example);

    AccountProduct selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AccountProduct record, @Param("example") AccountProductExample example);

    int updateByExample(@Param("record") AccountProduct record, @Param("example") AccountProductExample example);

    int updateByPrimaryKeySelective(AccountProduct record);

    int updateByPrimaryKey(AccountProduct record);
}