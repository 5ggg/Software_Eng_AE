package com.em.dao;

import com.em.model.TeachingRequest;
import com.em.model.TeachingRequestExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface TeachingRequestMapper {
    long countByExample(TeachingRequestExample example);

    int deleteByExample(TeachingRequestExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TeachingRequest record);

    int insertSelective(TeachingRequest record);

    List<TeachingRequest> selectByExample(TeachingRequestExample example);

    TeachingRequest selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    TeachingRequest record, @Param("example")
    TeachingRequestExample example);

    int updateByExample(@Param("record")
    TeachingRequest record, @Param("example")
    TeachingRequestExample example);

    int updateByPrimaryKeySelective(TeachingRequest record);

    int updateByPrimaryKey(TeachingRequest record);
}

