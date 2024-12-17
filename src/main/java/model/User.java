package model;

import java.util.Date;

public class User {
	private int user_id;
	private String fullname;
	private String username;
	private String password;
	private String avatar;
	private String phone;
	private String email;
	private String gender;
	private Date date_of_birt;
	private String address;
	private String role;
	private int status;
	private Date created_at;
	private Date updated_at;
	
	public User() {
	}

	public User(int user_id, String fullname, String username, String password, String avatar, String phone,
			String email, String gender, Date date_of_birt, String address, String role, int status,
			Date created_at, Date updated_at) {
	
		this.user_id = user_id;
		this.fullname = fullname;
		this.username = username;
		this.password = password;
		this.avatar = avatar;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.date_of_birt = date_of_birt;
		this.address = address;
		this.role = role;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDate_of_birt() {
		return date_of_birt;
	}

	public void setDate_of_birt(Date date_of_birt) {
		this.date_of_birt = date_of_birt;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
		return "User [user_id=" + user_id + ", fullname=" + fullname + ", username=" + username + ", password="
				+ password + ", avatar=" + avatar + ", phone=" + phone + ", email=" + email + ", gender=" + gender
				+ ", date_of_birt=" + date_of_birt + ", address=" + address + ", role=" + role + ", status=" + status
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}
	
}
