package model;

import java.util.Date;

public class Exercise {
	private int exercises_id;
	private Lecture lecture;
	private String title;
	private String description;
	private String file_path;
	private Date due_date;
	private int status;
	private Date created_at;
	private Date updated_at;
	public Exercise() {
		
	}
	public Exercise(int exercises_id, Lecture lecture, String title, String description, String file_path,
			Date due_date, int status, Date created_at, Date updated_at) {
		this.exercises_id = exercises_id;
		this.lecture = lecture;
		this.title = title;
		this.description = description;
		this.file_path = file_path;
		this.due_date = due_date;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public int getExercises_id() {
		return exercises_id;
	}
	public void setExercises_id(int exercises_id) {
		this.exercises_id = exercises_id;
	}
	public Lecture getLecture() {
		return lecture;
	}
	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
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
		return "Exercise [exercises_id=" + exercises_id + ", lecture=" + lecture + ", title=" + title + ", description="
				+ description + ", file_path=" + file_path + ", due_date=" + due_date + ", status=" + status
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}
	
	
	
	
	
	
}
