package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
@Controller
public class UserController {
	@Autowired
	UserService userservice;
	
	@RequestMapping(value="user",method=RequestMethod.GET)
	public String user(ModelMap map){
		User user=userservice.selectUserByName("xiong");
		map.addAttribute("user", user);
		return "/hello";
	}
}
