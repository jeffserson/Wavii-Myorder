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

public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Usuario1 porId(Long id) {
		return this.manager.find(Usuario1.class, id);
	}
	
	
	
	public Usuario1 adcionar1(Usuario1 usuario) {
		EntityTransaction trx = this.manager.getTransaction();
		trx.begin();
		this.manager.merge(usuario);
		trx.commit();
		return usuario;

	}
	
	public Usuario1 adcionar(Usuario1 usuario) {
		return this.manager.merge(usuario);
	}

	public List<Usuario1> vendedores() {
		// TODO filtrar apenas vendedores (por um grupo específico)
		return this.manager.createQuery("from Usuario1", Usuario1.class).getResultList();
	}

	public List<Grupo> grupos() {
		// TODO filtrar apenas vendedores (por um grupo específico)
		return this.manager.createQuery("from Grupo", Grupo.class).getResultList();
	}
	public Usuario1 porEmail(String email) {
		Usuario1 usuario = null;

		try {
			usuario = this.manager.createQuery("from Usuario1 where lower(email) = :email", Usuario1.class)
					.setParameter("email", email.toLowerCase()).getSingleResult();
		} catch (NoResultException e) {
			// nenhum usuário encontrado com o e-mail informado
		}

		return usuario;
	}

}