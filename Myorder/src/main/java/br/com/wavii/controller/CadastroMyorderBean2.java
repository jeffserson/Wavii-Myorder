package br.com.wavii.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;

import antlr.debug.Event;
import br.com.wavii.model.Caixa;
import br.com.wavii.model.Cep;
import br.com.wavii.model.Cliente;
import br.com.wavii.model.Funcionario;
import br.com.wavii.model.ItensDaMesa;
import br.com.wavii.model.Mesa;
import br.com.wavii.model.MovimentoCaixa;
import br.com.wavii.model.MovimentoMesa;
import br.com.wavii.model.Preço;
import br.com.wavii.model.Produto;
import br.com.wavii.model.StatusMesa;
import br.com.wavii.model.Tabela;
import br.com.wavii.reposytory.CaixaMyorder;
import br.com.wavii.reposytory.CepMyorder;
import br.com.wavii.reposytory.ClienteMyorder;
import br.com.wavii.reposytory.FuncionarioMyorder;
import br.com.wavii.reposytory.MesasMyorder;
import br.com.wavii.reposytory.MovimentoCaixaMyorder;
import br.com.wavii.reposytory.MovimentoMesaMyorder;
import br.com.wavii.reposytory.PreçoMyorder;
import br.com.wavii.reposytory.ProdutoMyorder;
import br.com.wavii.reposytory.SalvarClienteMyorder;
import br.com.wavii.reposytory.TabelaMyorder;
import br.com.wavii.util.FacesUtil;

@Named
@ViewScoped
public class CadastroMyorderBean2 implements Serializable {

  public	CadastroMyorderBean2(){
	  limpar();
  }
	
	
	
	private static final long serialVersionUID = 1L;

	@Inject
	private SalvarClienteMyorder salvarcliente2;
	@Inject
	private FuncionarioMyorder funcionariomy;
	@Inject
	private ProdutoMyorder produtomy;
	@Inject
	private CepMyorder cepmy;
	@Inject
	private ClienteMyorder clientemy;
	@Inject
	private PreçoMyorder preçomy;
	@Inject
	private TabelaMyorder tabelamy;
	@Inject
	private MesasMyorder mesamy;
	@Inject
	private CaixaMyorder caixamy;
	@Inject
	private MovimentoCaixaMyorder movmy;
	@Inject
	private MovimentoMesaMyorder movmesa;
	@Inject
	private ItensDaMesa itensmy;

	private String codigo;
	private ItensDaMesa itendamesa;
	@Produces
	@MovimentomesaEdicao
	private MovimentoMesa movimentomesa;
	private Caixa caixa;
	private Mesa mesa;
	private Tabela tabela;
	private Preço preço;
	private Cliente cliente;
	private Produto produto;
	private Cep cep;
	private Funcionario funcionario;
	private MovimentoCaixa movicaixa;
	private List<ItensDaMesa> itensmesa = new ArrayList<>();
	private List<MovimentoCaixa> movimentos = new ArrayList<>();
	private List<Caixa> caixas = new ArrayList<>();
	private List<Mesa> mesas = new ArrayList<>();
	private List<Tabela> tabelas = new ArrayList<>();
	private List<Preço> preços = new ArrayList<>();
	private List<Cliente> clientes = new ArrayList<>();
	private List<Produto> produtos = new ArrayList<>();
    private List<Cep> ceps = new ArrayList<>();
	private List<Funcionario> funcionarios = new ArrayList<>();
    private List<MovimentoMesa> movimentomesas = new ArrayList<>();
	private List<Integer> itens;
	
	
	
	public void MovimentomesaAlterado(@Observes Movimentomesaalteredevent event) {
		this.movimentomesa = event.getMovimentomesa();
	}
	
	public void inicializar() {
		if(FacesUtil.isNotPostback()){
			
			this.movimentomesa.adicionarItemVazio();
			this.recalcularMesa();
		}
		
	}
	
	private void limpar() {
		movimentomesa = new MovimentoMesa();
		
	}
	
	
	
	
	public void carregarprodutoporcodigo() {
		if (StringUtils.isNotEmpty(this.codigo)) {
			this.produto = this.produtomy.porcodigo(this.codigo);
			this.carregarProdutoLinhaEditavel();
		}
	}
	    
	public void carregarProdutoLinhaEditavel() {
		// TODO Auto-generated method stub
          ItensDaMesa item = this.movimentomesa.getItens().get(0);
		
		if (this.produto != null) {
			if (this.existeMesaComProduto(this.produto)) {
				FacesUtil.addErrorMessage("Esse produto já existe na Mesa");
			} else {
				item.setProduto(this.produto);
			    item.setUnitario(this.produto.getPreco1().getValor());
				
				this.movimentomesa.adicionarItemVazio();
				this.produto = null;
				this.codigo = null;
				this.movimentomesa.recalcularValorTotal();
			}
		}
	}
		
	
	public void atualizarQuantidade(ItensDaMesa item, int linha) {
		if (item.getQuantidade() < 1) {
			if (linha == 0) {
				item.setQuantidade(1);
			} else {
				this.getMovimentomesa().getItens().remove(linha);
			}
		}
		
		this.movimentomesa.recalcularValorTotal();
	}

	
	
