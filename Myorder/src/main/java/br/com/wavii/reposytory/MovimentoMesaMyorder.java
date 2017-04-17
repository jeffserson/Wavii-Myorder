package br.com.wavii.reposytory;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.wavii.model.Caixa;
import br.com.wavii.model.Cliente;
import br.com.wavii.model.Mesa;
import br.com.wavii.model.MovimentoCaixa;
import br.com.wavii.model.MovimentoMesa;
import br.com.wavii.model.Preço;
import br.com.wavii.model.Produto;
import br.com.wavii.model.StatusMesa;
import br.com.wavii.model.Tabela;

public class MovimentoMesaMyorder implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	public MovimentoMesa porid(Long id) {
		return manager.find(MovimentoMesa.class, id);
	}

	public List<MovimentoMesa> todos() {
		TypedQuery<MovimentoMesa> query = manager.createQuery("from MovimentoMesa", MovimentoMesa.class);
		return query.getResultList();

	}

	public MovimentoMesa adcionar(MovimentoMesa movimentomesa) {
		EntityTransaction trx = this.manager.getTransaction();
		trx.begin();
		this.manager.merge(movimentomesa);
		trx.commit();
		return movimentomesa;
	}

	public MovimentoMesa guardar(MovimentoMesa pedido) {
		return this.manager.merge(pedido);
	}
	
	

	@SuppressWarnings("unchecked")
	public List<MovimentoMesa> filtrados(MovimentoMesaFilter filtro, MovimentoCaixa movcaixa) {
		Session session = this.manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(MovimentoMesa.class)
				// fazemos uma associação (join) com cliente e nomeamos como "c"
			
				.createAlias("cliente", "c").createAlias("mesa", "m");

		Criteria sum = session.createCriteria(MovimentoMesa.class).setProjection(Projections.sum("total"));
		filtro.setTotalmesa((BigDecimal) sum.uniqueResult());
		movcaixa.setTotal(filtro.getTotalmesa());
		

		if (filtro.getNumeroDe() != null) {
			// id deve ser maior ou igual (ge = greater or equals) a
			// filtro.numeroDe
			criteria.add(Restrictions.ge("id", filtro.getNumeroDe()));
		}

		if (filtro.getNumeroAte() != null) {
			// id deve ser menor ou igual (le = lower or equal) a
			// filtro.numeroDe
			criteria.add(Restrictions.le("id", filtro.getNumeroAte()));
		}

		if (filtro.getDataCriacaoDe() != null) {
			criteria.add(Restrictions.ge("inicio", filtro.getDataCriacaoDe()));
		}

		if (filtro.getDataCriacaoAte() != null) {
			criteria.add(Restrictions.le("inicio", filtro.getDataCriacaoAte()));
		}
		
		

		if (StringUtils.isNotBlank(filtro.getNomeCliente())) {
			// acessamos o nome do cliente associado ao pedido pelo alias "c",
			// criado anteriormente
			criteria.add(Restrictions.ilike("c.nome", filtro.getNomeCliente(), MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotBlank(filtro.getMesa())) {
			// acessamos o nome do cliente associado ao pedido pelo alias "c",
			// criado anteriormente
			criteria.add(Restrictions.ilike("m.nome", filtro.getMesa(), MatchMode.START));

		}

		if (filtro.getStatuses() != null && filtro.getStatuses().length > 0) {
			// adicionamos uma restrição "in", passando um array de constantes
			// da enum StatusPedido
			criteria.add(Restrictions.in("statusmesa", filtro.getStatuses()));
		}

		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public MovimentoMesa buscarpelonome(Mesa mesa, StatusMesa statuses) {
		Session session = this.manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(MovimentoMesa.class);

		criteria.createAlias("mesa", "m");

		if (StringUtils.isNotBlank(mesa.getNome())) {
			criteria.add(Restrictions.ilike("m.nome", mesa.getNome()));
		}

		if (StringUtils.join(statuses.ABERTO.values()) != null) {
			criteria.add(Restrictions.in("statusmesa", statuses.ABERTO));
		}

		return (MovimentoMesa) criteria.uniqueResult();

	}

	public MovimentoMesa pordata(Date inicio) {
		try {
			return manager.createQuery("from MovimentoMesa where upper(inicio) = :inicio", MovimentoMesa.class)
					.setParameter("inicio", inicio).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
