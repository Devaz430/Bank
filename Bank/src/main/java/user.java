

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class user extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		
		

		String cid=request.getParameter("cid");
		userDao dao=new userDao();
		loginBean bean=dao.empInfo(cid);
		request.setAttribute("bean", bean);
		
		
		RequestDispatcher rs=request.getRequestDispatcher("displayUser.jsp");
		rs.forward(request, response);
		
	}

	

}
