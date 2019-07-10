package com.atrium.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Ejemplo de uso configuration de spring.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 15-3-2017.
 *
 */
@Configuration
public class AppConfiguracion {
	
	@Bean(name = "holaBean")
	public MensajeHola hola() {
		return new MensajeHola();
	}

	@Bean(name = "adiosBean")
	public MensajeAdios adios() {
		return new MensajeAdios();
	}

}
