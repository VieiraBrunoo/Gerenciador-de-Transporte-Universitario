package br.ucsal.transporte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.transporte.model.Onibus;

import br.ucsal.transporte.util.Conexao;

public class OnibusDao implements IOnibusDao {

	private Connection conn;

	public OnibusDao() {
		conn = Conexao.getConnection();
	}

	@Override
	public void adicionarOnibus(Onibus onibus) {

		try {
			String query = "insert into onibus (Placa, Empresa,Ano_Fabricacao,quantidade_assentos,idMotorista) values (?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, onibus.getPlaca());
			preparedStatement.setString(2, onibus.getEmpresa());
			preparedStatement.setInt(3, onibus.getAnoFabricacao());
			preparedStatement.setInt(4, onibus.getQuantidadeAssentos());
			preparedStatement.setInt(5, onibus.getIdMotorista());
			

			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deletarOnibus(String placa) {
		try {
			String query = "delete from onibus where placa=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, placa);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void AtualizarOnibus(Onibus onibus) {

		try {
			PreparedStatement preparedStatement = Conexao.getConnection().prepareStatement(
					"update onibus set Empresa=?, Ano_Fabricacao=?, quantidade_assentos=?, idMotorista=? where Placa=?");
			// Parameters start with 1
			preparedStatement.setString(1, onibus.getEmpresa());
			preparedStatement.setInt(2, onibus.getAnoFabricacao());
			preparedStatement.setInt(3, onibus.getQuantidadeAssentos());
			preparedStatement.setInt(4, onibus.getIdMotorista());
			preparedStatement.setString(5, onibus.getPlaca());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Onibus> getAllOnibus() {

		List<Onibus> onibus = new ArrayList<Onibus>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from onibus");
			while (resultSet.next()) {
				Onibus buzu = new Onibus();
				buzu.setPlaca(resultSet.getString("Placa"));
				buzu.setEmpresa(resultSet.getString("Empresa"));
				buzu.setAnoFabricacao(resultSet.getInt("Ano_Fabricacao"));
				buzu.setQuantidadeAssentos(resultSet.getInt("quantidade_assentos"));
				buzu.setIdMotorista(resultSet.getInt("idMotorista"));

				onibus.add(buzu);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return onibus;
	}

	@Override
	public Onibus buscarOnibusPlaca(String placa) {

		Onibus onibus = new Onibus();
		try {
			String query = "select * from onibus where Placa=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, placa);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				onibus.setPlaca(resultSet.getString("Placa"));
				onibus.setEmpresa(resultSet.getString("Empresa"));
				onibus.setAnoFabricacao(resultSet.getInt("Ano_Fabricacao"));
				onibus.setQuantidadeAssentos(resultSet.getInt("quantidade_assentos"));
				onibus.setIdMotorista(resultSet.getInt("idMotorista"));

			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return onibus;
	}

}
