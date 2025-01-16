package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Course;
import model.Payments;
import model.User;

public class PaymentDAO extends DBContext{
	UserDAO us = new UserDAO();
	public List<Payments> allPayment() {
	    List<Payments> list = new ArrayList<>();
	    String sql = "SELECT * FROM `tb_payments` order By `payment_id` DESC ";

	    try {
	        connection = getConnection();
	        PreparedStatement p = connection.prepareStatement(sql);
	        ResultSet rs = p.executeQuery();

	        while (rs.next()) {
	            int payment_id = rs.getInt("payment_id");
	            int user_id = rs.getInt("user_id");
	            Double amount = rs.getDouble("amount");
	            String payment_method = rs.getString("payment_method");
	            int payment_status = rs.getInt("payment_status");
	            Date payment_date = rs.getDate("payment_date");

	            User user = us.getUserById(user_id);

	            Payments payment = new Payments(payment_id, user, amount, payment_method, payment_status, payment_date);
	            list.add(payment);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}
	
	public Payments getPaymentById(int id) {
		String sql = "select * from `tb_payments` where `payment_id` = ?";
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int payment_id = rs.getInt("payment_id");
	            int user_id = rs.getInt("user_id");
	            Double amount = rs.getDouble("amount");
	            String payment_method = rs.getString("payment_method");
	            int payment_status = rs.getInt("payment_status");
	            Date payment_date = rs.getDate("payment_date");
				 
				User user = us.getUserById(user_id);
				
				Payments payment = new Payments(payment_id, user, amount, payment_method, payment_status, payment_date);
				return payment;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public void insert(Payments p) {
		String sql = "INSERT INTO tb_payments (user_id, amount, payment_method, payment_status, payment_date) VALUES (?, ?, ?, ?, ?)";
	    try {
	    	connection = getConnection();
	    	PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
	        
	        ps.setInt(1, p.getUser().getUser_id());
	        ps.setDouble(2, p.getAmount());
	        ps.setString(3, p.getPayment_method());
	        ps.setInt(4, p.getPayment_status());
	        ps.setDate(5, new java.sql.Date(p.getPayment_date().getTime()));
	        
	        // Thực thi câu lệnh INSERT
	        ps.executeUpdate();

	        // Lấy giá trị của khóa tự động sinh (payment_id)
	        ResultSet rs = ps.getGeneratedKeys();
	        if (rs.next()) {
	            int paymentId = rs.getInt(1); // Cột đầu tiên chứa khóa tự động sinh
	            p.setPayment_id(paymentId);   // Gán payment_id vào đối tượng Payments
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
