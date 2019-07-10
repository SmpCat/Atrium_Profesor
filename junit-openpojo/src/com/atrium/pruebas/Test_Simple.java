 package com.atrium.pruebas;

import org.junit.Before;
import org.junit.Test;

import com.atrium.clases.Person;
import com.atrium.clases.Usuarios;
import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

/**
 * Validacion basica de accesores de propiedades.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 22-3-2017.
 *
 */
public class Test_Simple {
	private String paquete_aprobar;

	@Before
	public void inicio_Prueba() {
		paquete_aprobar = "com.atrium.clases";
	}

	/**
	 * Metodo donde comprobamos que la clase contenga los metodos accesores
	 * segun la norma JAVABEAN.
	 */
	@Test
	public void validacion_SettersAndGetters() {
		// CREACION DE UN OBJETO AUXILIAR PARA EFECTUAR LAS PRUEBAS
		PojoClass objeto_acomprobar = PojoClassFactory.getPojoClass(Usuarios.class);
		// DEFINIMOS OTRO OBJETO AUXILIAR DONDE DEFINIREMOS REGLAS Y SI SE
		// SIGUEN
		ValidatorBuilder validador = ValidatorBuilder.create();
		// INDICAMOS LAS REGLAS A SEGUIR
		// EN ESTE CASO QUE EXISTAN TODOS LOS METODOS SETTER Y GETTER NECESARIOS
		validador.with(new SetterMustExistRule(), new GetterMustExistRule());
		// CREAMOS LOS OBJETOS QUE DEBEN COMPROBAR EL SEGUIMIENTO DE LAS REGLAS
		validador.with(new SetterTester(), new GetterTester());
		// CON EL BUILD CREAMOS EL OBJETO PARA REALIZAR LA VALIDACION Y
		// VALIDAMOS
		validador.build().validate(objeto_acomprobar);
	}

	/**
	 * Metodo donde comprobamos que todas las clases de un paquete contengan los
	 * metodos accesores segun la norma JAVABEAN.
	 */
	@Test
	public void validacion_SettersAndGetters2() {
		// DEFINIMOS OTRO OBJETO AUXILIAR DONDE DEFINIREMOS REGLAS Y SI SE
		// SIGUEN
		ValidatorBuilder validador = ValidatorBuilder.create();
		// INDICAMOS LAS REGLAS A SEGUIR
		// EN ESTE CASO QUE EXISTAN TODOS LOS METODOS SETTER Y GETTER NECESARIOS
		validador.with(new SetterMustExistRule(), new GetterMustExistRule());
		// CREAMOS LOS OBJETOS QUE DEBEN COMPROBAR EL SEGUIMIENTO DE LAS REGLAS
		validador.with(new SetterTester(), new GetterTester());
		// CON EL BUILD CREAMOS EL PAQUETE CON LAS CLASES PARA LA VALIDACION Y
		// VALIDAMOS
		validador.build().validate(paquete_aprobar);
	}
}