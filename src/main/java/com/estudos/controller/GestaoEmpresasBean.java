package com.estudos.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.estudos.model.Empresa;
import com.estudos.service.EmpresaService;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private EmpresaService empresaService;
    
    private List<Empresa> listaEmpresas;
    
    public void todasEmpresas() {
        listaEmpresas = empresaService.findAll();
    }
    
    public List<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }
}
