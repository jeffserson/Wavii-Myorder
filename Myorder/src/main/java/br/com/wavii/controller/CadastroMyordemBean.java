package br.com.wavii.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.wavii.model.Cep;
import br.com.wavii.model.Empresa;
import br.com.wavii.model.Localidade;
import br.com.wavii.model.Logradouro;
import br.com.wavii.model.Pais;
import br.com.wavii.model.Sublocalidade;
import br.com.wavii.model.Uf;
import br.com.wavii.reposytory.CepMyorder;
import br.com.wavii.reposytory.EmpresaMyorder;
import br.com.wavii.reposytory.LocalidadeMyorder;
import br.com.wavii.reposytory.LogradouroMyorder2;
import br.com.wavii.reposytory.PaisMyorder2;
import br.com.wavii.reposytory.SalvarClienteMyorder;
import br.com.wavii.reposytory.SubLocalidadeMyorder;
import br.com.wavii.reposytory.UfMyorder;
import br.com.wavii.util.JpaUtil;

@Named
@ViewScoped
public  class CadastroMyordemBean implements  Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cepmy == null) ? 0 : cepmy.hashCode());
		result = prime * result + ((ceps == null) ? 0 : ceps.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((localidade == null) ? 0 : localidade.hashCode());
		result = prime * result + ((localidades == null) ? 0 : localidades.hashCode());
		result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result + ((logradouros == null) ? 0 : logradouros.hashCode());
		result = prime * result + ((lomy == null) ? 0 : lomy.hashCode());
		result = prime * result + ((ola == null) ? 0 : ola.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		result = prime * result + ((paises == null) ? 0 : paises.hashCode());
		result = prime * result + ((paiss == null) ? 0 : paiss.hashCode());
		result = prime * result + ((salvarCliente == null) ? 0 : salvarCliente.hashCode());
		result = prime * result + ((sublocalidade == null) ? 0 : sublocalidade.hashCode());
		result = prime * result + ((sublocalidades == null) ? 0 : sublocalidades.hashCode());
		result = prime * result + ((submy == null) ? 0 : submy.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
		result = prime * result + ((uf1 == null) ? 0 : uf1.hashCode());
		result = prime * result + ((ufmy == null) ? 0 : ufmy.hashCode());
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
		CadastroMyordemBean other = (CadastroMyordemBean) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cepmy == null) {
			if (other.cepmy != null)
				return false;
		} else if (!cepmy.equals(other.cepmy))
			return false;
		if (ceps == null) {
			if (other.ceps != null)
				return false;
		} else if (!ceps.equals(other.ceps))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (localidade == null) {
			if (other.localidade != null)
				return false;
		} else if (!localidade.equals(other.localidade))
			return false;
		if (localidades == null) {
			if (other.localidades != null)
				return false;
		} else if (!localidades.equals(other.localidades))
			return false;
		if (logradouro == null) {
			if (other.logradouro != null)
				return false;
		} else if (!logradouro.equals(other.logradouro))
			return false;
		if (logradouros == null) {
			if (other.logradouros != null)
				return false;
		} else if (!logradouros.equals(other.logradouros))
			return false;
		if (lomy == null) {
			if (other.lomy != null)
				return false;
		} else if (!lomy.equals(other.lomy))
			return false;
		if (ola == null) {
			if (other.ola != null)
				return false;
		} else if (!ola.equals(other.ola))
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		if (paises == null) {
			if (other.paises != null)
				return false;
		} else if (!paises.equals(other.paises))
			return false;
		if (paiss == null) {
			if (other.paiss != null)
				return false;
		} else if (!paiss.equals(other.paiss))
			return false;
		if (salvarCliente == null) {
			if (other.salvarCliente != null)
				return false;
		} else if (!salvarCliente.equals(other.salvarCliente))
			return false;
		if (sublocalidade == null) {
			if (other.sublocalidade != null)
				return false;
		} else if (!sublocalidade.equals(other.sublocalidade))
			return false;
		if (sublocalidades == null) {
			if (other.sublocalidades != null)
				return false;
		} else if (!sublocalidades.equals(other.sublocalidades))
			return false;
		if (submy == null) {
			if (other.submy != null)
				return false;
		} else if (!submy.equals(other.submy))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		if (uf1 == null) {
			if (other.uf1 != null)
				return false;
		} else if (!uf1.equals(other.uf1))
			return false;
		if (ufmy == null) {
			if (other.ufmy != null)
				return false;
		} else if (!ufmy.equals(other.ufmy))
			return false;
		return true;
	}

	@Inject
	private SalvarClienteMyorder salvarCliente;
	
	@Inject
	private PaisMyorder2 paiss;
	
	
	@Inject
	private LogradouroMyorder2 ola;

	@Inject
	private UfMyorder ufmy;
	
	@Inject
	private LocalidadeMyorder lomy;
	
	@Inject
	private SubLocalidadeMyorder submy;
	
	@Inject
	private CepMyorder cepmy;
	
	@Inject
	private EmpresaMyorder empresamy;
	
	private Cep cep = new Cep();
	
	public Cep getCep() {
		return cep;
	}


	public void setCep(Cep cep) {
		this.cep = cep;
	}

	private Empresa empresa = new Empresa();
	private Pais pais = new Pais();
	
	
	private Pais pais1;
	
	
	
	
	
	
	
	public Pais getPais1() {
		return pais1;
	}


	public void setPais1(Pais pais1) {
		this.pais1 = pais1;
	}

	private List<Empresa> empresas;
	public List<Empresa> getEmpresas() {
		return empresas;
	}


	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	private Uf uf = new Uf();
	
	private Uf uf2;
	
	private Localidade localidade ;
	
	private Sublocalidade sublocalidade;
	
	public Sublocalidade getSublocalidade() {
		return sublocalidade;
	}


	public void setSublocalidade(Sublocalidade sublocalidade) {
		this.sublocalidade = sublocalidade;
	}


	public List<Sublocalidade> getSublocalidades() {
		return sublocalidades;
	}


	public void setSublocalidades(List<Sublocalidade> sublocalidades) {
		this.sublocalidades = sublocalidades;
	}

	private List<Sublocalidade> sublocalidades = new ArrayList<>() ;
	
	
	public Localidade getLocalidade() {
		return localidade;
	}


	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}


	public List<Localidade> getLocalidades() {
		return localidades;
	}


	public void setLocalidades(List<Localidade> localidades) {
		this.localidades = localidades;
	}

	private List<Localidade> localidades = new ArrayList<>() ;
	
	
	public Uf getUf2() {
		return uf2;
	}


	public void setUf2(Uf uf2) {
		this.uf2 = uf2;
	}


	public Uf getUf() {
		
		
		return uf;
	}


	public void setUf(Uf uf) {
		this.uf = uf;
	}


	public List<Uf> getUf1() {
		
		
		
		return uf1;
	}


	public void setUf1(List<Uf> uf1) {
		this.uf1 = uf1;
	}

	private List<Uf> uf1 = new ArrayList<>() ;
		
	
	private List<Cep> ceps = new ArrayList<>();
		
		
		
	
	public List<Cep> getCeps() {
		return ceps;
	}


	public void setCeps(List<Cep> ceps) {
		this.ceps = ceps;
	}


	public Pais getPais() {
		return pais;
	}


	public void setPais(Pais pais) {
		this.pais = pais;
	}


	public Logradouro getLogradouro() {
		return logradouro;
	}


	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	private Logradouro logradouro = new Logradouro();
	
	public List<Logradouro> getLogradouros() {
		return logradouros;
	}


	public void setLogradouros(List<Logradouro> logradouros) {
		this.logradouros = logradouros;
	}

	private List<Logradouro> logradouros;
	private List<Pais> paises = new ArrayList<>();
	public List<Pais> getPaises() {
		try {
			if((paises == null)||(paises.size()==0)){
				paises = paiss.BuscarPais();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return paises;
	}


	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}

	
	




	public Empresa getEmpresa() {
		return empresa;
	}


	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	
  

	
	public void salvar(){
		salvarCliente.commitar(empresa);
		this.pais = new Pais();
		FacesMessage msg = new FacesMessage("empresa salvo com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	

	
	public void salvarpais(){
		salvarCliente.salvarpais(pais);
		this.pais = new Pais();
		FacesMessage msg = new FacesMessage("Pais salvo com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void salvarlog1(){
		salvarCliente.salvarlog(logradouro);
		this.logradouro = new  Logradouro();
		FacesMessage msg = new FacesMessage("Logradouro salvo com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}
	
	public void salvaruf(){
		salvarCliente.Salvaruf(uf);
		this.uf = new  Uf();
		FacesMessage msg = new FacesMessage("UF salvo com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}
		
	public void salvarloc(){
		salvarCliente.Salvarlocalidade(localidade);
		this.localidade = new Localidade();
		FacesMessage msg = new FacesMessage("Cidade salvo com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}	
			
	public void salvarsubloc(){
		salvarCliente.Salvarsublocalidade(sublocalidade);
		this.sublocalidade = new Sublocalidade();
		FacesMessage msg = new FacesMessage("Bairro salvo com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}	
	public void salvarcep(){
		salvarCliente.Salvarcep(cep);
		this.cep = new Cep();
		FacesMessage msg = new FacesMessage("Cep salvo com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}	
			

		
		public void PrepararCadastro2(){
			this.logradouros = ola.todos();
			if(this.logradouro ==  null){
				this.logradouro = new Logradouro();
			}
		}
		public void PrepararCadastro3(){
			this.paises = paiss.todos();
			if(this.pais==null){
				pais = new Pais();
			}
		}

		public void PrepararCadastro4(){
			this.uf1 = ufmy.todos();
			if(this.uf ==  null){
				this.uf = new Uf();
			}
		}
		
		public void PrepararCadastro5(){
			this.localidades = this.lomy.todos();
			if(this.localidade ==  null){
				this.localidade = new Localidade();
			}
		}
		
		public void PrepararCadastro6(){
			this.sublocalidades = this.submy.todos();
			if(this.sublocalidade ==  null){
				this.sublocalidade = new Sublocalidade();
			}
		}
		
		
		public void PrepararCadastro7(){
			this.ceps = this.cepmy.todos();
			if(this.cep ==  null){
				this.cep = new Cep();
			}
		}
		
		public void PrepararCadastro8(){
			this.empresas = this.empresamy.todos();
			if(this.empresa ==  null){
				this.empresa = new Empresa();
			}
		}
		
		

		public void alterarestado(AjaxBehaviorEvent event){
			   uf1 = ufmy.buscaruf(pais1);
					System.out.println(pais1.getId());
				}
	
		public void alterarcidade(AjaxBehaviorEvent event){
			  localidades = lomy.buscarlocalidade(uf2);
					System.out.println(uf2.getId());
				}
		}
		
		
		

