package controller.pages;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Chapter;
import model.Course;
import model.Exercise;
import model.Lecture;

import java.io.IOException;
import java.util.List;

import dal.ChapterDAO;
import dal.CourseDAO;
import dal.ExerciseDAO;
import dal.LectureDAO;

/**
 * Servlet implementation class CourseDetailServlet
 */
public class CourseDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CourseDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("welcome", "/View/Pages/Course/course-detail.jsp");
		String courseId = request.getParameter("id");
		int course_id = Integer.parseInt(courseId);
		CourseDAO cd = new CourseDAO();
		Course course = cd.getCourseById(course_id);
		ExerciseDAO e = new ExerciseDAO();
		List<Exercise> exercise = e.getExerciseCourseById(course_id);
		LectureDAO l = new LectureDAO();
		List<Lecture> lecture = l.getLectureCourseById(course_id);
		ChapterDAO c = new ChapterDAO();
		List<Chapter> chapter = c.getChapterCourseById(course_id);
		request.setAttribute("chapter", chapter);
		request.setAttribute("lecture", lecture);
		System.out.println(course);
		request.setAttribute("course", course);
		request.setAttribute("exercise", exercise);
		System.out.println(exercise);
		
		request.getRequestDispatcher("/View/Pages/welcome.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
