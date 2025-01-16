<%@page import="model.User"%>
<%@ page import="java.text.DecimalFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    User user = (User) session.getAttribute("data"); 
	double balance = user.getBalance(); // Lấy số tiền từ User
	DecimalFormat df = new DecimalFormat("#,###");
	String formattedBalance = df.format(balance);
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>eLEARNING - eLearning HTML Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Nunito:wght@600;700;800&display=swap" rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="${pageContext.request.contextPath}/public/frontend/lib/animate/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/public/frontend/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="${pageContext.request.contextPath}/public/frontend/css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="${pageContext.request.contextPath}/public/frontend/css/style.css" rel="stylesheet">
    <style type="text/css">
    	.button-container{
          position: relative;
          display: inline-block;
          padding-left: 10px;
        }

        .button-container a {
            text-decoration: none;   /* Bỏ gạch chân */
            color: inherit;          /* Giữ nguyên màu chữ của nút */
            font-size: inherit;      /* Giữ kích thước chữ theo nút */
            display: block;          /* Giúp thẻ a chiếm toàn bộ không gian nút */
            width: 100%;
            height: 100%;
            text-align: center;
            line-height: normal;
        }

        .btn-signup {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 1px 75px;
            border-radius: 50px;
            font-size: 16px;
            cursor: pointer;
            position: relative;
            height:80px;
            z-index: 2;
            left: 40px;
            transition: background-color 0.3s;
            overflow: hidden;
        }

        .signup-link {
            text-decoration: none;
            color: white; 
            display: block;
            position: absolute; 
            top: -10px;  
            left: 50%;
            transform: translateX(-50%) translateY(50%);
            font-size: 16px;  
            transition: top 0.3s;
        }

        .btn-signup:hover {
          background-color: #218838;
        }

        .btn-login {
          background-color: #cae3ce;
          color: #218838;
          border: none;
          padding: 1px 75px;
          border-radius: 50px  ;
          font-size: 16px;
          cursor: pointer;
          position: relative;
          width:100px;
          height:80px;
          top: 0;
          left: -25px;
          z-index: 1;
          transition: background-color 0.7s;
        }

        .btn-login:hover {
          background-color: #218838;
          color: #eaf7ec;
          ;
        }
    </style>
</head>

