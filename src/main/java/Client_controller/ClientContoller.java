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
 * Servlet implementation class ClientContoller
 */
@WebServlet("/ClientContoller")
public class ClientContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClientContoller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String account_id = request.getParameter("account_id");
		String client_name = request.getParameter("client_name");
		String contact_name = request.getParameter("contact_name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");

		client_bio_add ob = new client_bio_add(client_name, contact_name, email, phone, city, state, country);

		int status = client_dao.addEmployee(ob);

		if (status > 0) {
			RequestDispatcher rd = request.getRequestDispatcher("AllClientController");
			 rd.forward(request, response);
			
			System.out.println("Data added Successfully!!!");
		} else {
			pw.print("Something went wrong!!!");
			RequestDispatcher rd = request.getRequestDispatcher("addclient.html");
			rd.include(request, response);
		}

	}

}
