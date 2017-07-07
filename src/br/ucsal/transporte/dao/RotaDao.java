package br.ucsal.transporte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.transporte.model.Rota;

import br.ucsal.transporte.util.Conex;
import br.ucsal.transporte.util.Conexao;

public class RotaDao implements IRota {

	private Connection conn;

	public RotaDao() {
		conn = Conexao.getConnection();
	}

	@Override
	public void adicionarRota(Rota rota) {

		try {
			String query = "insert into rota (Nome_Rota, Turno, Pontos_Parada, Placa_Onibus) values (?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, rota.getNome());
			preparedStatement.setString(2, rota.getTurno());
			preparedStatement.setString(3, rota.getPontosParada());
			preparedStatement.setString(4, rota.getPlacaOnibus());

			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deletarRota(Integer idRota) {
		try {
			String query = "delete from rota where idRota=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, idRota);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void AtualizarRota(Rota rota) {

		try {

			PreparedStatement pstmt = Conex.conectar().prepareStatement(
					"Update rota SET Nome_Rota = ?, Turno = ?, Pontos_Parada = ?, Placa_Onibus = ? where idRota=?");
			pstmt.setString(1, rota.getNome());
			pstmt.setString(2, rota.getTurno());
			pstmt.setString(3, rota.getPontosParada());
			pstmt.setString(4, rota.getPlacaOnibus());
			pstmt.setInt(5, rota.getIdRota());

			pstmt.execute();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Rota> getAllRota() {
		List<Rota> rotas = new ArrayList<Rota>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from rota");
			while (resultSet.next()) {
				Rota rota = new Rota();
				rota.setIdRota(resultSet.getInt("idRota"));
				rota.setNome(resultSet.getString("Nome_Rota"));
				rota.setTurno(resultSet.getString("Turno"));
				rota.setPontosParada(resultSet.getString("Pontos_Parada"));
				rota.setPlacaOnibus(resultSet.getString("Placa_Onibus"));

				rotas.add(rota);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rotas;
	}

	@Override
	public Rota buscarRotaId(Integer idRota) {
		Rota rota = new Rota();
		try {
			String query = "select * from rota where idRota=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, idRota);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				rota.setIdRota(resultSet.getInt("idRota"));
				rota.setNome(resultSet.getString("Nome_Rota"));
				rota.setTurno(resultSet.getString("Turno"));
				rota.setPontosParada(resultSet.getString("Pontos_Parada"));
				rota.setPlacaOnibus(resultSet.getString("Placa_Onibus"));

			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rota;
	}

}
