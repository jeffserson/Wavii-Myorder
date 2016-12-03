package br.com.wavii.reposytory;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.wavii.model.Caixa;
import br.com.wavii.model.Cliente;
import br.com.wavii.model.ItensDaMesa;
import br.com.wavii.model.MovimentoCaixa;
import br.com.wavii.model.Preço;
import br.com.wavii.model.Tabela;

public class ItensDaNesaMyorder implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	EntityManager manager;

	


	public ItensDaMesa porid(Long id) {
		return manager.find(ItensDaMesa.class, id);
	}

	public List<ItensDaMesa> todos() {
		TypedQuery<ItensDaMesa> query = manager.createQuery("from ItensDaMesa", ItensDaMesa.class);
		return query.getResultList();
	}

	public ItensDaMesa adcionar(ItensDaMesa itensdamesa) {
		return this.manager.merge(itensdamesa);
	}

}
