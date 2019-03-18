package com.kh.dao;

import com.kh.pojo.User;

public interface UserDao {
	
	//根据用户查询密码
	public User findPassword(String username) throws Exception;
	
	//注册新用户
	public void addUser(User user) throws Exception;
	
	//查询用户是否存在
	public User checkUser(String username) throws Exception;
	

}
