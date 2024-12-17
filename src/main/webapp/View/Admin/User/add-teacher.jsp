<% request.setAttribute("bodyPage", "/View/Admin/User/add-teacher.jsp"); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="content container-fluid">

    <div class="page-header">
        <div class="row align-items-center">
            <div class="col">
                <h3 class="page-title">Thêm mới giáo viên</h3>
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="teachers.html">Giáo viên</a></li>
                    <li class="breadcrumb-item active">Thêm mới giáo viên</li>
                </ul>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-12">
            <div class="card">
                <div class="card-body">
                    <form action="add-teacher" method="post" enctype="multipart/form-data">
                        <div class="row">
                            <div class="col-12">
                                <h5 class="form-title"><span>Giáo viên</span></h5>
                            </div>
                            <div class="col-12 col-sm-4">
                                <div class="form-group local-forms">
                                    <label>Họ và tên <span class="login-danger">*</span></label>
                                    <input type="text" name="fullname" class="form-control" placeholder="Nhập họ tên">
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
							        <select name="role" class="form-control select">
							            <option value="admin">Admin</option>
							            <option value="teacher">Teacher</option>
							            <option value="student">Student</option>
							        </select>
							    </div>
							</div>
                            <div class="col-12 col-sm-4">
                                <div class="form-group local-forms">
                                    <label>Giới tính<span class="login-danger">*</span></label>
                                    <select class="form-control select" name="gender">
                                        <option value="Nam">Nam</option>
                                        <option value="Nữ">Nữ</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-12 col-sm-4">
							    <div class="form-group local-forms ">
							        <label for="date_of_birt">Ngày sinh <span class="login-danger">*</span></label>
							        <input type="date" class="form-control" name="date_of_birt"  required>
							    </div>
							</div>

                            <div class="col-12 col-sm-4">
                                <div class="form-group local-forms">
                                    <label>Số điện thoại <span class="login-danger">*</span></label>
                                    <input type="number" name="phone" class="form-control" placeholder="Nhập số điện thoại">
                                </div>
                            </div>

                            <div class="col-12">
                                <h5 class="form-title"><span>Chi tiết tài khoản</span></h5>
                            </div>
                            <div class="col-12 col-sm-4">
                                <div class="form-group local-forms">
                                    <label>Tên người dùng <span class="login-danger">*</span></label>
                                    <input type="text" name="username" class="form-control" placeholder="Nhập tên người dùng">
                                </div>
                            </div>
                            <div class="col-12 col-sm-4">
                                <div class="form-group local-forms">
                                    <label>Email <span class="login-danger">*</span></label>
                                    <input type="email" name="email" class="form-control" placeholder="Nhập email">
                                </div>
                            </div>
                            <div class="col-12 col-sm-4">
                                <div class="form-group local-forms">
                                    <label>Mật khẩu <span class="login-danger">*</span></label>
                                    <input type="password" name="password" class="form-control" placeholder="Nhập mật khẩu">
                                </div>
                            </div>

                            <div class="col-12">
                                <div class="form-group local-forms">
                                    <label>Địa chỉ <span class="login-danger">*</span></label>
                                    <input type="text" name="address" class="form-control" placeholder="Nhập địa chỉ">
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
