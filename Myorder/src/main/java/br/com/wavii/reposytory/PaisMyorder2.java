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
	@Inject
	private EntityManager manager;

	
	public void excluir(Pais pais){
		this.manager.remove(pais);
	}

	public Pais PorId(Long id) {
		return manager.find(Pais.class, id);
	}

	public List<Pais> todos() {
		TypedQuery<Pais> query = manager.createQuery("from Pais", Pais.class);
		return query.getResultList();
	}

	public Pais adcionar(Pais pais) {
		return manager.merge(pais);
	}

	public List<Pais> porNomeSemelhante(String nome) {
		return manager.createQuery("from Pais where nome like :nome", Pais.class).setParameter("nome", "%" + nome + "%")
				.getResultList();
	}

	public List<Pais> BuscarPais() {
		return manager.createNamedQuery("Pais.buscarPaises", Pais.class).getResultList();

	}
}
