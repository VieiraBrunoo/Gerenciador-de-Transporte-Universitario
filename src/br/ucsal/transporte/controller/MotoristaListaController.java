package br.ucsal.transporte.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.transporte.dao.MotoristaDao;
import br.ucsal.transporte.model.Motorista;

/**
 * Servlet implementation class MotoristaListaController
 */
@WebServlet("/MotoristaListaController")
public class MotoristaListaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String MOTORISTA_EDITADO = "/MotoristaEditado.jsp";
	public static final String EDITAR = "/MotoristaEditar.jsp";
	public static final String lISTA_MOTORISTA = "/table.jsp";

	private MotoristaDao dao;
	private Motorista motorista;

	/**
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @see HttpServlet#HttpServlet()
	 * 
	 */
	public MotoristaListaController() throws InstantiationException, IllegalAccessException {
		dao = new MotoristaDao();
		motorista = new Motorista();

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
			forward = lISTA_MOTORISTA;
			Integer idMotorista = Integer.parseInt(request.getParameter("idMotorista"));
			dao.deletarMotorista(idMotorista);
			request.setAttribute("motoristas", dao.getAllMotorista());
		} else if (action.equalsIgnoreCase("editar")) {
			forward = EDITAR;
			Integer idMotorista = Integer.parseInt(request.getParameter("idMotorista"));
			Motorista motorista = dao.buscarMotoristaId(idMotorista);

			dao.AtualizarMotorista(motorista);
			request.setAttribute("motorista", motorista);
		}

		else {
			forward = lISTA_MOTORISTA;
			request.setAttribute("motoristas", dao.getAllMotorista());
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
		int idMotoristas = Integer.parseInt(request.getParameter("idMotorista"));

		String id = Integer.toString(idMotoristas);
		if (id == null || id.isEmpty()) {
			dao.adicionarMotorista(motorista);
		}

		else {

			motorista.setIdMotorista(Integer.parseInt(id));
			dao.AtualizarMotorista(motorista);
		}

		RequestDispatcher view = request.getRequestDispatcher(MOTORISTA_EDITADO);

		request.setAttribute("motoristas", dao.getAllMotorista());

		view.forward(request, response);

	}

}