	public void recalcularMesa() {
		if (this.movimentomesa != null) {
			this.movimentomesa.recalcularValorTotal();
		}
	}
	
	
	private boolean existeMesaComProduto(Produto produto) {
		boolean existeItem = false;
		for (ItensDaMesa item : this.getMovimentomesa().getItens()) {
			if (produto.equals(item.getProduto())) {
				existeItem = true;
				break;
			}
		}
		
		return existeItem;
	}
	
	
	
	public void buscarcep(AjaxBehaviorEvent event){
		ceps = cepmy.todos();
        for (Cep cep1 : ceps) {

            if (this.funcionario.getCep().equals(cep1.getCep())) {
            	funcionario.setLogradouro(cep1.getLogradouro());
                funcionario.setComplemento(cep1.getComplemento());
            }else{
            	FacesUtil.addErrorMessage("Cep não encontrado"); 
            }
 }
 }
	
	
	public void buscarcep1(AjaxBehaviorEvent event){
		ceps = cepmy.todos();
        for (Cep cep1 : ceps) {

            if (this.cliente.getCep().equals(cep1.getCep())) {
            	cliente.setLogradouro(cep1.getLogradouro());
                cliente.setComplemento(cep1.getComplemento());
            }else{
            	
            	FacesUtil.addErrorMessage("Cep não encontrado"); 
                    
            }
 }
 }
	
	
	
	public String salvarpreço(){	
		salvarcliente2.salvarpreço(preço);
		this.preço = new  Preço();
		FacesUtil.addInfoMessage("Preço Salvo Com Sucesso");
		return "/auxrecurso/CadastroPreço?faces-redirect=true";
		
		
		}
	
	
	public String salvarfuncionario(){
		salvarcliente2.SalvarFuncionario(funcionario);
		this.funcionario = new Funcionario();
		FacesUtil.addInfoMessage("Funcionario Salvo Com Sucesso");
		return "/cadastros/FuncionariosCadastrados?faces-redirect=true";
	}
	
	public String salvarcliente(){
		salvarcliente2.salvarcliente(cliente);
		this.cliente = new Cliente();
		FacesUtil.addInfoMessage("Cliente Salvo Com Sucesso");
		return "/cadastros/ClientesCadastrados?faces-redirect=true";
	}
	
	public String salvartabela(){
		salvarcliente2.salvartabela(tabela);
		this.tabela = new Tabela();
		FacesUtil.addInfoMessage("Tabela Salva Com Sucesso");
		return "/auxrecurso/TabelasCadastradas?faces-redirect=true";
	}
	

	public String salvarproduto(){
	    this.produto = salvarcliente2.salvarproduto(this.produto);
		this.produto = new Produto();
		FacesUtil.addInfoMessage("Produto Salvo Com Sucesso");
		return "/cadastros/ProdutosCadastrados?faces-redirect=true";
		}
		
	public void salvarmesa(){
		salvarcliente2.salvarmesa(mesa);
		this.mesa = new Mesa();
		FacesUtil.addInfoMessage("Mesa Salva Com Sucesso");
	}
	public void salvarcaixa(){
		salvarcliente2.salvarcaixa(caixa);
		this.caixa = new Caixa();
		FacesUtil.addInfoMessage("Caixa Salvo com Sucesso");
	}
	
	public void salvarmovmesa(){
		this.movimentomesa.removerItemVazio();
		
		try {
			this.movimentomesa = this.salvarcliente2.salvarmovimentomesa(movimentomesa);
			FacesUtil.addInfoMessage("Venda Salva Com Sucesso");
			
		} finally {
			this.movimentomesa.adicionarItemVazio();
		}
		}
	
	
	
	public void prepararpreço(){
		
		this.preços = preçomy.todos();
		if(this.preço == null){
			this.preço = new Preço();
		}
	}
	
	public void prepararcaixa(){
		this.caixas = caixamy.todos();
		if(this.caixa == null){
			this.caixa = new Caixa();
		}
	}
	
	public void prepararmesa(){
		this.mesas = mesamy.todos();
		if(this.mesa == null){
		    this.mesa = new Mesa();
		}
	}
	
	public void prepararfuncionario(){
		this.funcionarios = funcionariomy.todos();
		if(this.funcionario == null){
			this.funcionario = new  Funcionario();
		}
	}
	
	public void prepararproduto(){
		this.produtos = produtomy.todos();
		if(this.produto == null){
			this.produto = new Produto();
		}
	}
	
	public void prepararcliente(){
		this.clientes = clientemy.todos();
		if(this.cliente == null){
			this.cliente = new Cliente();
		}
	}
	public void preparartabela(){
		this.tabelas = tabelamy.todos();
		if(this.tabela == null){
			this.tabela = new Tabela();
		}
	}
	public void prepararmovimentocaixa(){
		this.caixas = caixamy.todos();
		this.mesas = mesamy.todos();
		this.movimentomesas = movmesa.todos();
		this.movimentos = movmy.todos();
		if(this.movicaixa == null){
			this.movicaixa = new MovimentoCaixa();
		}
	}
	
