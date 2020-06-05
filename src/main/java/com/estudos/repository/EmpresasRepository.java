package com.estudos.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.estudos.model.Empresa;

import java.util.List;

public class EmpresasRepository implements Serializable{

	private static final long serialVersionUID = -4336300264550645692L;
	
	@Inject
	private EntityManager manager;
	
	public EmpresasRepository() {
		
	}
	
	public EmpresasRepository(EntityManager em) {
		this.manager=em;
		
	}

	public Empresa findById(Long id) {
		return manager.find(Empresa.class, id);
		
	}
	
	public List<Empresa> findByNomeFantasia(String nome) {
		//consulta usando jpql
		TypedQuery<Empresa> query = manager.createQuery("from Empresa where nomeFantasia like :nome",Empresa.class);
		query.setParameter("nomeFantasia", nome + "%");
		return query.getResultList();
		
	}
	
	public void saveOrUpdate(Empresa empresa) {
		manager.merge(empresa);
		
	}
	
	public void remover(Empresa empresa) {
		manager.remove(empresa);
		
	}
	
	public List<Empresa> findAll() {
	
		 return manager.createQuery("from Empresa", Empresa.class).getResultList();	
		
	}
	
}
