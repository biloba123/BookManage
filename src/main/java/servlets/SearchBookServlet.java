package servlets;

import java.io.IOException;
import java.util.List;

import com.mysql.jdbc.StringUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Book;
import dao.BookDAO;

/**
 * Servlet implementation class SearchBookServlet
 */
@WebServlet("/search-book")
public class SearchBookServlet extends  BaseServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		init(request, response);
		if(isLogined()) {
			String searchType=request.getParameter("search-type");
			String text=request.getParameter("text");
			if(!StringUtils.isNullOrEmpty(searchType) && text!=null) {
				BookDAO bookDAO=new BookDAO();
				List<Book> books=null;
				if(searchType.equals("price") || searchType.equals("publishTime")){
					if(text.contains("~")) {
						String[] vals=text.split("~");
						if(searchType.equals("price")) {
							books=bookDAO.queryByRange(searchType, Float.valueOf(vals[0]), Float.valueOf(vals[1]));
						}else {
							books=bookDAO.queryByRange(searchType, vals[0], vals[1]);
						}
					}
				}else {
					books=bookDAO.queryBy(searchType, text);
				}
				
				mSession.setAttribute("books", books);
			}
			
			mResponse.sendRedirect("book-list.jsp");
		}else {
			backToIndex("请先登录");
		}
	}

}
