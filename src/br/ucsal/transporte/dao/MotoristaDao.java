package br.ucsal.transporte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.transporte.model.Motorista;
import br.ucsal.transporte.util.Conex;
import br.ucsal.transporte.util.Conexao;

public class MotoristaDao implements IMotoristaDao {

	private Connection conn;

	public MotoristaDao() throws InstantiationException, IllegalAccessException {
		conn = Conex.conectar();
	}

	@Override
	public void adicionarMotorista(Motorista motorista) {

		try {
			String query = "insert into motorista (Nome, Numero_Habilitacao,Telefone,Endereco,Bairro,Cidade,Sexo,CPF,Estado_Civil,Data_Nascimento ) values (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, motorista.getNome());
			preparedStatement.setString(2, motorista.getHabilitacao());
			preparedStatement.setString(3, motorista.getTelefone());
			preparedStatement.setString(4, motorista.getEndereco());
			preparedStatement.setString(5, motorista.getBairro());
			preparedStatement.setString(6, motorista.getCidade());
			preparedStatement.setString(7, motorista.getSexo());
			preparedStatement.setString(8, motorista.getCpf());
			preparedStatement.setString(9, motorista.getEstadoCivil());
			preparedStatement.setString(10, motorista.getDataNascimento());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deletarMotorista(Integer idMotorista) {

		try {
			String query = "delete from motorista where idMotorista=?";
			PreparedStatement preparedStatement = Conexao.getConnection().prepareStatement(query);
			preparedStatement.setInt(1, idMotorista);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void AtualizarMotorista(Motorista motorista) {

		try {

			PreparedStatement pstmt = Conex.conectar().prepareStatement(
					"Update motorista SET Nome = ?, Numero_Habilitacao = ?, Telefone = ?, Endereco = ?, Bairro = ?, Cidade = ?, Sexo = ?, CPF = ?, Estado_Civil = ?, Data_Nascimento = ?"
							+ " WHERE idMotorista = ? ");
			pstmt.setString(1, motorista.getNome());
			pstmt.setString(2, motorista.getHabilitacao());
			pstmt.setString(3, motorista.getTelefone());
			pstmt.setString(4, motorista.getEndereco());
			pstmt.setString(5, motorista.getBairro());
			pstmt.setString(6, motorista.getCidade());
			pstmt.setString(7, motorista.getSexo());
			pstmt.setString(8, motorista.getCpf());
			pstmt.setString(9, motorista.getEstadoCivil());
			pstmt.setString(10, motorista.getDataNascimento());
			pstmt.setInt(11, motorista.getIdMotorista());

			pstmt.execute();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Motorista> getAllMotorista() {
		List<Motorista> motoristas = new ArrayList<Motorista>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from motorista");
			while (resultSet.next()) {
				Motorista motorista = new Motorista();
				motorista.setIdMotorista(resultSet.getInt("idMotorista"));
				motorista.setNome(resultSet.getString("Nome"));
				motorista.setHabilitacao(resultSet.getString("Numero_Habilitacao"));
				motorista.setTelefone(resultSet.getString("Telefone"));
				motorista.setEndereco(resultSet.getString("Endereco"));
				motorista.setBairro(resultSet.getString("Bairro"));
				motorista.setCidade(resultSet.getString("Cidade"));
				motorista.setSexo(resultSet.getString("Sexo"));
				motorista.setCpf(resultSet.getString("CPF"));
				motorista.setEstadoCivil(resultSet.getString("Estado_Civil"));
				motorista.setDataNascimento(resultSet.getString("Data_Nascimento"));

				motoristas.add(motorista);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return motoristas;

	}

	public List<Motorista> getAllNomesMotorista() {

		List<Motorista> nomesmotoristas = new ArrayList<Motorista>();
		try {

			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("select nome  from motorista");

			while (resultSet.next()) {

				Motorista motorista = new Motorista();
				motorista.setNome(resultSet.getString("Nome"));

				nomesmotoristas.add(motorista);

			}

			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nomesmotoristas;

	}

	@Override
	public Motorista buscarMotoristaId(Integer IdMotorista) {
		Motorista motorista = new Motorista();
		try {
			String query = "select * from motorista where idMotorista=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, IdMotorista);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				motorista.setIdMotorista(resultSet.getInt("idMotorista"));
				motorista.setNome(resultSet.getString("Nome"));
				motorista.setHabilitacao(resultSet.getString("Numero_Habilitacao"));
				motorista.setTelefone(resultSet.getString("Telefone"));
				motorista.setEndereco(resultSet.getString("Endereco"));
				motorista.setBairro(resultSet.getString("Bairro"));
				motorista.setCidade(resultSet.getString("Cidade"));
				motorista.setSexo(resultSet.getString("Sexo"));
				motorista.setCpf(resultSet.getString("CPF"));
				motorista.setEstadoCivil(resultSet.getString("Estado_Civil"));
				motorista.setDataNascimento(resultSet.getString("Data_Nascimento"));

			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return motorista;
	}

}
