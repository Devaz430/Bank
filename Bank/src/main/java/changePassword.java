

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class changePassword extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String eid=request.getParameter("eid");
		String password=request.getParameter("pass");
		String npass=request.getParameter("npass");
		String cpass=request.getParameter("cpass");
		userDao dao=new userDao();
		boolean bean=dao.changePassword(eid,password,npass);
		request.setAttribute("bean",bean);
		if(!npass.equals(cpass))
		{
			out.println("The two passwords are different!");
			RequestDispatcher rs=request.getRequestDispatcher("change.jsp");
			rs.forward(request, response);
		}
		
		
		else if(bean)
		{
			
			RequestDispatcher rs=request.getRequestDispatcher("login.jsp");
			rs.forward(request, response);
			out.print("Password is successfully changed");
		}
		else
			out.println("Wrong password or employee id");
		RequestDispatcher rs=request.getRequestDispatcher("change.jsp");
		rs.forward(request, response);
	}

}
