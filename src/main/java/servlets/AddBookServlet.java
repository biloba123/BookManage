package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Book;
import dao.BookDAO;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/add-book")
public class AddBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		init(request, response);
		if(isLogined()) {
			Book book=new Book(request);
			System.out.println(book.toValues());
			BookDAO bookDAO=new BookDAO();
			bookDAO.addBook(book);
			response.sendRedirect("get-books");
		}else {
			backToIndex("请先登录");
		}
	}
}
