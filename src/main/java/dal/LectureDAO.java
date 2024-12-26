package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Chapter;
import model.Lecture;

public class LectureDAO extends DBContext{
	CourseDAO cr = new CourseDAO();
	ChapterDAO cd = new ChapterDAO();
	public List<Lecture> allLecture(){
		List<Lecture> list = new ArrayList<>();
		String sql = "select * from `tb_lectures` order By `lecture_id` DESC ";
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int lecture_id = rs.getInt("lecture_id");
				int chapter_id = rs.getInt("chapter_id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String media_type = rs.getString("media_type");
				String media_url = rs.getString("media_url");
				int order = rs.getInt("order");
				int status = rs.getInt("status");
				Date created_at = rs.getDate("created_at");
				Date updated_at = rs.getDate("updated_at");
				Chapter chapter = cd.getChapterById(chapter_id);
				Lecture lecture = new Lecture(lecture_id, chapter, title, content, media_type, media_url, order, status, created_at, updated_at);
				list.add(lecture);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void insert(Lecture l) {
	    String sql = "INSERT INTO `tb_lectures` " +
	                 "(`chapter_id`,`title`, `content`,`media_type`, `media_url`, `order`, `status`, `created_at`, `updated_at`) " +
	                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    try {
	    	connection = getConnection(); 
	        PreparedStatement ps = connection.prepareStatement(sql);
	        ps.setInt(1, l.getChapter().getChapter_id());    
	        ps.setString(2, l.getTitle()); 
	        ps.setString(3, l.getContent());
	        ps.setString(4, l.getMedia_type());
	        ps.setString(5, l.getMedia_url());
	        ps.setInt(6, l.getOrder());
	        ps.setInt(7, l.getStatus());
	        ps.setDate(8, new java.sql.Date(l.getCreated_at().getTime()));
	        ps.setDate(9, new java.sql.Date(l.getUpdated_at().getTime()));
	        ps.executeUpdate();
	       
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void update(Lecture l) {
		String sql = "UPDATE `tb_lectures`\r\n"
				+ "SET\r\n"
				+ "`chapter_id` = ?,\r\n"
				+ "`title` = ?,\r\n"
				+ "`content` = ?,\r\n"
				+ "`media_type` = ?,\r\n"
				+ "`media_url` = ?,\r\n"
				+ "`order` = ?,\r\n"
				+ "`status` = ?,\r\n"
				+ "`updated_at` = ?\r\n"
				+ "WHERE `lecture_id` = ?;\r\n";
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			 	ps.setInt(1, l.getChapter().getChapter_id());    
		        ps.setString(2, l.getTitle()); 
		        ps.setString(3, l.getContent());
		        ps.setString(4, l.getMedia_type());
		        ps.setString(5, l.getMedia_url());
		        ps.setInt(6, l.getOrder());
		        ps.setInt(7, l.getStatus());
		        ps.setDate(8, new java.sql.Date(l.getUpdated_at().getTime()));
		        ps.setInt(9, l.getLecture_id());
		        ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		String sql = "delete from `tb_lectures` \r\n"
					+"where `lecture_id` =?;";
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Lecture getLectureById(int id) {
		String sql = "select * from `tb_lectures` where `lecture_id` = ?";
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int lecture_id = rs.getInt("lecture_id");
				int chapter_id = rs.getInt("chapter_id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String media_type = rs.getString("media_type");
				String media_url = rs.getString("media_url");
				int order = rs.getInt("order");
				int status = rs.getInt("status");
				Date created_at = rs.getDate("created_at");
				Date updated_at = rs.getDate("updated_at");
				Chapter chapter = cd.getChapterById(chapter_id);
				Lecture lecture = new Lecture(lecture_id, chapter, title, content, media_type, media_url, order, status, created_at, updated_at);
				return lecture;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Lecture> getLectureCourseById(int course_id){
		List<Lecture> lectures = new ArrayList<>();
		String sql = "SELECT l.lecture_id, " +
	             "l.chapter_id, " +
	             "l.title, " +
	             "l.content, " +
	             "l.media_type, " +
	             "l.media_url, " +
	             "l.order, " +
	             "l.status, " +
	             "l.created_at, " +
	             "l.updated_at " + 
	             "FROM tb_lectures l " +
	             "LEFT JOIN tb_chapters c ON l.chapter_id = c.chapter_id " +
	             "WHERE c.course_id = ?";
		try {
			connection = getConnection();
			PreparedStatement p = connection.prepareStatement(sql);
			p.setInt(1, course_id);
			ResultSet rs = p.executeQuery();
			while(rs.next()) {
				int lecture_id = rs.getInt("lecture_id");
				int chapter_id = rs.getInt("chapter_id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String media_type = rs.getString("media_type");
				String media_url = rs.getString("media_url");
				int order = rs.getInt("order");
				int status = rs.getInt("status");
				Date created_at = rs.getDate("created_at");
				Date updated_at = rs.getDate("updated_at");
				ChapterDAO c = new ChapterDAO();
				Chapter chapter = c.getChapterById(chapter_id);
				Lecture lecture = new Lecture(lecture_id, chapter, title, content, media_type, media_url, order, status, created_at, updated_at);
				lectures.add(lecture);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lectures;
	}
	
	public List<Lecture> getLectureChapterbyId(int chapter_id){
		List<Lecture> lectures = new ArrayList<>();
		String sql = "SELECT l.lecture_id, " +
	             "l.chapter_id, " +
	             "l.title, " +
	             "l.content, " +
	             "l.media_type, " +
	             "l.media_url, " +
	             "l.order, " +
	             "l.status, " +
	             "l.created_at, " +
	             "l.updated_at " + 
	             "FROM tb_lectures l " +
	             "LEFT JOIN tb_chapters c ON l.chapter_id = c.chapter_id " +
	             "WHERE l.chapter_id = ?";
		try {
			connection = getConnection();
			PreparedStatement p = connection.prepareStatement(sql);
			p.setInt(1, chapter_id);
			ResultSet rs = p.executeQuery();
			while(rs.next()) {
				int lecture_id = rs.getInt("lecture_id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String media_type = rs.getString("media_type");
				String media_url = rs.getString("media_url");
				int order = rs.getInt("order");
				int status = rs.getInt("status");
				Date created_at = rs.getDate("created_at");
				Date updated_at = rs.getDate("updated_at");
				ChapterDAO c = new ChapterDAO();
				Chapter chapter = c.getChapterById(chapter_id);
				Lecture lecture = new Lecture(lecture_id, chapter, title, content, media_type, media_url, order, status, created_at, updated_at);
				lectures.add(lecture);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lectures;
	}
}
