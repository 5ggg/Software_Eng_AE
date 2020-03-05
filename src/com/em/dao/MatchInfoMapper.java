package com.em.dao;

import com.em.model.MatchInfo;
import com.em.model.MatchInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface MatchInfoMapper {
    long countByExample(MatchInfoExample example);

    int deleteByExample(MatchInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MatchInfo record);

    int insertSelective(MatchInfo record);

    List<MatchInfo> selectByExample(MatchInfoExample example);

    MatchInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    MatchInfo record, @Param("example")
    MatchInfoExample example);

    int updateByExample(@Param("record")
    MatchInfo record, @Param("example")
    MatchInfoExample example);

    int updateByPrimaryKeySelective(MatchInfo record);

    int updateByPrimaryKey(MatchInfo record);
}

