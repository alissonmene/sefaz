package br.com.ivia.util;

public enum Parametros {
	
	CONTENT_TYPE_JSON("application/json"),
	GET_PARAMETRO_ACTION("ACTION");
	
	
	private String valor;

	Parametros(String valor) {

		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

}
