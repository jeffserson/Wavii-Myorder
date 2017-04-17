package br.com.wavii.reposytory;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.wavii.model.Logradouro;
import br.com.wavii.model.Pais;

public class LogradouroMyorder2 implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	@Inject
	public LogradouroMyorder2(EntityManager manager) {
		this.manager = manager;
	}

	public Logradouro porId(Long id) {
		return manager.find(Logradouro.class, id);
	}

	public List<Logradouro> todos() {
		TypedQuery<Logradouro> query = manager.createQuery("from Logradouro", Logradouro.class);
		return query.getResultList();
	}

	public void adcionar(Logradouro logradouro) {
		EntityTransaction trx = this.manager.getTransaction();
		trx.begin();
		this.manager.merge(logradouro);
		trx.commit();
	}

	public List<Logradouro> porNomeSemelhante(String nome) {
		return manager.createQuery("from Logradouro where nome like :nome", Logradouro.class)
				.setParameter("nome", "%" + nome + "%").getResultList();
	}
}
