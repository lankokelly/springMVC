package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.memberDao;

//@WebServlet("/LoginController")
public class LoginController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public LoginController() {
		super();
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*1.±µ¦¬
		 *2.query(±b¸¹,±K½X)
		 *3.true--->loginSuccess.jsp
		 *4.false--->loginEror.jsp 
		 */
		
		String Username=request.getParameter("username");
		String Password=request.getParameter("password");
		
		if (new memberDao().query(Username, Password)) {
			response.sendRedirect("loginSuccess.jsp");
		} else {
			response.sendRedirect("loginError.jsp");
		}
	}

}
