package br.com.wavii.controller;

import br.com.wavii.model.MovimentoMesa;

public class Movimentomesaalteredevent {
	private MovimentoMesa movimentomesa;

	public Movimentomesaalteredevent(MovimentoMesa movimentoMesa) {
		this.movimentomesa = movimentoMesa;
	}

	public MovimentoMesa getMovimentomesa() {
		return movimentomesa;
	}

}
