package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.bean.Account;
import com.dao.AccountDao;
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {			
		request.setCharacterEncoding("UTF-8");	
		try {			     
			String username = request.getParameter("username");
			double balance = Double.valueOf(request.getParameter("balance"));	
	        // 加载配置文件
			WebApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
		    // 获取AccountDao实例
		    AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
		    // 创建Account对象，并向Account对象中添加数据
		    Account account = new Account();
		    account.setUsername(username);
		    account.setBalance(balance);
		    // 执行addAccount()方法，并获取返回结果
		    int num = accountDao.addAccount(account);
		    if (num > 0) {
		        System.out.println("成功插入了" + num + "条数据！");
		    } else {
		        System.out.println("插入操作执行失败！");
		    }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("FindAllServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
