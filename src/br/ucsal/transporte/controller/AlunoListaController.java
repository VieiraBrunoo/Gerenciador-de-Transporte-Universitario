package br.ucsal.transporte.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.transporte.dao.AlunoDao;
import br.ucsal.transporte.model.Aluno;

/**
 * Servlet implementation class AlunoListaController
 */
@WebServlet("/AlunoListaController")
public class AlunoListaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ALUNO_EDITADO = "/AlunoEditado.jsp";
	public static final String EDITAR = "/AlunoEditar.jsp";
	public static final String lISTA_ALUNO = "/tableAluno.jsp";
	private AlunoDao dao;
	private Aluno aluno;

	/**
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @see HttpServlet#HttpServlet()
	 */
	public AlunoListaController() throws InstantiationException, IllegalAccessException {
		super();
		dao = new AlunoDao();
		aluno = new Aluno();
		// TODO Auto-generated constructor stub
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
			forward = lISTA_ALUNO;
			Integer idAluno = Integer.parseInt(request.getParameter("idAluno"));
			dao.deletarAluno(idAluno);
			request.setAttribute("alunos", dao.getAllAluno());
		} else if (action.equalsIgnoreCase("editar")) {
			forward = EDITAR;
			Integer idAluno = Integer.parseInt(request.getParameter("idAluno"));
			Aluno aluno = dao.buscarAlunoId(idAluno);

			dao.AtualizarAluno(aluno);
			request.setAttribute("aluno", aluno);
		}

		else {
			forward = lISTA_ALUNO;
			request.setAttribute("alunos", dao.getAllAluno());
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

		String nome = request.getParameter("nome");

		aluno.setNome(nome);

		aluno.setRg(request.getParameter("rg"));
		aluno.setTituloEleitor(request.getParameter("TituloEleitor"));
		aluno.setDataNascimento(request.getParameter("dataNascimento"));
		aluno.setTelefone(request.getParameter("telefone"));
		aluno.setEndereco(request.getParameter("endereco"));
		aluno.setBairro(request.getParameter("bairro"));
		aluno.setCidade(request.getParameter("cidade"));
		aluno.setSexo(request.getParameter("sexo"));
		aluno.setEstadoCivil(request.getParameter("estadoCivil"));

		int idAluno = Integer.parseInt(request.getParameter("idAluno"));

		String id = Integer.toString(idAluno);

		if (id == null || id.isEmpty()) {
			dao.adicionarAluno(aluno);
		}

		else {

			aluno.setIdAluno(Integer.parseInt(id));
			dao.AtualizarAluno(aluno);
		}

		RequestDispatcher view = request.getRequestDispatcher(ALUNO_EDITADO);

		request.setAttribute("alunos", dao.getAllAluno());

		view.forward(request, response);

	}

}
