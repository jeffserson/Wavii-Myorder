package br.com.wavii.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.wavii.model.Cliente;
import br.com.wavii.model.Empresa;
import br.com.wavii.model.Funcionario;
import br.com.wavii.model.Mesa;
import br.com.wavii.model.MovimentoMesa;
import br.com.wavii.model.Preço;
import br.com.wavii.model.Produto;
import br.com.wavii.model.Tabela;
import br.com.wavii.reposytory.ClienteMyorder;
import br.com.wavii.reposytory.ExcluirClienteMyorder;
import br.com.wavii.reposytory.FuncionarioMyorder;
import br.com.wavii.reposytory.MesasMyorder;
import br.com.wavii.reposytory.MovimentoMesaMyorder;
import br.com.wavii.reposytory.PreçoMyorder;
import br.com.wavii.reposytory.ProdutoMyorder;
import br.com.wavii.reposytory.TabelaMyorder;
import br.com.wavii.util.FacesUtil;
import br.com.wavii.util.JpaUtil;

@Named
@ViewScoped
public class ConsultaMyorderBean2 implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PreçoMyorder preçomy;
	@Inject
	private ExcluirClienteMyorder excluirmy;
	@Inject
	private FuncionarioMyorder funcionariomy;
	@Inject
	private ProdutoMyorder produtomy;
	@Inject
	private ClienteMyorder clientemy;
	@Inject
	private TabelaMyorder tabelamy;
	@Inject
	private MovimentoMesaMyorder movmy;
	@Inject
	private MesasMyorder mesamy;

	private List<Funcionario> funcionarios;
	private List<Cliente> clientes;
	private List<Produto> produtos;
	private List<Preço> preços;
	private List<Tabela> tabelas;
	private List<MovimentoMesa> movimentosmesas;
	private List<Mesa> mesas;

	private Preço preço;
	private Funcionario funcionario;
	private Cliente cliente;
	private Produto produto;
	private Tabela tabela;
	private MovimentoMesa movimentomesa;

	public void consultartabela() {
		this.tabelas = tabelamy.todos();
		this.tabela = new Tabela();
	}

	public void consultarcliente() {
		this.clientes = clientemy.todos();
		this.cliente = new Cliente();
	}

	public void consultarfuncionario() {
		this.funcionarios = funcionariomy.todos();
		this.funcionario = new Funcionario();
	}

	public void consultarproduto() {
		this.produtos = produtomy.todos();
		this.produto = new Produto();
	}

	public void consultarpreço() {
		this.preços = preçomy.todos();
		this.preço = new Preço();
	}

	public void consultarmovimentomesa() {
		this.movimentosmesas = movmy.todos();
		this.movimentomesa = new MovimentoMesa();
	}

	public void excluir(Funcionario funcionario) {
		excluirmy.excluirfuncionario(funcionario);
		FacesUtil.addInfoMessage("Funcionario Excluido Com Sucesso");
	}

	public void excluircliente(Cliente cliente) {
		excluirmy.excluircliente(cliente);
		FacesUtil.addInfoMessage("Cliente Excluido Com Sucesso");
	}

	public void excluirproduto(Produto produto) {
		excluirmy.excluirproduto(produto);
		FacesUtil.addInfoMessage("Produto excluido com sucesso");
	}

	public void excluirpreço(Preço preço) {
		excluirmy.excluirpreço(preço);
		FacesUtil.addInfoMessage("Produto Excluido Com Sucesso");
	}

	public void excluirtabela(Tabela tabela) {
	    excluirmy.excluirtabela(tabela);
		FacesUtil.addInfoMessage("Tabela Excluida Com Sucesso");
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Preço> getPreços() {
		return preços;
	}

	public void setPreços(List<Preço> preços) {
		this.preços = preços;
	}

	public Preço getPreço() {
		return preço;
	}

	public void setPreço(Preço preço) {
		this.preço = preço;
	}

	public List<Tabela> getTabelas() {
		return tabelas;
	}

	public void setTabelas(List<Tabela> tabelas) {
		this.tabelas = tabelas;
	}

	public Tabela getTabela() {
		return tabela;
	}

	public void setTabela(Tabela tabela) {
		this.tabela = tabela;
	}

	public List<MovimentoMesa> getMovimentosmesas() {
		return movimentosmesas;
	}

	public void setMovimentosmesas(List<MovimentoMesa> movimentosmesas) {
		this.movimentosmesas = movimentosmesas;
	}

}
