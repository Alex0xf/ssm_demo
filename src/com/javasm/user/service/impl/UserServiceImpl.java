package com.javasm.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javasm.user.dao.UserDAO;
import com.javasm.user.model.UserModel;
import com.javasm.user.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	UserDAO userDao;
	
	@Override
	public List<UserModel> findUserList() {
		List<UserModel> list=userDao.selectUserList();
		
		return list;
	}

}
