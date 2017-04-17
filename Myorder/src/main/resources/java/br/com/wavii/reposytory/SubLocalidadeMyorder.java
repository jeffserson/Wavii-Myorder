package br.com.wavii.reposytory;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.wavii.model.Logradouro;
import br.com.wavii.model.Sublocalidade;

public class SubLocalidadeMyorder implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	@Inject
	public SubLocalidadeMyorder(EntityManager manager) {
		this.manager = manager;
	}

	public Sublocalidade PorId(Long id) {
		return manager.find(Sublocalidade.class, id);
	}

	public List<Sublocalidade> todos() {
		TypedQuery<Sublocalidade> query = manager.createQuery("from Sublocalidade", Sublocalidade.class);
		return query.getResultList();
	}

	public void adcionar(Sublocalidade sublocalidade) {
		EntityTransaction trx = this.manager.getTransaction();
		trx.begin();
		this.manager.merge(sublocalidade);
		trx.commit();
	}

	public List<Sublocalidade> porNomeSemelhante(String nome) {
		return manager.createQuery("from Sublocalidade where nome like :nome", Sublocalidade.class)
				.setParameter("nome", "%" + nome + "%").getResultList();
	}
}
