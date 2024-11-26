package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.User;

public class UserDAO extends DBContext {
	public List<User> allTeacher(){
		List<User> list = new ArrayList<>();
		String sql = "select * from `tb_user`"
					+"where `role` = 'teacher'";
		try {
			connection = getConnection();
			PreparedStatement p = connection.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			int user_id;
			String fullname, username, password, avatar, phone, email, gender, address, role;
			Date date_of_birt, created_at, updated_at;
			boolean status;
			while(rs.next()) {
				user_id = rs.getInt("user_id");
				fullname = rs.getString("fullname");
				username = rs.getString("username");
				password = rs.getString("password");
				avatar = rs.getString("avatar");
				phone = rs.getString("phone");
				email = rs.getString("email");
				gender = rs.getString("gender");
				date_of_birt = rs.getDate("date_of_birt");
				address = rs.getString("address");
				role = rs.getString("role");
				status = rs.getBoolean("status");
				created_at = rs.getDate("created_at");
				updated_at = rs.getDate("updated_at");
				User u = new User(user_id, fullname, username, password, avatar, phone, email, gender, date_of_birt, address, role, status, created_at, updated_at);
				list.add(u);
			}
			p.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	public User getUserById(int id) {
		String sql = "select * from `tb_user` where `user_id` = ?";
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			int user_id;
			String fullname, username, password, avatar, phone, email, gender, address, role;
			Date date_of_birt, created_at, updated_at;
			boolean status;
			if(rs.next()) {
				user_id = rs.getInt("user_id");
				fullname = rs.getString("fullname");
				username = rs.getString("username");
				password = rs.getString("password");
				avatar = rs.getString("avatar");
				phone = rs.getString("phone");
				email = rs.getString("email");
				gender = rs.getString("gender");
				date_of_birt = rs.getDate("date_of_birt");
				address = rs.getString("address");
				role = rs.getString("role");
				status = rs.getBoolean("status");
				created_at = rs.getDate("created_at");
				updated_at = rs.getDate("updated_at");
				User u = new User(user_id, fullname, username, password, avatar, phone, email, gender, date_of_birt, address, role, status, created_at, updated_at);
				return u;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public void insert(User u) {
	    String sql = "INSERT INTO `tb_user` (`user_id`, `fullname`, `username`, `password`, `avatar`, `phone`, `email`, `gender`, `date_of_birt`, `address`, `role`, `status`, `created_at`, `updated_at`) "
	               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    try {
	    	connection = getConnection();
	        PreparedStatement ps = connection.prepareStatement(sql);

	        ps.setInt(1, u.getUser_id());
	        ps.setString(2, u.getFullname());
	        ps.setString(3, u.getUsername());
	        ps.setString(4, u.getPassword());
	        ps.setString(5, u.getAvatar());
	        ps.setString(6, u.getPhone());
	        ps.setString(7, u.getEmail());
	        ps.setString(8, u.getGender());
	        ps.setDate(9, new java.sql.Date(u.getDate_of_birt().getTime()));
	        ps.setString(10, u.getAddress());
	        ps.setString(11, u.getRole());
	        ps.setBoolean(12, u.isStatus());
	        ps.setDate(13, new java.sql.Date(u.getCreated_at().getTime()));
	        ps.setDate(14, new java.sql.Date(u.getUpdated_at().getTime()));
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}



}
