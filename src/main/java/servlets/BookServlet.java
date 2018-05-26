package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Book;
import dao.BookDAO;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/get-books")
public class BookServlet extends BaseServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		init(request, response);
		// 判断是否登录
		if (isLogined()) {
			BookDAO bDao = new BookDAO();
			List<Book> books = bDao.getAllBooks();

			mSession.setAttribute("books", books);
			mResponse.sendRedirect("book-list.jsp");
		} else {
			backToIndex("请先登录");
		}
	}

}
