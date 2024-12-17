package model;

import java.util.Date;

public class Course {
	private int course_id;
	private User user;
	private String name;
	private String image;
	private String description;
	private double price;
	private int duration;
	private int status;
	private Date created_at;
	private Date updated_at;
	public Course() {
	}
	public Course(int course_id, User user, String name, String image, String description, double price, int duration,
			int status, Date created_at, Date updated_at) {
		
		this.course_id = course_id;
		this.user = user;
		this.name = name;
		this.image = image;
		this.description = description;
		this.price = price;
		this.duration = duration;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
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
		return "Course [course_id=" + course_id + ", user=" + user + ", name=" + name + ", image=" + image
				+ ", description=" + description + ", price=" + price + ", duration=" + duration + ", status=" + status
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}
	
	

	
	
}
