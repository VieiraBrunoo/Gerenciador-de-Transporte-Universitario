package br.ucsal.transporte.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.transporte.dao.RotaDao;
import br.ucsal.transporte.model.Rota;

@WebServlet("/RotaController")
public class RotaController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private RotaDao dao;

	public static final String LISTA_ROTA = "/RotaCadastrada.jsp";
	public static final String ROTA_EXISTES = "/RotaExiste.jsp";
	public RotaController() {
		dao = new RotaDao();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Rota rota = new Rota();

		rota.setNome(request.getParameter("Nome"));
		rota.setTurno(request.getParameter("Turno"));
		rota.setPontosParada(request.getParameter("Pontos_Parada"));
		rota.setPlacaOnibus(request.getParameter("Placa_Onibus"));
		
			
		

		String connectionURL = "jdbc:mysql://localhost:3306/roteiro";
		Connection connection = null;
		ResultSet rs;
		String userName = new String("");
		
		response.setContentType("text/html");
		try {
			// Load the database driver
			Class.forName("com.mysql.jdbc.Driver");
			// Get a Connection to the database
			connection = DriverManager.getConnection(connectionURL, "root", "admin");
			// Add the data into the database
			String sql = "select Nome_Rota from  rota ";
			Statement s = connection.createStatement();
			s.executeQuery(sql);
			rs = s.getResultSet();
			while (rs.next()) {
				userName = rs.getString("Nome_Rota");
				
			}
			rs.close();
			s.close();
		} catch (Exception e) {
			System.out.println("Exception is ;" + e);
		}
		if (userName.equals(request.getParameter("Nome"))) {

			RequestDispatcher view = request.getRequestDispatcher(ROTA_EXISTES);
			view.forward(request, response);

		}  else{

		dao.adicionarRota(rota);

		RequestDispatcher view = request.getRequestDispatcher(LISTA_ROTA);

		request.setAttribute("rota", rota);

		view.forward(request, response);

	}

}
}
