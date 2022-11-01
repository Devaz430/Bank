

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RegisterController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		
		String eid=request.getParameter("eid");
		String name=request.getParameter("name");
		String password=request.getParameter("apass");
		
		userDao dao=new userDao();
	boolean bean=dao.register(eid,name,password);
		request.setAttribute("bean",bean);
		
		
		
		if(bean){
			RequestDispatcher rd=request.getRequestDispatcher("register-success.jsp");
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
		}
		
		
	}}
    