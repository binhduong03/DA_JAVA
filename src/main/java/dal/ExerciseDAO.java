package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Exercise;
import model.Lecture;

public class ExerciseDAO extends DBContext {
	LectureDAO l = new LectureDAO();
	ChapterDAO c = new ChapterDAO();
	public List<Exercise> allExercise(){
		List<Exercise> list = new ArrayList<>();
		String sql = "select * from `tb_exercises` order By `exercises_id` DESC";
		try {
			connection = getConnection();
			PreparedStatement p = connection.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while(rs.next()) {
				int exercises_id = rs.getInt("exercises_id");
				int lecture_id = rs.getInt("lecture_id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				String file_path = rs.getString("file_path");
				Date due_date = rs.getDate("due_date");
				int status = rs.getInt("status");
				Date created_at = rs.getDate("created_at");
				Date updated_at = rs.getDate("updated_at");
				Lecture lecture = l.getLectureById(lecture_id);
				Exercise e = new Exercise(exercises_id, lecture, title, description, file_path, due_date, status, created_at, updated_at);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public Exercise getExerciseById(int id) {
		String sql = "select * from `tb_exercises` where `exercises_id` = ?";
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int exercises_id = rs.getInt("exercises_id");
				int lecture_id = rs.getInt("lecture_id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				String file_path = rs.getString("file_path");
				Date due_date = rs.getDate("due_date");
				int status = rs.getInt("status");
				Date created_at = rs.getDate("created_at");
				Date updated_at = rs.getDate("updated_at");
				Lecture lecture = l.getLectureById(lecture_id);
				Exercise exercise = new Exercise(exercises_id, lecture, title, description, file_path, due_date, status, created_at, updated_at);
				return exercise;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Exercise> getExerciseCourseById(int course_id){
		List<Exercise> exercise = new ArrayList<>();
		String sql = "SELECT e.exercises_id, " +
                "       e.lecture_id, " +
                "       e.title, " +
                "       e.description, " +
                "       e.file_path, " +
                "       e.due_date, " +
                "       e.status, " +
                "       e.created_at, " +
                "       e.updated_at " +
                "FROM tb_exercises e " +
                "JOIN tb_lectures l ON e.lecture_id = l.lecture_id " +
                "JOIN tb_chapters c ON l.chapter_id = c.chapter_id " +
                "WHERE c.course_id = ?";
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, course_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int exercises_id = rs.getInt("exercises_id");
				int lecture_id = rs.getInt("lecture_id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				String file_path = rs.getString("file_path");
				Date due_date = rs.getDate("due_date");
				int status = rs.getInt("status");
				Date created_at = rs.getDate("created_at");
				Date updated_at = rs.getDate("updated_at");
				Lecture lecture = l.getLectureById(lecture_id);
				Exercise exercise2 = new Exercise(exercises_id, lecture, title, description, file_path, due_date, status, created_at, updated_at);
				exercise.add(exercise2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exercise;
	}
	
	public void insert(Exercise ex) {
		String sql = "INSERT INTO `tb_exercises` "
		           + "(`lecture_id`, `title`, `description`, "
		           + "`file_path`, `due_date`, `status`, `created_at`, `updated_at`) "
		           + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, ex.getLecture().getLecture_id());
			ps.setString(2, ex.getTitle());
			ps.setString(3, ex.getDescription());
			ps.setString(4, ex.getFile_path());
			ps.setDate(5, new java.sql.Date(ex.getDue_date().getTime()));
			ps.setInt(6, ex.getStatus());
			ps.setDate(7, new java.sql.Date(ex.getCreated_at().getTime()));
	        ps.setDate(8, new java.sql.Date(ex.getUpdated_at().getTime()));
	        ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Exercise ex) {
		String sql = "UPDATE `tb_exercises`\r\n"
				+ "SET\r\n"
				+ "`lecture_id` = ?,\r\n"
				+ "`title` = ?,\r\n"
				+ "`description` = ?,\r\n"
				+ "`file_path` = ?,\r\n"
				+ "`due_date` = ?,\r\n"
				+ "`status` = ?,\r\n"
				+ "`updated_at` = ?\r\n"
				+ "WHERE `exercises_id` = ?;";
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, ex.getLecture().getLecture_id());
			ps.setString(2, ex.getTitle());
			ps.setString(3, ex.getDescription());
			ps.setString(4, ex.getFile_path());
			ps.setDate(5, new java.sql.Date(ex.getDue_date().getTime()));
			ps.setInt(6, ex.getStatus());
			ps.setDate(7, new java.sql.Date(ex.getUpdated_at().getTime()));
			ps.setInt(8, ex.getExercises_id());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		String sql = "delete from `tb_exercises` \r\n"
					+"where `exercises_id` =?;";
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
