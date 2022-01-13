package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.memberDao;
import Model.member;


@WebServlet("/updateController")
public class updateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public updateController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 *1.接收
		 *2.轉型
		 *3.update
		 *4.回到update.jsp 
		 */
		
		// 接收
		request.setCharacterEncoding("utf-8");
		String Name = request.getParameter("name");
		String Id = request.getParameter("id");
		// 轉型
		int ID = Integer.parseInt(Id);
		new memberDao().update(Name,ID);

		response.sendRedirect("update.jsp");
	}


}
