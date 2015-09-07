package com.hand.action;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.bean.Customer;
import com.hand.dao.CustomerDao;
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
		if (username == null || username.trim().equals("")) {
			addFieldError("username", "用户不能为空");
		}
		if (password == null || password.trim().equals("")) {
			addFieldError("password", "密码不能为空");
		}
	}

	public String check() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"ApplicationContext.xml");

		CustomerDao customerss = (CustomerDao) context.getBean("customer");
		List<Customer> customers = customerss.getCustomer();
		for (Customer customer : customers) {
			if (customer.getFirst_name().equals(username)&&customer.getLast_name().equals(password)) {
				
				return SUCCESS;
			}
		}
		return ERROR;
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
