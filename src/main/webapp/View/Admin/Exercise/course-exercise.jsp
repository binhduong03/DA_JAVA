<%
request.setAttribute("bodyPage", "/View/Admin/Exercise/course-exercise.jsp");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="content container-fluid">
	<div class="page-header">
		<div class="row align-items-center">
			<div class="col">
				<h3 class="page-title">Khoá học</h3>
				<ul class="breadcrumb">
					<li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
					<li class="breadcrumb-item active">Khoá học</li>
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
						placeholder="Search by Class ...">
				</div>
			</div>
			<div class="col-lg-2">
				<div class="search-student-btn">
					<button type="btn" class="btn btn-primary">Search</button>
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
								<h3 class="page-title">Khoá học</h3>
							</div>
							<div class="col-auto text-end float-end ms-auto download-grp">
								<a href="#" class="btn btn-outline-primary me-2"><i
									class="fas fa-download"></i> Download</a>
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
									<th>Tên khoá học</th>
									<th>Tên giáo viên</th>
									<th>Mô tả</th>
									<th>Giá tiền</th>
									<th>Tình trạng</th>
									<th>Hành động</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${course }" var="all" varStatus="status">
								<tr>
									<td>${status.index + 1}</td>
									<td>
											<input type="hidden" name="id" value="${all.course_id}">
											<img class="avatar-img rounded-circle" style="width:50px; max-height: 50px"
												src="${pageContext.request.contextPath}/public/backend/img/course/${all.image }" alt="Course Image">
									</td>
									<td style="max-width: 120px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">${all.name }</td>
									<td>${all.user.fullname }</td>
									<td style="max-width: 120px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">${all.description }</td>
									<td>${all.price }</td>
									<td>
										<span class="badge ${all.status == 1 ? 'bg-success-dark' : 'bg-secondary'}">
										    ${all.status == 1 ? 'Hoạt động' : 'Không hoạt động'}
										</span>
									</td>
									<td class="text-end">
										<div class="actions">
											<a href="javascript:;"
												class="btn btn-sm bg-success-light me-2"> <i
												class="fas fa-hand-point-right"></i>
											</a> 
											<a href="all-exercise?id=${all.course_id}"
												class="btn btn-sm bg-success-light me-2"> <i
												class="feather-eye"></i>
											</a> 
											<a href="javascript:;"
												class="btn btn-sm bg-success-light me-2"> <i
												class="fas fa-hand-point-left"></i>
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

