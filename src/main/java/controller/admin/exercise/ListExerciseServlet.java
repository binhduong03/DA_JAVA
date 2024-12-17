package controller.admin.exercise;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Exercise;

import java.io.IOException;
import java.util.List;

import dal.ExerciseDAO;

/**
 * Servlet implementation class ListExerciseServlet
 */
public class ListExerciseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListExerciseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("bodyPage", "/View/Admin/Exercise/all-exercise.jsp");
		String courseId = request.getParameter("id");
		int course_id = Integer.parseInt(courseId);
		System.out.println(course_id);
		ExerciseDAO e = new ExerciseDAO();
		List<Exercise> exercise = e.getExerciseCourseById(course_id);
		request.setAttribute("courseId", courseId);
		request.setAttribute("exercise", exercise);
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
