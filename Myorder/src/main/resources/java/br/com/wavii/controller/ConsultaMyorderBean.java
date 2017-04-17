package br.com.wavii.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

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
import br.com.wavii.reposytory.SubLocalidadeMyorder;
import br.com.wavii.reposytory.UfMyorder;
import br.com.wavii.util.FacesUtil;
import br.com.wavii.util.JpaUtil;

@Named
@ViewScoped
public class ConsultaMyorderBean implements Serializable {
	private static final long serialVersionUID = 1L;

	String cep;

	String fantasia;

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNome() {

		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	String nome;

	private Uf uf;

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

	public List<Uf> getUfs() {
		return ufs;
	}

	public void setUfs(List<Uf> ufs) {
		this.ufs = ufs;
	}

	private List<Uf> ufs;

	private Empresa empresa;

	private Pais pais;

	private Logradouro logradouro;

	private Localidade localidade;

	private Cep cep1;

	public Cep getCep1() {
		return cep1;
	}

	public void setCep1(Cep cep1) {
		this.cep1 = cep1;
	}

	public String getCep() {
		return cep;
	}

	public List<Cep> getCeps() {
		return ceps;
	}

	public void setCeps(List<Cep> ceps) {
		this.ceps = ceps;
	}

	private List<Cep> ceps;

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

	private List<Localidade> localidades;

	private Sublocalidade sublocalidade;

	private List<Sublocalidade> sublocalidades;

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Pais> getPaises() {
		return paises;
	}

	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}

	private List<Pais> paises;

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	private List<Empresa> empresas;

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	@Inject
	private EmpresaMyorder empresamy;
	@Inject
	private PaisMyorder2 paismy;
	@Inject
	private LogradouroMyorder2 log1;
	@Inject
	private UfMyorder umy;
	@Inject
	private LocalidadeMyorder cidmy;
	@Inject
	private SubLocalidadeMyorder baimy;
	@Inject
	private CepMyorder cepmy;

	private List<Logradouro> logradouros;

	public Logradouro getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	public List<Logradouro> getLogradouros() {
		return logradouros;
	}

	public void setLogradouros(List<Logradouro> logradouros) {
		this.logradouros = logradouros;
	}

	public void consultar2() {
		this.empresas = empresamy.todos();
		empresa = new Empresa();
	}

	public void consultar3() {
		this.paises = paismy.todos();
		pais = new Pais();
	}

	public void consultar4() {
		this.logradouros = log1.todos();
		logradouro = new Logradouro();
	}

	public void consultar5() {
		this.ufs = umy.todos();
		uf = new Uf();
	}

	public void consultar6() {
		this.localidades = cidmy.todos();
		localidade = new Localidade();
	}

	public void consultar7() {
		this.sublocalidades = baimy.todos();
		sublocalidade = new Sublocalidade();
	}

	public void consultar8() {
		this.ceps = cepmy.todos();
		cep1 = new Cep();
	}

	public void excluir(Empresa empresa) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		empresa = manager.find(Empresa.class, empresa.getId());
		manager.remove(empresa);
		trx.commit();
		FacesUtil.addInfoMessage("Empresa Excluida Com Sucesso");
	}

	public void excluirloc(Localidade localidade) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		localidade = manager.find(Localidade.class, localidade.getId());
		manager.remove(localidade);
		trx.commit();
		FacesUtil.addInfoMessage("Cidade Excluida Com Sucesso");
	}

	public void excluirloc(Sublocalidade sublocalidade) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		sublocalidade = manager.find(Sublocalidade.class, sublocalidade.getId());
		manager.remove(sublocalidade);
		trx.commit();
		FacesUtil.addInfoMessage("Bairro Excluido Com Sucesso");
	}

	public void excluirloc(Cep cep) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		cep = manager.find(Cep.class, cep.getId());
		manager.remove(cep);
		trx.commit();
		FacesUtil.addInfoMessage("Cep Excluido Com Sucesso");
	}

	public void excluirloc(Pais pais) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		pais = manager.find(Pais.class, pais.getId());
		manager.remove(pais);
		trx.commit();
		FacesUtil.addInfoMessage("Pais Excluido Com Sucesso");
	}

	public void excluirloc(Uf uf) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		uf = manager.find(Uf.class, uf.getId());
		manager.remove(uf);
		trx.commit();
		FacesUtil.addInfoMessage("Estado Excluido Com Sucesso");
	}

	public void excluirloc(Logradouro logradouro) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		logradouro = manager.find(Logradouro.class, logradouro.getId());
		manager.remove(logradouro);
		trx.commit();
		FacesUtil.addInfoMessage("Tipo De Logradouro Excluido Com Sucesso");
	}

	public void pesquisarpais() {
		paises = paismy.porNomeSemelhante(nome);
	}

	public void pesquisarcep() {
		ceps = cepmy.porNomeSemelhante(cep);
	}

	public void pesquisaruf() {
		ufs = umy.porNomeSemelhante(nome);
	}

	public void pesquisarcidade() {
		localidades = cidmy.porNomeSemelhante(nome);
	}

	public void pesquisarempresa() {
		empresas = empresamy.porNomeSemelhante(fantasia);
	}

	public void pesquisarbairro() {
		sublocalidades = baimy.porNomeSemelhante(nome);
	}
}
