package br.com.wavii.reposytory;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.wavii.model.Caixa;
import br.com.wavii.model.Cliente;
import br.com.wavii.model.Preço;
import br.com.wavii.model.Tabela;

public class CaixaMyorder implements Serializable {

	private static final long serialVersionUID = 1L;

	EntityManager manager;

	@Inject
	public CaixaMyorder(EntityManager manager) {
		this.manager = manager;
	}

	public Caixa porid(Long id) {
		return manager.find(Caixa.class, id);
	}

	public List<Caixa> todos() {
		TypedQuery<Caixa> query = manager.createQuery("from Caixa", Caixa.class);
		return query.getResultList();
	}

	public void adcionar(Caixa caixa) {
		EntityTransaction trx = this.manager.getTransaction();
		trx.begin();
		this.manager.merge(caixa);
		trx.commit();
	}

}
