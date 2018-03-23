package com.effectivetesting.entities;

import java.util.List;

public class Entry {
	private int id;
	private String title;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	private String slug;
	private int num_results;
	private List<Entry> objects;
	private int page;
	private int total_pages;
	private int author_id;
	private String body;
	private int status;
	private String created_timestamp;
	private String modified_timestamp;
	private List<String> tags;
	private List<String> comments;
	
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCreated_timestamp() {
		return created_timestamp;
	}

	public void setCreated_timestamp(String created_timestamp) {
		this.created_timestamp = created_timestamp;
	}

	public String getModified_timestamp() {
		return modified_timestamp;
	}

	public void setModified_timestamp(String modified_timestamp) {
		this.modified_timestamp = modified_timestamp;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	public int getTotal_pages() {
		return total_pages;
	}
	
	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<Entry> getObjects() {
		return objects;
	}
	
	public void setObjects(List<Entry> objects) {
		this.objects = objects;
	}
	
	public int getNum_results() {
		return num_results;
	}
	
	public void setNum_results(int num_results) {
		this.num_results = num_results;
	}
}