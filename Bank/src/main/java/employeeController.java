

import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class employeeController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
	
	
		String eid=request.getParameter("eid");
		userDao dao=new userDao();
		loginBean bean=dao.empInfo(eid);
		request.setAttribute("bean", bean);
		
		
		RequestDispatcher rs=request.getRequestDispatcher("displayEmp.jsp");
		rs.forward(request, response);
		
			}}
		
		
	



