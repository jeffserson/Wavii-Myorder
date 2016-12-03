package br.com.wavii.reposytory;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.wavii.model.Caixa;
import br.com.wavii.model.Cliente;
import br.com.wavii.model.Mesa;
import br.com.wavii.model.Movimentacao;
import br.com.wavii.model.MovimentoCaixa;
import br.com.wavii.model.Preço;
import br.com.wavii.model.Tabela;

public class MovimentacaoMyorder2 implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager manager;

	
	

	public Movimentacao porid(Long id) {
		return manager.find(Movimentacao.class, id);
	}

	public List<Movimentacao> todos() {
		TypedQuery<Movimentacao> query = manager.createQuery("from Movimentacao", Movimentacao.class);
		return query.getResultList();
	}

	public void adcionar(Movimentacao movimentacao) {
		EntityTransaction trx = this.manager.getTransaction();
		trx.begin();
		this.manager.merge(movimentacao);
		trx.commit();
	}

}
