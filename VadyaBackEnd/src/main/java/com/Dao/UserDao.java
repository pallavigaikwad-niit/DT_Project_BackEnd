package com.Dao;

import java.util.List;
import com.Model.User;


public interface UserDao {

	void insertUser(User user);

	void updateUser(User user);

	void deleteUser(User user);

	User getUser(int id);

	List<User> getAllUsers();
	
	User getUserByEmail(String email);

}
