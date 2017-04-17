package br.com.wavii.reposytory;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.OptimisticLockException;

import br.com.wavii.model.Caixa;
import br.com.wavii.model.Cep;
import br.com.wavii.model.Cliente;
import br.com.wavii.model.Empresa;
import br.com.wavii.model.Funcionario;
import br.com.wavii.model.ItensDaMesa;
import br.com.wavii.model.Localidade;
import br.com.wavii.model.Logradouro;
import br.com.wavii.model.Mesa;
import br.com.wavii.model.MovimentoCaixa;
import br.com.wavii.model.MovimentoMesa;
import br.com.wavii.model.Pais;
import br.com.wavii.model.Preço;
import br.com.wavii.model.Produto;
import br.com.wavii.model.StatusMesa;
import br.com.wavii.model.Sublocalidade;
import br.com.wavii.model.Tabela;
import br.com.wavii.model.Uf;
import br.com.wavii.model.Usuario1;
import br.com.wavii.util.FacesUtil;
import br.com.wavii.util.NegocioException;
import br.com.wavii.util.Transactional;

public class ExcluirClienteMyorder implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FuncionarioMyorder funcionariomy;
	
	@Inject
	private Usuarios usuariosmy;

	@Inject
	private EmpresaMyorder empresamy;

	@Inject
	private PaisMyorder2 paismy;

	@Inject
	private LogradouroMyorder2 log1;

	@Inject
	private UfMyorder ufmy1;

	@Inject
	private LocalidadeMyorder locmy;

	@Inject
	private SubLocalidadeMyorder submy;

	@Inject
	private CepMyorder cepmy;

	@Inject
	private ProdutoMyorder produtomy;

	@Inject
	private ClienteMyorder clientemy;

	@Inject
	private PreçoMyorder preçomy;

	@Inject
	private TabelaMyorder tabelamy;

	@Inject
	private MovimentacaoMyorder2 movmy;

	@Inject
	private MovimentoCaixaMyorder movc;

	@Inject
	private MovimentoMesaMyorder movm;

	@Inject
	private CaixaMyorder movcai;

	@Inject
	private ItensDaNesaMyorder itensmy;

	@Inject
	private MesasMyorder mesas;

	@Inject
	private CaixaMyorder caixas;
	
	@Transactional
	public void excluirlogradouro(Logradouro logradouro){
		logradouro = log1.PorId(logradouro.getId());
		log1.excluir(logradouro);
	}
	
	
	@Transactional
	public void excluiruf(Uf uf){
		uf = ufmy1.PorId(uf.getId());
		ufmy1.excluir(uf);
	}
	
	@Transactional
	public void excluirpais(Pais pais){
		pais = paismy.PorId(pais.getId());
		paismy.excluir(pais);
	}
	
	
	@Transactional
	public void excluircep(Cep cep){
		cep = cepmy.PorId(cep.getId());
		cepmy.excluir(cep);
	}
	
	
	@Transactional
	public void excluirsublocalidade(Sublocalidade sublocalidade){
		sublocalidade = submy.PorId(sublocalidade.getId());
		submy.excluir(sublocalidade);
	}
	
	@Transactional
	public void excluirlocalidade(Localidade localidade){
		localidade = locmy.PorId(localidade.getId());
		locmy.excluir(localidade);
	}
	
	
	@Transactional
	public void excluirempresa(Empresa empresa){
		empresa = empresamy.PorId(empresa.getId());
		empresamy.excluir(empresa);
	}
	
	 @Transactional
	    public void excluirfuncionario(Funcionario funcionario){
	    	funcionario = funcionariomy.porid(funcionario.getId());
	    	funcionariomy.excluir(funcionario);
	    }
	
	 @Transactional
	    public void excluirtabela(Tabela tabela){
	    	tabela = tabelamy.porid(tabela.getId());
	    	tabelamy.excluir(tabela);
	    }
	
    @Transactional
    public void excluirproduto(Produto produto){
    	produto = produtomy.porid(produto.getId());
    	produtomy.excluir(produto);
    }
    @Transactional
    public void excluircliente(Cliente cliente){
    	cliente = clientemy.porid(cliente.getId());
    	clientemy.excluir(cliente);
    }
    
    @Transactional
    public void excluirpreço(Preço preco){
    	preco = preçomy.porid(preco.getId());
    	preçomy.remove(preco);
    }
}
