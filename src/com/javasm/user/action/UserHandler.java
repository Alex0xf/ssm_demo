package com.javasm.user.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javasm.user.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserHandler {

	@Autowired
	IUserService userService;
	
	@RequestMapping("/list_page")
	public String jumpListPage(){
		
		return "user/list";
	}
}
