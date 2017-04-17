package br.com.wavii.reposytory;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.wavii.model.Empresa;
import br.com.wavii.model.Pais;

public class PaisMyorder2 implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	@Inject
	public PaisMyorder2(EntityManager manager) {
		this.manager = manager;
	}

	public Pais PorId(Long id) {
		return manager.find(Pais.class, id);
	}

	public List<Pais> todos() {
		TypedQuery<Pais> query = manager.createQuery("from Pais", Pais.class);
		return query.getResultList();
	}

	public void adcionar(Pais pais) {
		EntityTransaction trx = this.manager.getTransaction();
		trx.begin();
		this.manager.merge(pais);
		trx.commit();
	}

	public List<Pais> porNomeSemelhante(String nome) {
		return manager.createQuery("from Pais where nome like :nome", Pais.class).setParameter("nome", "%" + nome + "%")
				.getResultList();
	}

	public List<Pais> BuscarPais() {
		return manager.createNamedQuery("Pais.buscarPaises", Pais.class).getResultList();

	}
}
