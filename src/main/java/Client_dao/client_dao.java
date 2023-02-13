package Client_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Client_bio.client_bio;
import Client_bio.client_bio_add;
 
public class client_dao 
{

	 public static Connection getConnection()
	 {
		 Connection con =null;
		 
		 try {

				// String url =""; // "jdbc:mysql://localhost:3306/sep", "root", "9545"
				// String Username = "";
				// String password = "";
				
				 Class.forName("com.mysql.cj.jdbc.Driver");

				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientmanagement", "root", "9545");

			} catch (Exception e) 
			{
	                  System.out.println("Error"+e);
			}
			return con;
		}
	 
	 // Signup 
	 
	 public static int signup( client_bio em)
		{
			int status=0;
			
			try
			{
			   Connection con = client_dao.getConnection();
			   
			   String sql = "insert into signup(name,email,phone,pass) values(?,?,?,?)";
			   
			   PreparedStatement ps = con.prepareStatement(sql);
			   
			   ps.setString(1, em.getName());
			   ps.setString(2, em.getEmail());
			   ps.setString(3, em.getPhone());
			   ps.setString(4, em.getPass());
			   
			   status = ps.executeUpdate(); 
			   
			   
			   
			}
			catch(Exception e)
			{
			    System.out.println("Error ==="+e);	
			}
			
			return status;
			
		}
	 
	 // login 
	 
	 public static boolean userLogin(String email,String pass)
		{
			boolean status =false;
			try
			{
			    Connection con = client_dao.getConnection();
			    
			    String sql = "Select * from signup where email=? and  pass=?";
			    
			    PreparedStatement ps = con.prepareStatement(sql);
			    
			    ps.setString(1, email);
			    ps.setString(2, pass);
			    
			    ResultSet rs = ps.executeQuery();
			    
			    status= rs.next();
			
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			return status;
			
		}
		
	 // addemployee
	 
	 public static int addEmployee(client_bio_add em)
		{
			 int status = 0;
			 
			 
			Connection con = client_dao.getConnection();
			
			String query = "Insert into addclient(client_name,contact_name,email,phone,city,state,country) Values(?,?,?,?,?,?,?)";
			
			try 
			{
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, em.getClient_name());
				ps.setString(2, em.getContact_name());
				ps.setString(3, em.getEmail());
				ps.setString(4, em.getPhone());
				ps.setString(5, em.getCity());
				ps.setString(6, em.getState());
				ps.setString(7, em.getCountry());
				
				
		          status = ps.executeUpdate();
				
			} 
			catch (Exception e) {
				 
				System.out.println("Error :"+e);
			}
			 
			return status;
			 
			
		}
	 
	 // get all client 
	 
	 public static List getAllClient()
		{
			List<client_bio_add> list = new ArrayList<client_bio_add>();
			
			try
			{
				Connection con = client_dao.getConnection();
				PreparedStatement ps = con.prepareStatement("Select * from addclient");
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next())
				{
					client_bio_add eb = new client_bio_add();
					
					eb.setAccount_id(rs.getInt(1));
					eb.setClient_name(rs.getNString(2));
					eb.setContact_name(rs.getString(3));
					eb.setEmail(rs.getString(4));
					eb.setPhone(rs.getString(5));
					eb.setCity(rs.getString(6));
					eb.setState(rs.getString(7));
					eb.setCountry(rs.getString(8));
					 
					list.add(eb);
				}
			}
			catch(Exception e)
			{
				
			}
			return list;
		}
	  
// //////////////
	 
	 public static client_bio_add getEmployeeById(int id)
		{
		 client_bio_add eb = new client_bio_add();
			
			try
			{
				Connection con = client_dao.getConnection();
				
				String query = "select * from addclient where account_id=?";
				PreparedStatement ps = con.prepareStatement(query);
				
				ps.setInt(1, id);
				
				ResultSet rs = ps.executeQuery();
				
				if(rs.next())
				{
					eb.setAccount_id(rs.getInt(1));
					eb.setClient_name(rs.getNString(2));
					eb.setContact_name(rs.getString(3));
					eb.setEmail(rs.getString(4));
					eb.setPhone(rs.getString(5));
					eb.setCity(rs.getString(6));
					eb.setState(rs.getString(7));
					eb.setCountry(rs.getString(8));
				}
			}
			catch(Exception e)
			{
				System.out.println("Error occure ::"+e);
			}
			return eb;
			
		}
		
		// Update 
		public static int Update(client_bio_add em)
		{
			int status =0;
			
			try
			{
				Connection con = client_dao.getConnection();
				
				String query ="Update addclient set client_name=?,contact_name=?,email=?,phone=?,city=?,state=?,country=? where account_id=?";
				
				PreparedStatement ps = con.prepareStatement(query);
				
				ps.setString(1, em.getClient_name());
				ps.setString(2, em.getContact_name());
				ps.setString(3, em.getEmail());
				ps.setString(4, em.getPhone());
				ps.setString(5, em.getCity());
				ps.setString(6, em.getState());
				ps.setString(7, em.getCountry());
				
				 ps.setInt(8, em.getAccount_id());
				
				status = ps.executeUpdate();
				
				
			}
			catch(Exception e)
			{
				System.out.println("Error ::"+e);
			}
			return status;	
			
		}
		
	public static int delete(int id) {
			
			int status=0;
			  try {
			
				  Connection con=client_dao.getConnection();
				  String query="Delete from addclient where account_id =?";
				  PreparedStatement ps=con.prepareStatement(query);
				  ps.setInt(1, id);
				  status=ps.executeUpdate();
				  
			} catch (Exception e) {
			
				   System.out.println(e);
			}
			
			return status;
			
		}
}
