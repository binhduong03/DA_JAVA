package controller.pages;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;

import dal.AuthDAO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/View/Pages/Auth/login.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un = request.getParameter("user");
		String p = request.getParameter("pass");
		AuthDAO a = new AuthDAO();
		User u = a.check(un, p);
		HttpSession session = request.getSession();
		if(u == null) {
			request.setAttribute("error", "Tên người dùng hoặc mật khẩu bị sai");
			request.getRequestDispatcher("View/Pages/Auth/login.jsp").forward(request, response);
		} else {
			session.setAttribute("data", u);
			if(u.getRole().equals("admin") || u.getRole().equals("teacher")) {
				response.sendRedirect("Admin/dashboard");
			}else {
				response.sendRedirect("trang-chu");
			}
		}
	}

}
