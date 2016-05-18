package br.com.wavii.reposytory;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.wavii.model.Cep;
import br.com.wavii.model.Pais;

public class CepMyorder implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	
	@Inject
	public CepMyorder(EntityManager manager){
		this.manager = manager;
	}
	
	public Cep PorId(Long id){
    	return manager.find(Cep.class, id);
    }
	
	public List<Cep>todos(){
		TypedQuery<Cep> query = manager.createQuery("from Cep",Cep.class);
		return query.getResultList();
	}
	
	public void adcionar(Cep cep){
		EntityTransaction trx = this.manager.getTransaction();
		trx.begin();
		this.manager.merge(cep);
		trx.commit();
	}
	public List<Cep> porNomeSemelhante(String cep) {
		return manager.createQuery("from Cep where cep like :cep", Cep.class)
				.setParameter("cep", "%" + cep + "%")
				.getResultList();
	}
}
