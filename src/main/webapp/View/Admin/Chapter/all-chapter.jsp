<%
request.setAttribute("bodyPage", "/View/Admin/Chapter/all-chapter.jsp");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	function doDelete(chapter_id, course_id) {
		if (confirm("Bạn có chắc chắn muốn xóa chương với id = " + chapter_id
				+ " không?")) {
			window.location = "delete-chapter?chapter_id=" + chapter_id + "&course_id="+ course_id;
		}
	
	}
</script>
<div class="content container-fluid">
	<div class="page-header">
		<div class="row align-items-center">
			<div class="col">
				<h3 class="page-title">Chương</h3>
				<ul class="breadcrumb">
					<li class="breadcrumb-item"><a href="index.html">Trang chủ</a></li>
					<li class="breadcrumb-item active">Chương</li>
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
								<h3 class="page-title">Chương</h3>
							</div>
							<div class="col-auto text-end float-end ms-auto download-grp">
								<a href="#" class="btn btn-outline-primary me-2"><i
									class="fas fa-download"></i> Tải về</a> <a
									href="add-chapter?id=${courseId}" class="btn btn-primary"><i
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
									<th>Tên chương</th>
									<th>Khóa học</th>
									<th>Mô tả</th>									
									<th class="text-end">Hành động</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${chapter }" var="all" varStatus="status">
								<tr>
									<td>${status.index + 1}</td>
									<td>${all.title }</td>
									<td style="max-width: 120px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">${all.course.name }</td>
									<td style="max-width: 120px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">${all.content }</td>
									
						
									<td class="text-end">
										<div class="actions">
											<a href="update-chapter?id=${all.chapter_id }&course_id=${all.course.course_id}"
												class="btn btn-sm bg-danger-light"> <i
												class="feather-edit"></i>
											</a>
											<a href="#" onclick="doDelete('${all.chapter_id}','${all.course.course_id}')"
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

