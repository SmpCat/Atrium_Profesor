package com.atrium.util;

public interface IEliminacion_CargasVagas {

	/**
	 * Proceso de busqueda de propiedades en los objetos de hibernate con cargas
	 * vagas pendientes para su anulacion previa a la conversion a texto.<br/>
	 * Este proceso es valido si la carga vaga es de una propiedad simple, no
	 * funciona si la propiedad es una coleccion.
	 * 
	 * @param tipo_vago
	 *            Tipo del objeto de persistencia.
	 * @param objeto_vago
	 *            Objeto desconectado de hibernate.
	 */
	public void eliminar_CargasVagas(Class<?> tipo_vago, Object objeto_vago);

	/**
	 * Proceso para la elimancion de cargas vagas en objetos de persistencia en
	 * forma reflexiva
	 */
	public void eliminar_CargasEnColecciones(Class<?> tipo_vago,
			Object objeto_vago);

}