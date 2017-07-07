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
import br.ucsal.transporte.model.Motorista;

/**
 * Servlet implementation class MotoristaController
 */
@WebServlet("/MotoristaController")
public class MotoristaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MotoristaDao dao;

	public static final String MOTORISTA_CADASTRADO = "/MotoristaCadastrado.jsp";
	public static final String MOTORISTA_EXISTE = "/MotoristaExiste.jsp";

	public MotoristaController() throws InstantiationException, IllegalAccessException {
		dao = new MotoristaDao();

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

		Motorista motorista = new Motorista();
		motorista.setNome(request.getParameter("nome"));
		motorista.setHabilitacao(request.getParameter("numeroHabilitacao"));
		motorista.setTelefone(request.getParameter("telefone"));
		motorista.setEndereco(request.getParameter("endereco"));
		motorista.setBairro(request.getParameter("bairro"));
		motorista.setCidade(request.getParameter("cidade"));
		motorista.setSexo(request.getParameter("sexo"));
		motorista.setCpf(request.getParameter("cpf"));
		motorista.setEstadoCivil(request.getParameter("estadocivil"));
		motorista.setDataNascimento(request.getParameter("dataNascimento"));
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
			String sql = "select CPF from  motorista ";
			Statement s = connection.createStatement();
			s.executeQuery(sql);
			rs = s.getResultSet();
			while (rs.next()) {
				userName = rs.getString("CPF");
				
			}
			rs.close();
			s.close();
		} catch (Exception e) {
			System.out.println("Exception is ;" + e);
		}
		if (userName.equals(request.getParameter("cpf"))) {

			RequestDispatcher view = request.getRequestDispatcher(MOTORISTA_EXISTE);
			view.forward(request, response);

		}  else{
		
		
		
		

		dao.adicionarMotorista(motorista);

		RequestDispatcher view = request.getRequestDispatcher(MOTORISTA_CADASTRADO);

		view.forward(request, response);

	}
	}
}

