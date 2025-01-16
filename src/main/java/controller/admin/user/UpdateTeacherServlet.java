package controller.admin.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.User;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import dal.UserDAO;

/**
 * Servlet implementation class UpdateTeacherServlet
 */
@MultipartConfig
public class UpdateTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTeacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id_s = request.getParameter("id");
		int id = Integer.parseInt(id_s);
		UserDAO us = new UserDAO();
		User u = us.getUserById(id);
		request.setAttribute("user", u);
		request.setAttribute("bodyPage", "/View/Admin/User/edit-teacher.jsp");
		request.getRequestDispatcher("/View/Admin/admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO us = new UserDAO();
		Date currentDate = new Date(System.currentTimeMillis());
		String id_s = request.getParameter("id");
		
		String fullname = request.getParameter("fullname");
		String gender = request.getParameter("gender");
		String date_of_birt = request.getParameter("date_of_birt");
		String aavatar = request.getParameter("aavatar");
		String phone = request.getParameter("phone");
		String created_at = request.getParameter("created_at");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String balance = "0.0";
		String role = request.getParameter("role");
		java.sql.Date birthDate = java.sql.Date.valueOf(date_of_birt);
		String status = request.getParameter("status");
		int statusBoolean = "1".equals(status) ? 1 : 0;
		int id = Integer.parseInt(id_s);
		Double Balance = Double.parseDouble(balance);
		Part avatarPart = request.getPart("avatar");
		String avatar = null;
		String uploadPath = null;

		if (avatarPart != null && avatarPart.getSize() > 0) {
		    String filename = avatarPart.getSubmittedFileName();
		    avatar = System.currentTimeMillis() + "_" + filename;

		    // Đường dẫn lưu file
		    uploadPath = "D:/eclipse-workspace/DA_JAVA/src/main/webapp/public/backend/img/user";

		    // Đảm bảo thư mục lưu file tồn tại
		    File uploadDir = new File(uploadPath);
		    if (!uploadDir.exists()) {
		        uploadDir.mkdirs();  // Tạo thư mục nếu chưa có
		    }

		    // Lưu file vào thư mục đích
		    avatarPart.write(uploadPath + File.separator + avatar);
		} else {
		    avatar = aavatar; 
		}
		
		User u = new User(id, fullname, username, password, avatar, phone, email, gender, birthDate, address, Balance, role, statusBoolean, currentDate, currentDate);
		us.update(u);
		response.sendRedirect("all-teacher");
	}

}
