package Client_controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Client_bio.client_bio_add;
import Client_dao.client_dao;
 

/**
 * Servlet implementation class updateController
 */
@WebServlet("/updateController")
public class updateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		int account_id = Integer.parseInt(request.getParameter("account_id"));
		
		String client_name = request.getParameter("client_name");
		String contact_name = request.getParameter("contact_name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		 
		 /*
		  String account_id = request.getParameter("account_id");
		String client_name = request.getParameter("client_name");
		String contact_name = request.getParameter("contact_name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		*/
		 
		 client_bio_add eb = new client_bio_add();
		 
		 
		 eb.setAccount_id(account_id);
		 eb.setClient_name(client_name);
		 eb.setContact_name(contact_name);
		 eb.setEmail(email);
		 eb.setPhone(phone);
		 eb.setCity(city);
		 eb.setState(state);
		 eb.setCountry(country);
		 
		 int status = client_dao.Update(eb);
		 
		 System.out.println("updatedController:");
		 
		 if(status>0) {
			 
			 System.out.println("Data updated");
      	   
       	  RequestDispatcher rd=request.getRequestDispatcher("AllClientController");
       	    rd.forward(request, response);
       	    
         }
	}

}
