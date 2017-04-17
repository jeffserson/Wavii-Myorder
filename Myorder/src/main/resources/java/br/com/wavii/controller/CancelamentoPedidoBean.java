package br.com.wavii.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.wavii.model.MovimentoMesa;
import br.com.wavii.reposytory.SalvarClienteMyorder;

@Named
@RequestScoped
public class CancelamentoPedidoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private SalvarClienteMyorder cancelamentoPedidoService;

	@Inject
	private Event<Movimentomesaalteredevent> pedidoAlteradoEvent;

	@Inject
	@MovimentomesaEdicao
	private MovimentoMesa pedido;

	public void cancelarPedido() {
		this.pedido = this.cancelamentoPedidoService.cancelar(this.pedido);
		this.pedidoAlteradoEvent.fire(new Movimentomesaalteredevent(this.pedido));

		br.com.wavii.util.FacesUtil.addInfoMessage("Mesa cancelada com sucesso!");
	}

}
