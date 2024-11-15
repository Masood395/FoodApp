package com.tap.userdao;

import java.util.List;

import com.tap.user.User;

public interface UserDAO {

		int insert(User u);
		List<User> fetchAll();
		User fetchSpecific(String email);
		int update(User u);
		int delete(int uid);
}
