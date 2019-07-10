package com.atrium.acciones;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;

import com.atrium.formbeans.Listas_Bean;
import com.atrium.hibernate.Provincias;
import com.atrium.hibernate.modelo.IGestion_Provincias;
import com.atrium.spring.Acceso_ApplicationContext;
import com.atrium.util.Combo_Objeto;

/**
 * Ejemplo de accion multiple de strut para la resolucion de las peticiones via
 * AJAX de los combos.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 3-11-2017.
 * 
 */
public class Listas_Accion extends LookupDispatchAction {

	/**
	 * Definicion de valores y metodos a llamar segun valor de peticion
	 * recibida.</br> La clave del mapa tendra que ser una clave de properties y
	 * el valor el nombre del metodo a llamar por el controlador de strut.
	 * 
	 * @return Map Mapa con las opciones definidas para esta accion.
	 */
	@Override
	protected Map getKeyMethodMap() {
		Map<String, String> mapa = new HashMap<>();
		mapa.put("ajax.provincias", "cargar_Provincias");
		return mapa;
	}

	/**
	 * Proceso de consulta de las provincias y su posterior envio en formato
	 * JSON al cliente.
	 * 
	 * @param mapa_forward
	 * @param datos
	 * @param peticion
	 * @param respuesta
	 * @return
	 */
	public ActionForward cargar_Provincias(ActionMapping mapa_forward,
			ActionForm datos, HttpServletRequest peticion,
			HttpServletResponse respuesta) {
		// PROPIEDADES DE TRABAJO DE LA ACCION
		Listas_Bean datos_formulario = (Listas_Bean) datos;
		String respuesta_json = null;
		List<Provincias> lista = null;
		if (datos_formulario.getPais_seleccionado().equals("73")) {
			datos_formulario.getLista_provincias().clear();
			// PAIS SELECCIONADO ESPAÑA. SE CARGAN PROVINCIAS
			lista = Acceso_ApplicationContext
					.getBean(IGestion_Provincias.class).consultar_Todas();
			// ACTUALIZAMOS LA PROPIEDAD DEL FORMBEAN CON LOS VALORES LEIDOS
			for (Provincias provincia : lista) {
				Combo_Objeto opcion = new Combo_Objeto();
				opcion.setValor_combo(String.valueOf(provincia
						.getCodigoProvincia()));
				opcion.setTexto_combo(provincia.getProvincia());
				datos_formulario.getLista_provincias().add(opcion);
			}
		} else {
			// EL PAIS SELECCIONADO NO ES ESPAÑA.
			// CREAMOS UNA OPCION POR DEFECTO
			Combo_Objeto opcion = new Combo_Objeto();
			opcion.setTexto_combo("Seleccione previamente un pais");
			opcion.setValor_combo("0");
			// ACTUALIZAMOS LA PROPIEDAD DEL FORMBEAN CON LOS VALORES LEIDOS
			datos_formulario.getLista_provincias().clear();
			datos_formulario.getLista_provincias().add(opcion);
			// PREPARAMOS DATOS PARA CONTESTAR LA PETICION
			lista = new ArrayList<>(0);
			Provincias opcion_defecto = new Provincias();
			opcion_defecto.setProvincia("Seleccione previamente un pais");
			opcion_defecto.setCodigoProvincia(new Byte((byte) 0));
			lista.add(opcion_defecto);
		}
		// CONVERSION A TEXTO PARA LA RESPUESTA AL CLIENTE
		// DEFINICION DE LOS ELEMENTOS DE LA LISTA
		JsonConfig configurador = new JsonConfig();
		configurador.setRootClass(Combo_Objeto.class);
		// CONVERSION DE LA LISTA A TEXTO SEGUN SU CONTENIDO
		respuesta_json = JSONArray.fromObject(lista, configurador).toString();
		// ESCRIBIMOS LA RESPUESTA AL CLIENTE
		respuesta.setContentType("text/plain");
		respuesta.setCharacterEncoding("ISO-8859-15");
		try {
			respuesta.getOutputStream().print(respuesta_json);
		} catch (IOException e) {
			// ERROR EN LA SALIDA DE LA RESPUESTA A LA PETICION AJAX
			e.printStackTrace();
		}
		return null;
	}

}
