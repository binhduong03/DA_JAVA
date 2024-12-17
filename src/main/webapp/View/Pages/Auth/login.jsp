<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- link css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/frontend/css/stylelogin.css">

    <!-- link icon -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.5/font/bootstrap-icons.min.css" integrity="sha512-ZnR2wlLbSbr8/c9AgLg3jQPAattCUImNsae6NHYnS9KrIwRdcY9DxFotXhNAKIKbAXlRnujIqUWoXXwqyFOeIQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />


    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form</title>
</head>
<body>
    <div class="container">
        <div class="box">
            <div class="form sign_in">
                <h3>Đăng nhập</h3>
                <h3 style="color: red;">${requestScope.error}</h3>
                <span>đăng nhập tài khoản của bạn</span>

                <form action="login" method="post" id="form_input">
                    <div class="type">
                        <input type="text" placeholder="Tên người dùng" name="user" id="email">

                    </div>
                    <div class="type">
                        <input type="password" placeholder="Mật khẩu" name="pass" id="password">

                    </div>

                    <div class="forgot">
                        <span>Quên mật khẩu?</span>
                    </div>

                    <button class="btn bkg">Đăng nhập</button>
                </form>
            </div>
    
            <div class="form sign_up">
                <h3>Đăng ký</h3>
                <span>đăng ký bằng tài khoản email của bạn</span>

                <form action="RegisterServlet" method="post" id="form_input">
                    <div class="type">

                        <input type="text" name="fullname" placeholder="Nhập họ và tên" id="fullname" required>
                    </div>
                    <div class="type">

                        <input type="text" name="username" placeholder="Nhập tên người dùng" id="username" required>
                    </div>
                    <div class="type">
                        
                        <input type="email" name="email" placeholder="Nhập Email" id="email" required>
                    </div>
                    <div class="type">

                        <input type="password" name="password" placeholder="Nhập mật khẩu" id="password" required>
                    </div>

                    <button type="submit" class="btn bkg">Đăng ký</button>
                </form>
            </div>
        </div>

        <div class="overlay">
            <div class="page page_signIn">
                <h3>Chào mừng quay trở lại!</h3>
                <p>Để ở lại với chúng tôi, vui lòng đăng nhập bằng thông tin cá nhân của bạn.</p>

                <button class="btn btnSign-in">Đăng ký <i class="bi bi-arrow-right"></i></button>
            </div>

            <div class="page page_signUp">
                <h3>Xin chào bạn!</h3>
                <p>Nhập thông tin cá nhân của bạn và bắt đầu hành trình cùng chúng tôi.</p>

                <button class="btn btnSign-up">
                    <i class="bi bi-arrow-left"></i> Đăng nhập</button>
            </div>
        </div>
    </div>
    

    <!-- link script -->
    <script src="${pageContext.request.contextPath}/public/frontend/js/mainlogin.js"></script>
</body>
</html>