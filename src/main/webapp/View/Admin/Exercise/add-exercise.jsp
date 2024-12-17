<% request.setAttribute("bodyPage", "/View/Admin/Exercise/add-exercise.jsp"); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="content container-fluid">
    <div class="page-header">
        <div class="row align-items-center">
            <div class="col">
                <h3 class="page-title">Thêm mới bài tập</h3>
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="exercises.html">Bài tập</a></li>
                    <li class="breadcrumb-item active">Thêm mới bài tập</li>
                </ul>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-12">
            <div class="card">
                <div class="card-body">
                    <form action="add-exercise" method="post" enctype="multipart/form-data">
                        <div class="row">
                            <div class="col-12">
                                <h5 class="form-title"><span>Bài tập</span></h5>
                            </div>
                            <div class="col-12 col-sm-6">
                                <div class="form-group local-forms">
                                    <label>Tên bài tập <span class="login-danger">*</span></label>
                                    <input type="text" name="title" class="form-control" placeholder="Nhập tên bài tập" required>
                                </div>
                            </div>
                            
                            <div class="col-6">
                                <div class="form-group local-forms">
                                    <label>Tài liệu</label>
                                    <input type="file" name="file_path" class="form-control" placeholder="Chọn file" accept=".pdf,.doc,.docx,.ppt,.pptx,.jpg,.png">
                                </div>
                            </div>

                            <c:set value="${course }" var="c"/>
                            <div class="col-12 col-sm-6">
                                <div class="form-group local-forms">
                                    <label for="name" class="form-label">Khoá học</label>
                                    <input type="text" class="form-control" id="name" name="name" value="${c.name }" placeholder="Khoá học" readonly>
                                    <input type="hidden" class="form-control" id="course_id" name="course_id" value="${c.course_id }" placeholder="Khoá học" readonly>
                                </div>
                            </div>
                            
                            <div class="col-12 col-sm-6">
							    <div class="form-group local-forms">
							        <label>Bài giảng <span class="login-danger">*</span></label>
							        <select  class="form-control select" name="lecture_id">
							        	<option>Chọn bài giảng</option>
							           <c:forEach items="${lecture }" var="l">
							           		<option value="${l.lecture_id }">${l.title }</option>
							           </c:forEach>
							        </select>
							    </div>
							</div>
							
							

                            <div class="col-12">
                                <div class="form-group local-forms">
                                    <label>Mô tả <span class="login-danger">*</span></label>
                                    <textarea name="description" class="form-control" placeholder="Nhập nội dung" required></textarea>
                                </div>
                            </div>

                            

                            <div class="col-12">
                                <div class="form-group local-forms">
                                    <label>Hạn nộp <span class="login-danger">*</span></label>
                                    <input type="date" name="due_date" class="form-control" required>
                                </div>
                            </div>

                            <div class="col-12">
                                <div class="student-submit">
                                    <button type="submit" class="btn btn-primary">Gửi</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
