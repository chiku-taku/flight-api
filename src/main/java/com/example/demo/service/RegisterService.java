package com.example.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserinfoMapper;
import com.example.demo.model.Userinfo;

@Service
public class RegisterService {
    @Autowired
    private UserinfoMapper userinfoMapper;
    
    public int setUserInfo(Userinfo row) {
        return userinfoMapper.insertSelective(row);
    }
    
    public Userinfo getUserInfoByKey(String userId) {
        return userinfoMapper.selectByPrimaryKey(userId);
    }

}
