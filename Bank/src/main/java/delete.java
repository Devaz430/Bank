


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class delete extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String eid=request.getParameter("eid");
		userDao dao=new userDao();
		boolean bean=dao.delete(eid);
		request.setAttribute("bean", bean);
		
		
		if(bean)
		{
			out.println("Successfully deleted");
			response.sendRedirect("login-success.jsp");
		}
		else
		{
			out.println("Try again");
			response.sendRedirect("deleteEmployee.jsp");
		}
			
		
	}

}
