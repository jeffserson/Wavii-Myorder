package br.com.wavii.reposytory;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.wavii.model.Cep;
import br.com.wavii.model.Empresa;
import br.com.wavii.model.Localidade;
import br.com.wavii.model.Uf;


public class EmpresaMyorder implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	
	@Inject
	public EmpresaMyorder(EntityManager manager){
		this.manager = manager;
	}
	
	public Empresa PorId(Long id){
    	return manager.find(Empresa.class, id);
    }
	
	public List<Empresa>todos(){
		TypedQuery<Empresa> query = manager.createQuery("from Empresa",Empresa.class);
		return query.getResultList();
	}
	
	public void adcionar(Empresa empresa){
		EntityTransaction trx = this.manager.getTransaction();
		trx.begin();
		this.manager.merge(empresa);
		trx.commit();
	}
	
	public List<Empresa> porNomeSemelhante(String fantasia) {
		return manager.createQuery("from Empresa where fantasia like :fantasia", Empresa.class)
				.setParameter("fantasia", "%" + fantasia + "%")
				.getResultList();
	}
	
	
	
	
}
