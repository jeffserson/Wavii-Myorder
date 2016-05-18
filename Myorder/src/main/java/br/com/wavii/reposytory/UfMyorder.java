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

import br.com.wavii.model.Empresa;
import br.com.wavii.model.Pais;
import br.com.wavii.model.Uf;

public class UfMyorder implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	
	@Inject
	public UfMyorder(EntityManager manager){
		this.manager = manager;
	}
	
	public Uf PorId(Long id){
    	return manager.find(Uf.class, id);
    }
	
	public List<Uf>todos(){
		TypedQuery<Uf> query = manager.createQuery("from Uf",Uf.class);
		return query.getResultList();
	}
	
	public void adcionar(Uf uf){
		EntityTransaction trx = this.manager.getTransaction();
		trx.begin();
		this.manager.merge(uf);
		trx.commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Uf>buscaruf(Pais pais){
		Session session = this .manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Uf.class);
		
		if(pais != null){
			criteria.add(Restrictions.eq("pais", pais));
		}
		
		
		return criteria.list();
		
	}
	public List<Uf> porNomeSemelhante(String nome) {
		return manager.createQuery("from Uf where nome like :nome", Uf.class)
				.setParameter("nome", "%" + nome + "%")
				.getResultList();
	}
	public List<Uf> Buscaruf(){
		return manager.createNamedQuery("Uf.buscaruf", Uf.class).getResultList();
		
	}
}
