package br.ucsal.transporte.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucsal.transporte.dao.AlunoDao;
import br.ucsal.transporte.model.Aluno;
import br.ucsal.transporte.model.Rota;

/**
 * Servlet implementation class AlunoController
 */
@WebServlet("/AlunoController")
public class AlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ALUNO_CADASTRADO = "/AlunoCadastrado.jsp";
	public static final String ALUNO_EXISTE = "/AlunoExiste.jsp";
	private AlunoDao dao;
	private Rota rota;
	private Aluno aluno;

	/**
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @see HttpServlet#HttpServlet()
	 */
	public AlunoController() throws InstantiationException, IllegalAccessException {
		super();
		dao = new AlunoDao();
		aluno = new Aluno();

		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws IOException
	 * @throws ServletException
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

		
		
		
		Aluno aluno = new Aluno();

		String nome = request.getParameter("nome");

		aluno.setNome(nome);

		aluno.setRg(request.getParameter("rg"));
		aluno.setTituloEleitor(request.getParameter("TituloEleitor"));
		aluno.setDataNascimento(request.getParameter("dataNascimento"));
		aluno.setTelefone(request.getParameter("telefone"));
		aluno.setFaculdade(request.getParameter("faculdade"));
		aluno.setEndereco(request.getParameter("endereco"));
		aluno.setBairro(request.getParameter("bairro"));
		aluno.setCidade(request.getParameter("cidade"));
		aluno.setSexo(request.getParameter("sexo"));
		aluno.setEstadoCivil(request.getParameter("estadoCivil"));
		aluno.setIdRota(Integer.parseInt(request.getParameter("idRota")));
		aluno.setTurnoFaculdade(request.getParameter("turno"));

		
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
			String sql = "select Rg from aluno ";
			Statement s = connection.createStatement();
			s.executeQuery(sql);
			rs = s.getResultSet();
			while (rs.next()) {
				userName = rs.getString("Rg");
				
			}
			rs.close();
			s.close();
		} catch (Exception e) {
			System.out.println("Exception is ;" + e);
		}
		if (userName.equals(request.getParameter("rg"))) {

			RequestDispatcher view = request.getRequestDispatcher(ALUNO_EXISTE);
			view.forward(request, response);

		}  else{
		
		
		dao.adicionarAluno(aluno);

		RequestDispatcher view = request.getRequestDispatcher(ALUNO_CADASTRADO);

		view.forward(request, response);

	}
	}
}
