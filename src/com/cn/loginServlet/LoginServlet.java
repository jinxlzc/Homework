package com.cn.loginServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.loginDao.UserDao;

public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");//设置请求编码
		response.setCharacterEncoding("UTF-8");//设置响应编码
		response.setContentType("text/html;charset=UTF-8");//设置响应 MIMU
		String username=request.getParameter("username");//获取表单的提交数据
		String password=request.getParameter("password");//获取表单的提交数据
		UserDao ud=new UserDao();//生成实例对象
		String pwd =ud.FindUser(username);//通过实例对象调用方法
		
		if(username==null||username.isEmpty()){//验证 密码不为空
			request.setAttribute("passmsg", "密码不能为空！！");
			System.out.println("1");
			request.getRequestDispatcher("/pages/Login.jsp").forward(request, response);
			return;
		}
		if(ud.FindUser(username)==null||ud.FindUser(username).isEmpty()){
			System.out.println("2");
			request.setAttribute("usermsg", "用户不存在(*^__^*) 嘻嘻去注册一个吧！！");
			request.getRequestDispatcher("/pages/Login.jsp").forward(request, response);
			return;
		}
		

		if(password!=null&&!password.equals(pwd)){//验证密码正确性
			System.out.println("3");
			request.setAttribute("passmsg", "密码不正确！！");
			request.getRequestDispatcher("/pages/Login.jsp").forward(request, response);
			return;
		}
		if(password.equals(pwd)){//登陆成功
			System.out.println("4");
			request.setAttribute("msg", "登陆成功");
			//response.getWriter().write("登陆成功!2秒后跳转到欢迎界面");
			//response.setHeader("refresh","2;url="+request.getContextPath()+"/pages/welcome.jsp");
			request.getRequestDispatcher("/pages/welcome.jsp").forward(request, response);
			return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		     this.doGet(request, response);
	}

}
