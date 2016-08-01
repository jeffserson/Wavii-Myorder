package br.com.wavii.controller;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.wavii.model.Grupo;
import br.com.wavii.model.Usuario1;
import br.com.wavii.util.JpaUtil;

public class CriarTabelas {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		
		Grupo vendedor = new Grupo();
		vendedor.setNome("VENDEDOR");
		vendedor.setDescricao("ana camila ");
		
		Grupo usuario = new Grupo();
		usuario.setNome("ROLE_USER");
		usuario.setDescricao("jefferson carvalho");
		
		manager.persist(vendedor);
		manager.persist(usuario);
		
		
		Usuario1 usuario1 = new Usuario1();
		usuario1.setEmail("anacamilalc@gmail.com.br");
		usuario1.getGrupos().add(vendedor);
		usuario1.setNome("camila");
		usuario1.setSenha("luancalebe");
		
		
		Usuario1 usuario2 = new Usuario1();
		usuario2.setEmail("mariaalice@gmail.com.br");
		usuario2.getGrupos().add(usuario);
		usuario2.setNome("alice");
		usuario2.setSenha("rian");
		
		manager.persist(usuario2);
		manager.persist(usuario1);
		
		trx.commit();
		
		manager.close();
	   
	}
		

}	
	
		
	


	


