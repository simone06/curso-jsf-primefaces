package com.estudos.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.estudos.model.Empresa;
import com.estudos.repository.EmpresasRepository;
import com.estudos.util.Transacional;

public class EmpresaService implements Serializable {

	@Inject
	private EmpresasRepository empresaRepository;
	
	@Transacional
	public void saveOrUpdate(Empresa empresa) {
		empresaRepository.saveOrUpdate(empresa);
	}
	
	@Transacional
	public void excluir(Empresa empresa) {
		empresaRepository.remover(empresa);
				
	}
	
	public List<Empresa> findAll() {		
		 return empresaRepository.findAll();		
	}
}
