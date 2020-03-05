package com.em.dao;

import com.em.model.TeachingRequirement;
import com.em.model.TeachingRequirementExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface TeachingRequirementMapper {
    long countByExample(TeachingRequirementExample example);

    int deleteByExample(TeachingRequirementExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TeachingRequirement record);

    int insertSelective(TeachingRequirement record);

    List<TeachingRequirement> selectByExample(
        TeachingRequirementExample example);

    TeachingRequirement selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    TeachingRequirement record,
        @Param("example")
    TeachingRequirementExample example);

    int updateByExample(@Param("record")
    TeachingRequirement record,
        @Param("example")
    TeachingRequirementExample example);

    int updateByPrimaryKeySelective(TeachingRequirement record);

    int updateByPrimaryKey(TeachingRequirement record);
}

