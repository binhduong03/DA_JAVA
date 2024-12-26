package controller.admin.lectures;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.Chapter;
import model.Course;
import model.Lecture;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import dal.ChapterDAO;
import dal.CourseDAO;
import dal.LectureDAO;

/**
 * Servlet implementation class UpdateLectureServlet
 */
@MultipartConfig
public class UpdateLectureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateLectureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_S = request.getParameter("id");
		String course_S = request.getParameter("course_id");
		int lecture_id = Integer.parseInt(id_S);
		int course_id = Integer.parseInt(course_S);
		CourseDAO cs = new CourseDAO();
		Course course = cs.getCourseById(course_id);
		ChapterDAO cd = new ChapterDAO();
		List<Chapter> chapter = cd.getChapterCourseById(course_id);
		LectureDAO ld =  new LectureDAO();
		Lecture lecture = ld.getLectureById(lecture_id);
		request.setAttribute("lecture", lecture);
		request.setAttribute("course", course);
		request.setAttribute("chapter", chapter);
		request.setAttribute("bodyPage", "/View/Admin/Lecture/edit-lecture.jsp");
		request.getRequestDispatcher("/View/Admin/admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_S = request.getParameter("id");
		String chapter_id = request.getParameter("chapter_id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String media_type = request.getParameter("media_type");
		String media_url_old = request.getParameter("media_url_old");
		String order = request.getParameter("order");
		String status = request.getParameter("status");
		String course_S = request.getParameter("course_id");
		int lecture_id = Integer.parseInt(id_S);
		int course_id = Integer.parseInt(course_S);
		Course course = new Course();
		course.setCourse_id(course_id);
		int Chapter_id = Integer.parseInt(chapter_id);
		int Order = Integer.parseInt(order);
		int Status = Integer.parseInt(status);
		Chapter chapter = new Chapter();
		chapter.setChapter_id(Chapter_id);
		LectureDAO ld = new LectureDAO();
		Date currentDate = new Date(System.currentTimeMillis());
		
		Part filePart = request.getPart("media_url");
        String media_url = null;
        String uploadPath = null;

        if (filePart != null && filePart.getSize() > 0) {
            // Đổi tên file với thời gian hiện tại để tránh trùng lặp
            String filename = filePart.getSubmittedFileName();
            media_url = System.currentTimeMillis() + "_" + filename;

            // Đường dẫn lưu file
            // Chỉnh sửa đường dẫn: 
            uploadPath = "C:/Users/ADMIN/eclipse-workspace/DA_JAVA/src/main/webapp/public/backend/filepath/lecture";
            //Dương: D:/eclipse-workspace/DA_JAVA/src/main/webapp/public/backend/img/user
		    //Giang: C:/Users/ADMIN/eclipse-workspace/DA_JAVA/src/main/webapp/public/backend/img/course
            
            // Đảm bảo thư mục lưu file tồn tại
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();  // Tạo thư mục nếu chưa có
            }

            // Lưu file vào thư mục đích
            filePart.write(uploadPath + File.separator + media_url);
        }else {
        	media_url = media_url_old; 
		}
       
        Lecture l = new Lecture(lecture_id, chapter, title, content, media_type, media_url, Order, Status, null, currentDate);
		ld.update(l);
		response.sendRedirect("all-lecture?id="+ course_id);
	}
}
