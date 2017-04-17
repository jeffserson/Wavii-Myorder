package br.com.wavii.reposytory;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import br.com.wavii.model.Grupo;
import br.com.wavii.model.Produto;
import br.com.wavii.model.Usuario1;
import br.com.wavii.util.Transactional;

public class Grupos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
   

	public Grupo pegaid(Long id){
		return this.manager.find(Grupo.class,id);
	}
	
	public List<Grupo> grupos() {
		// TODO filtrar apenas vendedores (por um grupo específico)
		return this.manager.createQuery("from Grupo", Grupo.class).getResultList();
	}
	

}