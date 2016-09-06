package br.com.wavii.model;

import java.beans.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import br.com.wavii.converter.BaseEntity;

@Entity
@Table(name = "tb_movimentomesa")
public class MovimentoMesa implements BaseEntity, Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "tb_movimentomesa_cliente")
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name = "tb_movimentomesa_movimentocaixa")
	private MovimentoCaixa movcaixa;
	@ManyToOne
	private Mesa mesa;
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private StatusMesa statusmesa = StatusMesa.ABERTO;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "inicio", nullable = false)
	private Date inicio;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Fim", nullable = true)
	private Date fim;
	@Column(name = "total", nullable = false)
	private BigDecimal total = BigDecimal.ZERO;
	@OneToMany(mappedBy = "movimentomesa", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<ItensDaMesa> itens = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa produto) {
		this.mesa = produto;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total2) {
		this.total = total2;
	}

	public List<ItensDaMesa> getItens() {
		return itens;
	}

	public void setItens(List<ItensDaMesa> itens) {
		this.itens = itens;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public StatusMesa getStatusmesa() {
		return statusmesa;
	}

	public void setStatusmesa(StatusMesa statusmesa) {
		this.statusmesa = statusmesa;
	}

	public MovimentoCaixa getMovcaixa() {
		return movcaixa;
	}

	public void setMovcaixa(MovimentoCaixa movcaixa) {
		this.movcaixa = movcaixa;
	}

	@Transient
	public boolean isNovo() {
		return getId() == null;
	}

	@Transient
	public boolean isExistente() {
		return !isNovo();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((fim == null) ? 0 : fim.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((inicio == null) ? 0 : inicio.hashCode());
		result = prime * result + ((itens == null) ? 0 : itens.hashCode());
		result = prime * result + ((mesa == null) ? 0 : mesa.hashCode());
		result = prime * result + ((statusmesa == null) ? 0 : statusmesa.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovimentoMesa other = (MovimentoMesa) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (fim == null) {
			if (other.fim != null)
				return false;
		} else if (!fim.equals(other.fim))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inicio == null) {
			if (other.inicio != null)
				return false;
		} else if (!inicio.equals(other.inicio))
			return false;
		if (itens == null) {
			if (other.itens != null)
				return false;
		} else if (!itens.equals(other.itens))
			return false;
		if (mesa == null) {
			if (other.mesa != null)
				return false;
		} else if (!mesa.equals(other.mesa))
			return false;
		if (statusmesa != other.statusmesa)
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}

	public void adicionarItemVazio() {

		if (this.isAberto()) {
			Produto produto = new Produto();

			ItensDaMesa item = new ItensDaMesa();
			item.setProduto(produto);
			item.setMovimentomesa(this);

			this.getItens().add(0, item);
		}
	}

	public void recalcularValorTotal() {
		BigDecimal total = BigDecimal.ZERO;

		for (ItensDaMesa item : this.getItens()) {
			if (item.getProduto() != null && item.getProduto().getId() != null) {
				total = total.add(item.getTotal());

			}
		}

		this.setTotal(total);
	}

	public void removerItemVazio() {
		ItensDaMesa primeiroItem = this.getItens().get(0);

		if (primeiroItem != null && primeiroItem.getProduto().getId() == null) {
			this.getItens().remove(0);
		}
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transient
	public boolean isAberto() {
		return StatusMesa.ABERTO.equals(this.getStatusmesa());
	}

	@Transient
	public boolean isFinalizado() {
		return StatusMesa.FINALIZADO.equals(this.getStatusmesa());
	}

	@Transient
	public boolean isNaoFinalizavel() {
		return !this.isFinalizavel();
	}

	@Transient
	public boolean isFinalizavel() {
		return this.isExistente() && this.isAberto();
	}

	@Transient
	public boolean isCancelavel() {
		return this.isExistente() && !this.isCancelado();
	}

	@Transient
	private boolean isCancelado() {
		return StatusMesa.CANCELADO.equals(this.getStatusmesa());
	}

	@Transient
	public boolean isNaoCancelavel() {
		return !this.isCancelavel();
	}

	@Transient
	public boolean isAlteravel() {
		return this.isAberto();
	}

	@Transient
	public boolean isNaoAlteravel() {
		return !this.isAlteravel();
	}

	@Transient
	public boolean isNaoEnviavelPorEmail() {
		return this.isNovo() || this.isCancelado();
	}

	@Transient
	public boolean isProdutoAssociado() {
		return this.getMesa() != null && this.getMesa().getId() != null;
	}

}
