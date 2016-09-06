package br.com.wavii.securyti;

import java.util.Collection;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import br.com.wavii.model.Usuario1;

public class UsuarioSistema extends User {

	private static final long serialVersionUID = 1L;
    
	private Usuario1 usuario;

	public UsuarioSistema(Usuario1 usuario, Collection<? extends GrantedAuthority> authorities) {
		super(usuario.getEmail(), usuario.getSenha(), authorities);
		this.usuario = usuario;
	}

	public Usuario1 getUsuario() {
		return usuario;
	}

}
