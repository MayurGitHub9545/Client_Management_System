package Client_controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Client_bio.client_bio_add;
import Client_dao.client_dao;
 
 

/**
 * Servlet implementation class AllClientController
 */
@WebServlet("/AllClientController")
public class AllClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllClientController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 response.setContentType("text/html");
		 PrintWriter pw = response.getWriter();
		 
		 pw.print("<link rel='stylesheet' href='css/table.css'>");
		 
		// System.out.println("Update operation is successfully");
		 
		 
		 
		 pw.print("<body  style=\"background-color:white;\"  >");
		   
		 pw.print("<table border='1px' width='100%'> ");
		 
		 
		 pw.print("<tr> <th> ACCOUNT ID </th> <th> CLIENT NAME  </th> <th> CONTACT NAME </th> <th> EMAIL</th> <th> PHONE </th> <th> CITY </th> <th> STATE </th> <th> COUNTRY </th><th> ACTIONS</th>  <th> ACTIONS </th></tr>");
		
	 List<client_bio_add> list=  client_dao.getAllClient();
	 
	 for(client_bio_add eb:list) 
	  {
		  
        pw.print("<tr><td>"+eb.getAccount_id()+"</td><td>"+eb.getClient_name()+"</td><td>"+eb.getContact_name()+"</td><td>"+eb.getEmail()+"</td><td>"+eb.getPhone()+"</td><td>"+eb.getCity()+"</td><td>"+eb.getState()+"</td><td>"+eb.getCountry()+"</td><td>"+"<a style=\"color: green;\" href='Editservelt2?id="+eb.getAccount_id()+"'> edit </a></td> <td><a style=\"color: red;\" href='DeleteServlet?id="+eb.getAccount_id()+"'>delete </a></td></tr>"); 
		  
	  }
	   
	  pw.print("</table>");
	  
	  pw.print( " <h2><link rel='stylesheet' href='css/table.css'>    <a style=\"text-decoration: none\" href='home.html'>Back</a> </h2>");
	  
	  pw.print("</body>");
}

}
