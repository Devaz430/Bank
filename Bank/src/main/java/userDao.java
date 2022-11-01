import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class userDao {

	public loginBean empInfo(String eid)
	{
		loginBean bean=new loginBean();
			try {
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");  
				java.sql.Statement stmt=con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from employee where eid='" +eid+"'");  
						if(rs.next())  
							
							bean.setEid(rs.getString(1));
						    bean.setName(rs.getString(2));
						    bean.setPassword(rs.getString(3));
						
						   
						con.close(); 
				
			}
			catch(Exception e){ System.out.println(e);}      
			return bean;
			}
	public boolean validate(String eid,String password){
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");  
		java.sql.Statement stmt=con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from employee where eid='"
		+eid + "' and password = '" + password +"'");  
		if(rs.next())  
		    return true;
		con.close();  
		}catch(Exception e){ System.out.println(e);}      
		return false; 
		}
	public boolean register(String eid,String name,String password){
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");  
		PreparedStatement st = con.prepareStatement("insert into employee values(?,?,?)");
		st.setString(1,eid);
		 st.setString(2,name);
		 st.setString(3,password);
		 int val = st.executeUpdate();           
		 
		if(val!=0)  
		    return true;
		con.close();  
		}catch(Exception e){ System.out.println(e);}      
		return false;
	}
	public loginBean userInfo(String cid) {
		loginBean bean=new loginBean();
	try {
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");  
		java.sql.Statement stmt=con.createStatement();
		ResultSet rs = stmt.executeQuery("'select * from customer where cust_id='" +cid);  
				if(rs.next())  
					bean.setCid(rs.getString(1));
				bean.setName(rs.getString(2));
				bean.setCid(rs.getString(3));
				con.close(); 
		
		
		
	}
	catch(Exception e){ System.out.println(e);}      
	return bean;
}
	public boolean changePassword(String eid,String password,String npass){
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");  
		java.sql.Statement stmt= con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from employee where eid='"
		+eid + "' and password = '" + password +"'");  
		if(rs.next())  {
			
			 stmt.executeUpdate("update employee set password='"+npass+"' where eid='"+eid+"'");
		    return true;}
		con.close();
		}catch(Exception e){ System.out.println(e);}      
		return false;
		}
	public boolean delete(String eid) {
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");  
			java.sql.Statement stmt=con.createStatement();
			int rs = stmt.executeUpdate("delete from employee where eid='" +eid+"'");  
					if(rs!=0)  
					    return true;
					con.close(); 
			
			
			
		}
		catch(Exception e){ System.out.println(e);}      
		return false;
		}

	}

