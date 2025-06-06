package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Userinfo;

@Mapper
public interface UserinfoMapper {
    int deleteByPrimaryKey(String userId);

    int insert(Userinfo row);

    int insertSelective(Userinfo row);

    Userinfo selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(Userinfo row);

    int updateByPrimaryKey(Userinfo row);
}