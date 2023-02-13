package Client_controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Client_dao.client_dao;
 

/**
 * Servlet implementation class loginController
 */
@WebServlet("/loginController")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 response.setContentType("text/html");
		 PrintWriter pw = response.getWriter();
		 
		 String email = request.getParameter("User_name");
		 String pass = request.getParameter("pass");
		 
		 
		 if(client_dao.userLogin(email, pass))
			{
				pw.print("You have Succesfully Login");
				
				RequestDispatcher rd = request.getRequestDispatcher("home.html");
				rd.forward(request, response);
				
				
			}
			else
			{
				pw.print("Username and PassWord Is wrong");
				
				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.include(request, response);
			}
			
		
	}

}
