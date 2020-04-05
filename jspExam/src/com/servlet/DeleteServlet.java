package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.dao.AccountDaoImpl;

public class DeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));
		
		WebApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
		AccountDaoImpl accountDao = (AccountDaoImpl) applicationContext.getBean("accountDao");
		
		int num = accountDao.deleteAccount(id);    
		if (num > 0) {
		    System.out.println("成功删除了" + num + "条数据！");
		} else {
		    System.out.println("删除操作执行失败！");
		}
		
		resp.sendRedirect("FindAllServlet");
	}
}
