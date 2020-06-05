package com.estudos.enums;

public enum TipoEmpresa {
	MEI("Microempreendedor"),
	EIRLI("Empresa Individual"),
	LTDA("Limitada"),
	SA("Anônima");
	
	private String descricao;	
	

	private TipoEmpresa(String descricao) {
		this.descricao = descricao;
	}


	public String getDescricao() {
		return descricao;
	}

	

}
