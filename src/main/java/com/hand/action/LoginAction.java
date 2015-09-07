package com.hand.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String username;
	private String password;

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	@Override
	public void validate() {
		if(username==null||username.trim().equals("")){
			addFieldError("username", "用户不能为空");
		}
		if(password==null||password.trim().equals("")){
			addFieldError("password", "密码不能为空");
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
