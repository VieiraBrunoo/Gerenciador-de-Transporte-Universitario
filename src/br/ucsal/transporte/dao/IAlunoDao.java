package br.ucsal.transporte.dao;

import java.util.List;

import br.ucsal.transporte.model.Aluno;


public interface IAlunoDao {
	
	
	
	 public void adicionarAluno( Aluno aluno );
	    public void deletarAluno( Integer idAluno );
	    public void AtualizarAluno( Aluno aluno );
	    public List<Aluno> getAllAluno();
	    public Aluno buscarAlunoId( Integer IdAluno );
	   // public List<Rota>getAllRotas(String pontoParada);

	    
	
	
	

}
