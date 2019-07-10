package com.atrium.controlador;

import java.util.List;

import com.atrium.hibernate.Municipios;
import com.atrium.hibernate.Pais;
import com.atrium.hibernate.Provincias;
import com.atrium.hibernate.modelo.Gestion_Municipios;
import com.atrium.hibernate.modelo.Gestion_Pais;
import com.atrium.hibernate.modelo.Gestion_Provincias;
import com.atrium.hibernate.modelo.IGestion_Pais;

/**
 * Ejemplo basico de uso de HIBERNATE para la gestion de la persistencia.
 * 
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 2-11-2016.
 *
 */
public class Inicio {

	/**
	 * Arranque del programa.
	 * 
	 * @param args
	 *            Argumentos pasados via consola.
	 */
	public static void main(String[] args) {

		Inicio inicio = new Inicio();
		// LLAMADA A CONSULTAS
		inicio.consultar_Pais();
		inicio.consultar_TodosPaises();
		// LLAMADAS A MODICACIONES
		Pais pais = new Pais();
		inicio.altas(pais);
		pais.setPaisNombre("CAMBIAMOS EL NOMBRE");
		inicio.modificacion(pais);
		inicio.bajas(pais);

	}

	/**
	 * Llamada a la consulta de los datos de un pais concreto.
	 */
	public void consultar_Pais() {
		IGestion_Pais gestion_pais = new Gestion_Pais();
		Pais pais_consultado = gestion_pais.consultar_PorCodigo(new Long(73));
		pais_consultado = gestion_pais.consultar_PorCodigo(new Long(995));
	}

	/**
	 * LLamada a la consulta general.
	 */
	public void consultar_TodosPaises() {
		IGestion_Pais gestion_pais = new Gestion_Pais();
		List<Pais> lista = gestion_pais.consultar_Todos();
	}

	/**
	 * Proceso de alta de pais.
	 * 
	 * @param pais
	 *            Objeto de persistencia a dar de alta.
	 */
	public void altas(Pais pais) {
		pais.setCodigoPais(new Long(1999));
		pais.setPaisIso2("13");
		pais.setPaisIso3("113");
		pais.setPaisIsonum(new Integer(999));
		pais.setPaisNombre("prueba online");
		IGestion_Pais gestion_pais = new Gestion_Pais();
		boolean correcto = gestion_pais.alta_Pais(pais);
		if (correcto) {
			// alta correcta
		} else {
			// error en el alta
		}
	}

	/**
	 * Proceso de baja de pais.
	 * 
	 * @param pais
	 *            Objeto de persistencia a dar de baja.
	 */
	public void bajas(Pais pais_aeliminar) {
		IGestion_Pais gestion_pais = new Gestion_Pais();
		boolean correcto = gestion_pais.baja_Pais(pais_aeliminar);
		if (correcto) {
			// baja correcta
		} else {
			// error en la baja
		}
	}

	/**
	 * Proceso de modificacion de pais.
	 * 
	 * @param pais
	 *            Objeto de persistencia a modificar.
	 */
	public void modificacion(Pais pais_modificado) {
		IGestion_Pais gestion_pais = new Gestion_Pais();
		boolean correcto = gestion_pais.modificacion_Pais(pais_modificado);
		if (correcto) {
			// modificacion correcta
		} else {
			// error en la modificacion
		}
	}

	/**
	 * Proceso de consultas de pais.
	 * 
	 * @param pais
	 *            Objeto de persistencia a consultar.
	 */
	public void consultas(Pais pais_modificado) {
		IGestion_Pais gestion_pais = new Gestion_Pais();
		List<Pais> lista = gestion_pais.consultar_Todos();

		for (Pais pais : lista) {
			System.out.println("Nombre pais: " + pais.getPaisNombre());
		}

		Gestion_Provincias gestion_provincias = new Gestion_Provincias();
		List<Provincias> lista_pro = gestion_provincias.consultar_Todas();

		for (Provincias provincia : lista_pro) {
			System.out.println("Provincia " + provincia.getProvincia()
					+ " codigo: " + provincia.getCodigoProvincia());

		}

		Gestion_Municipios gestion_municios = new Gestion_Municipios();
		List<Municipios> lista_muni = gestion_municios.consultar_Todos();

		for (Municipios municipio : lista_muni) {
			System.out.println("Municipio: " + municipio.getMunicipio()
					+ " codigo: " + municipio.getId().getCodigoMunicipio());
		}

		lista_muni = gestion_municios.consultar_PorProvincias(new Byte(
				(byte) 28));

		for (Municipios municipio : lista_muni) {
			System.out.println("Municipio: " + municipio.getMunicipio()
					+ " codigo: " + municipio.getId().getCodigoMunicipio());
		}
	}
}
