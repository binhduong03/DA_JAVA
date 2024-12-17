package controller.admin.chapter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Chapter;
import model.Course;

import java.io.IOException;
import java.util.Date;

import dal.ChapterDAO;
import dal.CourseDAO;

/**
 * Servlet implementation class AddChapterServlet
 */
public class AddChapterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddChapterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_S = request.getParameter("id");
		int id = Integer.parseInt(id_S);
		CourseDAO c = new CourseDAO();
		Course course = c.getCourseById(id);
		request.setAttribute("course", course);
		request.setAttribute("bodyPage", "/View/Admin/Chapter/add-chapter.jsp");
		request.getRequestDispatcher("/View/Admin/admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String id_S = request.getParameter("course_id");
		int course_id = Integer.parseInt(id_S);
		Course course = new Course();
		course.setCourse_id(course_id);
		ChapterDAO c = new ChapterDAO();
		Date currentDate = new Date(System.currentTimeMillis());
		Chapter ct = new Chapter(1, title, content, course, currentDate, currentDate);
		c.insert(ct);
		response.sendRedirect("all-chapter?id="+course_id);
	}

}
