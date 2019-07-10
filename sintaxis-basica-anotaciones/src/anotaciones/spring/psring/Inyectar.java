package anotaciones.spring.psring;

/**
 * Ejemplo de objeto simple que va ha ser inyectado mediante la anotacion.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 1-3-2017.
 *
 */
public class Inyectar {
	// PROPIEDAD DE CLASE
	private String algoQueDevolver = "'Algo devuelto desde el objeto inyectado'";

	// METODO DE ACCESO A LA PROPIEDAD
	public String metodoDeObjetoInyectado() {
		return algoQueDevolver;
	}

}
