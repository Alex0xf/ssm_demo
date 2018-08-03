package com.javasm.user.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javasm.user.model.UserModel;
import com.javasm.user.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserHandler {

	@Autowired
	IUserService userService;
	
	@RequestMapping("/list_page")
	public String jumpListPage(Model model){
		//查询列表数据 返回给页面
		List<UserModel> list=userService.findUserList();
		model.addAttribute("userList",list);
		return "user/list";
	}
}
