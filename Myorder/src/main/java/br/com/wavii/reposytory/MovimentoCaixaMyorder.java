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
	@Inject
	private EntityManager manager;

	
	

	public MovimentoCaixa porid(Long id) {
		return manager.find(MovimentoCaixa.class, id);
	}

	public List<MovimentoCaixa> todos() {
		TypedQuery<MovimentoCaixa> query = manager.createQuery("from MovimentoCaixa", MovimentoCaixa.class);
		return query.getResultList();
	}
    
	public MovimentoCaixa adcionar(MovimentoCaixa movimentocaixa) {
		return manager.merge(movimentocaixa);
	}

	public List<MovimentoCaixa> filtrados(MovimentoMesaFilter filtro,MovimentoCaixa caixa) {
		Session session = this.manager.unwrap(Session.class);
		Criteria sum = session.createCriteria(MovimentoMesa.class).setProjection(Projections.sum("total"));
		filtro.setTotalmesa((BigDecimal) sum.uniqueResult());
		caixa.setTotal(filtro.getTotalmesa());
		return null;

	}

}
