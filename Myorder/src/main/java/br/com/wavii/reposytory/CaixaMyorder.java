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
	@Inject
	private EntityManager manager;

	
	

	public Caixa porid(Long id) {
		return manager.find(Caixa.class, id);
	}

	public List<Caixa> todos() {
		TypedQuery<Caixa> query = manager.createQuery("from Caixa", Caixa.class);
		return query.getResultList();
	}

	public Caixa adcionar(Caixa caixa) {
		return manager.merge(caixa);
	}

}