	public void prepararmovimentomesa(){
		this.caixas = caixamy.todos();
		this.clientes = clientemy.todos();
		this.mesas = mesamy.todos();
		this.movimentomesas = movmesa.todos();
		if(this.movimentomesa == null){
			this.movimentomesa = new MovimentoMesa();
		}
	}
	
	
	public List<Funcionario>completarfunc(String nome){
		List<Funcionario> funcionarios = funcionariomy.buscarpelonome(nome);
		if(funcionarios.size()==0){
			FacesUtil.addErrorMessage("Funcionario Não Encontrado");
		}
		return funcionarios;
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

	public Cep getCep() {
		return cep;
	}

	public void setCep(Cep cep) {
		this.cep = cep;
	}

	public List<Cep> getCeps() {
		return ceps;
	}

	public void setCeps(List<Cep> ceps) {
		this.ceps = ceps;
	}



	public Produto getProduto() {
		return produto;
	}



	public void setProduto(Produto produto) {
		this.produto = produto;
	}



	public List<Produto> getProdutos() {
		return produtos;
	}



	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public List<Cliente> getClientes() {
		return clientes;
	}



	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Preço getPreço() {
		return preço;
	}

	public void setPreço(Preço preço) {
		this.preço = preço;
	}

	public List<Preço> getPreços() {
		return preços;
	}

	public void setPreços(List<Preço> preços) {
		this.preços = preços;
	}


	public Tabela getTabela() {
		return tabela;
	}


	public void setTabela(Tabela tabela) {
		this.tabela = tabela;
	}


	public List<Tabela> getTabelas() {
		return tabelas;
	}


	public void setTabelas(List<Tabela> tabelas) {
		this.tabelas = tabelas;
	}
	
	
	public Mesa getMesa() {
		return mesa;
	}


	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}


	public List<Mesa> getMesas() {
		return mesas;
	}


	public void setMesas(List<Mesa> mesas) {
		this.mesas = mesas;
	}


	public Caixa getCaixa() {
		return caixa;
	}


	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}


	public List<Caixa> getCaixas() {
		return caixas;
	}


	public void setCaixas(List<Caixa> caixas) {
		this.caixas = caixas;
	}
    
	

	public MovimentoCaixa getMovicaixa() {
		return movicaixa;
	}


	public void setMovicaixa(MovimentoCaixa movicaixa) {
		this.movicaixa = movicaixa;
	}


	public List<MovimentoCaixa> getMovimentos() {
		return movimentos;
	}


	public void setMovimentos(List<MovimentoCaixa> movimentos) {
		this.movimentos = movimentos;
	}

	
	public List<Mesa> completarmesa(String nome){
		List<Mesa> mesas = mesamy.buscarpelonome(nome);
		if(mesas.size()==0){
			FacesUtil.addErrorMessage("Mesa Não Encontrada");
		}
		return mesas ;
	}
	
	

	public List<Produto> completarproduto(String nome){
		List<Produto> produtos = produtomy.buscarpelonome(nome);
		if(produtos.size()==0){
			FacesUtil.addErrorMessage("Produto Não Encontrado");
		}
		return produtos;
	}
	
	public List<Tabela> completartabela(String nome){
		List<Tabela> tabelas = tabelamy.buscarpelonome(nome);
		if(tabelas.size()==0){
			FacesUtil.addErrorMessage("Tabela Não Encontrada");
		}
		return tabelas;
	}
	public List<Cliente>completarcliente(String nome){
		List<Cliente> clientes = clientemy.buscarpelonome(nome);
		if(clientes.size()==0){
			FacesUtil.addErrorMessage("Cliente Não Encontrado");
		}
		return clientes;
	}


	public MovimentoMesa getMovimentomesa() {
		return movimentomesa;
	}


	public void setMovimentomesa(MovimentoMesa movimentomesa) {
		this.movimentomesa = movimentomesa;
	}


	public List<MovimentoMesa> getMovimentomesas() {
		return movimentomesas;
	}


	public void setMovimentomesas(List<MovimentoMesa> movimentomesas) {
		this.movimentomesas = movimentomesas;
	}


	public ItensDaMesa getItendamesa() {
		return itendamesa;
	}


	public void setItendamesa(ItensDaMesa itendamesa) {
		this.itendamesa = itendamesa;
	}


	public List<ItensDaMesa> getItensmesa() {
		return itensmesa;
	}


	public void setItensmesa(List<ItensDaMesa> itensmesa) {
		this.itensmesa = itensmesa;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public List<Integer> getItens() {
		return itens;
	}


	public void setItens(List<Integer> itens) {
		this.itens = itens;
	}


	public boolean isEditando() {
		return this.movimentomesa.getId() != null;
	}
     

}
