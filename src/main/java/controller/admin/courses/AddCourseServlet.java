package controller.admin.courses;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.Course;
import model.User;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import dal.CourseDAO;
import dal.UserDAO;

/**
 * Servlet implementation class AddCourseServlet
 */
@MultipartConfig
public class AddCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCourseServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDAO us = new UserDAO();
		List<User> users = us.allTeacher();
		request.setAttribute("users", users);

		request.setAttribute("bodyPage", "/View/Admin/Course/add-course.jsp");
		request.getRequestDispatcher("/View/Admin/admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CourseDAO c = new CourseDAO();
		Date currentDate = new Date(System.currentTimeMillis());
		String user_id = request.getParameter("user_id");
		String name = request.getParameter("name");
		String image = "course.jpg";
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		String duration = request.getParameter("duration");
//		String created_at = request.getParameter("created_at");
		int UserID = Integer.parseInt(user_id);
		int Duration = Integer.parseInt(duration);
		double Price = Double.parseDouble(price);
        Part imagePart = request.getPart("image");
        String uploadPath = null;

        if (imagePart != null && imagePart.getSize() > 0) {
            // Đổi tên file với thời gian hiện tại để tránh trùng lặp
            String filename = imagePart.getSubmittedFileName();
            image = System.currentTimeMillis() + "_" + filename;

            // Đường dẫn lưu file
            // Chỉnh sửa đường dẫn: 
            uploadPath = "D:/eclipse-workspace/DA_JAVA/src/main/webapp/public/backend/img/course";
            //Dương: D:/eclipse-workspace/DA_JAVA/src/main/webapp/public/backend/img/user
		    //Giang: C:/Users/ADMIN/eclipse-workspace/DA_JAVA/src/main/webapp/public/backend/img/course
            
            // Đảm bảo thư mục lưu file tồn tại
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();  // Tạo thư mục nếu chưa có
            }

            // Lưu file vào thư mục đích
            imagePart.write(uploadPath + File.separator + image);
        }
        User user = new User();
        user.setUser_id(UserID); 

		Course course =  new Course(0, user, name, image, description, Price, Duration, 1, currentDate, currentDate);
		c.insert(course);    
		response.sendRedirect("all-courses");
	}
}
