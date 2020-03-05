package com.em.dao;

import com.em.model.PptDirector;
import com.em.model.PptDirectorExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface PptDirectorMapper {
    long countByExample(PptDirectorExample example);

    int deleteByExample(PptDirectorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PptDirector record);

    int insertSelective(PptDirector record);

    List<PptDirector> selectByExample(PptDirectorExample example);

    PptDirector selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    PptDirector record, @Param("example")
    PptDirectorExample example);

    int updateByExample(@Param("record")
    PptDirector record, @Param("example")
    PptDirectorExample example);

    int updateByPrimaryKeySelective(PptDirector record);

    int updateByPrimaryKey(PptDirector record);
}

