package com.atrium.pruebas;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.Rule;
import com.openpojo.validation.rule.impl.TestClassMustBeProperlyNamedRule;

/**
 * Ejemplo de testeo de estructuras. Reglas de nombrado en las clases de prueba. (SOLO USO DOCUMENTAL)
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 31-3-2017.
 *
 */
public class Test_Estructuras {
	private ValidatorBuilder validador;

	@Before
	public void setup() {
		validador = ValidatorBuilder.create();
		// OPCION POR DEFECTO MAVEN-SUREFIRE-PLUGGIN *Test.java | Test*.java |
		// *TestCase.java
		validador.with(new TestClassMustBeProperlyNamedRule());
	}

	@Before
	public void setup2() {
		// DEFINIMOS LOS PREFIJOS DE LAS CLASES
		List<String> prefixTokens = new ArrayList<String>();
		prefixTokens.add("IT");
		// DEFINIMOS LOS SUFIJOS DE LAS CLASES
		List<String> suffixTokens = new ArrayList<String>();
		suffixTokens.add("IT");
		suffixTokens.add("ITCase");
		// OPCION CON REGLAS DE MAVEN-FAILSAFE-PLUGGIN IT*.java *IT.java
		// *ITCase.java
		Rule testClassMustBeProperlyNamedRule = new TestClassMustBeProperlyNamedRule(prefixTokens, suffixTokens);

		validador.with(testClassMustBeProperlyNamedRule);
	}

	@Test
	public void allTestsMustBeProperlyNamed() {
		// CAPTURA DE LAS CLASES DE UN PAQUETE DETERMINADO
		List<PojoClass> pojoClasses = PojoClassFactory.getPojoClassesRecursively("nombre_paquete", null);
		// APLICACION DE LA REGLAS DE ESTRUCTURA PARA VALIDAR LOS TEST
		for (PojoClass pojoClass : pojoClasses) {
			validador.build().validate(pojoClass);
		}
	}
}