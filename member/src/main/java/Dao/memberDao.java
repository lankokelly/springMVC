package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.member;

public class memberDao implements implDao{
	
	public static void main(String[] args) {
		System.out.println(new memberDao().query("abc"));
	}

	@Override
	public void add(Object o) {
		Connection conn = implDao.getDb();
		String SQL = "insert into member(name, username, password, address, phone, mobile) values(?,?,?,?,?,?)";
		member m = (member)o;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, m.getName());
			ps.setString(2, m.getUsername());
			ps.setString(3, m.getPassword());
			ps.setString(4, m.getAddress());
			ps.setString(5, m.getPhone());
			ps.setString(6, m.getMobile());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean query(String username, String password) {
		/*1.連線
		 *2.SQL-->帳號,密碼
		 *3.preparedstatement
		 *4.ResultSet-->next()	
		 * 
		 */
		Connection conn=implDao.getDb();
		String SQL="select * from member where username=? and password=?";
		boolean b=false;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, username);
			ps.setString(2,password );
			ResultSet rs=ps.executeQuery();		
			if(rs.next()==true) b=true;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return b;
	}

	@Override
	public boolean query(String username) {
		/*1.連線
		 *2.SQL-->帳號,密碼
		 *3.preparedstatement
		 *4.ResultSet-->next()	
		 * 
		 */
		Connection conn=implDao.getDb();
		String SQL="select * from member where username=? ";
		boolean b=false;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, username);			
			ResultSet rs=ps.executeQuery();		
			if(rs.next()==true) b=true;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return b;
	}
	

}
