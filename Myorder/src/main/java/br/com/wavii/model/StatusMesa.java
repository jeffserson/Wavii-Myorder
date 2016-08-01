package br.com.wavii.model;

public enum StatusMesa {

	ABERTO("Aberto"), 
	FINALIZADO("Finalizado"), 
	CANCELADO("Cancelado");
	
	private String descricao;
	
	StatusMesa(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
