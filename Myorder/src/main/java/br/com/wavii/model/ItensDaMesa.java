package br.com.wavii.model;



import java.beans.Transient;
import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tb_itens_mesa")
public class ItensDaMesa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="tb_mov_itens_mesa")
	private MovimentoMesa movimentomesa;
	@ManyToOne
	@JoinColumn(name="tb_produto_itens")
	private Produto produto;
	@NotNull
	@Column(name="quantidade", nullable = false)
	private Integer quantidade = 1;
	@NotNull
	@Column(name="valor_unitario", nullable = false, precision = 10, scale = 2)
	private BigDecimal unitario = BigDecimal.ZERO;
	@Column(name="valor_total", nullable = true, precision = 10, scale = 2)
	private BigDecimal total = BigDecimal.ZERO;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public MovimentoMesa getMovimentomesa() {
		return movimentomesa;
	}
	public void setMovimentomesa(MovimentoMesa movimentomesa) {
		this.movimentomesa = movimentomesa;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getUnitario() {
		return unitario;
	}
	public void setUnitario(BigDecimal unitario) {
		this.unitario = unitario;
	}
	public BigDecimal getTotal() {
		return this.getUnitario().multiply(new BigDecimal(this.getQuantidade()));
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((movimentomesa == null) ? 0 : movimentomesa.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
		result = prime * result + ((unitario == null) ? 0 : unitario.hashCode());
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
		ItensDaMesa other = (ItensDaMesa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (movimentomesa == null) {
			if (other.movimentomesa != null)
				return false;
		} else if (!movimentomesa.equals(other.movimentomesa))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		if (unitario == null) {
			if (other.unitario != null)
				return false;
		} else if (!unitario.equals(other.unitario))
			return false;
		return true;
	}
	
	@Transient
	public boolean isProdutoAssociado() {
		return this.getProduto() != null && this.getProduto().getId() != null;
	}
	
	
	
	
	
	
	
}
