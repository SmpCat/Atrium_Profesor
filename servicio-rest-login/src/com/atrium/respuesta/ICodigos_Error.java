package com.atrium.respuesta;

/**
 * Interface que definen el conjunto de valores para indicar el error encontrado
 * al ejecutar el servicio.
 * 
 * @author Juan Antonio Solves Garcia
 * @version 1.2
 * @since 14-2-2018.
 */
public interface ICodigos_Error {
	// CODIGOS DE ERROR EN LAS OPERACIONES
	public final int ERROR_FORMATOINCORRECTO = 1;
	public final int ERROR_VALIDACIONNOMBREVACIO = 10;
	public final int ERROR_VALIDACIONNOMBRENULO = 15;
	public final int ERROR_VALIDACIONCLAVEROLVACIA = 16;
	public final int ERROR_VALIDACIONCLAVETAREAVACIA = 17;
	public final int ERROR_VALIDACIONCLAVEVACIA = 20;
	public final int ERROR_VALIDACIONCLAVENULO = 25;
	public final int ERROR_VALIDACIONTAMNOMBRE = 30;
	public final int ERROR_VALIDACIONTAMCLAVE = 35;
	public final int ERROR_VALIDACIONFECHASUSUARIOS = 40;
	public final int ERROR_USUARIOINEXISTENTE = 100;
	public final int ERROR_USUARIOCLAVE = 200;
	public final int ERROR_USUARIOSINROL = 300;
	public final int ERROR_USUARIOSINTAREAS = 400;
	// CODIGOS DE CONFIRMACION DE OPERACION
	public final int USUARIO_CORRECTO = 0;
	public final int ALTA_USUARIOCORRECTA = 500;
	public final int ALTA_USUARIOINCORRECTA = 510;
	public final int BAJA_USUARIOCORRECTA = 520;
	public final int BAJA_USUARIOINCORRECTA = 525;
	public final int MODIFICACION_USUARIOCORRECTA = 530;
	public final int MODIFICACION_USUARIOINCORRECTA = 535;
	public final int ALTA_ROLCORRECTA = 600;
	public final int ALTA_ROLINCORRECTA = 605;
	public final int BAJA_ROLCORRECTA = 610;
	public final int BAJA_ROLINCORRECTA = 615;
	public final int MODIFICACION_ROLCORRECTA = 620;
	public final int MODIFICACION_ROLINCORRECTA = 625;
	public final int ALTA_TAREACORRECTA = 700;
	public final int ALTA_TAREAINCORRECTA = 705;
	public final int BAJA_TAREACORRECTA = 710;
	public final int BAJA_TAREAINCORRECTA = 715;
	public final int MODIFICACION_TAREACORRECTA = 720;
	public final int MODIFICACION_TAREAINCORRECTA = 725;
}
