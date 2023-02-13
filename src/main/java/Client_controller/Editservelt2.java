package Client_controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Client_bio.client_bio_add;
import Client_dao.client_dao;

/**
 * Servlet implementation class Editservelt2
 */
@WebServlet("/Editservelt2")
public class Editservelt2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Editservelt2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String id = request.getParameter("id");

		int eid = Integer.parseInt(id);

		client_bio_add eb = client_dao.getEmployeeById(eid);

		pw.print("<link rel='stylesheet' href='css/addClient.css'>");

		pw.print("<link rel='stylesheet' href='css/table.css'>");

		pw.print("<body>");

		pw.print("<div class='signupFrm'>");

		pw.print("<form  action='updateController' method='get'  class='form' > ");

		pw.print("<table>");
		pw.print("<div class='inputContainer'>");

		/*
		 * pw.
		 * print("<tr><td>CLIENT NAME: </td> <td> <input type='text' name='account_id' value='"
		 * +eb.getClient_name()+"'/></td></tr>");
		 * pw.print(" <label for=' ' class='label'> Client Name</label> ");
		 * 
		 */

		pw.print("<tr><td>ACCOUNT ID : </td> <td> <input type='hidden' name='account_id' value='" + eb.getAccount_id()
				+ "'/></td></tr>");
		pw.print("<tr><td> CLIENT NAME :</td> <td><input type='text'  name='client_name'  value='" + eb.getClient_name()
				+ "'/></td></tr>");
		pw.print("<tr><td>CONTACT NAME : </td> <td><input type='text'  name='contact_name'  value='"
				+ eb.getContact_name() + "'/></td></tr>");
		pw.print(
				"<tr><td>EMAIL : </td> <td><input type='text'  name='email' value='" + eb.getEmail() + "'/></td></tr>");
		pw.print("<tr><td>PHONE :</td> <td><input type='text'  name='phone' value='" + eb.getPhone() + "'/></td></tr>");
		pw.print("<tr><td>CITY : </td> <td><input type='text'  name='city' value='" + eb.getCity() + "'/></td></tr>");
		pw.print(
				"<tr><td>STATE : </td> <td><input type='text'  name='state' value='" + eb.getState() + "'/></td></tr>");
		pw.print("<tr><td>COUNTRY : </td> <td><input type='text'  name='country' value='" + eb.getCountry()
				+ "'/></td></tr>");

		pw.print("</div>");

		pw.print("</table>");

		pw.print("<tr><td><input  class='submitBtn'  type='submit' value='Update '/></td></tr>");

		pw.print("</form>");

		pw.print("</div>");

		pw.print("<body>");
	}

}
