<% request.setAttribute("bodyPage", "/View/Admin/Chapter/add-chapter.jsp"); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="content container-fluid">
    <div class="page-header">
        <div class="row align-items-center">
            <div class="col">
                <h3 class="page-title">Thêm mới bài giảng</h3>
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="teachers.html">Bài giảng</a></li>
                    <li class="breadcrumb-item active">Thêm mới bài giảng</li>
                </ul>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-12">
            <div class="card">
                <div class="card-body">
               	 <c:set value="${lecture }" var="l"/>
                    <form action="update-lecture" method="post" enctype="multipart/form-data">
                        <div class="row">
                            <div class="col-12">
                            	<input type="hidden" name="id" value="${l.lecture_id}">
                                <h5 class="form-title"><span>Bài giảng</span></h5>
                            </div>
							<div class="col-12 col-sm-6">
							    <div class="form-group local-forms">
							        <label>Chương <span class="login-danger">*</span></label>
							        <select class="form-control select" name="chapter_id">
							            <option value="${lecture.chapter.chapter_id}">${lecture.chapter.title}</option>
							            <c:forEach items="${chapter}" var="chapterItem">
							                <option value="${chapterItem.chapter_id}">${chapterItem.title}</option>
							            </c:forEach>
							        </select>
							    </div>
							</div>

                            <c:set value="${course }" var="c"/>
                            <div class="col-12 col-sm-6">
                                <div class="form-group local-forms">				          
					                <label for="price" class="form-label">Khoá học</label>
					                <input type="text" class="form-control" id="name" name="name" value="${c.name }" placeholder="Khoá học" readonly>
					                <input type="hidden" class="form-control" id="course_id" name="course_id" value="${c.course_id }" placeholder="Khoá học" readonly>
				                </div>
				            </div>                     
                            <div class="col-12 col-sm-6">
                                <div class="form-group local-forms">
                                    <label>Tên bài giảng <span class="login-danger">*</span></label>
                                    <input type="text" name="title" class="form-control" value="${l.title }" placeholder="Nhập tên bài giảng" required>
                                </div>
                            </div>   
                            <div class="col-12">
                                <div class="form-group local-forms">
                                    <label>Nội dung <span class="login-danger">*</span></label>
                                    <input type="text" name="content" class="form-control" value="${l.content }" placeholder="Nhập nội dung" required>
                                </div>
                            </div>  
                            <div class="col-12 col-sm-6">
							    <div class="form-group local-forms">
							        <label>Định dạng <span class="login-danger">*</span></label>
							        <select  class="form-control select" name="media_type">
							        	<option value="${l.media_type }">${l.media_type }</option>
							           	<option value="VIDEO">VIDEO</option>
							           	<option value="TEXT">TEXT</option>
							           	<option value="PDF">PDF</option>
							        </select>
							    </div>
							</div>                                                                      
				              <div class="col-12 col-sm-6">
							    <div class="form-group local-forms">
							        <label>Chọn File <span class="login-danger">*</span></label>
							        <input type="file" name="media_url" class="form-control" value="${l.media_url} placeholder="Chọn file" >
							        <input type="hidden" name="media_url_old" value="${l.media_url}">
							    </div>
							</div>     
							<div class="col-12 col-sm-6">
							    <div class="form-group local-forms">
							        <label>Thứ tự bài giảng <span class="login-danger">*</span></label>
							        <select  class="form-control select" name="order">
							        <option value="${l.order }">${l.order }</option>
							           	<option value="1">1</option>
							           	<option value="2">2</option>
							           	<option value="3">3</option>
							        </select>
							    </div>
							</div>                                                                      
				              <div class="col-12 col-sm-6">
							    <div class="form-group local-forms">
							        <label>Trạng thái <span class="login-danger">*</span></label>
							         <select  class="form-control select" name="status">
							         	<option value="${l.status}">${l.status}</option>
							           	<option value="1">Đang hoạt động</option>
							           	<option value="0">Không hoạt động</option>
							        </select>
							    </div>
							</div>      
							 				            
                            <div class="col-12">
                                <div class="student-submit">
                                    <button type="submit" class="btn btn-primary">Submit</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
