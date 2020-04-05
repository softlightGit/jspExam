package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.bean.Account;
import com.dao.AccountDaoImpl;

public class UpdateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String username =  req.getParameter("username");
		Double balance = Double.parseDouble(req.getParameter("balance"));
		int id = Integer.valueOf(req.getParameter("id"));
		
		Account account = new Account();
		account.setId(id);
		account.setUsername(username);
		account.setBalance(balance);
		
		WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		AccountDaoImpl accountDao = (AccountDaoImpl) context.getBean("accountDao");
		
		int num = accountDao.updateAccount(account);
		if (num > 0) {
	        System.out.println("成功修改数据");
	    } else {
	        System.out.println("修改数据出错！");
	    }
		
		resp.sendRedirect("FindAllServlet");
	}
}
