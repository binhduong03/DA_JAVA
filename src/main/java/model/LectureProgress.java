package model;

import java.util.Date;

public class LectureProgress {
	private int lecture_progress_id;
	private User user;
	private Lecture lecture;
	private float progress;
	private int status;
	private Date created_at;
	private Date updated_at;
	public LectureProgress() {
		
	}
	public LectureProgress(int lecture_progress_id, User user, Lecture lecture, float progress, int status,
			Date created_at, Date updated_at) {
		this.lecture_progress_id = lecture_progress_id;
		this.user = user;
		this.lecture = lecture;
		this.progress = progress;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public int getLecture_progress_id() {
		return lecture_progress_id;
	}
	public void setLecture_progress_id(int lecture_progress_id) {
		this.lecture_progress_id = lecture_progress_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Lecture getLecture() {
		return lecture;
	}
	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}
	public float getProgress() {
		return progress;
	}
	public void setProgress(float progress) {
		this.progress = progress;
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
		return "LectureProgress [lecture_progress_id=" + lecture_progress_id + ", user=" + user + ", lecture=" + lecture
				+ ", progress=" + progress + ", status=" + status + ", created_at=" + created_at + ", updated_at="
				+ updated_at + "]";
	}
	
	
	
	
}
