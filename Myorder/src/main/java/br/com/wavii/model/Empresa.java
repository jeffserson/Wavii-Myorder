package br.com.wavii.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;

import br.com.wavii.converter.BaseEntity;




@Entity
@Table(name="tb_empresa")
public class Empresa implements BaseEntity, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String codigo;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	private String nome;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getFantasia() {
		return fantasia;
	}
	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}
	public String getRazao() {
		return razao;
	}
	public void setRazao(String razao) {
		this.razao = razao;
	}
	public String getInscestadual() {
		return inscestadual;
	}
	public void setInscestadual(String inscestadual) {
		this.inscestadual = inscestadual;
	}
	public String getInscmunicipal() {
		return inscmunicipal;
	}
	public void setInscmunicipal(String inscmunicipal) {
		this.inscmunicipal = inscmunicipal;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Uf getUf() {
		return uf;
	}
	public void setUf(Uf uf) {
		this.uf = uf;
	}
	
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	@CNPJ
	@Column(length = 60,nullable = false)
	private String cnpj;
	@NotEmpty
	@Column(length = 60,nullable = false)
	private String fantasia;
	@NotEmpty
	@Column(length = 150,nullable = false)
	private String razao;
	@Column(length = 30,nullable = false)
	private String inscestadual;
	@Column(length = 30,nullable = false)
	private String inscmunicipal;
	@Column(length = 10,nullable = false)
	private String cep;
	
	@Column(length = 150,nullable = false)
	private String logradouro;
	@Column(length = 200,nullable = false)
	private String complemento;
	@Column(length = 10,nullable = false)
	private String numero;
	@Column(length = 30,nullable = false)
	private String fone;
	@Column(length = 80,nullable = false)
	private String homepage;
	@Column(length = 80,nullable = false)
	private String Email;
	
	@ManyToOne
	@JoinColumn(name="tb_sublocalidade")
	private Sublocalidade subloclidade;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="tb_pais")
	private Pais pais;
	
	
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	@ManyToOne
	private Logradouro tblogradouro;
	
	
	public Logradouro getTblogradouro() {
		return tblogradouro;
	}
	public void setTblogradouro(Logradouro tblogradouro) {
		this.tblogradouro = tblogradouro;
	}
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="tb_uf")
	private Uf uf;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="tb_localidade")
	private Localidade tblocalidade;
	

	
	
	public Sublocalidade getSubloclidade() {
		return subloclidade;
	}
	public void setSubloclidade(Sublocalidade subloclidade) {
		this.subloclidade = subloclidade;
	}
	public Localidade getTblocalidade() {
		return tblocalidade;
	}
	public void setTblocalidade(Localidade tblocalidade) {
		this.tblocalidade = tblocalidade;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((fantasia == null) ? 0 : fantasia.hashCode());
		result = prime * result + ((fone == null) ? 0 : fone.hashCode());
		result = prime * result + ((homepage == null) ? 0 : homepage.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((inscestadual == null) ? 0 : inscestadual.hashCode());
		result = prime * result + ((inscmunicipal == null) ? 0 : inscmunicipal.hashCode());
		result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		result = prime * result + ((razao == null) ? 0 : razao.hashCode());
		result = prime * result + ((subloclidade == null) ? 0 : subloclidade.hashCode());
		result = prime * result + ((tblocalidade == null) ? 0 : tblocalidade.hashCode());
		result = prime * result + ((tblogradouro == null) ? 0 : tblogradouro.hashCode());
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
		Empresa other = (Empresa) obj;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (fantasia == null) {
			if (other.fantasia != null)
				return false;
		} else if (!fantasia.equals(other.fantasia))
			return false;
		if (fone == null) {
			if (other.fone != null)
				return false;
		} else if (!fone.equals(other.fone))
			return false;
		if (homepage == null) {
			if (other.homepage != null)
				return false;
		} else if (!homepage.equals(other.homepage))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inscestadual == null) {
			if (other.inscestadual != null)
				return false;
		} else if (!inscestadual.equals(other.inscestadual))
			return false;
		if (inscmunicipal == null) {
			if (other.inscmunicipal != null)
				return false;
		} else if (!inscmunicipal.equals(other.inscmunicipal))
			return false;
		if (logradouro == null) {
			if (other.logradouro != null)
				return false;
		} else if (!logradouro.equals(other.logradouro))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		if (razao == null) {
			if (other.razao != null)
				return false;
		} else if (!razao.equals(other.razao))
			return false;
		if (subloclidade == null) {
			if (other.subloclidade != null)
				return false;
		} else if (!subloclidade.equals(other.subloclidade))
			return false;
		if (tblocalidade == null) {
			if (other.tblocalidade != null)
				return false;
		} else if (!tblocalidade.equals(other.tblocalidade))
			return false;
		if (tblogradouro == null) {
			if (other.tblogradouro != null)
				return false;
		} else if (!tblogradouro.equals(other.tblogradouro))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}
	
	
	
	
}

