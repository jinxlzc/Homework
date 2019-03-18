package com.kh.dao;


import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kh.pojo.User;
  /*
   * UserDao接口的实现类
   * time:2018-5-9 19:59
   * */


public class UserDaoImp implements UserDao{
	
	//向dao实现类中注入SqlSessionFactory
	//通过构造方法注册
	private SqlSessionFactory sqlSessionFactory;
	public UserDaoImp(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory=sqlSessionFactory;
	}
	//创建工厂
	public void setUp() throws IOException{
		//mybatis配置文件
		String resource="mybatis-config.xml";
		//以流的方式得到
		InputStream inputStream=Resources.getResourceAsStream(resource);
		 sqlSessionFactory = new  SqlSessionFactoryBuilder().build(inputStream);
	}
	
	
	//根据用户查询密码
	@Override
	public User findPassword(String username) throws Exception {
		setUp();
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		User pwd=sqlSession.selectOne("test.findPassword",username);
		System.out.println(pwd);
		sqlSession.close();
		
		return pwd;
	}

	//注册新用户
	@Override
	public void addUser(User user) throws Exception {
		setUp();
		SqlSession sqlSession=sqlSessionFactory.openSession();
	
		sqlSession.insert("test.addUser", user);
		System.out.println("test");
		sqlSession.commit();
		sqlSession.close();
		
	}
	
	//检查用户是否存在
	@Override
	public User checkUser(String username) throws Exception {
		setUp();
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		User user=sqlSession.selectOne("test.checkUser", username);
		sqlSession.commit();
		sqlSession.close();
		return user;
	}


}
