package com.estudos.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//define que essa instacia existe durante todo o ciclo de vida da aplicação
@ApplicationScoped 
public class EntityManagerProducer {
	
	private EntityManagerFactory factory;
	
	public EntityManagerProducer() {
		//criação da factory
		this.factory = Persistence.createEntityManagerFactory("CriacaoManagerProducter");
	}
	
	//metodo produtor do EntityManager (metodo que produz a classe EntityManager )
	@Produces
	@RequestScoped //a cada requisição será uma instancia nova do EntityManager
	public EntityManager createEntityManager() {
		return this.factory.createEntityManager();		
	}
	
	//toda vez que acabar o escopo do EntityManager(quando ele for encerrado),
	//o cdi vai chamar esse metodo para  fechar o EntityManager
	public void closeEntityManager(@Disposes EntityManager manager) {
	manager.close();
		
	}
}
