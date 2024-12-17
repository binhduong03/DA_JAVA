package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Course;
import model.User;

public class CourseDAO extends DBContext{
	UserDAO us = new UserDAO(); 
	public List<Course> allCourse() {
	    List<Course> list = new ArrayList<>();
	    String sql = "SELECT * FROM `tb_course` order By `course_id` DESC ";

	    try {
	        connection = getConnection();
	        PreparedStatement p = connection.prepareStatement(sql);
	        ResultSet rs = p.executeQuery();

	        while (rs.next()) {
	            int course_id = rs.getInt("course_id");
	            int user_id = rs.getInt("user_id");
	            String name = rs.getString("name");
	            String image = rs.getString("image");
	            String description = rs.getString("description");
	            double price = rs.getDouble("price");
	            int duration = rs.getInt("duration");
	            int status = rs.getInt("status");
	            Date created_at = rs.getDate("created_at");
	            Date updated_at = rs.getDate("updated_at");

	            User user = us.getUserById(user_id);

	            Course course = new Course(course_id, user, name, image, description, price, duration, status, created_at, updated_at);
	            list.add(course);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}

	public Course getCourseById(int id) {
		String sql = "select * from `tb_course` where `course_id` = ?";
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			int course_id, user_id, duration, status;
			String name, image, description;
			Date created_at, updated_at;
			double price;
			while(rs.next()) {
				course_id = rs.getInt("course_id");
				user_id = rs.getInt("user_id");
				name = rs.getString("name");
				image = rs.getString("image");
				description = rs.getString("description");
				price = rs.getDouble("price");
				duration = rs.getInt("duration");
				status = rs.getInt("status");
				created_at = rs.getDate("created_at");
				updated_at = rs.getDate("updated_at");
				 
				User user = us.getUserById(user_id);
				
				Course c = new Course(course_id, user, name, image, description, price, duration, status, created_at, updated_at);
				return c;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public void insert(Course c) {
	    String sql = "INSERT INTO `tb_course` (`course_id`, `user_id`, `name`, `image`, `description`, `price`, `duration`, `status`, `created_at`, `updated_at`) "
	               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    try {
	    	connection = getConnection();
	        PreparedStatement ps = connection.prepareStatement(sql);
	        
	        ps.setInt(1, c.getCourse_id());
	        ps.setInt(2, c.getUser().getUser_id());
	        ps.setString(3, c.getName());
	        ps.setString(4, c.getImage());
	        ps.setString(5, c.getDescription());
	        ps.setDouble(6, c.getPrice());
	        ps.setInt(7, c.getDuration());	       
	        ps.setInt(8, c.getStatus());
	        ps.setDate(9, new java.sql.Date(c.getCreated_at().getTime()));
	        ps.setDate(10, new java.sql.Date(c.getUpdated_at().getTime()));
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void update(Course c) {
	    String sql = "UPDATE `tb_course` SET "
	            + "`user_id` = ?, "
	            + "`name` = ?, "
	            + "`image` = ?, "
	            + "`description` = ?, "
	            + "`price` = ?, "
	            + "`duration` = ?, "
	            + "`status` = ?, "
	            + "`created_at` = ?, "
	            + "`updated_at` = ? "
	            + "WHERE `course_id` = ?";

	    try {
	        connection = getConnection();
	        PreparedStatement ps = connection.prepareStatement(sql);

	        ps.setInt(1, c.getUser().getUser_id());
	        ps.setString(2, c.getName());
	        ps.setString(3, c.getImage());
	        ps.setString(4, c.getDescription());
	        ps.setDouble(5, c.getPrice());
	        ps.setInt(6, c.getDuration());
	        ps.setInt(7, c.getStatus());
	        ps.setDate(8, new java.sql.Date(c.getCreated_at().getTime()));
	        ps.setDate(9, java.sql.Date.valueOf(LocalDate.now()));
	        ps.setInt(10, c.getCourse_id());

	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void delete(int id) {
		String sql = "delete from `tb_course` \r\n"
					+"where `course_id` =?;";
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//Trang chính
	public List<Course> course() {
	    List<Course> list = new ArrayList<>();
	    String sql = "SELECT * FROM `tb_course` where `status` = 1";

	    try {
	        connection = getConnection();
	        PreparedStatement p = connection.prepareStatement(sql);
	        ResultSet rs = p.executeQuery();

	        while (rs.next()) {
	            int course_id = rs.getInt("course_id");
	            int user_id = rs.getInt("user_id");
	            String name = rs.getString("name");
	            String image = rs.getString("image");
	            String description = rs.getString("description");
	            double price = rs.getDouble("price");
	            int duration = rs.getInt("duration");
	            int status = rs.getInt("status");
	            Date created_at = rs.getDate("created_at");
	            Date updated_at = rs.getDate("updated_at");

	            User user = us.getUserById(user_id);

	            Course course = new Course(course_id, user, name, image, description, price, duration, status, created_at, updated_at);
	            list.add(course);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}
}
