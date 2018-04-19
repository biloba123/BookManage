package servlets;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

public class BaseServlet extends HttpServlet {

	protected HttpSession mSession;
	protected HttpServletRequest mRequest;
	protected HttpServletResponse mResponse;
	
	protected void init(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		response.setContentType("text/html;charset=utf-8");
		mSession=request.getSession();
		mRequest=request;
		mResponse=response;;
	}

	protected void backToIndex(String info)
			throws IOException {
		setErrorInfo(info);
		mResponse.sendRedirect("index.jsp");
	}
	
	
	protected void setErrorInfo(String info) {
		mSession.setAttribute("err", info);
	}
	
	protected void removeErrorInfo() {
		mSession.removeAttribute("error");
	}

	protected boolean isLogined() {
		return mSession.getAttribute("user")!=null;
	}
	
	protected void login(String username) {
		mSession.setAttribute("user", username);
	}
	
	protected void logout() throws IOException {
		mSession.removeAttribute("user");
		mResponse.sendRedirect("index.jsp");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		mSession = null;
		mRequest = null;
		mResponse = null;
	}
}
