package br.com.wavii.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

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
import br.com.wavii.util.FacesUtil;

@Named
@ViewScoped
public  class CadastroMyordemBean implements  Serializable{

	private static final long serialVersionUID = 1L;

	String cep2;
	


	public String getCep2() {
		return cep2;
	}


	public void setCep2(String cep2) {
		this.cep2 = cep2;
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
	
	private Cep cep;
	
	public Cep getCep() {
		return cep;
	}


	public void setCep(Cep cep) {
		this.cep = cep;
	}

	private Empresa empresa;
	private Pais pais;
	
	
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

	private Uf uf;
	
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
	private List<Pais> paises = new ArrayList<>() ;
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
		if(this.empresa != null){
			this.pais = this.empresa.getSubloclidade().getLocalidade().getUf().getPais();
			this.uf = this.empresa.getSubloclidade().getLocalidade().getUf();
		}
	}


	
  

	
	public String salvar(){
		salvarCliente.commitar(empresa);
		this.pais = new Pais();
		return "/cadastros/EmpresasCadastradas?faces-redirect=true";
	}
	
	

	
	public String salvarpais(){
		
		salvarCliente.salvarpais(pais);
		this.pais = new Pais();
		FacesUtil.addInfoMessage("Pais Cadastrado Com Sucesso");
		return "/auxcadastro/PaisesCadastrados?faces-redirect=true";
	}
	
	public String salvarlog1(){
		salvarCliente.salvarlog(logradouro);
		this.logradouro = new  Logradouro();
		FacesUtil.addInfoMessage("Logradouro Cadastrado Com Sucesso");
		return "/auxcadastro/LogradourosCadastrados2?faces-redirect=true";
	}
	
	public String salvaruf(){
		salvarCliente.Salvaruf(uf);
		this.uf = new  Uf();
		FacesUtil.addInfoMessage("Estado Cadastrado Com Sucesso");
		return "/auxcadastro/UfCadastrados?faces-redirect=true";
	}
		
	public String salvarloc(){
		salvarCliente.Salvarlocalidade(localidade);
		this.localidade = new Localidade();
		FacesUtil.addInfoMessage("Cidade Cadastrado Com Sucesso");
		return "/auxcadastro/LocaisCadastrados?faces-redirect=true";
	}	
			
	public String salvarsubloc(){
		salvarCliente.Salvarsublocalidade(sublocalidade);
		this.sublocalidade = new Sublocalidade();
		FacesUtil.addInfoMessage("Bairro Cadastrado Com Sucesso");
		return "/auxcadastro/BairrosCadastrados?faces-redirect=true";
	}	
	public String salvarcep(){
		salvarCliente.Salvarcep(cep);
		this.cep = new Cep();
		FacesUtil.addInfoMessage("Cep Cadastrado Com Sucesso");
		return "/auxcadastro/CepsCadastrados?faces-redirect=true";
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
			this.paises = paiss.todos();
			this.uf1 = ufmy.todos();
			this.localidades = this.lomy.todos();
			this.logradouros = this.ola.todos();
			this.sublocalidades = this.submy.todos();
			
			if(this.cep ==  null){
				this.cep = new Cep();
			}
		}
		
		public void PrepararCadastro8(){
			this.ceps = this.cepmy.todos();
			this.paises = paiss.todos();
			this.uf1 = ufmy.todos();
			this.localidades = this.lomy.todos();
			this.logradouros = this.ola.todos();
			this.sublocalidades = this.submy.todos();
			if(this.empresa ==  null){
				this.empresa = new Empresa();
			}
		}
		
		
		

		public void alterarestado(AjaxBehaviorEvent event){
			   uf1 = ufmy.buscaruf(pais);
					System.out.println(pais.getId());
			    	
			     }
				
	
		public void alterarcidade(AjaxBehaviorEvent event){
			  localidades = lomy.buscarlocalidade(uf);
			        
					System.out.println(uf.getId());
				}
	         
		 public void buscarcep(AjaxBehaviorEvent event){
		        for (Cep cep1 : ceps) {

		            if (this.empresa.getCep().equals(cep1.getCep())) {
		            	empresa.setLogradouro(cep1.getLogradouro());
                        empresa.setComplemento(cep1.getComplemento());
         
		            }else{
		            	FacesUtil.addErrorMessage("Cep Não encontrado");
		            	empresa.setCep("");
		            }
		 }
		 }
		}
		
		      
		      
		
		
		
		       
		        
		      
		   
		    	
		    	
		
		
		
			   
		   
		
		     
		
			
		
		
		
		
		
		

