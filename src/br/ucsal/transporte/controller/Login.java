package br.ucsal.transporte.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String lISTA_MOTORISTA = "/index.jsp";
	public static final String ERRO = "/ErroLogin.jsp";

	private ServletConfig config;

	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}

	public Login() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String connectionURL = "jdbc:mysql://localhost:3306/roteiro";
		Connection connection = null;
		ResultSet rs;
		String userName = new String("");
		String passwrd = new String("");
		response.setContentType("text/html");
		try {
			// Load the database driver
			Class.forName("com.mysql.jdbc.Driver");
			// Get a Connection to the database
			connection = DriverManager.getConnection(connectionURL, "root", "admin");
			// Add the data into the database
			String sql = "select usuario,senha from login ";
			Statement s = connection.createStatement();
			s.executeQuery(sql);
			rs = s.getResultSet();
			while (rs.next()) {
				userName = rs.getString("usuario");
				passwrd = rs.getString("senha");
			}
			rs.close();
			s.close();
		} catch (Exception e) {
			System.out.println("Exception is ;" + e);
		}
		if (userName.equals(request.getParameter("user")) && passwrd.equals(request.getParameter("pass"))) {

			RequestDispatcher view = request.getRequestDispatcher(lISTA_MOTORISTA);
			view.forward(request, response);

		} else {

			RequestDispatcher view = request.getRequestDispatcher(ERRO);
			view.forward(request, response);

		}
	}
}
