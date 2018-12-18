package com.example.demo.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.UserMapper;
import com.example.demo.domain.UserEntity;
import com.example.demo.service.UserService;
@Service(value = "userService")
public class UserServerImpl implements UserService{
	@Autowired
    private UserMapper userMapper;//这里会报错，但是并不会影响
	
	
	 @Transactional
	public List<UserEntity> getAll(){
		UserEntity user1=new UserEntity();
		user1.setEmail("5");
		user1.setId(5l);
		user1.setNickName("5");
		user1.setPassWord("5");
		user1.setRegTime("5");
		user1.setUserName("5");
		
		userMapper.insert(user1);
		
		
		UserEntity user=new UserEntity();
		user.setEmail("d");
		user.setId(4l);
		user.setNickName("d");
		user.setPassWord("d");
		user.setRegTime("d");
		user.setUserName("d");
		
		userMapper.insert(user);
		
		
		return userMapper.getAll();
	}

}
