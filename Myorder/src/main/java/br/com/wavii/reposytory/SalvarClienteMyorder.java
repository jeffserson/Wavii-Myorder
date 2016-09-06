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

public class SalvarClienteMyorder implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FuncionarioMyorder funcionariomy;
	
	@Inject
	private Usuarios usuariosmy;

	@Inject
	private EmpresaMyorder empresa;

	@Inject
	private PaisMyorder2 pais;

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

	public void commitar(Empresa empresa) {
		this.empresa.adcionar(empresa);

	}
	@Transactional
	public Usuario1 salvarusuarioo(Usuario1 usuario) {
	return	this.usuariosmy.adcionar(usuario);

	}
	
	public void salvarpais(Pais pais) {
		this.pais.adcionar(pais);

	}

	public void salvarlog(Logradouro logradouro) {
		this.log1.adcionar(logradouro);
	}

	public void Salvaruf(Uf uf) {
		this.ufmy1.adcionar(uf);
	}

	public void Salvarlocalidade(Localidade localidade) {
		this.locmy.adcionar(localidade);
	}

	public void Salvarsublocalidade(Sublocalidade sublocalidade) {
		this.submy.adcionar(sublocalidade);
	}

	public void Salvarcep(Cep cep) {
		this.cepmy.adcionar(cep);
	}

	public void SalvarFuncionario(Funcionario funcionario) {
		this.funcionariomy.adcionar(funcionario);
	}

	public Produto salvarproduto(Produto produto) {
		try {
			Produto produtoExistente = produtomy.porcodigo(produto.getCodigo());

			if (produtoExistente != null && !produtoExistente.equals(produto)) {
				throw new NegocioException("Já existe um produto com o Codigo informado.");
			}

			return produtomy.adcionar(produto);
		} catch (OptimisticLockException e) {
		    throw new NegocioException("Erro de Concorrência Esse Usuario ja foi alterado Anteriormente");
		}
	
	}

	public void salvarcliente(Cliente cliente) {
		this.clientemy.adcionar(cliente);
	}

	public void salvarpreço(Preço preço) {
		this.preçomy.adcionar(preço);
	}

	public void salvartabela(Tabela tabela) {
		this.tabelamy.adcionar(tabela);
	}

	public void salvarmesa(Mesa mesa) {
		this.mesas.adcionar(mesa);

	}

	public void salvarcaixa(Caixa caixa) {
		this.caixas.adcionar(caixa);
	}

	public void salvarmovimentocaixa(MovimentoCaixa movcaixa) {
		this.movc.adcionar(movcaixa);
	}

	@Transactional
	public MovimentoMesa salvarmovimentomesa(MovimentoMesa movmesa) throws NegocioException {

		MovimentoMesa mesaExistente = movm.buscarpelonome(movmesa.getMesa(), movmesa.getStatusmesa());

		if (mesaExistente != null && !mesaExistente.equals(movmesa.getMesa())) {
			throw new NegocioException("A Mesa já Esta Em Aberto");
		}

		else if (movmesa.isNovo()) {
			movmesa.setInicio(new Date());
			movmesa.setStatusmesa(StatusMesa.ABERTO);
		}
		movmesa.recalcularValorTotal();

		if (movmesa.isNaoAlteravel()) {
			throw new NegocioException(
					"Mesa não pode ser alterada no status " + movmesa.getStatusmesa().getDescricao() + ".");
		}

		movmesa = this.movm.guardar(movmesa);

		return movmesa;
	}

	@Transactional
	public MovimentoMesa finalizar(MovimentoMesa movmesa) throws NegocioException {

		movmesa.setFim(new Date());
		;

		if (movmesa.isNaoFinalizavel()) {
			throw new NegocioException(
					"Mesa não pode ser finalizada com status " + movmesa.getStatusmesa().getDescricao() + ".");
		}

		movmesa.setStatusmesa(StatusMesa.FINALIZADO);

		movmesa = this.movm.guardar(movmesa);

		return movmesa;
	}

	@Transactional
	public MovimentoMesa cancelar(MovimentoMesa movmesa) throws NegocioException {
		movmesa = this.movm.porid(movmesa.getId());

		if (movmesa.isNaoCancelavel()) {
			throw new NegocioException(
					"Mesa não pode ser cancelada no status " + movmesa.getStatusmesa().getDescricao() + ".");
		}

		movmesa = this.movm.guardar(movmesa);
		movmesa.setStatusmesa(StatusMesa.CANCELADO);
		return movmesa;
	}

	public void salvaritensdamesa(ItensDaMesa itensdamesa) {
		this.itensmy.adcionar(itensdamesa);

	}
}
