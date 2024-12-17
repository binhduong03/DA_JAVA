package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;

public class AuthDAO extends DBContext{
	public User check (String username, String password) {
		String sql = "select * from tb_user \r\n"
				+ "where username =? and password=?;";
		try {
			connection = getConnection();
			PreparedStatement p = connection.prepareStatement(sql);
			p.setString(1, username);
			p.setString(2, password);
			ResultSet rs = p.executeQuery();
			if(rs.next()) {
				User u = new User(rs.getInt("user_id"), rs.getString("fullname"), rs.getString("username"), rs.getString("password"), rs.getString("avatar"), rs.getString("phone"), rs.getString("email"), rs.getString("gender"), rs.getDate("date_of_birt"), rs.getString("address"), rs.getString("role"), rs.getInt("status"), rs.getDate("created_at"), rs.getDate("updated_at"));
				return u;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
