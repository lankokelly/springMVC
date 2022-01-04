package Controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.memberDao;
import Model.member;

@WebServlet("/addController")
public class addController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
    
	   
    public addController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*1.接收
		 *2.new member物件 
		 *3.新增到資料庫-->add(Object); 
		 *4.換頁--->ok.html 
		 */
	
		String Name=request.getParameter("name");
		String userName=request.getParameter("username");
		String passWord=request.getParameter("password");
		
		member m=new member(Name,userName,passWord);
		
		new memberDao().add(m);
		
		
		response.sendRedirect("ok.html");
	
	}


}
