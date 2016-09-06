package br.com.wavii.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import br.com.wavii.converter.BaseEntity;

@Entity
@Table(name = "tb_cep")
public class Cep implements BaseEntity, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "tb_sublocalidade")
	private Sublocalidade sublocalidade;

	@ManyToOne
	@JoinColumn(name = "tb_logradouro")
	private Logradouro Tipologradouro;

	@ManyToOne
	@JoinColumn(name = "tb_localidade")
	private Localidade localidade;
	@ManyToOne
	@JoinColumn(name = "tb_uf")
	private Uf uf;
	@ManyToOne
	@JoinColumn(name = "tb_pais")
	private Pais pais;
	@NotBlank(message = "Cep É Obrigatorio")
	@Column(length = 10, nullable = false)
	private String cep;
	@Column(length = 150, nullable = false)
	private String logradouro;
	@Column(length = 200, nullable = false)
	private String complemento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Logradouro getTipologradouro() {
		return Tipologradouro;
	}

	public void setTipologradouro(Logradouro tipologradouro) {
		Tipologradouro = tipologradouro;
	}

	public Sublocalidade getSublocalidade() {
		return sublocalidade;
	}

	public void setSublocalidade(Sublocalidade sublocalidade) {
		this.sublocalidade = sublocalidade;
	}

	public Localidade getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Tipologradouro == null) ? 0 : Tipologradouro.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((localidade == null) ? 0 : localidade.hashCode());
		result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		result = prime * result + ((sublocalidade == null) ? 0 : sublocalidade.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
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
		Cep other = (Cep) obj;
		if (Tipologradouro == null) {
			if (other.Tipologradouro != null)
				return false;
		} else if (!Tipologradouro.equals(other.Tipologradouro))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (localidade == null) {
			if (other.localidade != null)
				return false;
		} else if (!localidade.equals(other.localidade))
			return false;
		if (logradouro == null) {
			if (other.logradouro != null)
				return false;
		} else if (!logradouro.equals(other.logradouro))
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		if (sublocalidade == null) {
			if (other.sublocalidade != null)
				return false;
		} else if (!sublocalidade.equals(other.sublocalidade))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

}
