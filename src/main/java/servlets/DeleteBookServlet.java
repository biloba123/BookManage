package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Book;
import dao.BookDAO;

/**
 * Servlet implementation class DeleteBookServlet
 */
@WebServlet("/delete-books")
public class DeleteBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		init(request, response);
		if(isLogined()) {
			String books=request.getParameter("books");
			if(books!=null && !books.isEmpty()) {
				BookDAO bookDAO=new BookDAO();
				bookDAO.deleteBooks(books);
				response.sendRedirect("get-books");
			}
		}else {
			backToIndex("请先登录");
		}
	}

}