<body>
    <!-- Spinner Start -->
    <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
        <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
            <span class="sr-only">Loading...</span>
        </div>
    </div>
    <!-- Spinner End -->


    <!-- Navbar Start -->
    <nav class="navbar navbar-expand-lg bg-white navbar-light shadow sticky-top p-0">
        <a href="index.html" class="navbar-brand d-flex align-items-center px-4 px-lg-5">
            <h2 class="m-0 text-primary"><i class="fa fa-book me-3"></i>eLEARNING</h2>
        </a>
        <button type="button" class="navbar-toggler me-4" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <div class="navbar-nav ms-auto p-4 p-lg-0">
                <a href="trang-chu" class="nav-item nav-link active">Trang chủ</a>
                <a href="about.html" class="nav-item nav-link">About</a>
                <a href="khoa-hoc" class="nav-item nav-link">Khóa học</a>
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Pages</a>
                    <div class="dropdown-menu fade-down m-0">
                        <a href="team.html" class="dropdown-item">Our Team</a>
                        <a href="testimonial.html" class="dropdown-item">Testimonial</a>
                        <a href="404.html" class="dropdown-item">404 Page</a>
                    </div>
                </div>
                <a href="contact.html" class="nav-item nav-link">Contact</a>
                <a href="${pageContext.request.contextPath}/cart" class="nav-item nav-link"> 
				    <i class="bi bi-cart4" style="font-size: 20px"></i>
				    <span style="background-color: red; border-radius: 10px;color: white; margin-left:-5px; padding: 3px; font-weight: bold;">
				        <%= session.getAttribute("cart_count") != null ? session.getAttribute("cart_count") : 0 %>
				    </span>
				</a>	  
            </div>
            <div class="button-container">
			    <li class="nav-item dropdown pe-2 d-flex align-items-left">
			        <a href="javascript:;" class="nav-link text-body p-0" id="dropdownProfile" data-bs-toggle="dropdown" aria-expanded="false">
			            <% 			            
			                if (user != null) { 
			            %>
			                <!-- Khi đã đăng nhập -->
			                <div class="user-info">                                
			                    <img src="${pageContext.request.contextPath}/public/backend/img/user/<%= user.getAvatar() %>" class="user-avatar col-lg-3" style="width: 50px; mix-blend-mode: multiply;">
			                    <span class="user-name col-md-6" style="color: black;"><%= user.getFullname() %></span>                               
			                    <div>Tài khoản: <%= formattedBalance %> VND</div>
			                </div>
			                <ul class="dropdown-menu dropdown-menu-end me-sm-n4" aria-labelledby="dropdownProfile" style="margin: 10px 50px 10px -45px; width: 40px;">
			                    <li class="mb-2">
			                        <a class="dropdown-item border-radius-md" href="${pageContext.request.contextPath}/profile">   
			                            <div class="d-flex py-1">
			                                <div class="my-auto">
			                                    <i class='fas fa-address-card' style='font-size:24px;padding-right: 10px;margin-top: -10px;'></i>
			                                </div>
			                                <div class="d-flex flex-column justify-content-left">
			                                    <h6 class="text-sm font-weight-normal mb-1">
			                                        <span class="font-weight-bold">Tiểu sử</span>
			                                    </h6>
			                                </div>
			                            </div>
			                        </a>
			                        <a class="dropdown-item border-radius-md" href="#" data-bs-toggle="modal" data-bs-target="#walletModal">
			                            <div class="d-flex py-1">
			                                <div class="my-auto">
			                                    <i class='fas fa-wallet' style='font-size:24px;padding-right: 10px;margin-top: -10px;'></i>
			                                </div>
			                                <div class="d-flex flex-column justify-content-left">
			                                    <h6 class="text-sm font-weight-normal mb-1">
			                                        <span class="font-weight-bold">Nạp tiền</span>
			                                    </h6>
			                                </div>
			                            </div>
			                        </a>
			                        <a class="dropdown-item border-radius-md" href="#" data-bs-toggle="modal" data-bs-target="#scoreModal">
			                            <div class="d-flex py-1">
			                                <div class="my-auto">
			                                    <i class="bi bi-calculator" style='font-size:24px;padding-right: 10px;margin-top: -0px;'></i>
			                                </div>
			                                <div class="d-flex flex-column justify-content-left">
			                                    <h6 class="text-sm font-weight-normal mt-2">
			                                        <span class="font-weight-bold">Điểm số</span>
			                                    </h6>
			                                </div>
			                            </div>
			                        </a>
			                        <a class="dropdown-item border-radius-md" href="${pageContext.request.contextPath}/login" style="text-decoration: none;">
			                            <div class="d-flex py-1">
			                                <div class="my-auto">
			                                    <i class='bi bi-box-arrow-right' style='font-size:24px;padding-right: 10px;padding-top: 10px;'></i>
			                                </div>
			                                <div class="d-flex flex-column justify-content-left">
			                                    <h6 class="text-sm font-weight-normal mb-1">
			                                        <span class="font-weight-bold">Đăng xuất</span>                                                   
			                                    </h6>
			                                </div>
			                            </div>
			                        </a>
			                    </li>
			                </ul>
			            <% 
			                } else { 
			            %>
			                <!-- Khi chưa đăng nhập -->
			                <button class="btn-signup">
			                    <a href="${pageContext.request.contextPath}/register" class="signup-link">Sign Up</a>
			                </button>
			
			                <button class="btn-login">
			                    <a href="${pageContext.request.contextPath}/login" style="text-decoration: none; padding-top: 25px; width:50px;">Log in</a>
			                </button>
			            <% 
			                } 
			            %>
			        </a>
			    </li>
			</div>            
        </div>
    </nav>
    <!-- Navbar End -->


    <jsp:include page="${welcome}" />
        

    <!-- Footer Start -->
    <div class="container-fluid bg-dark text-light footer pt-5 mt-5 wow fadeIn" data-wow-delay="0.1s">
        <div class="container py-5">
            <div class="row g-5">
                <div class="col-lg-3 col-md-6">
                    <h4 class="text-white mb-3">Quick Link</h4>
                    <a class="btn btn-link" href="">About Us</a>
                    <a class="btn btn-link" href="">Contact Us</a>
                    <a class="btn btn-link" href="">Privacy Policy</a>
                    <a class="btn btn-link" href="">Terms & Condition</a>
                    <a class="btn btn-link" href="">FAQs & Help</a>
                </div>
                <div class="col-lg-3 col-md-6">
                    <h4 class="text-white mb-3">Contact</h4>
                    <p class="mb-2"><i class="fa fa-map-marker-alt me-3"></i>123 Street, New York, USA</p>
                    <p class="mb-2"><i class="fa fa-phone-alt me-3"></i>+012 345 67890</p>
                    <p class="mb-2"><i class="fa fa-envelope me-3"></i>info@example.com</p>
                    <div class="d-flex pt-2">
                        <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-twitter"></i></a>
                        <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-facebook-f"></i></a>
                        <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-youtube"></i></a>
                        <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-linkedin-in"></i></a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <h4 class="text-white mb-3">Gallery</h4>
                    <div class="row g-2 pt-2">
                        <div class="col-4">
                            <img class="img-fluid bg-light p-1" src="img/course-1.jpg" alt="">
                        </div>
                        <div class="col-4">
                            <img class="img-fluid bg-light p-1" src="img/course-2.jpg" alt="">
                        </div>
                        <div class="col-4">
                            <img class="img-fluid bg-light p-1" src="img/course-3.jpg" alt="">
                        </div>
                        <div class="col-4">
                            <img class="img-fluid bg-light p-1" src="img/course-2.jpg" alt="">
                        </div>
                        <div class="col-4">
                            <img class="img-fluid bg-light p-1" src="img/course-3.jpg" alt="">
                        </div>
                        <div class="col-4">
                            <img class="img-fluid bg-light p-1" src="img/course-1.jpg" alt="">
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <h4 class="text-white mb-3">Newsletter</h4>
                    <p>Dolor amet sit justo amet elitr clita ipsum elitr est.</p>
                    <div class="position-relative mx-auto" style="max-width: 400px;">
                        <input class="form-control border-0 w-100 py-3 ps-4 pe-5" type="text" placeholder="Your email">
                        <button type="button" class="btn btn-primary py-2 position-absolute top-0 end-0 mt-2 me-2">SignUp</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="copyright">
                <div class="row">
                    <div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
                        &copy; <a class="border-bottom" href="#">Your Site Name</a>, All Right Reserved.

                        <!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
                        Designed By <a class="border-bottom" href="https://htmlcodex.com">HTML Codex</a>
                    </div>
                    <div class="col-md-6 text-center text-md-end">
                        <div class="footer-menu">
                            <a href="">Home</a>
                            <a href="">Cookies</a>
                            <a href="">Help</a>
                            <a href="">FQAs</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Footer End -->


    <!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>


    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="${pageContext.request.contextPath}/public/frontend/lib/wow/wow.min.js"></script>
    <script src="${pageContext.request.contextPath}/public/frontend/lib/easing/easing.min.js"></script>
    <script src="${pageContext.request.contextPath}/public/frontend/lib/waypoints/waypoints.min.js"></script>
    <script src="${pageContext.request.contextPath}/public/frontend/lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Template Javascript -->
    <script src="${pageContext.request.contextPath}/public/frontend/js/main.js"></script>
