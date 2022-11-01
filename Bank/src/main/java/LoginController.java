

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
public class LoginController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		
		
		
		String password=request.getParameter("pass");
		String eid=request.getParameter("eid");
		
		
		userDao dao=new userDao();
	boolean bean=dao.validate(eid,password);
		request.setAttribute("bean",bean);
		
		
		
		if(bean){
			RequestDispatcher rd=request.getRequestDispatcher("login-success.jsp");
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
		
	}
	

}
