package com.atrium.validadores;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Proceso de validacion de fechas en un formulario.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.5
 * @serial 28-4-2017.
 * 
 */
public class Validar_RangoFechas implements Validator {

	/**
	 * Proceso de validacion comparando las dos fechas del formulario.<br/>
	 * Tambien, al tener en esta aplicacion activado la comprobacion de campos
	 * vacios, se considera ese caso para no realizar la operacion.
	 */
	@Override
	public void validate(FacesContext contexto, UIComponent componente,
			Object objeto_avalidar) throws ValidatorException {
		// SEGUNDA FECHA PARA LA COMPROBACION, ES EL VALOR DEL COMPONENTE
		Date fecha_baja = (Date) objeto_avalidar;
		// ACCEDEMOS AL OTRO COMPONENTE PARA OBTENER LA OTRA FECHA NECESARIA
		// PARA SU VALIDACION
		UIComponent componente_fechaalta = contexto.getViewRoot()
				.findComponent("formu_conversionvalidacion:fecha_alta");
		// SACAMOS EL OBJETO DATE DEL COMPONENTE
		Date fecha_alta = (Date) ((HtmlInputText) componente_fechaalta)
				.getValue();
		// COMPARAMOS LAS FECHAS
		if (fecha_alta != null && fecha_baja != null
				&& fecha_alta.after(fecha_baja)) {
			// LANZAMOS UNA EXCEPCION EN CASO DE ERROR
			throw new ValidatorException(new FacesMessage(
					"La segunda fecha debe de ser posterior a la primera"));
		}

	}

}
