package br.com.wavii.reposytory;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.wavii.model.Cliente;
import br.com.wavii.model.Preço;
import br.com.wavii.model.Produto;

public class PreçoMyorder implements Serializable {

	private static final long serialVersionUID = 1L;

	EntityManager manager;
	
	@Inject
	public PreçoMyorder(EntityManager manager){
		this.manager = manager;
	}
	
	public Preço porid(Long id){
		return manager.find(Preço.class, id);
	}
	
	public List<Preço> todos(){
		TypedQuery<Preço> query = manager.createQuery("from Preço", Preço.class);
		return query.getResultList();
	}
	public void adcionar(Preço preço){
		EntityTransaction trx = this.manager.getTransaction();
		trx.begin();
		this.manager.merge(preço);
		trx.commit();
	}
	
	public Preço porcodigo(BigDecimal valor) {
		try {
			return manager.createQuery("from Preço where upper(valor) = :valor", Preço.class)
				.setParameter("valor", valor)
				.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
	
	}

