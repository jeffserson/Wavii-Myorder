package br.com.wavii.reposytory;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.wavii.model.Cliente;
import br.com.wavii.model.Preço;
import br.com.wavii.model.Produto;
import br.com.wavii.model.Tabela;

public class TabelaMyorder implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager manager;


	public Tabela porid(Long id) {
		return manager.find(Tabela.class, id);
	}

	public void excluir(Tabela tabela){
	this.manager.remove(tabela);	
	}
	
	public List<Tabela> todos() {
		TypedQuery<Tabela> query = manager.createQuery("from Tabela", Tabela.class);
		return query.getResultList();
	}

	public Tabela adcionar(Tabela tabela) {
		return manager.merge(tabela);
	}

	@SuppressWarnings("unchecked")
	public List<Tabela> buscarpelonome(String nome) {
		Session session = this.manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Tabela.class);

		if (StringUtils.isNotBlank(nome)) {
			criteria.add(Restrictions.ilike("nome", nome.toUpperCase(), MatchMode.START));
		}

		return criteria.list();

	}

}
