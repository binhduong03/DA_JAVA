package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Carts;
import model.Chapter;
import model.Course;
import model.Lecture;
import model.Payments;
import model.User;

public class CartDAO extends DBContext{
	UserDAO us = new UserDAO();
	CourseDAO cd = new CourseDAO();
	public boolean addToCart(Carts cart) {
	    try {
	        // Kiểm tra xem giỏ hàng đã tồn tại chưa
	        String checkQuery = "SELECT * FROM tb_carts WHERE user_id = ? AND course_id = ?";
	        PreparedStatement checkStmt = connection.prepareStatement(checkQuery);
	        checkStmt.setInt(1, cart.getUser().getUser_id());
	        checkStmt.setInt(2, cart.getCourse().getCourse_id());
	        ResultSet rs = checkStmt.executeQuery();

	        if (rs.next()) {
	            return false; // Khóa học đã tồn tại trong giỏ hàng
	        }

	        // Thêm mới vào giỏ hàng
	        String insertQuery = "INSERT INTO tb_carts (user_id, course_id, status, created_at, updated_at) VALUES (?, ?, ?, ?, ?)";
	        PreparedStatement insertStmt = connection.prepareStatement(insertQuery);
	        insertStmt.setInt(1, cart.getUser().getUser_id());
	        insertStmt.setInt(2, cart.getCourse().getCourse_id());
	        insertStmt.setString(3, cart.getStatus());
	        insertStmt.setTimestamp(4, new java.sql.Timestamp(cart.getCreated_at().getTime()));
	        insertStmt.setTimestamp(5, new java.sql.Timestamp(cart.getUpdated_at().getTime()));
	        insertStmt.executeUpdate();

	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	public Carts getCartById(int id) {
		String sql = "select * from `tb_carts` where `cart_id` = ?";
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int cart_id = rs.getInt("cart_id");
	            int user_id = rs.getInt("user_id");
	            int course_id = rs.getInt("course_id");
	            Double amount = rs.getDouble("amount");
	            String status = rs.getString("status");
	            Date created_at = rs.getDate("created_at");
	            Date updated_at = rs.getDate("updated_at");
				 
				User user = us.getUserById(user_id);
				Course course = cd.getCourseById(course_id);
				Carts cart = new Carts(cart_id, user, course, status, created_at, updated_at);
				return cart;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public List<Carts> getCartItems(int userId) {
	    List<Carts> cartItems = new ArrayList<>();
	    try {
	    	String query = "SELECT c.cart_id, c.status, c.created_at, c.updated_at, u.*, co.* " +
	                "FROM tb_carts c " +
	                "JOIN tb_user u ON c.user_id = u.user_id " +
	                "JOIN tb_course co ON c.course_id = co.course_id " +
	                "WHERE c.user_id = ? AND c.status = 'unpaid'";

	        PreparedStatement stmt = connection.prepareStatement(query);
	        stmt.setInt(1, userId);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            // Lấy thông tin User
	            User user = new User();
	            user.setUser_id(rs.getInt("u.user_id"));
	            user.setFullname(rs.getString("u.fullname"));	            

	            // Lấy thông tin Course
	            Course course = new Course();
	            course.setCourse_id(rs.getInt("co.course_id"));
	            course.setName(rs.getString("co.name"));
	            course.setPrice(rs.getDouble("price"));
	            course.setImage(rs.getString("image"));

	            // Lấy thông tin Carts
	            Carts cart = new Carts();
	            cart.setCart_id(rs.getInt("cart_id"));
	            cart.setUser(user);
	            cart.setCourse(course);
	            cart.setStatus(rs.getString("status"));
	            cart.setCreated_at(rs.getTimestamp("created_at"));
	            cart.setUpdated_at(rs.getTimestamp("updated_at"));

	            cartItems.add(cart);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return cartItems;
	}
	
	public void updateCartStatus(Carts cart) {
	    String sql = "UPDATE tb_carts SET status = ? WHERE cart_id = ?";
	    try {
	        connection = getConnection();
	        PreparedStatement ps = connection.prepareStatement(sql);
	        ps.setString(1, cart.getStatus()); // "paid"
	        ps.setInt(2, cart.getCart_id());
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	public void removeFromCart(int cartId) {
	    try { 	
	        String query = "DELETE FROM tb_carts WHERE cart_id = ?";
	        PreparedStatement stmt = connection.prepareStatement(query);
	        stmt.setInt(1, cartId);
	        stmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
