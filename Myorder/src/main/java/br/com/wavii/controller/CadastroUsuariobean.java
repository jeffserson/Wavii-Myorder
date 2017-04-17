package br.com.wavii.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.wavii.model.Grupo;
import br.com.wavii.model.Usuario1;
import br.com.wavii.reposytory.Grupos;
import br.com.wavii.reposytory.SalvarClienteMyorder;
import br.com.wavii.reposytory.Usuarios;
import br.com.wavii.util.FacesProducer;
import br.com.wavii.util.FacesUtil;
import br.com.wavii.util.Transactional;

@Named
@ViewScoped
public class CadastroUsuariobean implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Usuarios usuario1;
	@Inject
	private Grupos grupomy;
	@Inject
	private SalvarClienteMyorder salvarusuario;
	
    private List<Usuario1> usuarios;
    
	private Usuario1 usuario;
   
    private List<Grupo> grupos;
	
    public void consultarusuarios(){
    	this.usuarios = usuario1.vendedores();
    }
    public void prepararusuario(){
    	 
    	this.grupos = grupomy.grupos();
    	this.usuarios = usuario1.vendedores();
    	if(usuario == null){
    		usuario = new Usuario1();
    	
    	}
    }
	
	public void salvar(){
		usuario.setSenha(DigestUtils.sha256Hex(usuario.getSenha()));
		salvarusuario.salvarusuarioo(usuario);
		FacesUtil.addInfoMessage("Usuario Alterado Com Sucesso");
		this.usuario = new Usuario1();	
		}
	

	public List<Usuario1> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario1> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario1 getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario1 usuario) {
		this.usuario = usuario;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	
}
