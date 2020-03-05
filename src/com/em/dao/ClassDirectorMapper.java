package com.em.dao;

import com.em.model.ClassDirector;
import com.em.model.ClassDirectorExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ClassDirectorMapper {
    long countByExample(ClassDirectorExample example);

    int deleteByExample(ClassDirectorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClassDirector record);

    int insertSelective(ClassDirector record);

    List<ClassDirector> selectByExample(ClassDirectorExample example);

    ClassDirector selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    ClassDirector record, @Param("example")
    ClassDirectorExample example);

    int updateByExample(@Param("record")
    ClassDirector record, @Param("example")
    ClassDirectorExample example);

    int updateByPrimaryKeySelective(ClassDirector record);

    int updateByPrimaryKey(ClassDirector record);
}

