package com.estudos.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class EmpresaBean implements Serializable {

	private static final long serialVersionUID = 1L;	
	
	
	public String navegation() {
		return "escopo?faces-redirect=true";
		
	}



	
}
