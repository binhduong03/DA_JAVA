<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style type="text/css">
.top1 {
	border-radius: 1rem;
	background-color: rgb(24, 29, 56);
	color: white;
	margin: 30px auto;
	padding: 50px 30px;
}
</style>
	<div class="container mt-5 top1">
		<div class="d-flex justify-content-between align-items-center">
			<c:set value="${course }" var="course" />
			<div>
				<h1 style="color: white;">Ngôn ngữ ${course.name}</h1>
				<p class="lead">${course.description}</p>
				<div class="d-flex gap-3">
					<span><i class="fas fa-clock"></i> 20 giờ</span> <span><i
						class="fas fa-user"></i> Giảng viên: ${course.user.fullname}</span> <span><i
						class="fas fa-certificate"></i> Chứng chỉ</span> <span><i
						class="fas fa-star"></i> 4.3 (184 đánh giá)</span>
				</div>
			</div>
			<div>
				<img style="border-radius: 2rem; width: 200px; height: auto;"
					src="${pageContext.request.contextPath}/public/backend/img/course/${course.image }"
					alt="Hình khóa học" class="img-fluid">
			</div>
		</div>
	</div>
	<div class="container-fluid p-3">
		<div class="row">
			<div class="col-lg-9">
			    <c:choose>
			        <c:when test="${not empty lecture}">
			            <c:choose>
			                <c:when test="${lecture.media_type == 'VIDEO'}">
			                    <video width="100%" height="600" controls>
			                        <source src="${pageContext.request.contextPath}/public/backend/filepath/lecture/${lecture.media_url}" type="video/mp4">
			                        Trình duyệt của bạn không hỗ trợ video.
			                    </video>
			                    <h2>${lecture.title}</h2>
			            		<p>${lecture.content}</p>
			                </c:when>
			                <c:when test="${lecture.media_type == 'file'}">
			                    <a href="${lecture.media_url}" download>Tải xuống tệp</a>
			                </c:when>
			                <c:otherwise>
			                    <p>Nội dung không khả dụng.</p>
			                </c:otherwise>
			            </c:choose>
			        </c:when>
			        <c:otherwise>
			            <p>Bài giảng không tồn tại.</p>
			        </c:otherwise>
			    </c:choose>
			</div>

			<div class="col-lg-3 accordion" id="courseAccordion">
				<h1>Bài giảng khác:</h1>
				<c:forEach items="${chapter}" var="chapter">
					<div class="card">
						<div class="card-header" id="heading-${chapter.chapter_id}">
							<h5 class="mb-0">
								<button class="btn btn-link named" type="button"
									data-toggle="collapse"
									data-target="#collapse-${chapter.chapter_id}"
									aria-expanded="${chapters[0] == chapter ? 'true' : 'false'}"
									aria-controls="collapse-${chapter.chapter_id}">
									${chapter.title}
								</button>
							</h5>
						</div>
		
						<div id="collapse-${chapter.chapter_id}" class="collapse ${chapters[0] == chapter ? 'show' : ''}"
							aria-labelledby="heading-${chapter.chapter_id}"
							data-parent="#courseAccordion">
							<div class="card-body">
								<ul class="list-group">
									<!-- Hiển thị bài giảng thuộc chương -->
									<c:forEach items="${alllecture}" var="alllecture">
										<c:if test="${alllecture.chapter.chapter_id == chapter.chapter_id}">
											<li class="list-group-item d-flex justify-content-between align-items-center">																			
												<a href="lecture-detail?id=${alllecture.lecture_id}&course_id=${alllecture.chapter.course.course_id}" class="named">${alllecture.title}</a>																					
											</li>
											<!-- Hiển thị bài tập thuộc bài giảng -->
											<ul class="list-group">
												<c:forEach items="${exercise}" var="exercise">
													<c:if test="${exercise.lecture.lecture_id == lecture.lecture_id}">
														<li class="list-group-item d-flex justify-content-between align-items-center"  style="padding-left: 50px">													
															<a href="exercise-detail?id=${exercise.exercises_id}&course_id=${lecture.chapter.course.course_id}" class="named">${exercise.title} (Bài tập)</a>											
														</li>
													</c:if>
												</c:forEach>
											</ul>
										</c:if>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	
<!-- Bootstrap JS -->
<!-- Thêm jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- Thêm Popper.js -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"></script>

<!-- Thêm Bootstrap JS -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

	