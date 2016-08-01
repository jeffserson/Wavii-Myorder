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

	EntityManager manager;
	
	@Inject
	public TabelaMyorder(EntityManager manager){
		this.manager = manager;
	}
	
	public Tabela porid(Long id){
		return manager.find(Tabela.class, id);
	}
	
	public List<Tabela> todos(){
		TypedQuery<Tabela> query = manager.createQuery("from Tabela", Tabela.class);
		return query.getResultList();
	}
	public void adcionar(Tabela tabela){
		EntityTransaction trx = this.manager.getTransaction();
		trx.begin();
		this.manager.merge(tabela);
		trx.commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Tabela>buscarpelonome(String nome){
		Session session = this .manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Tabela.class);
		
		if(StringUtils.isNotBlank(nome)){
			criteria.add(Restrictions.ilike("nome", nome.toUpperCase(), MatchMode.START));
		}
		
		
		return criteria.list();
		
	}
	
	
	
}
