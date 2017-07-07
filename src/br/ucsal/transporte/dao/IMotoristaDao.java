package br.ucsal.transporte.dao;

import java.util.List;

import br.ucsal.transporte.model.Motorista;



public interface IMotoristaDao {
		
	 public void adicionarMotorista( Motorista motorista );
	    public void deletarMotorista( Integer idMotorista );
	    public void AtualizarMotorista( Motorista motorista );
	    public List<Motorista> getAllMotorista();
	    public Motorista buscarMotoristaId( Integer IdMotorista );

}
