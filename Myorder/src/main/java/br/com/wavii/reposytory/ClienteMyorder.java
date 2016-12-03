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
import br.com.wavii.model.Cliente;
import br.com.wavii.model.Empresa;
import br.com.wavii.model.Funcionario;
import br.com.wavii.model.Uf;

public class ClienteMyorder implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager manager;

	
	public void excluir(Cliente cliente){
		this.manager.remove(cliente);
	}

	public Cliente porid(Long id) {
		return manager.find(Cliente.class, id);
	}
    
	public Cliente guardar(Cliente cliente){
		return manager.merge(cliente);
	}
	
	public List<Cliente> todos() {
		TypedQuery<Cliente> query = manager.createQuery("from Cliente", Cliente.class);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> buscarpelonome(String nome) {
		Session session = this.manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Cliente.class);

		if (StringUtils.isNotBlank(nome)) {
			criteria.add(Restrictions.ilike("nome", nome.toUpperCase(), MatchMode.START));
		}

		return criteria.list();

	}

}
