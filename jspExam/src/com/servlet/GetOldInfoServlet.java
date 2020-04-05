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

public class GetOldInfoServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));
		
		WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		AccountDaoImpl accountDao = (AccountDaoImpl) context.getBean("accountDao");
		
		Account account = accountDao.findAccountById(id);
		
		req.setAttribute("account", account);
		
		req.getRequestDispatcher("edit.jsp").forward(req, resp);
	}
}
