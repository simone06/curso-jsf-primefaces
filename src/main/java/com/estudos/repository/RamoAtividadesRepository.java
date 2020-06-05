package com.estudos.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.estudos.model.RamoAtividade;

public class RamoAtividadesRepository {

	private EntityManager manager;
	
	@Inject
	public RamoAtividadesRepository() {
	}
	
	public RamoAtividadesRepository(EntityManager manager) {
	this.manager = manager;
	}
	

	public List<RamoAtividade> find(String descricao) {
		//busca usando criteria
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		
		CriteriaQuery<RamoAtividade> criteriaQuery =criteriaBuilder.createQuery(RamoAtividade.class);
		Root<RamoAtividade> root= criteriaQuery.from(RamoAtividade.class);//usado apenas para fazer uma especie de "alias"
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.like(root.get("descricao"), descricao + "%"));
		
		TypedQuery<RamoAtividade> query = manager.createQuery(criteriaQuery);
		
		return query.getResultList();
		
	}
}
