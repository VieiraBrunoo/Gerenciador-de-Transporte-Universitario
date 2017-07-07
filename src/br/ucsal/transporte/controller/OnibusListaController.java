package br.ucsal.transporte.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.transporte.dao.OnibusDao;
import br.ucsal.transporte.model.Onibus;

@WebServlet("/OnibusListaController")
public class OnibusListaController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String ONIBUS_EDITADO = "/OnibusEditado.jsp";
	public static final String EDITAR = "/OnibusEditar.jsp";
	public static final String LISTA_ONIBUS = "/tableOnibus.jsp";

	private OnibusDao dao;
	private Onibus onibus;

	/**
	 * @see HttpServlet#HttpServlet()
	 * 
	 */
	public OnibusListaController() {
		dao = new OnibusDao();
		onibus = new Onibus();

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
			forward = LISTA_ONIBUS;
			String placa = (request.getParameter("placa"));
			dao.deletarOnibus(placa);
			request.setAttribute("onibus", dao.getAllOnibus());
		} else if (action.equalsIgnoreCase("editar")) {
			forward = EDITAR;
			String placa = (request.getParameter("placa"));
			Onibus onibus = dao.buscarOnibusPlaca(placa);
			request.setAttribute("onibus", onibus);

			dao.AtualizarOnibus(onibus);

			request.setAttribute("onibus", onibus);
			;
		}

		else {
			forward = LISTA_ONIBUS;
			request.setAttribute("onibus", dao.getAllOnibus());
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

		Onibus onibus = new Onibus();
		onibus.setPlaca(request.getParameter("placa"));
		onibus.setEmpresa(request.getParameter("empresa"));
		onibus.setAnoFabricacao(Integer.parseInt(request.getParameter("anoFabricacao")));
		onibus.setQuantidadeAssentos(Integer.parseInt(request.getParameter("quantidadeAssentos")));
		onibus.setIdMotorista(Integer.parseInt(request.getParameter("idMotorista")));

		onibus.setPlaca(request.getParameter("placa"));
		dao.AtualizarOnibus(onibus);

		RequestDispatcher view = request.getRequestDispatcher(ONIBUS_EDITADO);

		request.setAttribute("onibus", dao.getAllOnibus());

		view.forward(request, response);

	}

}
