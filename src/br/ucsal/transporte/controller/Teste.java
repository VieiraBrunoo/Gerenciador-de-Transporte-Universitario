package br.ucsal.transporte.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.transporte.dao.AlunoDao;
import br.ucsal.transporte.model.Aluno;
import br.ucsal.transporte.model.Rota;

/**
 * Servlet implementation class Teste
 */
@WebServlet("/Teste")
public class Teste extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Aluno aluno;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Teste() {
		super();
		aluno = new Aluno();

		// TODO Auto-generated constructor stub
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
		aluno.setEstadoCivil(request.getParameter("estadocivil"));

		AlunoDao dao;
		try {
			dao = new AlunoDao();
			String faculdade = request.getParameter("faculdade");
			String nomes = request.getParameter("nome");
			int rg = Integer.parseInt(request.getParameter("rg"));
			String titulo = request.getParameter("TituloEleitor");
			String data = request.getParameter("dataNascimento");
			String telefone = request.getParameter("telefone");
			String endereco = request.getParameter("endereco");
			String bairro = request.getParameter("bairro");
			String cidade = request.getParameter("cidade");
			String sexo = request.getParameter("sexo");
			String estadoCivil = request.getParameter("estadocivil");
			String turno = request.getParameter("Turno");

			List<Rota> rotas = dao.getAllRotas(faculdade,turno);
			for (Rota rota : rotas) {

				request.setAttribute("idRota", rota.getIdRota());

			}

			request.setAttribute("nome", nomes);
			request.setAttribute("rg", rg);
			request.setAttribute("titulo", titulo);
			request.setAttribute("data", data);
			request.setAttribute("telefone", telefone);
			request.setAttribute("faculdade", faculdade);
			request.setAttribute("endereco", endereco);
			request.setAttribute("bairro", bairro);
			request.setAttribute("cidade", cidade);
			request.setAttribute("sexo", sexo);
			request.setAttribute("estadocivil", estadoCivil);
			request.setAttribute("turno", turno);

			String forward = "AlunoSelecionarRota.jsp";
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);

		} catch (InstantiationException | IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * String faculdade = request.getParameter("faculdade");
		 * request.setAttribute("idRota", faculdade); String forward =
		 * "AlunoSelecionarRota.jsp"; RequestDispatcher view =
		 * request.getRequestDispatcher(forward); view.forward(request,
		 * response);
		 */

	}

}
