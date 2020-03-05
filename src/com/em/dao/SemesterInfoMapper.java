package com.em.dao;

import com.em.model.SemesterInfo;
import com.em.model.SemesterInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SemesterInfoMapper {
    long countByExample(SemesterInfoExample example);

    int deleteByExample(SemesterInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SemesterInfo record);

    int insertSelective(SemesterInfo record);

    List<SemesterInfo> selectByExample(SemesterInfoExample example);

    SemesterInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    SemesterInfo record, @Param("example")
    SemesterInfoExample example);

    int updateByExample(@Param("record")
    SemesterInfo record, @Param("example")
    SemesterInfoExample example);

    int updateByPrimaryKeySelective(SemesterInfo record);

    int updateByPrimaryKey(SemesterInfo record);
}

