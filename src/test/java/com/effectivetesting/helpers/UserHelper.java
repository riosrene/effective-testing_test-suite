package com.effectivetesting.helpers;

import com.effectivetesting.entities.User;

public class UserHelper {
	public User createTestUser(String id) {

		User user = new User();

		user.setId(id);
		user.setEmail("userx@gmail.com");
		user.setpassword_hash("userx");
		user.setName("John Doe");
		
		return user;

	}
}
