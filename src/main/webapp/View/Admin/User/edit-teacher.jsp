<% request.setAttribute("bodyPage", "/View/Admin/User/edit-teacher.jsp"); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<div class="content container-fluid">

	<div class="page-header">
		<div class="row align-items-center">
			<div class="col">
				<h3 class="page-title">Sửa Giáo viên</h3>
				<ul class="breadcrumb">
					<li class="breadcrumb-item"><a href="teachers.html">Giáo viên</a></li>
					<li class="breadcrumb-item active">Sửa Giáo viên</li>
				</ul>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-sm-12">
			<div class="card">
				<div class="card-body">
				<c:set value="${user }" var="u"/>
					<form action="update-teacher" method="post" enctype="multipart/form-data">
						<div class="mb-3">
							<h5 class="form-title">
								<span>Giáo viên</span>
							</h5>
						</div>
						
						<div class="mb-5">
							<img style="width:230px; max-height:230px;" class="avatar-img img-thumbnail rounded-circle" alt="" src="${pageContext.request.contextPath}/public/backend/img/user/${u.avatar }">
							<input type="hidden" name="aavatar" value="${u.avatar }">
						</div>
						<div class="row">
							
							<input type="hidden" name="id" value="${u.user_id }">
							

							<div class="col-12 col-sm-4">
								<div class="form-group local-forms">
									<label>Họ và tên <span class="login-danger">*</span></label> <input
										type="text" class="form-control" name="fullname" value="${u.fullname }">
								</div>
							</div>
							
							<div class="col-12 col-sm-4">
							    <div class="form-group local-forms">
							        <label>Ảnh đại diện</label>
							        <input type="file" name="avatar" class="form-control">
							    </div>
							</div>
							
							<div class="col-12 col-sm-4">
							    <div class="form-group local-forms">
							        <label>Vai trò <span class="login-danger">*</span></label>
							        <select class="form-control select" name="role">
							            <option value="teacher" ${u.role == 'teacher' ? 'selected' : ''}>Giáo viên</option> 
        								<option value="student" ${u.role == 'student' ? 'selected' : ''}>Học viên</option>
							        </select>
							    </div>
							</div>
							
							<div class="col-12 col-sm-4">
							    <div class="form-group local-forms">
							        <label>Giới tính <span class="login-danger">*</span></label>
							        <select class="form-control select" name="gender">
							            <option value="nam" ${u.gender == 'nam' ? 'selected' : ''}>Nam</option> 
        								<option value="nữ" ${u.gender == 'nữ' ? 'selected' : ''}>Nữ</option>
							        </select>
							    </div>
							</div>

							<div class="col-12 col-sm-4">
								<div class="form-group local-forms">
									<label>Ngày sinh <span class="login-danger">*</span></label>
									<input class="form-control" type="date" name="date_of_birt"
										value="${u.date_of_birt }">
								</div>
							</div>
							<div class="col-12 col-sm-4">
								<div class="form-group local-forms">
									<label>Số điện thoại <span class="login-danger">*</span></label> <input
										type="number" class="form-control" name="phone" value="${u.phone }">
								</div>
							</div>
							
							<div class="col-12">
								<h5 class="form-title">
									<span>Chi tiết tài khoản</span>
								</h5>
							</div>
							<div class="col-12 col-sm-4">
								<div class="form-group local-forms">
									<label>Tên người dùng <span class="login-danger">*</span></label> <input
										type="text" class="form-control" name="username" value="${u.username }">
								</div>
							</div>
							<div class="col-12 col-sm-4">
								<div class="form-group local-forms">
									<label>Email <span class="login-danger">*</span></label> <input
										type="email" class="form-control" name="email" value="${u.email }">
								</div>
							</div>
							<div class="col-12 col-sm-4">
								<div class="form-group local-forms">
									<label>Mật khẩu <span class="login-danger">*</span></label> <input
										type="password" class="form-control" name="password" value="${u.password }">
								</div>
							</div>
							
							<div class="col-12 ">
								<div class="form-group local-forms">
									<label>Địa chỉ <span class="login-danger">*</span></label> <input
										type="text" class="form-control" name="address" value="${u.address }">
								</div>
							</div>
							

							<div class="col-sm-12">
								<div class="form-check custom-checkbox mb-3 checkbox-success">
									<input type="checkbox" name="status" value="1" class="form-check-input" ${u.status == 1 ? 'checked' : '' }>
									<input type="hidden" name="status" value="0" class="form-check-input">
			            			<label class="form-check-label">Hoạt động</label>
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