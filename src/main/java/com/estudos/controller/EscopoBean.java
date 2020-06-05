package com.estudos.controller;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class EscopoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static Integer NUM = 0;

	public EscopoBean() {
		NUM++;
	}

	public Integer getNum() {
		return NUM;
	}

	public static Integer getNUM() {
		return NUM;
	}



	
}
