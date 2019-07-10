package com.atrium.ciclovida;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Ejemplo de uso ciclo de vida en spring.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 15-3-2017.
 *
 */
public class FactoriaInstancia implements DisposableBean, InitializingBean,
		ApplicationContextAware {

	private String nombre;
	private ApplicationContext ctx;

	private FactoriaInstancia() {
	}

	public Factoria crearBeanInstancia() {
		return Factoria.crearBean();
	}

	//ACCESORES PARA SPRING
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ApplicationContext getCtx() {
		return ctx;
	}

	/**
	 * Metodo implementado de disposablebean.
	 */
	public void destroy() throws Exception {
		System.out.println("El bean se va a destruir");
	}

	/**
	 * Metodo implementado de initializingbean.
	 */
	public void afterPropertiesSet() throws Exception {
		System.out.println("El bean ha sido inicializado con sus propiedades");
	}

	/**
	 * Metodo de la interface ApplicationcontextAware
	 */
	@Override
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		this.ctx = ctx;
	}

}
