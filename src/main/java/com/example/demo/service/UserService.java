package com.example.demo.service;

import com.example.demo.domain.User;

public interface UserService {
	User selectUserByName(String name);
}
