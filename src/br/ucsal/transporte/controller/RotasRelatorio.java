package br.ucsal.transporte.controller;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/RotasRelatorio")
public class RotasRelatorio extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		String relatorio = caminho + "Rota.jasper";
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}