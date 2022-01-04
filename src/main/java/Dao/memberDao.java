package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.member;

public class memberDao implements implDao{

	public static void main(String[] args) {
		
		//add方法1
		//new memberDao().add("c", "happy", "89+89+");
		//add方法2
		//member m = new member("d", "sad", "666");
		//new memberDao().add(m);
		//query
		//System.out.println(new memberDao().queryAll());
		//update
		//new memberDao().update("amy", 6);
		//delete
		new memberDao().delete(10);
		/*
		String url = "jdbc:mysql://localhost:3306/company";
		String user = "root";
		String password = "123456";
		String sql1 = "insert into member(name, username, password)values('a','irene','123456')";
		String sql2 = "insert into member(name, username, password)values(?,?,?)";
		
		try {
			// mysql 廠商提供連線 driver，將driver jar放入lib中
			Class.forName("com.mysql.jdbc.Driver");//可能產生ClassNotFoundException
			Connection con = DriverManager.getConnection(url, user, password); //可能產生SQLException
			
			//法1:
			//Statement st = con.createStatement(); // Creates a Statement object for sendingSQL statements to the database
			//st.executeUpdate(sql1);
			
			//法2:
			PreparedStatement ps = con.prepareStatement(sql2);
			ps.setString(1, "b");
			ps.setString(2, "tony");
			ps.setString(3, "4564789");
			ps.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			System.out.println("no driver");
		} catch (SQLException e) {
			System.out.println("no connection");
		}
		*/
	}
	
	//add方法1
	@Override
	public
	void add(String name, String username, String pwd) {
		Connection conn=implDao.dbConnect();
		String sql="insert into member(name,username,password) values(?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, username);
			ps.setString(3, pwd);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//[推薦]add方法2(注入)
	@Override
	public void add(Object o) {
		Connection conn = implDao.dbConnect();
		String sql = "insert into member(name, username, password) values(?,?,?)";
		member m = (member) o;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, m.getName());
			ps.setString(2, m.getUsername());
			ps.setString(3, m.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 查詢
	@Override
	public String queryAll() {
		Connection conn = implDao.dbConnect();
		String sql="select * from member;";
		String show = "";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			System.out.println(rs);
			while(rs.next()) 
			{
				show = show + rs.getInt("id")+ "\t" 
							+ rs.getString("name") + "\t" 
							+ rs.getString("username") + "\t" 
							+ rs.getString("password") + "\n";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return show;
	}

	// 更新
	@Override
	public void update(String name, int id) {
			Connection conn = implDao.dbConnect();
			String sql = "update member set name=? where id=?";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, name);
				ps.setInt(2, id);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	@Override
	public void delete(int id) {
		Connection conn = implDao.dbConnect();
		String sql = "delete from member where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}