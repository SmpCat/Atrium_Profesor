package com.atrium.managedbean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.atrium.hibernate.Roles;
import com.atrium.hibernate.modelo.IGestion_Roles;


/**
 * Managedbean de soporte al ejemplo de conversion/validacion. No realiza ningun
 * tipo de tarea.
 * 
 * @author Juan Antonio Solves Garcia.
 * @serial 2.0.
 * @since 11-1-2017.
 * 
 */
@ManagedBean(name = "usuario_bean")
public class Usuario_Bean {
	// PROPIEDADES PARA LOS PARAMETROS DE LA PETICION
	private String nombre_usuario;
	private String clave_usuario;
	private Date fecha_alta;
	private Date fecha_baja;
	private Roles rol_usuario;
	private Integer numero;
	private String email;

	private Roles rol_selecionado;
	private List<Roles> lista_roles;
	@ManagedProperty("#{gestion_roles}")
	private IGestion_Roles gestion_roles;

	private String rol_texto;

	// CONTROL DE INTERNACIONALICION
	private Locale internalizacion_vista;

	@PostConstruct
	public void valores_Iniciales() {
		// CREACION DE UNA FECHA SIN NINGUNA INFORMACION DE LA HORA
		Date inicio_dia = new Date();
		GregorianCalendar eliminacion_horas = new GregorianCalendar();
		eliminacion_horas.setTime(inicio_dia);
		eliminacion_horas.set(Calendar.HOUR_OF_DAY, 1);
		eliminacion_horas.set(Calendar.MINUTE, 0);
		eliminacion_horas.set(Calendar.SECOND, 0);
		eliminacion_horas.set(Calendar.MILLISECOND, 0);
		fecha_alta = eliminacion_horas.getTime();
		// LOCALE POR DEFECTO DEL SISTEMA
		internalizacion_vista = Locale.getDefault();
		// PROCESO DINAMICO DE CREACION DE CONTENIDO DEL SELECT
		lista_roles = gestion_roles.consultar_Todos();
	}

	public void boton_Evento(ActionEvent evento) {
		System.out.println("soy el evento de boton");
	}

	// ACCESORES PARA JSF
	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getClave_usuario() {
		return clave_usuario;
	}

	public void setClave_usuario(String clave_usuario) {
		this.clave_usuario = clave_usuario;
	}

	public Date getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	public Date getFecha_baja() {
		return fecha_baja;
	}

	public void setFecha_baja(Date fecha_baja) {
		this.fecha_baja = fecha_baja;
	}

	public Roles getRol_usuario() {
		return rol_usuario;
	}

	public void setRol_usuario(Roles rol_usuario) {
		this.rol_usuario = rol_usuario;
	}

	public Locale getInternalizacion_vista() {
		return internalizacion_vista;
	}

	public void setInternalizacion_vista(Locale internalizacion_vista) {
		this.internalizacion_vista = internalizacion_vista;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Roles getRol_selecionado() {
		return rol_selecionado;
	}

	public void setRol_selecionado(Roles rol_selecionado) {
		this.rol_selecionado = rol_selecionado;
	}

	public List<Roles> getLista_roles() {
		return lista_roles;
	}

	public void setLista_roles(List<Roles> lista_roles) {
		this.lista_roles = lista_roles;
	}

	public String getRol_texto() {
		return rol_texto;
	}

	public void setRol_texto(String rol_texto) {
		this.rol_texto = rol_texto;
	}

	// ACCESORES PARA SPRING
	public void setGestion_roles(IGestion_Roles gestion_roles) {
		this.gestion_roles = gestion_roles;
	}

}
