package br.com.wavii.reposytory;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.wavii.model.Caixa;
import br.com.wavii.model.Cliente;
import br.com.wavii.model.Mesa;
import br.com.wavii.model.MovimentoCaixa;
import br.com.wavii.model.MovimentoMesa;
import br.com.wavii.model.Preço;
import br.com.wavii.model.Produto;
import br.com.wavii.model.Tabela;

public class MesasMyorder implements Serializable {

	private static final long serialVersionUID = 1L;

	EntityManager manager;

	@Inject
	public MesasMyorder(EntityManager manager) {
		this.manager = manager;
	}

	public Mesa porid(Long id) {
		return manager.find(Mesa.class, id);
	}

	public List<Mesa> todos() {
		TypedQuery<Mesa> query = manager.createQuery("from Mesa", Mesa.class);
		return query.getResultList();
	}

	public void adcionar(Mesa mesa) {
		EntityTransaction trx = this.manager.getTransaction();
		trx.begin();
		this.manager.merge(mesa);
		trx.commit();
	}

	@SuppressWarnings("unchecked")
	public List<Mesa> buscarpelonome(String nome) {
		Session session = this.manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Mesa.class);

		if (StringUtils.isNotBlank(nome)) {
			criteria.add(Restrictions.ilike("nome", nome.toUpperCase(), MatchMode.START));
		}

		return criteria.list();
	}

	public Mesa porcodigo(String codigo) {
		try {
			return manager.createQuery("from Mesa where upper(codigo) = :codigo", Mesa.class)
					.setParameter("codigo", codigo.toUpperCase()).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}

}
