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
import java.util.Date;
import java.util.List;

import dal.CourseDAO;
import dal.ExerciseDAO;
import dal.LectureDAO;

/**
 * Servlet implementation class UpdateExerciseServlet
 */
@MultipartConfig
public class UpdateExerciseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateExerciseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_S = request.getParameter("id");
		int id = Integer.parseInt(id_S);
		String courseId = request.getParameter("course_id");
		int course_id = Integer.parseInt(courseId);
		LectureDAO l = new LectureDAO();
		List<Lecture> lecture = l.getLectureCourseById(course_id);
		ExerciseDAO e = new ExerciseDAO();
		Exercise exercise = e.getExerciseById(id);
		CourseDAO c = new CourseDAO();
		Course course = c.getCourseById(course_id);
		request.setAttribute("course", course);
		request.setAttribute("lecture", lecture);
		request.setAttribute("exercise", exercise);
		request.setAttribute("bodyPage", "/View/Admin/Exercise/edit-exercise.jsp");
		request.getRequestDispatcher("/View/Admin/admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_S = request.getParameter("exercise_id");
		int exercise_id = Integer.parseInt(id_S);
		String courseId = request.getParameter("course_id");
		int course_id = Integer.parseInt(courseId);
		String title = request.getParameter("title");
		String lectureId = request.getParameter("lecture_id");
		String date = request.getParameter("due_date");
		Date due_date = java.sql.Date.valueOf(date);
		Date currentDate = new Date();
		int lecture_id = Integer.parseInt(lectureId);
		String description = request.getParameter("description");
		String status = request.getParameter("status");
		int statusBoolean = "1".equals(status) ? 1 : 0;
		Part file = request.getPart("file_path");
		String oldFilePath = request.getParameter("old_file_path"); // Lấy file cũ từ form
		String uploadPath = oldFilePath; 

		if (file != null && file.getSize() > 0) {
		    String filename = file.getSubmittedFileName();
		    String newFileName = System.currentTimeMillis() + "_" + filename;
		    String fileUploadDir = "D:/eclipse-workspace/DA_JAVA/src/main/webapp/public/backend/img/exercise";

		    File uploadDir = new File(fileUploadDir);
		    if (!uploadDir.exists()) {
		        uploadDir.mkdirs();
		    }
		    file.write(fileUploadDir + File.separator + newFileName);
		    uploadPath = fileUploadDir + File.separator + newFileName;
		}
		Lecture lecture = new Lecture();
		lecture.setLecture_id(lecture_id);
		ExerciseDAO ex = new ExerciseDAO();
		Exercise exercise = new Exercise(exercise_id, lecture, title, description, uploadPath, due_date, statusBoolean, currentDate, currentDate);
		ex.update(exercise);
		response.sendRedirect("all-exercise?id=" + course_id);
		
	}

}
