package controller.admin.lectures;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Chapter;
import model.Lecture;

import java.io.IOException;
import java.util.List;

import dal.ChapterDAO;
import dal.LectureDAO;

/**
 * Servlet implementation class ListLectureServlet
 */
public class ListLectureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListLectureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setAttribute("bodyPage", "/View/Admin/Lecture/all-lecture.jsp");
		String courseId = request.getParameter("id");
		int course_id = Integer.parseInt(courseId);
		LectureDAO l = new LectureDAO();
		List<Lecture> lecture = l.getLectureCourseById(course_id);
		request.setAttribute("courseId", courseId);
		request.setAttribute("lecture", lecture);
		request.getRequestDispatcher("/View/Admin/admin.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
