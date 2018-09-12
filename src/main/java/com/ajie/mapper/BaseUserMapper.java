package com.ajie.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ajie.pojo.BaseUser;
import com.ajie.pojo.BaseUserExample;

public interface BaseUserMapper {
    int countByExample(BaseUserExample example);

    int deleteByExample(BaseUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseUser record);

    int insertSelective(BaseUser record);

    List<BaseUser> selectByExample(BaseUserExample example);

    BaseUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseUser record, @Param("example") BaseUserExample example);

    int updateByExample(@Param("record") BaseUser record, @Param("example") BaseUserExample example);

    int updateByPrimaryKeySelective(BaseUser record);

    int updateByPrimaryKey(BaseUser record);
}