<%
	request.setAttribute("bodyPage", "/View/Admin/User/all-teacher.jsp");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
function doDelete(id) {
	if (confirm("Bạn có chắc chắn muốn xóa nguời dùng với id = "+id+ " không?")){
		window.location = "delete-teacher?id=" + id;
	}
	
}
</script>
<div class="content container-fluid">

	<div class="page-header">
		<div class="row align-items-center">
			<div class="col">
				<h3 class="page-title">Giáo viên</h3>
				<ul class="breadcrumb">
					<li class="breadcrumb-item"><a href="index.html">Trang chủ</a></li>
					<li class="breadcrumb-item active">Giáo viên</li>
				</ul>
			</div>
		</div>
	</div>

	<div class="student-group-form">
		<div class="row">
			<div class="col-lg-3 col-md-6">
				<div class="form-group">
					<input type="text" class="form-control"
						placeholder="Search by ID ...">
				</div>
			</div>
			<div class="col-lg-3 col-md-6">
				<div class="form-group">
					<input type="text" class="form-control"
						placeholder="Search by Name ...">
				</div>
			</div>
			<div class="col-lg-4 col-md-6">
				<div class="form-group">
					<input type="text" class="form-control"
						placeholder="Search by Phone ...">
				</div>
			</div>
			<div class="col-lg-2">
				<div class="search-student-btn">
					<button type="btn" class="btn btn-primary">Tìm kiếm</button>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="card card-table">
				<div class="card-body">

					<div class="page-header">
						<div class="row align-items-center">
							<div class="col">
								<h3 class="page-title">Giáo viên</h3>
							</div>
							<div class="col-auto text-end float-end ms-auto download-grp">
								<a href="teachers.html" class="btn btn-outline-gray me-2 active"><i
									class="feather-list"></i></a> <a href="teachers-grid.html"
									class="btn btn-outline-gray me-2"><i class="feather-grid"></i></a>
								<a href="#" class="btn btn-outline-primary me-2"><i
									class="fas fa-download"></i> Tải về</a> <a
									href="add-teacher" class="btn btn-primary"><i
									class="fas fa-plus"></i></a>
							</div>
						</div>
					</div>

					<div class="table-responsive">
						<table
							class="table border-0 star-student table-hover table-center mb-0 datatable table-striped">
							<thead class="student-thread">
								<tr>
									<th>STT</th>
									<th>Ảnh</th>
									<th>Họ tên</th>
									<th>Tên TK</th>
									<th>Giới tính</th>
									<th>SĐT</th>
									<th>Email</th>
									<th>Tình trạng</th>
									<th class="text-end">Hành động</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${teacher }" var="all" varStatus="status">
									<tr>
									<td>${status.index + 1}</td>
									<td>
											<input type="hidden" name="id" value="${all.user_id }">
											<img class="avatar-img rounded-circle" style="width:50px; max-height: 50px"
												src="${pageContext.request.contextPath}/public/backend/img/user/${all.avatar }" alt="User Image">
									</td>
									<td>${all.fullname }</td>
									<td>${all.username }</td>
									<td>${all.gender }</td>
									<td>${all.phone }</td>
									<td>${all.email }</td>
									<td>
										<span class="badge ${all.status == 1 ? 'bg-success-dark' : 'bg-secondary'}">
										    ${all.status == 1 ? 'Hoạt động' : 'Không hoạt động'}
										</span>

									</td>
									<td class="text-end">
										<div class="actions">
											<a href="javascript:;"
												class="btn btn-sm bg-success-light me-2"> <i
												class="feather-eye"></i>
											</a> <a href="update-teacher?id=${all.user_id }"
												class="btn btn-sm bg-danger-light"> <i
												class="feather-edit"></i>
											</a>
											</a> <a href="#" onclick="doDelete('${all.user_id}')"
												class="btn btn-sm bg-danger-light"> <i
												class="feather-delete"></i>
											</a>
										</div>
									</td>
								</tr>
								</c:forEach>
								
								
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>