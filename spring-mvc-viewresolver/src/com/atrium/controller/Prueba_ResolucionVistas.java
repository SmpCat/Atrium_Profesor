package com.atrium.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Ejemplo de controller para la llamada a resolutores de vista.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 16-11-2017.
 *
 */
@Controller("prueba.vistas")
@Scope("prototype")
public class Prueba_ResolucionVistas {

	/**
	 * Proceso de llamada a los resolutores. No realiza ninguna logica
	 * 
	 * @param pagina
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/pagina.htm")
	public String navegar_Pagina(@RequestParam(name = "pagina") String pagina) {
		System.out.println("Parametro de peticion ... "+pagina);
		return pagina;
	}

}
