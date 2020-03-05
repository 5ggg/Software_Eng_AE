package com.em.dao;

import com.em.model.SubjectInfo;
import com.em.model.SubjectInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SubjectInfoMapper {
    long countByExample(SubjectInfoExample example);

    int deleteByExample(SubjectInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SubjectInfo record);

    int insertSelective(SubjectInfo record);

    List<SubjectInfo> selectByExample(SubjectInfoExample example);

    SubjectInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    SubjectInfo record, @Param("example")
    SubjectInfoExample example);

    int updateByExample(@Param("record")
    SubjectInfo record, @Param("example")
    SubjectInfoExample example);

    int updateByPrimaryKeySelective(SubjectInfo record);

    int updateByPrimaryKey(SubjectInfo record);
}

