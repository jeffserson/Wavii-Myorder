package br.com.wavii.reposytory;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.wavii.model.Caixa;
import br.com.wavii.model.Cliente;
import br.com.wavii.model.MovimentoCaixa;
import br.com.wavii.model.Preço;
import br.com.wavii.model.Tabela;

public class MovimentoCaixaMyorder implements Serializable {

	private static final long serialVersionUID = 1L;

	EntityManager manager;
	
	@Inject
	public MovimentoCaixaMyorder(EntityManager manager){
		this.manager = manager;
	}
	
	public MovimentoCaixa porid(Long id){
		return manager.find(MovimentoCaixa.class, id);
	}
	
	public List<MovimentoCaixa> todos(){
		TypedQuery<MovimentoCaixa> query = manager.createQuery("from MovimentoCaixa", MovimentoCaixa.class);
		return query.getResultList();
	}
	public void adcionar(MovimentoCaixa movimentocaixa){
		EntityTransaction trx = this.manager.getTransaction();
		trx.begin();
		this.manager.merge(movimentocaixa);
		trx.commit();
	}
	
}
