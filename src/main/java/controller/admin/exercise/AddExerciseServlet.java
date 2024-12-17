package controller.admin.exercise;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.Course;
import model.Exercise;
import model.Lecture;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import dal.CourseDAO;
import dal.ExerciseDAO;
import dal.LectureDAO;

/**
 * Servlet implementation class AddExerciseServlet
 */
@MultipartConfig
public class AddExerciseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddExerciseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_S = request.getParameter("id");
		int id = Integer.parseInt(id_S);
		LectureDAO l = new LectureDAO();
		List<Lecture> lecture = l.getLectureCourseById(id);
		CourseDAO c = new CourseDAO();
		Course course = c.getCourseById(id);
		request.setAttribute("course", course);
		request.setAttribute("lecture", lecture);
		request.setAttribute("bodyPage", "/View/Admin/Exercise/add-exercise.jsp");
		request.getRequestDispatcher("/View/Admin/admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String date = request.getParameter("due_date");
		Date due_date = java.sql.Date.valueOf(date);
		Date currentDate = new Date();
		String lectureId = request.getParameter("lecture_id");
		String courseId = request.getParameter("course_id");
		int lecture_id = Integer.parseInt(lectureId);
		int course_id = Integer.parseInt(courseId);
		
		Part file = request.getPart("file_path");
		String uploadPath = null; 
		String file_path = null;
		if (file != null && file.getSize() > 0) {

		    String filename = file.getSubmittedFileName();
		    file_path = System.currentTimeMillis() + "_" + filename;
		    uploadPath = "D:/eclipse-workspace/DA_JAVA/src/main/webapp/public/backend/img/exercise";
		    File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();  
            }
            file.write(uploadPath + File.separator + file_path);
		}
		Lecture l = new Lecture();
		l.setLecture_id(lecture_id);
		Exercise e = new Exercise(1, l, title, description, file_path, due_date, 1, currentDate, currentDate);
		ExerciseDAO ex = new ExerciseDAO();
		ex.insert(e);
		response.sendRedirect("all-exercise?id="+ course_id);
	}

}
