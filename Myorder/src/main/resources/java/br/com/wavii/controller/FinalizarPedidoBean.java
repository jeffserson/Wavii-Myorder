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
public class FinalizarPedidoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private SalvarClienteMyorder emissaoPedidoService;

	@Inject
	@MovimentomesaEdicao
	private MovimentoMesa pedido;

	@Inject
	private Event<Movimentomesaalteredevent> pedidoAlteradoEvent;

	public void emitirPedido() {
		this.pedido.removerItemVazio();

		try {
			this.pedido = this.emissaoPedidoService.finalizar(this.pedido);
			this.pedidoAlteradoEvent.fire(new Movimentomesaalteredevent(this.pedido));

			br.com.wavii.util.FacesUtil.addInfoMessage("Mesa Finalizada com sucesso!");
		} finally {
			this.pedido.adicionarItemVazio();
		}
	}

}
