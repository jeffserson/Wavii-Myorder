package br.com.wavii.reposytory;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import br.com.wavii.model.StatusMesa;

public class MovimentoMesaFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long numeroDe;
	private Long numeroAte;
	private Date dataCriacaoDe;
	private Date dataCriacaoAte;
	private String mesa;
	private String nomeCliente;
	private StatusMesa[] statuses;
	private BigDecimal totalmesa;

	public Long getNumeroDe() {
		return numeroDe;
	}

	public void setNumeroDe(Long numeroDe) {
		this.numeroDe = numeroDe;
	}

	public Long getNumeroAte() {
		return numeroAte;
	}

	public void setNumeroAte(Long numeroAte) {
		this.numeroAte = numeroAte;
	}

	public Date getDataCriacaoDe() {
		return dataCriacaoDe;
	}

	public void setDataCriacaoDe(Date dataCriacaoDe) {
		this.dataCriacaoDe = dataCriacaoDe;
	}

	public Date getDataCriacaoAte() {
		return dataCriacaoAte;
	}

	public void setDataCriacaoAte(Date dataCriacaoAte) {
		this.dataCriacaoAte = dataCriacaoAte;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public StatusMesa[] getStatuses() {
		return statuses;
	}

	public void setStatuses(StatusMesa[] statuses) {
		this.statuses = statuses;
	}

	public String getMesa() {
		return mesa;
	}

	public void setMesa(String mesa) {
		this.mesa = mesa;
	}

	public BigDecimal getTotalmesa() {
		return totalmesa;
	}

	public void setTotalmesa(BigDecimal totalmesa) {
		this.totalmesa = totalmesa;
	}

}