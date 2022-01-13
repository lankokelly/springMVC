package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.memberDao;
import Model.member;


@WebServlet("/AddMemberController")
public class AddMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddMemberController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*1.接收-->username
		 *2.判斷帳號是否重複-->query(帳號)
		 *3.true-->重複--->addMemberError.jsp
		 *4.false->無此帳號-->接收所有資料-->new member-->add(m);-->addMemberSuccess.jsp 
		 */
		request.setCharacterEncoding("big5");
		String Username=request.getParameter("username");
		
		if(new memberDao().query(Username))
		{
			response.sendRedirect("addMemberError.jsp");
		}
		else
		{
			String Name=request.getParameter("name");
			String Password=request.getParameter("password");
			String Address=request.getParameter("address");
			String Phone=request.getParameter("phone");
			String Mobile=request.getParameter("mobile");
			
			member m=new member(Name,Username,Password,Address,Phone,Mobile);
			
			new memberDao().add(m);
			
			response.sendRedirect("addMemberSuccess.jsp");
			
			
			
		}
	}

}
