package org.tju.ebs.persistence;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.tju.ebs.entity.CompanyProduct;
import org.tju.ebs.entity.CompanyProductExample;

public interface CompanyProductMapper {
    int countByExample(CompanyProductExample example);

    int deleteByExample(CompanyProductExample example);

    int deleteByPrimaryKey(String id);

    int insert(CompanyProduct record);

    int insertSelective(CompanyProduct record);

    List<CompanyProduct> selectByExample(CompanyProductExample example);

    CompanyProduct selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CompanyProduct record, @Param("example") CompanyProductExample example);

    int updateByExample(@Param("record") CompanyProduct record, @Param("example") CompanyProductExample example);

    int updateByPrimaryKeySelective(CompanyProduct record);

    int updateByPrimaryKey(CompanyProduct record);
}