package com.atrium.enumerador;

import java.util.Objects;

/**
 * Ejemplo de uso del Enum Roles con polimorfismo de metodo.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 1-2-2017.
 *
 */
public class Ejemplo_UsoEnumeration2 {

	public static void main(String arg[]) {
		// OBTENEMOS UN VALOR DEL ENUM ROLES (UNA INSTANCIA PARTICULAR)
		Roles2 primer_rol = Roles2.VENDEDOR;
		// ACCEDEMOS A LAS PROPIEDADES DEL ENUM
		String nombre = primer_rol.getNombre_rol();

		// LLAMAMOS A LOS METODOS DE LA CLASE ENUM (PADRE POR HERENCIA)
		// NOS DA LA POSICION DE LA INSTANCIA CONCRETA, EMPEZANDO POR CERO
		int posicion = primer_rol.ordinal();

		// COMPARAMOS DOS INSTANCIAS DEL ENUM ROL
		boolean iguales = Roles.CLIENTE.equals(Roles.USUARIO);
		boolean iguales2 = Roles.CLIENTE.equals(Roles.CLIENTE);

		// LLAMA AL METODO DE ACCION DE LOS ENUM
		String texto = primer_rol.otro_Nombre();

		String otro_texto = Roles2.ADMINISTRADOR.otro_Nombre();

	}

}
