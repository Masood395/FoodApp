package com.tap.userdaoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.database.MyConnect;
import com.tap.user.User;
import com.tap.userdao.UserDAO;

public class UserDAOImpl implements UserDAO{

	List<User> userList = new ArrayList<User>();
	private final String INSER_QUERY = "insert into `user`(`username`,`email`,`password`,`mobile`) values(?,?,?,?)";
	private final String FETCH_ALL_QUERY = "select * from `user` ";
	private final String FETCH_QUERY = "select * from `user` where `email`=? ";
	private final String UPDATE_QUERY = "update `user` set `email`=? where `uid`=? ";
	private final String DELETE_QUERY = "delete from `user` where `uid`=?";
	
	private Connection con;
	private PreparedStatement pstmt;
	private int status;
	private Statement stmt;
	private ResultSet res;
	private User s;


	public UserDAOImpl() {
		
		con = MyConnect.connect();
		
	}
	@Override
	public int insert(User u) {

		try {

			pstmt= con.prepareStatement(INSER_QUERY);
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getEmail());
			pstmt.setString(3, u.getPassword());
			pstmt.setString(4,u.getMobile());

			status = pstmt.executeUpdate();
			

		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public List<User> fetchAll() {

		try {

			stmt = con.createStatement();
			res = stmt.executeQuery(FETCH_ALL_QUERY);

			userList = extractUserListFromResultSet(res);

		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return userList;

	}

	List<User> extractUserListFromResultSet( ResultSet res) {

		try {

			while(res.next()) {

				userList.add(new User(res.getInt("uid"),res.getString("username"),res.getString("email"),res.getString("password"),res.getString("mobile")));
			}

		}
		catch(Exception e) {

			e.printStackTrace();

		}
		
		return userList;

	}
	@Override
	public User fetchSpecific(String email) {
		 
		try {
			
			pstmt = con.prepareStatement(FETCH_QUERY);
			pstmt.setString(1, email);
			res = pstmt.executeQuery();
			
			userList = extractUserListFromResultSet(res);
			
			if(! userList.isEmpty()) {
				
				s =userList.get(0);
				
			}
//			else {
//				System.out.println("No Record..");
//				System.exit(0);
//			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return s;
	}
	@Override
	public int update(User u) {
		
		try {
			
			pstmt = con.prepareStatement(UPDATE_QUERY);
			pstmt.setString(1, u.getEmail());
			pstmt.setInt(2, u.getUid());
			status = pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	@Override
	public int delete(int uid) {
		
		try {
			
			pstmt = con.prepareStatement(DELETE_QUERY);
			pstmt.setInt(1, uid);
			status = pstmt.executeUpdate(); 
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
		
	}


}
