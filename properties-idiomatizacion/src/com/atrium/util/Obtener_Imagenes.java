package com.atrium.util;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Tratamiento general de las imagenes en nuestra aplicacion.
 * 
 * @author Juan Antonio Solves Garcia
 * @version 1.3
 * @since 28-9-2016.
 * 
 */
public class Obtener_Imagenes implements Imagen {

	/**
	 * Proceso de escalado de imagenes.
	 * 
	 * @param ruta_nombre
	 *            Ruta interna del icono/imagen.
	 * @param tamaño
	 *            Valor entro que representa el tamaño a aplicar, definido en
	 *            constantes de clase.
	 * @return Imagen escalada.
	 */
	public static ImageIcon escalar_Imagen(String ruta_nombre, int tamaño) {
		// OBTENEMOS LA IMAGEN A ESCALAR
		ImageIcon imagen_tratada = new ImageIcon(
				Obtener_Imagenes.class.getResource(ruta_nombre));
		// ESTABLECEMOS LA ESCALA SEGUN NECESIDADES
		if (tamaño == _16X16) {
			imagen_tratada = new ImageIcon(imagen_tratada.getImage()
					.getScaledInstance(16, 16, Image.SCALE_SMOOTH));
		}
		if (tamaño == _24X24) {
			imagen_tratada = new ImageIcon(imagen_tratada.getImage()
					.getScaledInstance(24, 24, Image.SCALE_SMOOTH));
		}
		if (tamaño == _32X32) {
			imagen_tratada = new ImageIcon(imagen_tratada.getImage()
					.getScaledInstance(32, 32, Image.SCALE_SMOOTH));
		}
		if (tamaño == _48X48) {
			imagen_tratada = new ImageIcon(imagen_tratada.getImage()
					.getScaledInstance(48, 48, Image.SCALE_SMOOTH));
		}
		if (tamaño == _60X60) {
			imagen_tratada = new ImageIcon(imagen_tratada.getImage()
					.getScaledInstance(60, 60, Image.SCALE_SMOOTH));
		}
		if (tamaño == _256X256) {
			imagen_tratada = new ImageIcon(imagen_tratada.getImage()
					.getScaledInstance(256, 256, Image.SCALE_SMOOTH));
		}
		return imagen_tratada;
	}

}