<!-- Modal nạp tiền -->
<div class="modal fade" id="walletModal" tabindex="-1" aria-labelledby="walletModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="${pageContext.request.contextPath}/wallet" method="POST" onsubmit="return validateAmount()">
                <div class="modal-header">
                    <h5 class="modal-title" id="walletModalLabel">Nạp tiền vào ví</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="amount">Nhập số tiền cần nạp:</label>
                        <input type="text" class="form-control" name="amount" id="amount" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                    <button type="submit" class="btn btn-primary">Nạp tiền</button>
                </div>
            </form>            
        </div>
    </div>
</div>
<script>

    // Xử lý định dạng số với dấu phân cách
    document.getElementById('amount').addEventListener('input', function (event) {
        let value = event.target.value.replace(/[^\d]/g, ''); // Loại bỏ tất cả ký tự không phải số

        // Định dạng số với dấu phân cách mỗi 3 chữ số
        if (value) {
            value = value.replace(/\B(?=(\d{3})+(?!\d))/g, '.');
        }

        // Cập nhật lại giá trị input với định dạng mới
        event.target.value = value;
    });

    // Kiểm tra và chuẩn hóa giá trị trước khi gửi
    function validateAmount() {
        let amountField = document.getElementById('amount');
        let amount = amountField.value.replace(/\./g, ''); // Loại bỏ dấu phân cách

        // Kiểm tra xem giá trị có hợp lệ không (lớn hơn hoặc bằng 1000)
        if (parseInt(amount) < 1000) {
            alert("Số tiền nạp phải lớn hơn hoặc bằng 1000");
            return false; // Ngừng form submission
        }
        if (amount.length > 14) {
            alert("Số tiền nạp phải bé hơn 15 số");
            return false; // Ngừng form submission
        }

        // Chuyển lại thành số nguyên để gửi lên server
        amountField.value = amount;
        return true;
    }
</script>
</body>

</html>