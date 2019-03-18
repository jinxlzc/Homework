package com.cn.loginServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.loginDao.UserDao;

public class regisServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		UserDao ud=new UserDao();
		String re_user=request.getParameter("username");
		String re_pwd=request.getParameter("password");
		
		if(re_user==null||re_user.trim().isEmpty()){
			request.setAttribute("c_user_msg", "*帐号不能为空");
			request.getRequestDispatcher("/pages/regis.jsp").forward(request, response);
			return;
		}
		if(re_pwd==null||re_pwd.trim().isEmpty()){
			request.setAttribute("re_pwd_msg", "*密码不能为空");
			request.getRequestDispatcher("/pages/regis.jsp").forward(request, response);
			return;
		}
		//注册的账号和数据库中的对比
		if(re_user.equals(ud.CheckUser(re_user))){
			request.setAttribute("re_user_msg","*用户已经存在");
			request.getRequestDispatcher("/pages/regis.jsp").forward(request,response);
			return;
		}
		

		UserDao u = new UserDao();
		u.addUser(re_user,re_pwd);
		request.setAttribute("msg", "恭喜："+re_user+"，注册成功");
		request.getRequestDispatcher("/pages/welcome.jsp").forward(request, response);//服务器端跳转
			//response.sendRedirect("welcome.jsp"); 客户端跳转

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
