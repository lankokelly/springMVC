package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface implDao {
	
	// for CRUD、資料庫連線
	
	// static 
	static Connection dbConnect() {
		String url = "jdbc:mysql://localhost:3306/company?useUnicode=true&characterEncoding=utf-8";
		String user = "root";
		String password = "123456";
		String sql2 = "insert into member(name, username, password)values(?,?,?)";
		Connection con = null;	
		try {
			Class.forName("com.mysql.jdbc.Driver");//可能產生ClassNotFoundException
			con = DriverManager.getConnection(url, user, password); //可能產生SQLException

		} catch (ClassNotFoundException e) {
			System.out.println("no driver");
			e.printStackTrace();
		} catch (SQLException e1) {
			System.out.println("no connection");
			e1.printStackTrace();
		}
		return con;
	}

	
	// create 
	void add(String name, String usrname, String pwd);
	void add(Object o);
	
	// query
	String queryAll();
	
	//update
	void update(String name, int id);
	
	//delete
	void delete(int id);
	
}
	

