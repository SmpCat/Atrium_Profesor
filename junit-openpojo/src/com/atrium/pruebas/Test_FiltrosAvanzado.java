package com.atrium.pruebas;

import java.io.Serializable;

import org.junit.Before;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoClassFilter;
import com.openpojo.reflection.filters.FilterBasedOnInheritance;
import com.openpojo.reflection.filters.FilterChain;
import com.openpojo.reflection.filters.FilterClassName;
import com.openpojo.reflection.filters.FilterEnum;
import com.openpojo.reflection.filters.FilterNestedClasses;
import com.openpojo.reflection.filters.FilterNonConcrete;
import com.openpojo.reflection.filters.FilterPackageInfo;
import com.openpojo.reflection.filters.FilterSyntheticClasses;
import com.openpojo.reflection.impl.PojoClassFactory;

/**
 * Ejemplo de filtros de clase para la comparacion de clases concretas.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 31-3-2017.
 *
 */
public class Test_FiltrosAvanzado implements PojoClassFilter {

	@Before
	public void filtro_Clases() {
		// FILTRO POR LA DEFINICION DEL PACKGE-INFO DEL PAQUETE
		PojoClassFactory.getPojoClassesRecursively("nombre_paquete", new FilterPackageInfo());
		// FILTRO POR LA INTERFACE QUE INCORPORE
		PojoClassFactory.getPojoClassesRecursively("nombre_paquete", new FilterBasedOnInheritance(Serializable.class));
		// FILTRO DE LAS CLASES CON NOMBRE QUE COINCIDAN CON LA EXPRESION
		// REGULAR
		PojoClassFactory.getPojoClassesRecursively("nombre_paquete", new FilterClassName("EXPRESION REGULAR"));
		// FILTRO DE LAS CLASES QUE ESTAN RELACIONES EN EL ENUMERADOR
		PojoClassFactory.getPojoClassesRecursively("nombre_paquete", new FilterEnum());
		// FILTRO PARA LAS CLASES CONCRETAS, EXCLUIDOS INTERFACES, ABSTRACT Y
		// ENUMERADORES
		PojoClassFactory.getPojoClassesRecursively("nombre_paquete", new FilterNonConcrete());
		// FILTRO PARA LAS CLASES SINTETICAS -- HABITUALMENTE LAS CREADAS POR
		// RUNABLE
		PojoClassFactory.getPojoClassesRecursively("nombre_paquete", new FilterSyntheticClasses());
		// FILTRO PARA LAS CLASES INTERNAS
		PojoClassFactory.getPojoClassesRecursively("nombre_paquete", new FilterNestedClasses());
		// AGRUPACION DE DISTINTOS FILTROS PARA APLICALOS TODOS A LA VEZ
		FilterChain filterSyntheticAndNonConcrete = new FilterChain(new FilterSyntheticClasses(),
				new FilterNonConcrete());
		PojoClassFactory.getPojoClassesRecursively("nombre_paquete", filterSyntheticAndNonConcrete);

	}

	@Override
	public boolean include(PojoClass pojoClass) {
		// CODIGO PARA INDICAR SI SE USA LA CLASE EN LA PRUEBA O NO
		return false;
	}

}
