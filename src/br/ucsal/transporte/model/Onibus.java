package br.ucsal.transporte.model;

public class Onibus {

	private String placa;
	private String empresa;
	private Integer anoFabricacao;
	private Integer quantidadeAssentos;
	private Integer idMotorista;

	public Onibus() {
		// TODO Auto-generated constructor stub
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Integer getQuantidadeAssentos() {
		return quantidadeAssentos;
	}

	public void setQuantidadeAssentos(Integer quantidadeAssentos) {
		this.quantidadeAssentos = quantidadeAssentos;
	}

	public Integer getIdMotorista() {
		return idMotorista;
	}

	public void setIdMotorista(Integer idMotorista) {
		this.idMotorista = idMotorista;
	}

}
