package br.ucsal.transporte.dao;

import java.util.List;


import br.ucsal.transporte.model.Onibus;

public interface IOnibusDao {
	
	public void adicionarOnibus( Onibus onibus);
    public void deletarOnibus( String placa );
    public void AtualizarOnibus( Onibus onibus );
    public List<Onibus> getAllOnibus();
    public Onibus buscarOnibusPlaca( String placa );

	

}
