package controller.pages;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import model.Carts;
import model.Course;
import model.Payment_Details;
import model.Payments;
import model.User;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import dal.CartDAO;
import dal.CourseDAO;
import dal.PaymentDAO;
import dal.PaymentDetailDAO;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setAttribute("welcome", "/View/Pages/Cart/show-cart.jsp");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("data");
		int userId = user.getUser_id();
	    CartDAO cartDAO = new CartDAO();

	    // Lấy danh sách giỏ hàng của người dùng
	    List<Carts> c = cartDAO.getCartItems(userId);

	    // Tính toán tổng tiền trong giỏ hàng
	    double totalPrice = 0;
	    for (Carts item : c) {
	        totalPrice += item.getCourse().getPrice();  // Thêm giá của mỗi khóa học
	    }

	    // Định dạng tổng tiền
	    DecimalFormat df = new DecimalFormat("#,###");
	    String formattedTotalPrice = df.format(totalPrice);	    
	    
	    // Truyền dữ liệu giỏ hàng và tổng tiền sang trang JSP
	    request.setAttribute("cartItems", c);
	    request.setAttribute("totalPrice", formattedTotalPrice);
        request.getRequestDispatcher("/View/Pages/welcome.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setAttribute("welcome", "/View/Pages/Course/course.jsp");
	    String action = request.getParameter("action");
	    CartDAO cartDAO = new CartDAO();

	    // Lấy đối tượng User từ session
	    HttpSession session = request.getSession();
	    User user = (User) session.getAttribute("data"); // Lấy đối tượng User từ session

	    // Kiểm tra xem user có tồn tại trong session không
	    if (user == null) {
	        response.sendRedirect("/login.jsp"); // Nếu chưa đăng nhập, chuyển hướng đến trang đăng nhập
	        return;
	    }

	    // Lấy userId từ đối tượng User
	    int userId = user.getUser_id();

	    if ("add".equals(action)) {
	        String courseIdStr = request.getParameter("courseId");
	        if (courseIdStr != null) {
	            int courseId = Integer.parseInt(courseIdStr);

	            Course course = new Course();
	            course.setCourse_id(courseId);

	            Carts cart = new Carts();
	            cart.setUser(user);  // Sử dụng đối tượng user đã lấy từ session
	            cart.setCourse(course);
	            cart.setStatus("unpaid"); //Ch thanh toán
	            cart.setCreated_at(new Date());
	            cart.setUpdated_at(new Date());

	            boolean isAdded = cartDAO.addToCart(cart);

	            if (isAdded) {
	                // Cập nhật số lượng khóa học trong giỏ hàng
	                int cartCount = cartDAO.getCartItems(userId).size();
	                session.setAttribute("cart_count", cartCount);  // Cập nhật lại số lượng khóa học trong session
	                request.setAttribute("message", "Khóa học đã được thêm vào giỏ hàng!");
	            } else {
	                request.setAttribute("message", "Khóa học đã tồn tại trong giỏ hàng!");
	            }

	            // Chuyển hướng đến trang khoa-hoc
	            response.sendRedirect(request.getContextPath() + "/khoa-hoc");
	        }

	    } else if ("remove".equals(action)) {
	        String cartIdStr = request.getParameter("cartId");
	        if (cartIdStr != null) {
	            int cartId = Integer.parseInt(cartIdStr);
	            cartDAO.removeFromCart(cartId);

	            // Cập nhật lại số lượng khóa học trong session
	            int cartCount = cartDAO.getCartItems(userId).size();
	            session.setAttribute("cart_count", cartCount);  // Cập nhật lại số lượng khóa học trong session

	            // Chuyển hướng đến trang khoa-hoc sau khi xóa
	            response.sendRedirect(request.getContextPath() + "/cart");
	        }
	    }else if ("checkout".equals(action)) {
	        // Lấy danh sách các khóa học trong giỏ hàng
	        List<Carts> cartItems = cartDAO.getCartItems(userId);

	        if (cartItems.isEmpty()) {
	            // Nếu giỏ hàng trống, chuyển hướng lại trang giỏ hàng và thông báo
	            request.setAttribute("message", "Giỏ hàng trống! Không thể thực hiện thanh toán.");
	            response.sendRedirect(request.getContextPath() + "/cart");
	            return;
	        }

	        // Tính tổng số tiền từ các khóa học trong giỏ hàng
	        double totalAmount = 0;
	        for (Carts item : cartItems) { 
	            totalAmount += item.getCourse().getPrice();
	        }

	        // Tạo đối tượng Payment để lưu vào bảng tb_payments
	        Payments payment = new Payments();
	        payment.setUser(user); // Người dùng hiện tại
	        payment.setAmount(totalAmount); // Tổng tiền
	        payment.setPayment_method("MOMO"); 
	        payment.setPayment_status(1); // Trạng thái thanh toán: 1 (Thành công)
	        payment.setPayment_date(new Date()); // Ngày thanh toán hiện tại

	        // Lưu dữ liệu thanh toán vào bảng tb_payments
	        PaymentDAO paymentDAO = new PaymentDAO();
	        paymentDAO.insert(payment);

	        PaymentDAO payDao = new PaymentDAO();
	        System.out.println(payment);
	        // Lưu chi tiết thanh toán vào bảng tb_payment_details và cập nhật status của tb_carts
	        PaymentDetailDAO paymentDetailDAO = new PaymentDetailDAO();
	        for (Carts item : cartItems) {
	            Payment_Details detail = new Payment_Details();
	            detail.setPayment(payment);
	            detail.setCart(item);
	            detail.setAmount(item.getCourse().getPrice());
	            paymentDetailDAO.insert(detail);

	            // Cập nhật trạng thái giỏ hàng thành "paid"
	            item.setStatus("paid");
	            cartDAO.updateCartStatus(item);  // Cập nhật trạng thái giỏ hàng
	        }

	        // Cập nhật lại số lượng giỏ hàng trong session (set to 0 since the cart is empty now)
	        session.setAttribute("cart_count", 0);

	        // Chuyển hướng đến trang xác nhận thanh toán
	        response.sendRedirect(request.getContextPath() + "/cart?message=Thanh toán thành công!");
	    }
	}
}
