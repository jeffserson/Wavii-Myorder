package br.com.wavii.reposytory;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.wavii.model.Cep;
import br.com.wavii.model.Empresa;
import br.com.wavii.model.Localidade;
import br.com.wavii.model.Logradouro;
import br.com.wavii.model.Pais;
import br.com.wavii.model.Sublocalidade;
import br.com.wavii.model.Uf;

public class SalvarClienteMyorder implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private EmpresaMyorder empresa;
	
	@Inject
	private PaisMyorder2 pais;
	
	@Inject
	private LogradouroMyorder2 log1;
	
	@Inject
	private UfMyorder ufmy1;
	
	@Inject
	private LocalidadeMyorder locmy;
	
	@Inject
	private SubLocalidadeMyorder submy;
	
	@Inject
	private CepMyorder cepmy;
	
	

	public void commitar(Empresa empresa){
		this.empresa.adcionar(empresa);
		
	}
	
	public void salvarpais(Pais pais){
		this.pais.adcionar(pais);
		
	}
	
	public void salvarlog(Logradouro logradouro){
		this.log1.adcionar(logradouro);
	}
	
	public void Salvaruf(Uf uf){
		this.ufmy1.adcionar(uf);
	}
	public void Salvarlocalidade(Localidade localidade){
		this.locmy.adcionar(localidade);
	}
	
	public void Salvarsublocalidade(Sublocalidade sublocalidade){
		this.submy.adcionar(sublocalidade);
	}
	
	public void Salvarcep(Cep cep){
		this.cepmy.adcionar(cep);
	}
	
}
