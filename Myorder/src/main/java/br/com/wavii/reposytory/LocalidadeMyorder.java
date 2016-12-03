package br.com.wavii.reposytory;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.wavii.model.Localidade;
import br.com.wavii.model.Pais;
import br.com.wavii.model.Uf;

public class LocalidadeMyorder implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager manager;

	public Localidade PorId(Long id) {
		return manager.find(Localidade.class, id);
	}

	public void excluir(Localidade localidade){
		this.manager.remove(localidade);
	}
	
	public List<Localidade> todos() {
		TypedQuery<Localidade> query = manager.createQuery("from Localidade v join fetch v.uf", Localidade.class);
		return query.getResultList();
	}

	public Localidade adcionar(Localidade localidade) {
	  return	this.manager.merge(localidade);
	}

	@SuppressWarnings("unchecked")
	public List<Localidade> buscarlocalidade(Uf uf) {
		Session session = this.manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Localidade.class);

		if (uf != null) {
			criteria.add(Restrictions.eq("uf", uf));
		}

		return criteria.list();

	}

	public List<Localidade> porNomeSemelhante(String nome) {
		return manager.createQuery("from Localidade where nome like :nome", Localidade.class)
				.setParameter("nome", "%" + nome + "%").getResultList();
	}
}
