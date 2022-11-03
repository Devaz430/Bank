

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

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		userDao dao=new userDao();
		int eid=dao.generateEid();
		String name=request.getParameter("name");
		String password=request.getParameter("pass");
		String country=request.getParameter("country");
		String state=request.getParameter("state");
		String city=request.getParameter("city");
		String phone_num=request.getParameter("phone_num");
		String email=request.getParameter("email");
		String streetno=request.getParameter("streetno");
		String gender=request.getParameter("gender");
		
	boolean bean=dao.register(eid,name,password,gender,country,state,city,email,streetno,phone_num);
		request.setAttribute("bean",bean);
		
		
		
		if(bean){
			RequestDispatcher rd=request.getRequestDispatcher("register-success.jsp");
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
		}
		
		}
	}
    