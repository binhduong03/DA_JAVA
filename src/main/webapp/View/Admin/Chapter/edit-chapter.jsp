<% request.setAttribute("bodyPage", "/View/Admin/Chapter/edit-chapter.jsp"); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="content container-fluid">
    <div class="page-header">
        <div class="row align-items-center">
            <div class="col">
                <h3 class="page-title">Cập nhật chương</h3>
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="teachers.html">Chương</a></li>
                    <li class="breadcrumb-item active">Cập nhật chương</li>
                </ul>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-12">
            <div class="card">
                <div class="card-body">
                	<c:set value="${chapter}" var="c"/>
                    <form action="update-chapter" method="post">
                        <div class="row">
                            <div class="col-12">
                                <h5 class="form-title"><span>Chương</span></h5>
                            </div>	
                            <!-- Trường ẩn lưu ID chương -->
                            <input type="hidden" name="chapter_id" value="${c.chapter_id}" />

                            <div class="col-12 col-sm-6">
                                <div class="form-group local-forms">
                                    <label>Tên chương <span class="login-danger">*</span></label>
                                    <input type="text" name="title" class="form-control" value="${c.title}" placeholder="Nhập tên chương" required>
                                </div>
                            </div>

                            <c:set value="${course}" var="cr"/>
                            <div class="col-12 col-sm-6">
                                <div class="form-group local-forms">
                                    <label for="price" class="form-label">Khoá học</label>
                                    <input type="text" class="form-control" id="name" name="name" value="${cr.name}" placeholder="Khoá học" readonly>
                                    <input type="hidden" class="form-control" id="course_id" name="course_id" value="${cr.course_id}" readonly>
                                </div>
                            </div>

                            <div class="col-12">
                                <div class="form-group local-forms">
                                    <label>Nội dung <span class="login-danger">*</span></label>
                                    <input type="text" name="content" class="form-control" value="${c.content}" placeholder="Nhập nội dung" required>
                                </div>
                            </div>

                            <div class="col-12">
                                <div class="student-submit">
                                    <button type="submit" class="btn btn-primary">Cập nhật</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
