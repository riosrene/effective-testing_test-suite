package com.effectivetesting.common;

import java.util.ArrayList;

import com.effectivetesting.entities.Entry;
import com.effectivetesting.entities.User;

public class EntityHelper {
	public static Entry createTestEntry(int id, int author_id, String title, String body, String slug, int status) {
		Entry entry = new Entry();
		entry.setComments(new ArrayList<String>());
		entry.setBody(body);
		entry.setAuthor_id(author_id);
		entry.setId(id);
		entry.setSlug(slug);
		entry.setStatus(status);
		entry.setTags(new ArrayList<String>());
		entry.setTitle(title);
		
		return entry;
	}
	
	public static User createTestUser(String id, String userName, String email, String password) {
		User user = new User();

		user.setId(id);
		user.setEmail(email);
		user.setpassword_hash(password);
		user.setName(userName);
		
		return user;
	}
}
