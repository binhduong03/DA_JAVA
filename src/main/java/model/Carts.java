package model;

import java.util.Date;

public class Carts {
	private int cart_id;
	private User user;
	private Course course;
	private int status;
	private Date created_at;
	private Date updated_at;
	public Carts() {
		
	}
	public Carts(int cart_id, User user, Course course, int status, Date created_at, Date updated_at) {
		
		this.cart_id = cart_id;
		this.user = user;
		this.course = course;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
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
		return "Carts [cart_id=" + cart_id + ", user=" + user + ", course=" + course + ", status=" + status
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}
	
	
	
	
	
	
	
	
	
}
