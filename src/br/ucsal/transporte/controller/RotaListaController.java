package br.ucsal.transporte.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.transporte.dao.RotaDao;
import br.ucsal.transporte.model.Rota;

@WebServlet("/RotaListaController")
public class RotaListaController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String ROTA_EDITADA = "/RotaEditada.jsp";
	public static final String EDITAR = "/RotaEditar.jsp";
	public static final String LISTA_ROTA = "/tableRota.jsp";

	private RotaDao dao;
	private Rota rota;

	/**
	 * @see HttpServlet#HttpServlet()
	 * 
	 */
	public RotaListaController() {
		dao = new RotaDao();
		rota = new Rota();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("delete")) {
			forward = LISTA_ROTA;
			Integer idRota = Integer.parseInt(request.getParameter("idRota"));
			dao.deletarRota(idRota);
			request.setAttribute("rotas", dao.getAllRota());
		} else if (action.equalsIgnoreCase("editar")) {
			forward = EDITAR;
			Integer idRota = Integer.parseInt(request.getParameter("idRota"));
			Rota rota = dao.buscarRotaId(idRota);
			request.setAttribute("rota", rota);
		}

		else {
			forward = LISTA_ROTA;
			request.setAttribute("rotas", dao.getAllRota());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);

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

		rota.setIdRota(Integer.parseInt(request.getParameter("idRota")));
		dao.AtualizarRota(rota);

		RequestDispatcher view = request.getRequestDispatcher(ROTA_EDITADA);

		request.setAttribute("rotas", dao.getAllRota());

		view.forward(request, response);

	}

}
