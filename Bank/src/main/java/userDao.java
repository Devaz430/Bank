import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;


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
	public boolean register(int eid,String name,String password,String gender,String country,String state,String city,String email,String streetno,
			String phone_num){
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");  
		PreparedStatement st = con.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?,?,?)");
		st.setInt(1,eid);
		 st.setString(2,name);
		 st.setString(3,password);
		 st.setString(4, gender);
		 st.setString(5,country);
		 st.setString(6,state);
		 st.setString(7,city);
		 st.setString(8,email);
		 st.setString(9,streetno);
		 st.setString(10,phone_num);
		 
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
public int generateEid()
{
	int empId=0;
	try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");  
		java.sql.Statement st= con.createStatement();
		ResultSet rs=null;
		
		do {
			 Random rand = new Random();

		        empId= rand.nextInt(10000);
		        //System.out.println("Random Password: "+passwd);
		        
           
            String abc = "select*from employee where eid='" + empId + "' ";//It checks in the database
            rs = st.executeQuery(abc);
            //System.out.println("The Random Account: "+str);
          
        } while(rs.next());
		

}
	catch(Exception e) {System.out.print(e);}
	return empId;
	}

}

