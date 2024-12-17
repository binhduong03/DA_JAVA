package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBContext {
	protected static Connection connection;
	
	public static Connection getConnection() throws SQLException {
		String db = "jdbc:mysql://localhost:3306/dajava";
		String userName = "root";
		String passWord = "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(db,userName,passWord);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void main(String[] args) {
		try {
			if(getConnection() != null) {
				System.out.println("Kết nối thành công");
			} else 
				System.out.println("Kết nối thất bại");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
