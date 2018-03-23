package com.effectivetesting.common;

import java.util.ArrayList;

import com.effectivetesting.entities.Entry;
import com.effectivetesting.entities.User;

public class EntityHelper {
	public static Entry createTestEntry(int Id, int author_id, String title, String body, String slug, int status) {
		Entry entry = new Entry();
		
		entry.setId(Id);
		entry.setAuthor_id(author_id);
		entry.setTitle(title);
		entry.setBody(body);
		entry.setSlug(slug);
		entry.setStatus(status);
		entry.setTags(new ArrayList<String>());
		entry.setComments(new ArrayList<String>());
		entry.setCreated_timestamp("2018-03-16T05:45:31.908288");
		entry.setModified_timestamp("2018-03-16T05:45:31.908288");
		entry.setNum_results(1);
		entry.setObjects(new ArrayList<Entry>());
		entry.setPage(1);
		entry.setTotal_pages(1);
		
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
