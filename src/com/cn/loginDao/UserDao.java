package com.cn.loginDao;
import java.sql.*;
public class UserDao {
	/**
	 * 用户的登录和注册
	 * @since 1.0  
	 * @version 1.1  
	 * @author Twenty-seven
	 * @data 18/3/25/11:24
	 *  */
	
	//查询用户密码
	public String FindUser(String username){
		String passd = null;
		String sql = "select * from User_info where username=?";
		Connection con =getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);//预处理
			pstmt.setString(1, username);//给？赋值
			rs = pstmt.executeQuery();//执行SQL语句
			if(rs.next()){//遍历查找到与username匹配的password
				passd=rs.getString("password");//将查询到的password赋值给passd
			}else{
				passd=null;//未查询到为空
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (SQLException e) {		
				e.printStackTrace();
			}
		}
		return passd;//返回passd
	}
	//--------------------我是分隔符----略略略-------------------------------
	//注册新用户
	public void addUser(String username,String passd){
		Connection con = getConnection();
		PreparedStatement pstmt =null;
		String sql = "INSERT INTO User_info(username,password) VALUES(?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, passd);
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch (SQLException e) {	
				e.printStackTrace();
			}
		}
	}
	//--------------------我是分隔符----略略略---------------------------
	//连接数据库
	public static Connection getConnection(){
		String driver ="com.mysql.jdbc.Driver";
		String url ="jdbc:mysql://localhost:3306/test";
		String user ="root";
		String password ="123456";
		Connection connection =null;
		try {
			Class.forName(driver);
			connection =DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	//--------------------我是分隔符----略略略---------------------------
	//查询用户名是否已经注册过
	public String CheckUser(String username){
		String re_user = null;
		String sql = "select username from User_info where username=?";
		Connection con =getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);//预处理
			pstmt.setString(1, username);//给？赋值
			rs = pstmt.executeQuery();//执行SQL语句
			if(rs.next()){//遍历查找到与username匹配的password
				re_user=rs.getString("username");//将查询到的password赋值给passd
			}else{
				re_user=null;//未查询到为空
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (SQLException e) {		
				e.printStackTrace();
			}
		}
		return re_user;//返回查找到的用户
	}
	
  // public static void main(String[] args) {
	//UserDao ud=new UserDao();
	//ud.addUser("zhaoo012","horyes012");
//	System.out.println(ud.CheckUser("zhaoo012"));
	
  // }
}
