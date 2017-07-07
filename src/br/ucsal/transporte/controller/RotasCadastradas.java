package br.ucsal.transporte.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.transporte.dao.RotaDao;

/**
 * Servlet implementation class RotasCadastradas
 */
@WebServlet("/RotasCadastradas")
public class RotasCadastradas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String TABELA = "/tableRota.jsp";
	private RotaDao dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RotasCadastradas() {

		dao = new RotaDao();

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
		request.setAttribute("rotas", dao.getAllRota());
		view.forward(request, response);

	}

}
