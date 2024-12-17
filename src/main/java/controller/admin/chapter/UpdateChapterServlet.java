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
 * Servlet implementation class UpdateChapterServlet
 */
public class UpdateChapterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateChapterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_S = request.getParameter("id");
		String course_S = request.getParameter("course_id");
		int course_id = Integer.parseInt(course_S);
		int chapter_id = Integer.parseInt(id_S);
		ChapterDAO c = new ChapterDAO();
		CourseDAO cs = new CourseDAO();
		Course course = cs.getCourseById(course_id);
		Chapter chapter = c.getChapterById(chapter_id);
		request.setAttribute("course", course);
		request.setAttribute("chapter", chapter);
		request.setAttribute("bodyPage", "/View/Admin/Chapter/edit-chapter.jsp");
		request.getRequestDispatcher("/View/Admin/admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_S = request.getParameter("chapter_id");
		String title = request.getParameter("title");
		String courseId = request.getParameter("course_id");
		String content = request.getParameter("content");
		Date currentDate = new Date();
		int chapter_id = Integer.parseInt(id_S);
		int course_id = Integer.parseInt(courseId);
		
		CourseDAO c = new CourseDAO();
		Course course = new Course();
		course.setCourse_id(course_id);
		
		ChapterDAO ct = new ChapterDAO();
		Chapter chapter = new Chapter(chapter_id, title, content, course, null, currentDate);
		ct.update(chapter);
		response.sendRedirect("all-chapter?id="+ course_id);
		
	}

}
