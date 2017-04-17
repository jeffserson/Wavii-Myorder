package br.com.wavii.controller;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import br.com.wavii.model.Grupo;
import br.com.wavii.model.MovimentoCaixa;
import br.com.wavii.model.MovimentoMesa;
import br.com.wavii.model.Usuario1;
import br.com.wavii.util.JpaUtil;

public class CriarTabelas {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(MovimentoCaixa.class);
		Criteria sum = session.createCriteria(MovimentoCaixa.class).createAlias("movimentomesa", "c")
				.setProjection(Projections.sum("c.total"));
		sum.uniqueResult();
		System.out.println(sum.uniqueResult());

		trx.commit();

		manager.close();

	}

}
