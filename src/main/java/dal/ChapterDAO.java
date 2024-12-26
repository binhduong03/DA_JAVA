package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Chapter;
import model.Course;
import model.Lecture;


public class ChapterDAO extends DBContext{
	CourseDAO cr = new CourseDAO();
	public List<Chapter> allChapter(){
		List<Chapter> list = new ArrayList<>();
		String sql = "select * from `tb_chapters` order By `chapter_id` DESC ";
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int chapter_id = rs.getInt("chapter_id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int course_id = rs.getInt("course_id");
				Date created_at = rs.getDate("created_at");
				Date updated_at = rs.getDate("updated_at");
				Course course = cr.getCourseById(course_id);
				Chapter chapter = new Chapter(chapter_id, title, content, course, created_at, updated_at);
				list.add(chapter);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Chapter getChapterById(int id) {
		String sql = "select * from `tb_chapters` where `chapter_id` = ?";
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int chapter_id = rs.getInt("chapter_id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int course_id = rs.getInt("course_id");
				Date created_at = rs.getDate("created_at");
				Date updated_at = rs.getDate("updated_at");
				
				Course course = cr.getCourseById(course_id);
				Chapter chapter = new Chapter(chapter_id, title, content, course, created_at, updated_at);
				return chapter;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void insert(Chapter c) {
	   
	    String sql = "INSERT INTO `tb_chapters` " +
	                 "(`title`, `content`, `course_id`, `created_at`, `updated_at`) " +
	                 "VALUES (?, ?, ?, ?, ?)";

	    try {
	    	connection = getConnection(); 
	        PreparedStatement ps = connection.prepareStatement(sql);
	        ps.setString(1, c.getTitle());    
	        ps.setString(2, c.getContent());  
	        ps.setInt(3, c.getCourse().getCourse_id()); 
	        ps.setDate(4, new java.sql.Date(c.getCreated_at().getTime()));
	        ps.setDate(5, new java.sql.Date(c.getUpdated_at().getTime()));
	        ps.executeUpdate();
	       
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void update(Chapter c) {
		String sql = "UPDATE `tb_chapters`\r\n"
				+ "SET\r\n"
				+ "`title` = ?,\r\n"
				+ "`content` = ?,\r\n"
				+ "`course_id` = ?,\r\n"
				+ "`updated_at` = ?\r\n"
				+ "WHERE `chapter_id` = ?;\r\n"
				+ "";
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, c.getTitle());
			ps.setString(2, c.getContent());
			ps.setInt(3, c.getCourse().getCourse_id());
			ps.setDate(4, new java.sql.Date(c.getUpdated_at().getTime()));
			ps.setInt(5, c.getChapter_id());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		String sql = "delete from `tb_chapters` \r\n"
					+"where `chapter_id` =?;";
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Chapter> getChapterCourseById(int courseId){
		List<Chapter> chapters = new ArrayList<>();
		String sql = "SELECT * FROM tb_chapters WHERE course_id = ?";
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, courseId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int chapter_id = rs.getInt("chapter_id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Date created_at = rs.getDate("created_at");
				Date updated_at = rs.getDate("updated_at");
				
				CourseDAO c = new CourseDAO();
				Course course = c.getCourseById(courseId);
				//Tạo đối tượng chương
				Chapter chapter = new Chapter(chapter_id, title, content, course, created_at, updated_at);
				chapters.add(chapter);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chapters;
	}
}
