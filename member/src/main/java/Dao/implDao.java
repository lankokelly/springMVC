package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface implDao {
	// 連線方法
	static Connection getDb() {
		
		String url = "jdbc:mysql://localhost:3306/member?useUnicode=true&characterEncoding=utf-8";
		String user = "root";
		String password = "123456";
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("no connection");
			e.printStackTrace();
		}
		System.out.print("連線成功");
		return conn;
	}
	
	//新增物件
	void add(Object o);
	
	//查詢物件
	boolean query(String username,String password);//判斷帳號與密碼
	boolean query(String username);//判斷帳號重複
	
	//修改物件
	
	
	//刪除物件

}
