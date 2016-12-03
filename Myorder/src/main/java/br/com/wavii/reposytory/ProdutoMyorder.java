package br.com.wavii.reposytory;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.wavii.model.Funcionario;
import br.com.wavii.model.Produto;
import br.com.wavii.util.FacesUtil;
import br.com.wavii.util.JpaUtil;
import br.com.wavii.util.Transactional;

public class ProdutoMyorder implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager manager;

	public Produto porid(Long id) {
		return manager.find(Produto.class, id);
	}

	public void excluir(Produto produto){
	   this.manager.remove(produto);
		
	}

	public List<Produto> todos() {
		TypedQuery<Produto> query = manager.createQuery("from Produto", Produto.class);
		return query.getResultList();
	}
      
	public Produto guardar(Produto produto) {
		return manager.merge(produto);

	}

	@SuppressWarnings("unchecked")
	public List<Produto> buscarpelonome(String nome) {
		Session session = this.manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Produto.class);

		if (StringUtils.isNotBlank(nome)) {
			criteria.add(Restrictions.ilike("nome", nome.toUpperCase(), MatchMode.START));
		}

		return criteria.list();

	}

	public Produto porcodigo(String codigo) {
		try {
			return manager.createQuery("from Produto where upper(codigo) = :codigo", Produto.class)
					.setParameter("codigo", codigo.toUpperCase()).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
