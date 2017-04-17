package br.com.wavii.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.validator.constraints.br.CNPJ;

import br.com.wavii.model.MovimentoCaixa;
import br.com.wavii.model.MovimentoMesa;
import br.com.wavii.model.StatusMesa;
import br.com.wavii.reposytory.MovimentoCaixaMyorder;
import br.com.wavii.reposytory.MovimentoMesaFilter;
import br.com.wavii.reposytory.MovimentoMesaMyorder;

@Named
@ViewScoped
public class PesquisaPedidosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private MovimentoMesaMyorder pedidos;
	@Inject
	private MovimentoCaixaMyorder caixamy;
	private MovimentoMesaFilter filtro;
	private List<MovimentoMesa> pedidosFiltrados;
	private MovimentoCaixa movicaixa;
	private List<MovimentoCaixa> movimentos;

	public PesquisaPedidosBean() {
		filtro = new MovimentoMesaFilter();
		pedidosFiltrados = new ArrayList<>();
	}

	public void pesquisar() {

		pedidosFiltrados = pedidos.filtrados(filtro);
	}

	public void pesquisar1() {
		this.movimentos = caixamy.filtrados(movicaixa);
	}

	public StatusMesa[] getStatuses() {
		return StatusMesa.values();
	}

	public List<MovimentoMesa> getPedidosFiltrados() {
		return pedidosFiltrados;
	}

	public MovimentoMesaFilter getFiltro() {
		return filtro;
	}

	

}