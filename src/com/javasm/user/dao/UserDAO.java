package com.javasm.user.dao;

import java.util.List;

import com.javasm.user.model.UserModel;

public interface UserDAO {
	List<UserModel> selectUserList();
}
