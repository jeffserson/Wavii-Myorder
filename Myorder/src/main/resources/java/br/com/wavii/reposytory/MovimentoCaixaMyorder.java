package br.com.wavii.reposytory;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.wavii.model.Caixa;
import br.com.wavii.model.Cliente;
import br.com.wavii.model.MovimentoCaixa;
import br.com.wavii.model.MovimentoMesa;
import br.com.wavii.model.Preço;
import br.com.wavii.model.Tabela;

public class MovimentoCaixaMyorder implements Serializable {

	private static final long serialVersionUID = 1L;

	EntityManager manager;

	@Inject
	public MovimentoCaixaMyorder(EntityManager manager) {
		this.manager = manager;
	}

	public MovimentoCaixa porid(Long id) {
		return manager.find(MovimentoCaixa.class, id);
	}

	public List<MovimentoCaixa> todos() {
		TypedQuery<MovimentoCaixa> query = manager.createQuery("from MovimentoCaixa", MovimentoCaixa.class);
		return query.getResultList();
	}

	public void adcionar(MovimentoCaixa movimentocaixa) {
		EntityTransaction trx = this.manager.getTransaction();
		trx.begin();
		this.manager.merge(movimentocaixa);
		trx.commit();
	}

	public List<MovimentoCaixa> filtrados(MovimentoCaixa caixa) {
		Session session = this.manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(MovimentoCaixa.class);
		Criteria sum = session.createCriteria(MovimentoCaixa.class).createAlias("movimentomesa", "c")
				.setProjection(Projections.sum("c.total"));
		sum.uniqueResult();
		System.out.println(sum.uniqueResult());
		return criteria.list();

	}

}
