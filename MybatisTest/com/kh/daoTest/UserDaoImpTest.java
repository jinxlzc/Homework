package com.kh.daoTest;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.kh.dao.UserDao;
import com.kh.dao.UserDaoImp;
import com.kh.pojo.User;


public class UserDaoImpTest {
	
	 private SqlSessionFactory sqlSessionFactory ;
	@Before
	public void setUp() throws Exception{
		//mybatis配置文件
		String resource="mybatis-config.xml";
		//以流的方式得到
		InputStream inputStream=Resources.getResourceAsStream(resource);
		 sqlSessionFactory = new  SqlSessionFactoryBuilder().build(inputStream);
		
	}
	@Test
	public void testfindPassword() throws Exception{
		//创建Dao对象
		UserDao userdao=new UserDaoImp(sqlSessionFactory);
		//调用UserDao方法
		User pwd=userdao.findPassword("zhaoo012");
		System.out.println("findPassword is success!!"+pwd);
		
	}
	@Test
	public void testaddUser() throws Exception{
		//创建Dao对象
		UserDao userdao=new UserDaoImp(sqlSessionFactory);
		//调用UserDao方法
		User user=new User();
		user.setUsername("zkh");
		user.setPassword("kh");
		userdao.addUser(user);
		System.out.println("testaddUser is success!");
	}
	
	@Test
	public void testcheckUser() throws Exception{
		//创建Dao对象
		UserDao userdao=new UserDaoImp(sqlSessionFactory);
		//调用UserDao方法
		String username=userdao.checkUser("zkh").toString();
		
		System.out.println(username);
		if(username.equals(null)){
			System.out.println("null");
		}else{
			System.out.println("not null");
		}
		System.out.println("testaddUser is success!");
	}
	
	

}
