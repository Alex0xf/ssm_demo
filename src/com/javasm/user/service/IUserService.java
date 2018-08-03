package com.javasm.user.service;

import java.util.List;

import com.javasm.user.model.UserModel;

public interface IUserService {
	List<UserModel> findUserList();
}
