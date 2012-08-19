package org.tju.ebs.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AbstractMapper<T, E> {

	int countByExample(E example);

    int deleteByExample(E example);

    int deleteByPrimaryKey(String id);

    int insert(T record);

    int insertSelective(T record);

    List<T> selectByExample(E example);

    T selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") T record, @Param("example") E example);

    int updateByExample(@Param("record") T record, @Param("example") E example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
    
}
