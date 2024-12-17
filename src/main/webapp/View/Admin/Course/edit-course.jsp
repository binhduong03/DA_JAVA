<% request.setAttribute("bodyPage", "/View/Admin/Course/add-course.jsp"); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="content container-fluid">
    <div class="page-header">
        <div class="row align-items-center">
            <div class="col">
                <h3 class="page-title">Chỉnh sửa khoá học</h3>
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="teachers.html">Khoá học</a></li>
                    <li class="breadcrumb-item active">Chỉnh sửa khoá học</li>
                </ul>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-12">
            <div class="card">
                <div class="card-body">
                <c:set value="${course }" var="c"/>
                    <form action="update-course" method="post" enctype="multipart/form-data">
                    	<div class="mb-3">
							<h5 class="form-title">
								<span>Khoá học</span>
							</h5>
						</div>						
						<div class="mb-5">
							<img style="width:230px; max-height:230px;" class="avatar-img img-thumbnail rounded-circle" alt="" src="${pageContext.request.contextPath}/public/backend/img/course/${c.image }">
							<input type="hidden" name="image_old" value="${c.image}">
						</div>
                        <div class="row">
                        	<input type="hidden" name="id" value="${c.course_id}">
                            <div class="col-12">
                                <h5 class="form-title"><span>Khoá học</span></h5>
                            </div>
                            <div class="col-12 col-sm-4">
                                <div class="form-group local-forms">
                                    <label>Tên khoá học <span class="login-danger">*</span></label>
                                    <input type="text" name="name" class="form-control" value="${c.name }">
                                </div>
                            </div>
                            
                            <div class="col-12 col-sm-4">
							    <div class="form-group local-forms">
							        <label>Ảnh khoá học</label>
							        <input type="file" name="image" class="form-control" value="${c.image }">
							    </div>
							</div>
							<div class="col-12 col-sm-4">
							    <div class="form-group local-forms">
							        <label>Tên giảng viên <span class="login-danger">*</span></label>
							        <select  class="form-control select " name="user_id">
							        	<option value="${c.user.user_id }">${c.user.fullname}</option>
							           	<c:forEach items="${users }" var="users">							           	
							           		<option value="${users.user_id }">${users.fullname }</option>
							           	</c:forEach>
							        </select>
							    </div>
							</div>                

                            <div class="col-12">
                                <div class="form-group local-forms">
                                    <label>Mô tả <span class="login-danger">*</span></label>
                                    <input type="text" name="description" class="form-control"  placeholder="Nhập mô tả" value="${c.description }">
                                </div>
                            </div>                                                                    
				             <div class="col-12 col-sm-6">
                                <div class="form-group local-forms">				          
					                <label for="price" class="form-label">Giá khoá học</label>
					                <input type="text" class="form-control" id="price" name="price" value="${c.price }" placeholder="Nhập giá khoá học" required>
				                </div>
				            </div>
				            
				             <div class="col-12 col-sm-6">
                                <div class="form-group local-forms">				          
					                <label for="duration" class="form-label"> Thời gian học</label>
					                <input type="number" class="form-control" name="duration" value="${c.duration }" placeholder="Nhập thời gian học" required>
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
<script>
    // Hàm để định dạng giá tiền theo VNĐ
    function formatCurrencyVND(value) {
        if (!value) return '';
        // Xóa ký tự không phải số
        value = value.toString().replace(/[^0-9]/g, '');

        // Định dạng số với dấu chấm
        return new Intl.NumberFormat('vi-VN').format(value) + '';
    }

    // Sự kiện khi người dùng nhập dữ liệu
    document.getElementById('price').addEventListener('input', function (e) {
        const rawValue = this.value.replace(/\D/g, ''); // Lấy giá trị chỉ chứa số
        this.value = formatCurrencyVND(rawValue);
    });

    // Sự kiện khi người dùng rời khỏi ô input
    document.getElementById('price').addEventListener('blur', function (e) {
        const rawValue = this.value.replace(/\D/g, ''); // Lấy giá trị chỉ chứa số
        this.value = formatCurrencyVND(rawValue);
    });

    // Sự kiện khi người dùng focus vào ô input (xóa định dạng để dễ chỉnh sửa)
    document.getElementById('price').addEventListener('focus', function (e) {
        const rawValue = this.value.replace(/\D/g, ''); // Lấy giá trị chỉ chứa số
        this.value = rawValue;
    });
</script>