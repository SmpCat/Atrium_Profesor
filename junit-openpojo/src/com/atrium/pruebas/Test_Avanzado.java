package com.atrium.pruebas;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.NoFieldShadowingRule;
import com.openpojo.validation.rule.impl.NoNestedClassRule;
import com.openpojo.validation.rule.impl.NoPrimitivesRule;
import com.openpojo.validation.rule.impl.NoPublicFieldsExceptStaticFinalRule;
import com.openpojo.validation.rule.impl.NoStaticExceptFinalRule;
import com.openpojo.validation.rule.impl.SerializableMustHaveSerialVersionUIDRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.rule.impl.TestClassMustBeProperlyNamedRule;
import com.openpojo.validation.test.impl.DefaultValuesNullTester;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

/**
 * Ejemplo de comprobacion de multitud de reglas distintas para las clases.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 22-3-2017.
 *
 */
public class Test_Avanzado {
	// NUMERO DE CLASES ESPERADAS DENTRO DEL PAQUETE, PODREMOS SABER CUANDO SE
	// AÑADEN O QUITAN CLASES.
	private static final int NUMERO_CLASES_PREVISTO = 5;
	// PAQUETE A TESTEAR
	private static final String PAQUETE_ACOMPROBAR = "com.atrium.clases";
	// COLECCION PARA GUARDAR TODOS LOS AUXILIARES DE LAS CLASES A TESTEAR
	private List<PojoClass> lista_objetosacomprobar;
	// OBJETO PARA DEFINIR REGLAS Y COMPROBARLAS
	private Validator validador;

	/**
	 * Creacion de reglas a comprobar. Basicamente todas las permitadas por
	 * openpojo en la version actual.
	 */
	@Before
	public void setup() {
		// CREAMOS UNA COLECCION CON TODAS LOS OBJETOS A COMPROBAR
		lista_objetosacomprobar = PojoClassFactory.getPojoClasses(PAQUETE_ACOMPROBAR, null);
		// OBJETO PARA DEFINIR LAS REGLAS A APLICAR
		validador = ValidatorBuilder.create()
				// **** CREACION DE REGLAS A APLICAR
				// **** REGLAS DE ESCRITURA DEL CODIGO
				// COMPROBAMOS LA EXISTENCIA DE ACCESORES
				.with(new GetterMustExistRule()).with(new SetterMustExistRule())

				// NO PERMITIMOS EL USO DE PRIMITIVAS EN LAS CLASES
				.with(new NoPrimitivesRule())

				// NO SE PERMITEN CLASES INTERNAS O ANIDADAS
				.with(new NoNestedClassRule())

				// LAS PROPIEDADES ESTATICAS DEBEN SER FINALES
				.with(new NoStaticExceptFinalRule())

				// SI IMPLEMENTA LA INTERFACE SERIALIZABLE DEBE DE TENER UN ID
				// PARA LA VERSION.
				.with(new SerializableMustHaveSerialVersionUIDRule())

				// SE COMPRUEBA QUE NO SE REPITAN LOS NOMBRES DE LAS PROPIEDADES
				// EN LA CLASE PADRE
				.with(new NoFieldShadowingRule())

				// CUANDO PROPIEDAD ES PUBLICA SOLO ES VALIDA SI ES ESTATICA Y
				// FINAL
				.with(new NoPublicFieldsExceptStaticFinalRule())

				// TAMBIEN SE PUEDE COMPROBAR QUE NO HAYA PROPIEDADES PUBLICAS
				// pojoValidator.addRule(new NoPublicFieldsRule());

				// COMPROBAMOS QUE EL NOMBRE DE CLASE DE PRUEBA ES CORRECTO
				.with(new TestClassMustBeProperlyNamedRule())

				// **** REGLAS DE ESCRITURA DE FUNCIONAMIENTO
				// COMPROBAMOS EL COMPORTAMIENTO DE LOS ACCESORES ES CORRECTO
				.with(new SetterTester()).with(new GetterTester())

				// COMPROBAMOS QUE LAS PROPIEDADES NO TENGAN NINGUN VALOR POR
				// DEFECTO, EXCEPTO SI SON FINALES O PRIMITIVAS
				.with(new DefaultValuesNullTester())

				// CONSTRUIMOS LA PRUEBA DE TODAS LAS REGLAS ANTERIORES
				.build();
	}

	/**
	 * Comprobacion de numero de clases.
	 */
	@Test
	public void ensureExpectedPojoCount() {
		Assert.assertEquals("Classes añadida / quitada?", NUMERO_CLASES_PREVISTO, lista_objetosacomprobar.size());
	}

	/**
	 * Comprobacion de reglas.
	 */
	@Test
	public void testPojoStructureAndBehavior() {
		validador.validate(lista_objetosacomprobar);
	}
}