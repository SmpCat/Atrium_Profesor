package com.atrium.pruebas;

import org.junit.Before;
import org.junit.Test;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoClassFilter;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

/**
 * Ejemplo donde se un filtro propio para el testo de la clases solo de la parte
 * de produccion.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 31-3-2017.
 *
 */
public class Test_ClasesProduccion {
	private Validator validator;
	private PojoClassFilter filtro_propio = new FilterTestClasses();

	@Before
	public void setup() {
		validator = ValidatorBuilder.create().with(new GetterMustExistRule()).with(new SetterMustExistRule())
				.with(new SetterTester()).with(new GetterTester()).build();
	}

	@Test
	public void validateProductionClasses() {
		validator.validate("nombre_paquete", filtro_propio);
	}

	private static class FilterTestClasses implements PojoClassFilter {
		public boolean include(PojoClass pojoClass) {
			return !pojoClass.getSourcePath().contains("/test-classes/");
		}
	}
}
