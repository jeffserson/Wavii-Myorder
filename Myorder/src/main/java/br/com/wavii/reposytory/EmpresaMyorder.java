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
	@Inject
	private EntityManager manager;

	public void excluir(Empresa empresa){
		this.manager.remove(empresa);
	}
	

	public Empresa PorId(Long id) {
		return manager.find(Empresa.class, id);
	}

	public List<Empresa> todos() {
		TypedQuery<Empresa> query = manager.createQuery("from Empresa", Empresa.class);
		return query.getResultList();
	}

	public Empresa adcionar(Empresa empresa) {
	return	this.manager.merge(empresa);
	}

	public List<Empresa> porNomeSemelhante(String fantasia) {
		return manager.createQuery("from Empresa where fantasia like :fantasia", Empresa.class)
				.setParameter("fantasia", "%" + fantasia + "%").getResultList();
	}

}
