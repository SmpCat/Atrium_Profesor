package com.atrium.object;

/**
 * Ejemplo de sobreescritura de los metodos de la clase object. De uso frecuente
 * dentro del los programas en JAVA.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0
 * @since 24-10-2016.
 */
public class Gestion_Object {
	// PROPIEDADES DE CLASE
	private String texto;
	private Integer ope1;
	private Integer ope2;

	/**
	 * Constructor de la clase.
	 */
	public Gestion_Object() {
		texto = "";
		ope1 = new Integer(0);
		ope2 = new Integer(0);
	}

	/**
	 * Comparacion entre objetos. Se verifica el estado del objeto.
	 */
	@Override
	public boolean equals(Object objeto_acomparar) {
		// BANDERA DE IGUALDAD
		boolean igual;
		// MIRAMOS SI SON DEL MISMO TIPO
		// EN CASO CONTRARIO SE DEVUELVE FALSO
		if (objeto_acomparar instanceof Gestion_Object) {
			igual = true;
		} else {
			igual = false;
		}
		// SI EL SEGUNDO OBJETO CON EL ESTABLECEMOS LA COMPARACION ESTA NULO SE
		// DEVUELVE FALSO
		if (objeto_acomparar == null) {
			igual = false;
		}
		// SI SON DEL MISMO TIPO SE COMPARA EL VALOR DE TODAS LAS PROPIEDADES
		// DEL LOS DOS OBJETOS
		if (igual) {
			// HACEMOS LA CONVERSION DE TIPO PARA PODER COMPARAR LAS PROPIEDADES
			// DE AMBOS OBJETOS
			Gestion_Object otro_modelo = (Gestion_Object) objeto_acomparar;
			if (!this.getOpe1().equals(otro_modelo.getOpe1())) {
				igual = false;
			}
			if (!this.getOpe2().equals(otro_modelo.getOpe2())) {
				igual = false;
			}
			if (!this.getTexto().equals(otro_modelo.getTexto())) {
				igual = false;
			}
		}
		// DEVOLVEMOS EL RESULTADO DE LA COMPARACION
		return igual;
	}

	/**
	 * Proceso de serializacion manual del objeto. Convertimos el estado del
	 * objeto a texto.
	 */
	@Override
	public String toString() {
		String salida;
		// CREAMOS EL TEXTO NECESARIO PARA MOSTRAR EL VALOR DE LAS PROPIEDADES
		salida = "El objeto de la clase Gestion_Object tiene como valores:\n"
				+ "ope1: " + this.getOpe1().toString() + "\n" + "ope2: "
				+ this.getOpe2().toString();
		return salida;
	}

	/**
	 * Proceso de objetencion de la identificacion del objeto para establecer su
	 * identidad unica.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ope1 == null) ? 0 : ope1.hashCode());
		result = prime * result + ((ope2 == null) ? 0 : ope2.hashCode());
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
		return result;
	}

	// METODOS ACCESORES
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Integer getOpe1() {
		return ope1;
	}

	public void setOpe1(Integer ope1) {
		this.ope1 = ope1;
	}

	public Integer getOpe2() {
		return ope2;
	}

	public void setOpe2(Integer ope2) {
		this.ope2 = ope2;
	}

}
