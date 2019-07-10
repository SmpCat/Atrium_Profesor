package com.atrium.dominio;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.atrium.hibernate.Roles;
import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.modelo.IGestion_Roles;

/**
 * Datos especificos para el proceso de administracion de usuarios.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 10-11-2017.
 */
@Component("datos_usuario")
@Scope("prototype")
public class Datos_Usuario extends Usuarios {
	// PROPIEDADES PARA LOS BOTONES DEL FORMULARIO
	private String boton_alta;
	private String boton_baja;
	private String boton_modificacion;
	private String boton_consulta;
	private String boton_limpiar;
	private String boton_salir;

	// PROPIEDAD PARA LA CARGA DINAMICA DEL SELECT
	private List<Roles> lista_roles;
	private IGestion_Roles gestion_roles;

	public Datos_Usuario() {
		System.out.println("datos usuario");
		// DATOS INICIALES DELFORMULARIO
		setCarpetaDocumentacion("");
		setFechaAlta(new Date());
		setFechaBaja(null);
		setNombreUsuario("");
		setPassword("");
		setIdioma("");
		setRoles(new Roles(new Byte((byte) 0)));
	}

	@PostConstruct
	public void carga_Roles() {
		lista_roles = gestion_roles.consultar_Todos();
	}

	// ACCESORES PARA SPRING MVC
	public String getBoton_alta() {
		return boton_alta;
	}

	public void setBoton_alta(String boton_alta) {
		this.boton_alta = boton_alta;
	}

	public String getBoton_baja() {
		return boton_baja;
	}

	public void setBoton_baja(String boton_baja) {
		this.boton_baja = boton_baja;
	}

	public String getBoton_modificacion() {
		return boton_modificacion;
	}

	public void setBoton_modificacion(String boton_modificacion) {
		this.boton_modificacion = boton_modificacion;
	}

	public String getBoton_consulta() {
		return boton_consulta;
	}

	public void setBoton_consulta(String boton_consulta) {
		this.boton_consulta = boton_consulta;
	}

	public String getBoton_limpiar() {
		return boton_limpiar;
	}

	public void setBoton_limpiar(String boton_limpiar) {
		this.boton_limpiar = boton_limpiar;
	}

	public String getBoton_salir() {
		return boton_salir;
	}

	public void setBoton_salir(String boton_salir) {
		this.boton_salir = boton_salir;
	}

	public List<Roles> getLista_roles() {
		return lista_roles;
	}

	public void setLista_roles(List<Roles> lista_roles) {
		this.lista_roles = lista_roles;
	}

	// ACCESORES PARA SPRING
	public IGestion_Roles getGestion_roles() {
		return gestion_roles;
	}

	public void setGestion_roles(IGestion_Roles gestion_roles) {
		this.gestion_roles = gestion_roles;
	}

}
