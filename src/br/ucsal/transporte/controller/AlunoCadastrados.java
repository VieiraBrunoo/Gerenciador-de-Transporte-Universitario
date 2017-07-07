package br.ucsal.transporte.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.transporte.dao.AlunoDao;

/**
 * Servlet implementation class AlunoCadastrados
 */
@WebServlet("/AlunoCadastrados")
public class AlunoCadastrados extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String TABELA = "/tableAluno.jsp";
	private AlunoDao dao;

	/**
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @see HttpServlet#HttpServlet()
	 */
	public AlunoCadastrados() throws InstantiationException, IllegalAccessException {
		super();
		dao = new AlunoDao();
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

		RequestDispatcher view = request.getRequestDispatcher(TABELA);
		request.setAttribute("alunos", dao.getAllAluno());
		view.forward(request, response);

	}

}
