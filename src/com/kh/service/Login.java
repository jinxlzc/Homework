package com.kh.service;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;

import com.kh.dao.UserDao;
import com.kh.dao.UserDaoImp;
public class Login extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		SqlSessionFactory sqlSessionFactory = null;
		UserDao userdao=new UserDaoImp(sqlSessionFactory);
		System.out.println(username +password);
		try {
		String	pwd = userdao.findPassword(username).toString();
		
		
		//账号不为空
		if(username==null||username.isEmpty()){//验证 密码不为空
			request.setAttribute("passmsg", "密码不能为空！！");
			System.out.println("1");
			request.getRequestDispatcher("/testMybatis/Login.jsp").forward(request, response);
			return;
		}
		//密码不为空
		
		if(userdao.findPassword(username)==null||userdao.findPassword(username).toString().equals(null)){
				System.out.println("2");
				request.setAttribute("usermsg", "用户不存在(*^__^*) 嘻嘻去注册一个吧！！");
				request.getRequestDispatcher("/testMybatis/Login.jsp").forward(request, response);
				return;
		}
		//验证密码
		if(password!=null&&!password.equals(pwd)){//验证密码正确性
			System.out.println("3");
			request.setAttribute("passmsg", "密码不正确！！");
			request.getRequestDispatcher("/testMybatis/Login.jsp").forward(request, response);
			return;
		}
		
		if(password.equals(pwd)){//登陆成功
			System.out.println("4");
			request.setAttribute("msg", "登陆成功");
			//response.getWriter().write("登陆成功!2秒后跳转到欢迎界面");
			//response.setHeader("refresh","2;url="+request.getContextPath()+"/pages/welcome.jsp");
			request.getRequestDispatcher("/testMybatis/welcome.jsp").forward(request, response);
			return;
		}
			
		
			} catch (Exception e1) {
				System.out.println("密码查询异常");
				e1.printStackTrace();
			}
		
	
	}

	
	
	
	
	
	
	public  void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 this.doGet(request, response);
	}

}
