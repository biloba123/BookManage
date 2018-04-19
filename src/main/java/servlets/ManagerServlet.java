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
public class ManagerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		init(request, response);
		String username = request.getParameter("username"), pwd = request.getParameter("password");

		ManagerDAO managerDAO = new ManagerDAO();
		if (managerDAO.check(username, pwd)) {
			removeErrorInfo();
			login(username);
			response.sendRedirect("get-books");
		} else {
			backToIndex("用户名或密码错误");
		}
	}

}
