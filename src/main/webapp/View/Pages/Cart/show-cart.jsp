<%@ page import="model.User" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Giỏ hàng</title>
</head>
<body>

<div class="container mt-5">
    <h2>Giỏ hàng của bạn</h2>

    <!-- Kiểm tra nếu giỏ hàng trống -->
    <c:if test="${empty cartItems}">
        <p>Giỏ hàng trống!</p>
    </c:if>
    
    <!-- Nếu giỏ hàng có items -->
    <c:if test="${not empty cartItems}">
        <table class="table">
            <thead>
                <tr>
                    <th class="text-center">Ảnh</th>
                    <th class="text-center">Tên khóa học</th>
                    <th class="text-center">Giá tiền</th>
                    <th class="text-center">Thao tác</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${cartItems}">
                    <tr>
                        <td class="align-middle text-center">
                            <img style="border-radius: 2rem; width: 200px; height: 120px" 
                                 src="${pageContext.request.contextPath}/public/backend/img/course/${item.course.image}" alt="${item.course.name}" class="img-fluid">
                        </td>
                        <td class="align-middle text-center">Khoá học ${item.course.name}</td>
                        <td class="align-middle text-center">${item.course.price}đ</td>
						<td class="align-middle text-center">
                            <form action="${pageContext.request.contextPath}/cart" method="POST">                            
							    <input type="hidden" name="action" value="remove">
                                <input type="hidden" name="cartId" value="${item.cart_id}" />
                                <button type="submit" class="btn btn-danger" style="border-radius: 2rem;" 
                                        onclick="return confirm('Bạn đã xác định xoá khoá học này khỏi giỏ hàng chưa?');"> 
                                        <i class="bi bi-cart-x-fill"></i> Xóa khỏi giỏ hàng
                                </button>
                            </form>
                        </td>                    
                   </tr>
                </c:forEach>
                <tr>
                    <td colspan="2"></td>
                    <td class="text-center"><strong>Tổng tiền:</strong> ${totalPrice}đ</td>
                    <td class="text-center">
                        <form action="${pageContext.request.contextPath}/cart" method="POST">
                            <button type="submit" class="btn btn-success" style="border-radius: 2rem;" 
                                    onclick="return confirm('Xác nhận thanh toán tất cả khoá học có trong giỏ hàng?');">                                                          
							    	<input type="hidden" name="action" value="checkout">
                                <i class="bi bi-cash"></i> Thanh toán tất cả
                            </button>
                        </form>
                    </td>
                </tr>
            </tbody>
        </table>
    </c:if>
</div>

</body>
</html>
