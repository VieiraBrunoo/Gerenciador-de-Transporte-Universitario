package br.ucsal.transporte.model;

public class Rota {

	private Integer idRota;
	private String nome;
	private String turno;
	private String pontosParada;
	private String placaOnibus;

	public Rota() {

	}

	public Integer getIdRota() {
		return idRota;
	}

	public void setIdRota(Integer idRota) {
		this.idRota = idRota;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getPontosParada() {
		return pontosParada;
	}

	public void setPontosParada(String pontosParada) {
		this.pontosParada = pontosParada;
	}

	public String getPlacaOnibus() {
		return placaOnibus;
	}

	public void setPlacaOnibus(String placaOnibus) {
		this.placaOnibus = placaOnibus;
	}

}
