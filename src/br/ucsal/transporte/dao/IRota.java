package br.ucsal.transporte.dao;

import java.util.List;

import br.ucsal.transporte.model.Rota;

public interface IRota {

	public void adicionarRota( Rota rota);
    public void deletarRota( Integer idRota );
    public void AtualizarRota( Rota rota );
    public List<Rota> getAllRota();
    public Rota buscarRotaId( Integer idRota );
}
