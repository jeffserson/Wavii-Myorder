package br.com.wavii.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.wavii.model.Empresa;
import br.com.wavii.model.Pais;
import br.com.wavii.util.JpaUtil;

public class CriarTabelas {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		
		manager.close();
		

	}

}
