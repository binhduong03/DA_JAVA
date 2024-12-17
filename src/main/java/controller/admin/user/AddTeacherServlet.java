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
import java.nio.file.Paths;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

import dal.UserDAO;

/**
 * Servlet implementation class AddTeacherServlet
 */
@MultipartConfig
public class AddTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("bodyPage", "/View/Admin/User/add-teacher.jsp");
		request.getRequestDispatcher("/View/Admin/admin.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDAO us = new UserDAO();
		Date currentDate = new Date(System.currentTimeMillis());
		String fullname = request.getParameter("fullname");
		String gender = request.getParameter("gender");
		String date_of_birt = request.getParameter("date_of_birt");
		String phone = request.getParameter("phone");
		String created_at = request.getParameter("created_at");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String role = request.getParameter("role");
		java.sql.Date birthDate = java.sql.Date.valueOf(date_of_birt);
        
        String avatar = "teacher.jpg"; 
        Part avatarPart = request.getPart("avatar");
        String uploadPath = null;
        
        if (avatarPart != null && avatarPart.getSize() > 0) {
            // Đổi tên file với thời gian hiện tại để tránh trùng lặp
            String filename = avatarPart.getSubmittedFileName();
            avatar = System.currentTimeMillis() + "_" + filename;

            // Đường dẫn lưu file
            // Chỉnh sửa đường dẫn: 
            uploadPath = "D:/eclipse-workspace/DA_JAVA/src/main/webapp/public/backend/img/user";

            
            // Đảm bảo thư mục lưu file tồn tại
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();  // Tạo thư mục nếu chưa có
            }

            // Lưu file vào thư mục đích
            avatarPart.write(uploadPath + File.separator + avatar);
        }
		
		User user =  new User(0, fullname, username, password, avatar, phone, email, gender, birthDate, address, role, 1, currentDate, currentDate);
		us.insert(user);    
		response.sendRedirect("all-teacher");
	}
}
