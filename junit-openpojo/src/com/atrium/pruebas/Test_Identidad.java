package com.atrium.pruebas;

import org.junit.Test;

import com.atrium.clases.Person;
import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.PojoValidator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.BusinessKeyMustExistRule;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.BusinessIdentityTester;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

/**
 * Ejemplo de uso de las opciones de identidad de OPENPOJO. (NO FUNCIONAL, SOLO
 * A EFECTOS DOCUMENTATIVOS)
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 31-3-2017.
 *
 */
public class Test_Identidad {
	@Test
	public void validatePerson() {
		// CLASE A COMPROBAR
		PojoClass personPojo = PojoClassFactory.getPojoClass(Person.class);
		// OBJETO AUXILIAR CON LAS REGLAS Y LOS TEST A REALIZAR
		ValidatorBuilder validador = ValidatorBuilder.create();
		// REGLAS A COMPROBAR (RULES)
		validador.with(new GetterMustExistRule(), new SetterMustExistRule(), new BusinessKeyMustExistRule());
		// TEST A REALIZAR (TESTAR)
		validador.with(new SetterTester(), new GetterTester(), new BusinessIdentityTester());
		// REALIZACION DE LA PRUEBA
		validador.build().validate(personPojo);
	}
}