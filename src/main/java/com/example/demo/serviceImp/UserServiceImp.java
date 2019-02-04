package com.example.demo.serviceImp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
@Service("userService")
public class UserServiceImp implements UserService{
	@Resource
	private UserDao userdao; 
	@Override
	public User selectUserByName(String name){
		return userdao.selectUserByName(name);
	}
}
