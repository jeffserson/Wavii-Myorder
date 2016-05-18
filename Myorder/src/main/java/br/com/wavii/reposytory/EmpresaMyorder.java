package br.com.wavii.reposytory;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;


import br.com.wavii.model.Empresa;


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
	
	public List<Empresa> porNomeSemelhante(String nome) {
		return manager.createQuery("from CadastroCliente where nome like :nome", Empresa.class)
				.setParameter("nome", "%" + nome + "%")
				.getResultList();
	}
}
