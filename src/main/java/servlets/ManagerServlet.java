package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import beans.Manager;
import dao.ManagerDAO;

/**
 * Servlet implementation class ManagerServlet
 */
@WebServlet("/check-account")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username"), pwd = request.getParameter("password");

		ManagerDAO managerDAO = new ManagerDAO();
		HttpSession session = request.getSession();
		if (managerDAO.check(username, pwd)) {
			session.removeAttribute("err");
			response.sendRedirect("BookServlet");
		} else {
			session.setAttribute("err", "用户名或密码错误");
			response.sendRedirect("index.jsp");
		}
	}

}
