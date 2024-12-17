package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Course;
import model.Lecture;
import model.LectureProgress;
import model.User;

public class LectureProgressDAO extends DBContext {
    LectureDAO lectureDAO = new LectureDAO();
    UserDAO userDAO = new UserDAO();

    public List<LectureProgress> getLectureProgressByCourseAndUser(int course_id, int user_id) {
        List<LectureProgress> lectureProgressList = new ArrayList<>();

        try {
            // Gọi phương thức từ LectureDAO để lấy danh sách bài giảng
            List<Lecture> lectures = lectureDAO.getLectureCourseById(course_id);

            // Bước 2: Lấy tiến độ bài giảng dựa trên user_id
            String progressSql = "SELECT lp.lecture_progress_id, lp.progress, lp.status, lp.created_at, lp.updated_at " +
                                 "FROM tb_lecture_progress lp " +
                                 "WHERE lp.lecture_id = ? AND lp.user_id = ?;";
            PreparedStatement ps = connection.prepareStatement(progressSql);

            for (Lecture lecture : lectures) {
            	ps.setInt(1, lecture.getLecture_id());
            	ps.setInt(2, user_id);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    // Nếu có tiến độ, tạo LectureProgress
                    int lectureProgressId = rs.getInt("lecture_progress_id");
                    float progress = rs.getFloat("progress");
                    int status = rs.getInt("status");
                    Date createdAt = rs.getDate("created_at");
                    Date updatedAt = rs.getDate("updated_at");

                    // Tạo Use
                    User user = userDAO.getUserById(user_id);

                    // Tạo LectureProgress
                    LectureProgress lp = new LectureProgress(lectureProgressId, user, lecture, progress, status, createdAt, updatedAt);

                    lectureProgressList.add(lp);
                } else {
                    // Nếu không có tiến độ, tạo LectureProgress mặc định
                    LectureProgress lp = new LectureProgress();
                    User user = userDAO.getUserById(user_id);
                    lp.setLecture(lecture);
                    lp.setUser(user);
                    lp.setProgress(0);
                    lp.setStatus(0); 
                    lectureProgressList.add(lp);
                }
                rs.close();
            }
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        } 
        return lectureProgressList;
    }
    
//    public static void main(String[] args) {
//        LectureProgressDAO lpDAO = new LectureProgressDAO();
//        List<LectureProgress> lectureProgressList = lpDAO.getLectureProgressByCourseAndUser(2, 12);
//        // In ra dữ liệu
//        for (LectureProgress lp : lectureProgressList) {
//            System.out.println("Lecture Title: " + lp.getLecture().getTitle());
//            System.out.println("User Progress: " + lp.getProgress());
//            System.out.println("User Name: " + lp.getUser().getFullname());
//            System.out.println("Status: " + lp.getStatus());
//            System.out.println("Created At: " + lp.getCreated_at());
//            System.out.println("Updated At: " + lp.getUpdated_at());
//            System.out.println("---------------------------------");
//        }
//    }

}
