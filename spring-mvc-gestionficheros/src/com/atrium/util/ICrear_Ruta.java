package com.atrium.util;

public interface ICrear_Ruta {

	/**
	 * Creacion de la carpeta general para el repositorio documental. Estrategia
	 * de creacion, dentro de la aplicacion WEB.
	 * 
	 * @param repositorio
	 *            Nombre de la carpeta.
	 * @return Ruta absoluta de la carpeta creada/comprobada.
	 */
	public String crear_CarpetaRepositorio(String repositorio);

	/**
	 * Proceso mediante el cual creamos la primera carpeta de cada usuario, sino
	 * existe. Ademas comprobamos que sea un usuario valido. A continuacion en
	 * caso de que tenga alguna preferecia en su perfil creamos una nueva
	 * carpeta para la documentacion. Se establece un sistema para
	 * autoconfigurar en nombre y ruta de la carpeta general (repositorio
	 * documental)
	 * 
	 * @param clave_usuario
	 */
	public String crear_Carpetas(String nombre_usuario, String clave_usuario);

	/**
	 * Creacion en dos pasos.<br/>
	 * 1º Creacion/comprobacion de la carpeta general a partir de un parametro
	 * del web.xml <br/>
	 * 2º Creacion/comprobacion de la carpeta del usurio a partir de la cadena
	 * dada.<br/>
	 * Una vez echo lo anterior se devuelve la ruta de la carpeta del usuario
	 * com un string
	 * 
	 * @param Carpeta_usuario
	 * 
	 * @return Ruta de la carpeta del usuario una vez comprobada/creada.
	 */
	public String crear_Carpetas(String carpeta_usuario);

}