package br.ucsal.transporte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.transporte.model.Aluno;
import br.ucsal.transporte.model.Rota;
import br.ucsal.transporte.util.Conex;

public class AlunoDao implements IAlunoDao {

	private Connection conn;

	public AlunoDao() throws InstantiationException, IllegalAccessException {
		conn = Conex.conectar();

	}

	@Override
	public void adicionarAluno(Aluno aluno) {

		try {
			String query = "insert into aluno (Nome,Rg,Data_Nascimento,Telefone,Endereco,Bairro,Cidade,Sexo,Estado_Civil,id_rota,Titulo_Eleitor,Faculdade,Turno_Faculdade) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, aluno.getNome());
			preparedStatement.setString(2, aluno.getRg());
			preparedStatement.setString(3, aluno.getDataNascimento());
			preparedStatement.setString(4, aluno.getTelefone());
			preparedStatement.setString(5, aluno.getEndereco());
			preparedStatement.setString(6, aluno.getBairro());
			preparedStatement.setString(7, aluno.getCidade());
			preparedStatement.setString(8, aluno.getSexo());
			preparedStatement.setString(9, aluno.getEstadoCivil());
			preparedStatement.setInt(10, aluno.getIdRota());
			preparedStatement.setString(11, aluno.getTituloEleitor());
			preparedStatement.setString(12, aluno.getFaculdade());
			preparedStatement.setString(13, aluno.getTurnoFaculdade());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deletarAluno(Integer idAluno) {

		try {
			String query = "delete from aluno where idaluno=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, idAluno);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void AtualizarAluno(Aluno aluno) {

		try {

			PreparedStatement pstmt = Conex.conectar().prepareStatement(
					"Update aluno SET Nome = ?, Rg = ?, Data_Nascimento = ?, Telefone = ?, Endereco = ?, Bairro = ?, Cidade = ?, Sexo = ?, Titulo_Eleitor = ?, Estado_Civil = ?"
							+ " WHERE idaluno = ? ");
			pstmt.setString(1, aluno.getNome());
			pstmt.setString(2, aluno.getRg());
			pstmt.setString(3, aluno.getDataNascimento());
			pstmt.setString(4, aluno.getTelefone());
			pstmt.setString(5, aluno.getEndereco());
			pstmt.setString(6, aluno.getBairro());
			pstmt.setString(7, aluno.getCidade());
			pstmt.setString(8, aluno.getSexo());
			pstmt.setString(9, aluno.getTituloEleitor());
			pstmt.setString(10, aluno.getEstadoCivil());
			pstmt.setInt(11, aluno.getIdAluno());

			pstmt.execute();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Aluno> getAllAluno() {

		List<Aluno> alunos = new ArrayList<Aluno>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from aluno");
			while (resultSet.next()) {
				Aluno aluno = new Aluno();

				aluno.setIdAluno(resultSet.getInt("idaluno"));
				aluno.setNome(resultSet.getString("Nome"));
				aluno.setRg(resultSet.getString("Rg"));
				aluno.setDataNascimento(resultSet.getString("Data_Nascimento"));
				aluno.setTelefone(resultSet.getString("Telefone"));
				aluno.setEndereco(resultSet.getString("Endereco"));
				aluno.setBairro(resultSet.getString("Bairro"));
				aluno.setCidade(resultSet.getString("Cidade"));
				aluno.setSexo(resultSet.getString("Sexo"));
				aluno.setEstadoCivil(resultSet.getString("Estado_Civil"));
				aluno.setIdRota(resultSet.getInt("id_rota"));
				aluno.setTituloEleitor(resultSet.getString("Titulo_Eleitor"));
				aluno.setFaculdade(resultSet.getString("Faculdade"));
				aluno.setTurnoFaculdade(resultSet.getString("Turno_Faculdade"));
				alunos.add(aluno);

			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alunos;

	}

	@Override
	public Aluno buscarAlunoId(Integer IdAluno) {

		Aluno aluno = new Aluno();

		try {
			String query = "select * from aluno where idaluno=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, IdAluno);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				aluno.setIdAluno(resultSet.getInt("idaluno"));
				aluno.setNome(resultSet.getString("Nome"));
				aluno.setRg(resultSet.getString("Rg"));
				aluno.setDataNascimento(resultSet.getString("Data_Nascimento"));
				aluno.setTelefone(resultSet.getString("Telefone"));
				aluno.setEndereco(resultSet.getString("Endereco"));
				aluno.setBairro(resultSet.getString("Bairro"));
				aluno.setCidade(resultSet.getString("Cidade"));
				aluno.setSexo(resultSet.getString("Sexo"));
				aluno.setEstadoCivil(resultSet.getString("Estado_Civil"));
				aluno.setIdRota(resultSet.getInt("id_rota"));
				aluno.setTituloEleitor(resultSet.getString("Titulo_Eleitor"));
				aluno.setFaculdade(resultSet.getString("Faculdade"));
				aluno.setTurnoFaculdade(resultSet.getString("Turno_Faculdade"));

			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aluno;

	}

	public List<Rota> getAllRotas(String pontoParada,String turno) throws SQLException {

		List<Rota> rotas = new ArrayList<Rota>();

		String sql = "select idrota from rota where Pontos_Parada like '%" + pontoParada + "%' and Turno like '%" + turno + "%'";
		PreparedStatement stmt = this.conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {

			Rota rota = new Rota();

			int id = rs.getInt("idrota");

			rota.setIdRota(id);

			rotas.add(rota);

		}
		return rotas;
		/*
		 * try { Statement statement = conn.createStatement(); ResultSet
		 * resultSet = statement.executeQuery(
		 * "select idrota from rota where Pontos_Parada like '%"+pontoParada+
		 * "'%" ); while( resultSet.next() ) {
		 * 
		 * rot.setIdRota(resultSet.getInt("idrota")); rotas.add(rot); }
		 * resultSet.close(); statement.close(); } catch (SQLException e) {
		 * e.printStackTrace(); } return rotas; }
		 * 
		 * 
		 */

	}

	public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException {

		AlunoDao dao = new AlunoDao();

		List<Rota> rota = dao.getAllRotas("ucsal","Noturno");

		for (Rota rotas : rota) {

			System.out.println(rotas.getIdRota());

		}

	}

}
