package controller.admin.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;

import dal.UserDAO;

/**
 * Servlet implementation class WalletServlet
 */
public class WalletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WalletServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
        User user = (User) session.getAttribute("data");

        if (user != null) {
            // Lấy số tiền từ form
            String amountStr = request.getParameter("amount");
            try {
                double amount = Double.parseDouble(amountStr);

                // Kiểm tra số tiền hợp lệ
                if (amount > 0) {
                    // Cập nhật số dư
                    double newBalance = user.getBalance() + amount;
                    user.setBalance(newBalance);

                    // Gọi DAO để cập nhật cơ sở dữ liệu
                    UserDAO userDAO = new UserDAO();
                    userDAO.updateBalance(user.getUser_id(), newBalance);

                    // Cập nhật session
                    session.setAttribute("user", user);

                    // Chuyển hướng về trang thành công
                    response.sendRedirect("trang-chu");
                } else {
                    request.setAttribute("error", "Số tiền phải lớn hơn 0!");
                    request.getRequestDispatcher("wallet-error.jsp").forward(request, response);
                }
            } catch (NumberFormatException e) {
                request.setAttribute("error", "Số tiền không hợp lệ!");
                request.getRequestDispatcher("wallet-error.jsp").forward(request, response);
            }
        } else {
            // Người dùng chưa đăng nhập
            response.sendRedirect("View/Pages/Auth/login.jsp");
        }
	}

}
