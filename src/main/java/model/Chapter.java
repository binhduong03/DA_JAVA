package model;

import java.util.Date;

public class Chapter {
	private int chapter_id;
	private String title;
	private String content;
	private Course course;
	private Date created_at;
	private Date updated_at;
	public Chapter() {
		
	}
	public Chapter(int chapter_id, String title, String content, Course course, Date created_at, Date updated_at) {
		this.chapter_id = chapter_id;
		this.title = title;
		this.content = content;
		this.course = course;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public int getChapter_id() {
		return chapter_id;
	}
	public void setChapter_id(int chapter_id) {
		this.chapter_id = chapter_id;
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
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
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
		return "Chapter [chapter_id=" + chapter_id + ", title=" + title + ", content=" + content + ", course=" + course
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}
	
	
	
}
