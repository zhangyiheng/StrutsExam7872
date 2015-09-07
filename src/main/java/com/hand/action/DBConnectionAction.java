package com.hand.action;

import java.sql.ResultSet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.bean.Customer;
import com.opensymphony.xwork2.ActionSupport;

public class DBConnectionAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		ResultSet customer = (ResultSet) context.getBean("custom");
		
		return SUCCESS;
	}

}
