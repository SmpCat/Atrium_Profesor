package anotaciones.spring.psring;

import anotaciones.spring.anotadas.Autowired;

/**
 * Ejemplo de clase que va ha recibir el objeto mediante la inyeccion de la
 * anotacion.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 1-3-2017.
 *
 */
public class NecesitaObjetoInyectado {

	// PROPIEDAD ANOTADA
	@Autowired
	private Inyectar miObjetoInyectado;

	// METODO QUE NOS PERMITIRA COMPROBAR EL EFECTO DE LA NOTACION
	public void usarObjetoInyectadoYMostrarPorPantalla() {
		String textoObtenidoDeObjetoInyectado = miObjetoInyectado.metodoDeObjetoInyectado();
		System.out.println(
				"Lo que me devuelve el método del objeto que me han inyectado: " + textoObtenidoDeObjetoInyectado);
	}

}