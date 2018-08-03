package com.javasm.user.model;
/**
 * 
 * ClassName: UserModel 
 * @Description: 用户类
 * @author Alex
 * @date 2018年8月3日
 */
public class UserModel {
	private int id;
	private String userName;
	private String password;
	private int rid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	
}
