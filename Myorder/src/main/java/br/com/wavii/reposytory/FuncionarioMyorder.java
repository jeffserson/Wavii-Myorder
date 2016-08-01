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

import br.com.wavii.model.Cep;
import br.com.wavii.model.Empresa;
import br.com.wavii.model.Funcionario;
import br.com.wavii.model.Uf;

public class FuncionarioMyorder implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;
	@Inject
	public FuncionarioMyorder (EntityManager manager){
		this.manager = manager;
	}
	
	public Funcionario porid(Long id){
		return manager.find(Funcionario.class, id);
	}
	
	public List<Funcionario>todos(){
		TypedQuery<Funcionario> query = manager.createQuery("from Funcionario",Funcionario.class);
		return query.getResultList();
	}
	
	public void adcionar(Funcionario funcionario){
		EntityTransaction trx = this.manager.getTransaction();
		trx.begin();
		this.manager.merge(funcionario);
		trx.commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario>buscarpelonome(String nome){
		Session session = this .manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Funcionario.class);
		
		if(StringUtils.isNotBlank(nome)){
			criteria.add(Restrictions.ilike("nome", nome.toUpperCase(), MatchMode.START));
		}
		
		
		return criteria.list();
		
	}
	
	
	
	
	
}
