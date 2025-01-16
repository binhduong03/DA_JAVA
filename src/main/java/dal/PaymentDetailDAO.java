package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dal.CartDAO;
import dal.DBContext;
import dal.PaymentDAO;
import dal.UserDAO;
import model.Carts;
import model.Payment_Details;
import model.Payments;

public class PaymentDetailDAO extends DBContext{
	UserDAO us = new UserDAO();
	PaymentDAO pd = new PaymentDAO();
	CartDAO cd = new CartDAO();
	public List<Payment_Details> allPayment() {
	    List<Payment_Details> list = new ArrayList<>();
	    String sql = "SELECT * FROM `tb_payment_details` order By `detail_id` DESC ";

	    try {
	        connection = getConnection();
	        PreparedStatement p = connection.prepareStatement(sql);
	        ResultSet rs = p.executeQuery();

	        while (rs.next()) {
	            int detail_id = rs.getInt("detail_id");
	            int payment_id = rs.getInt("payment_id");
	            int cart_id = rs.getInt("cart_id");
	            Double amount = rs.getDouble("amount");
	            
	            Payments payment = pd.getPaymentById(payment_id);
	            Carts cart = cd.getCartById(cart_id);
	            
	            Payment_Details detail = new Payment_Details(detail_id, payment, cart, amount);
	            list.add(detail);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}
	
	public void insert(Payment_Details pay) {
		String sql = "INSERT INTO tb_payment_details (payment_id, cart_id, amount) VALUES (?, ?, ?)";
	    try {
	    	connection = getConnection();
	        PreparedStatement ps = connection.prepareStatement(sql);
	        
	        ps.setInt(1, pay.getPayment().getPayment_id());
	        ps.setInt(2, pay.getCart().getCart_id());
	        ps.setDouble(3, pay.getAmount());
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
