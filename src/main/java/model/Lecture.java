package model;

import java.util.Date;

public class Lecture {
	private int lecture_id;
	private Chapter chapter;
	private String title;
	private String content;
	private String media_type;
	private String media_url;
	private int order;
	private int status;
	private Date created_at;
	private Date updated_at;
	public Lecture() {
		
	}
	public Lecture(int lecture_id, Chapter chapter, String title, String content, String media_type, String media_url,
			int order, int status, Date created_at, Date updated_at) {
		this.lecture_id = lecture_id;
		this.chapter = chapter;
		this.title = title;
		this.content = content;
		this.media_type = media_type;
		this.media_url = media_url;
		this.order = order;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public int getLecture_id() {
		return lecture_id;
	}
	public void setLecture_id(int lecture_id) {
		this.lecture_id = lecture_id;
	}
	public Chapter getChapter() {
		return chapter;
	}
	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMedia_type() {
		return media_type;
	}
	public void setMedia_type(String media_type) {
		this.media_type = media_type;
	}
	public String getMedia_url() {
		return media_url;
	}
	public void setMedia_url(String media_url) {
		this.media_url = media_url;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	@Override
	public String toString() {
		return "Lecture [lecture_id=" + lecture_id + ", chapter=" + chapter + ", title=" + title + ", content="
				+ content + ", media_type=" + media_type + ", media_url=" + media_url + ", order=" + order + ", status="
				+ status + ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}
	
	
	
}
