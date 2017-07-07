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

import br.ucsal.transporte.dao.MotoristaDao;
import br.ucsal.transporte.dao.OnibusDao;
import br.ucsal.transporte.model.Onibus;

@WebServlet("/OnibusController")
public class OnibusController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private OnibusDao dao;
	private MotoristaDao mdao;

	public static final String lISTA_ONIBUS = "/OnibusCadastrado.jsp";
	public static final String EDITAR = "/OnibusEditar.jsp";
	public static final String ONIBUS_EXISTE = "/OnibusExiste.jsp";

	public OnibusController() {
		dao = new OnibusDao();

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

		Onibus onibus = new Onibus();
		onibus.setPlaca(request.getParameter("placa"));
		onibus.setEmpresa(request.getParameter("empresa"));
		onibus.setAnoFabricacao(Integer.parseInt(request.getParameter("anoFabricacao")));
		onibus.setQuantidadeAssentos(Integer.parseInt(request.getParameter("quantidadeAssentos")));
		onibus.setIdMotorista(Integer.parseInt(request.getParameter("idMotorista")));
		
		
		
		
		
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
			String sql = "select Placa from  onibus ";
			Statement s = connection.createStatement();
			s.executeQuery(sql);
			rs = s.getResultSet();
			while (rs.next()) {
				userName = rs.getString("Placa");
				
			}
			rs.close();
			s.close();
		} catch (Exception e) {
			System.out.println("Exception is ;" + e);
		}
		if (userName.equals(request.getParameter("placa"))) {

			RequestDispatcher view = request.getRequestDispatcher(ONIBUS_EXISTE);
			view.forward(request, response);

		}  else{
		


			dao.adicionarOnibus(onibus);
		

		RequestDispatcher view = request.getRequestDispatcher(lISTA_ONIBUS);

		request.setAttribute("onibus", onibus);

		view.forward(request, response);

	}
}
}
