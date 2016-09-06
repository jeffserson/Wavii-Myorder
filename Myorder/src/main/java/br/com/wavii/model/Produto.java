package br.com.wavii.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import br.com.wavii.converter.BaseEntity;

@Entity
@Table(name = "tb_produto")
public class Produto implements BaseEntity, Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "tb_produto_funcionario")
	private Funcionario funcionario;
	@NotBlank
	@Column(length = 30, nullable = false)
	private String ean;
	@NotBlank
	@Column(length = 60, nullable = false)
	private String Codigo;
	@NotBlank
	@Column(length = 150, nullable = false)
	private String nome;
	@NotNull
	@Column(precision = 10, scale = 0, nullable = false)
	private BigDecimal Estmin;
	@NotNull
	@Column(precision = 10, scale = 0, nullable = false)
	private BigDecimal Estmax;
	@Temporal(TemporalType.DATE)
	@Column(name = "data_cadastro", nullable = false)
	private Date Cadastrado;
	@Temporal(TemporalType.DATE)
	@Column(name = "data_Inatividade", nullable = false)
	private Date Inativo;
	@OneToOne(mappedBy = "produto1")
	private Preço preco1;
    @Version
	private Integer versao;	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
	public Integer getVersao() {
		return versao;
	}

	public void setVersao(Integer versao) {
		this.versao = versao;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getEstmin() {
		return Estmin;
	}

	public void setEstmin(BigDecimal estmin) {
		Estmin = estmin;
	}

	public BigDecimal getEstmax() {
		return Estmax;
	}

	public void setEstmax(BigDecimal estmax) {
		Estmax = estmax;
	}

	public Date getCadastrado() {
		return Cadastrado;
	}

	public void setCadastrado(Date cadastrado) {
		Cadastrado = cadastrado;
	}

	public Date getInativo() {
		return Inativo;
	}

	public void setInativo(Date inativo) {
		Inativo = inativo;
	}

	public Preço getPreco1() {
		return preco1;
	}

	public void setPreco1(Preço preco1) {
		this.preco1 = preco1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
