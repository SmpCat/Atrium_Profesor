package com.atrium.aop.anotaciones;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Ejemplo de uso de AOP con anotaciones en spring.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 29-3-2017.
 *
 */
@Aspect
public class Aeropuerto {

	// @Pointcut("execution(* *viajar(..))")
	// public void viajar( ){}

	// **** INTERCEPCION ANTES DE LA EJECUCION DEL METODO
	@Before("execution(* *viajar(..))")
	public void embarcar() {
		System.out.println("Pasajeros del vuelo a la puerta de embarque");
	}

	@Before("execution(* *viajar(..))")
	public void facturar() {
		System.out.println("Pasajeros facturando equipaje del vuelo ");
	}

	@Before("execution(* *viajar(..))")
	public void despegar() {
		System.out.println("Vuelo despegando");
	}

	// **** INTERCEPCION DESPUES DE LA EJECUCION DEL METODO
	@After("execution(* *viajar(..))")
	public void aterrizar() {
		System.out.println("Vuelo aterrizando");
	}

	// **** INTERCEPCION DESPUES DE LA DEVOLUCION DEL VALOR
	@AfterReturning("execution(* *viajar(..))")
	public void recogerEquipaje() {
		System.out.println("Pasajeros a la cinta de equipajes");
	}

	@AfterReturning("execution(* *viajar(..))")
	public void salirAeropuerto() {
		System.out.println("Fin del viaje");
	}

	// **** INTERCEPCION AL LANZAR UNA EXCEPCION
	@AfterThrowing(throwing = "ex", pointcut = "execution(* *viajar(..))")
	public void emergenciaABordo(Exception ex) {
		System.out.println("Houston tenemos un problema");
		// ex.printStackTrace();
	}

	// **** INTERCEPCION ANTES Y DESPUES DE LA EJECUCION DEL METODO
	@Around("execution(* *viajar(..))")
	public void medirTiempo(ProceedingJoinPoint delegar) throws Throwable {
		// SE EJECUTA ANTES DEL METODO VIAJAR
		long tiempoInicio = System.currentTimeMillis();

		// PASAMOS EL CONTROL AL METODO VIAJAR
		// OBJ ALMACENA LO QUE DEVUELVE EL METODO VIAJAR.
		// SI ES DE TIPO VOID RETORNA NULL.
		Object obj = delegar.proceed();

		// SE EJECUTA DESPUES DEL METODO VIAJAR
		long tiempoFin = System.currentTimeMillis();
		System.out.println("La duracion del vuelo ha sido "
				+ (tiempoFin - tiempoInicio) + " mseg.");
	}
}
