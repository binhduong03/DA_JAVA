<% request.setAttribute("bodyPage", "/View/Admin/Exercise/edit-exercise.jsp"); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="content container-fluid">
    <div class="page-header">
        <div class="row align-items-center">
            <div class="col">
                <h3 class="page-title">Sửa bài tập</h3>
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="exercises.html">Bài tập</a></li>
                    <li class="breadcrumb-item active">Sửa bài tập</li>
                </ul>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-12">
            <div class="card">
                <div class="card-body">
                    <form action="update-exercise" method="post" enctype="multipart/form-data">
                    	<c:set value="${exercise }" var="e"/>
                        <div class="row">
                            <div class="col-12">
                                <h5 class="form-title"><span>Bài tập</span></h5>
                            </div>
                            <input type="hidden" name="exercise_id" value="${e.exercises_id }">
                            <div class="col-12 col-sm-6">
                                <div class="form-group local-forms">
                                    <label>Tên bài tập <span class="login-danger">*</span></label>
                                    <input type="text" value="${e.title }" name="title" class="form-control" placeholder="Nhập tên bài tập" >
                                </div>
                            </div>
                            
                            <div class="col-6">
                                <div class="form-group local-forms">
                                    <label>Tài liệu</label>
                                    <input type="file" name="file_path" class="form-control" placeholder="Chọn file" accept=".pdf,.doc,.docx,.ppt,.pptx,.jpg,.png">
                                    <input type="hidden" value="${e.file_path }" name="old_file_path" class="form-control" >
                                </div>
                            </div>

                            <c:set value="${course}" var="c"/>
                            <div class="col-12 col-sm-6">
                                <div class="form-group local-forms">
                                    <label for="name" class="form-label">Khoá học</label>
                                    <input type="text" class="form-control" id="name" name="name" value="${c.name }" placeholder="Khoá học" readonly>
                                    <input type="hidden" name="course_id" value="${c.course_id }">
                                </div>
                            </div>
                            
                            <div class="col-12 col-sm-6">
							    <div class="form-group local-forms">
							        <label>Bài giảng <span class="login-danger">*</span></label>
							        <select class="form-control select" name="lecture_id" required>
							            <option value="">Chọn bài giảng</option>
							            <c:forEach items="${lecture }" var="l">
							                <option value="${l.lecture_id }" ${e.lecture.lecture_id == l.lecture_id ? 'selected' : '' }>
							                    ${l.title }
							                </option>
							            </c:forEach>
							        </select>
							    </div>
							</div>

							

                            <div class="col-12">
                                <div class="form-group local-forms">
                                    <label>Mô tả <span class="login-danger">*</span></label>
                                    <textarea name="description" class="form-control" placeholder="Nhập nội dung" required>${e.description }</textarea>
                                    
                                </div>
                            </div>

                            

                            <div class="col-12">
                                <div class="form-group local-forms">
                                    <label>Hạn nộp <span class="login-danger">*</span></label>
                                    <input value="${e.due_date }" type="date" name="due_date" class="form-control" required>
                                </div>
                            </div>
                            
                            <div class="col-sm-12">
								<div class="form-check custom-checkbox mb-3 checkbox-success">
									<input type="checkbox" name="status" value="1" class="form-check-input" ${e.status == 1 ? 'checked' : '' }>
									<input type="hidden" name="status" value="0" class="form-check-input">
			            			<label class="form-check-label">Hoạt động</label>
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
