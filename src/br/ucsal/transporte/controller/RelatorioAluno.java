package br.ucsal.transporte.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 * Servlet implementation class RelatorioAluno
 */
@WebServlet("/RelatorioAluno")
public class RelatorioAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RelatorioAluno() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Connection getConnection() {
		Connection connection = null;
		try {
			// cria a conexão com o banco de dados
			Class.forName("com.mysql.jdbc.Driver");
			String db = "jdbc:mysql://localhost:3306/roteiro?user=root&password=admin";
			connection = DriverManager.getConnection(db);

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		return connection;

	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletOutputStream servletOutputStream = response.getOutputStream();

		String caminho = "/WEB-INF/Relatorio/";
		String relatorio = caminho + "Alunos.jasper";
		InputStream reportStream = getServletConfig().getServletContext().getResourceAsStream(relatorio);

		ServletContext context = getServletContext();

		try {

			Connection connection = getConnection();

			Map<String, Object> map = new HashMap<>();
			map.put("/WEB-INF/Relatorio/logo black.png", 2020);
			// para gerar o relatorio em PDF
			// o método runReportToPdfStream foi usado
			JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream, map, connection);

			// envia o relatório em formato PDF para o browser
			response.setContentType("application/pdf");
			servletOutputStream.flush();
			servletOutputStream.close();
			if (connection != null)
				connection.close();
		} catch (SQLException ex) {
			Logger.getLogger("global").log(Level.SEVERE, null, ex);
		} catch (JRException e) {
			// display stack trace in the browser
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			e.printStackTrace(printWriter);
			response.setContentType("text/plain");
			response.getOutputStream().print(stringWriter.toString());
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		processRequest(request, response);

	}
}
