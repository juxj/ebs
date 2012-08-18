package org.tju.ebs.persistence;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.tju.ebs.entity.ProductServer;
import org.tju.ebs.entity.ProductServerExample;

public interface ProductServerMapper {
    int countByExample(ProductServerExample example);

    int deleteByExample(ProductServerExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProductServer record);

    int insertSelective(ProductServer record);

    List<ProductServer> selectByExample(ProductServerExample example);

    ProductServer selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProductServer record, @Param("example") ProductServerExample example);

    int updateByExample(@Param("record") ProductServer record, @Param("example") ProductServerExample example);

    int updateByPrimaryKeySelective(ProductServer record);

    int updateByPrimaryKey(ProductServer record);
}