package br.com.wavii.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.wavii.converter.BaseEntity;
@Entity
@Table(name="tb_movcaixa")
public class MovimentoCaixa implements BaseEntity, Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(optional=false)
	@JoinColumn(name="tb_caixa")
	private Caixa caixa;
	@ManyToOne(optional=false)
	@JoinColumn(name="tb_funcionario")
	private Funcionario funcionario;
	@Temporal(TemporalType.DATE) 
	@Column(name = "data_abertura", nullable = false)
	private Date abertura;
	@Temporal(TemporalType.DATE) 
	@Column(name = "data_fechamento", nullable = false)
	private Date fechamento;
	@Column(precision = 10, scale = 0, nullable = false)
	private BigDecimal total = BigDecimal.ZERO;
	@OneToMany(mappedBy="movimentocaixa", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY )
	private List<MovimentoMesa> movimentomesas = new ArrayList<>();
	@OneToMany
	private List<Mesa> mesa = new ArrayList<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Caixa getCaixa() {
		return caixa;
	}
	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Date getAbertura() {
		return abertura;
	}
	public void setAbertura(Date abertura) {
		this.abertura = abertura;
	}
	public Date getFechamento() {
		return fechamento;
	}
	public void setFechamento(Date fechamento) {
		this.fechamento = fechamento;
	}
	public BigDecimal getTotal() {
		
		
		
		
		return total;
	}
	public void setTotal(BigDecimal total2) {
		this.total = total2;
	}
	
	public List<MovimentoMesa> getMovimentomesas() {
		return movimentomesas;
	}
	public void setMovimentomesas(List<MovimentoMesa> movimentomesas) {
		this.movimentomesas = movimentomesas;
	}
	
	
	public List<Mesa> getMesa() {
		return mesa;
	}
	public void setMesa(List<Mesa> mesa) {
		this.mesa = mesa;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abertura == null) ? 0 : abertura.hashCode());
		result = prime * result + ((caixa == null) ? 0 : caixa.hashCode());
		result = prime * result + ((fechamento == null) ? 0 : fechamento.hashCode());
		result = prime * result + ((funcionario == null) ? 0 : funcionario.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((movimentomesas == null) ? 0 : movimentomesas.hashCode());
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
		MovimentoCaixa other = (MovimentoCaixa) obj;
		if (abertura == null) {
			if (other.abertura != null)
				return false;
		} else if (!abertura.equals(other.abertura))
			return false;
		if (caixa == null) {
			if (other.caixa != null)
				return false;
		} else if (!caixa.equals(other.caixa))
			return false;
		if (fechamento == null) {
			if (other.fechamento != null)
				return false;
		} else if (!fechamento.equals(other.fechamento))
			return false;
		if (funcionario == null) {
			if (other.funcionario != null)
				return false;
		} else if (!funcionario.equals(other.funcionario))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (movimentomesas == null) {
			if (other.movimentomesas != null)
				return false;
		} else if (!movimentomesas.equals(other.movimentomesas))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}
	

		
		
		
	
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
