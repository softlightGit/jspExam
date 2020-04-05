package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.bean.Account;
import com.dao.AccountDaoImpl;

public class FindAllServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		WebApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
		AccountDaoImpl accountDaoImpl = (AccountDaoImpl) applicationContext.getBean("accountDao");
		
		List<Account> users = accountDaoImpl.findAllAccount();
		
		req.setAttribute("list", users);
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	

}
