/**
 * 
 */
package test.com.atrium.modelo.dao;

import java.util.List;

import com.atrium.modelo.Provincia;
import com.atrium.modelo.dao.Provincias_DAO;

import junit.framework.TestCase;

/**
 * @author profesor
 * 
 */
public class Test_ProvinciasDAO extends TestCase {
	private Provincias_DAO provincias_dao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		provincias_dao = new Provincias_DAO();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for
	 * {@link com.atrium.modelo.dao.Provincias_DAO#consultar_Todas()}.<br/>
	 * Prueba de numero de elementos en la respuesta.
	 */
	public void testConsultar_Todas1() {
		List<Provincia> lista = provincias_dao.consultar_Todas();

		assertEquals("ERROR EN EL TAMAÑO DE LA COLECCION", 4, lista.size());

	}

	/**
	 * Test method for
	 * {@link com.atrium.modelo.dao.Provincias_DAO#consultar_Todas()}.<br/>
	 * Prueba de contenido de los elementos de la coleccion.
	 */
	public void testConsultar_Todas2() {
		List<Provincia> lista = provincias_dao.consultar_Todas();

		for (Provincia provincia : lista) {
			if (provincia.getCodigoProvincia() == null) {
				fail("CODIGO DE PROVINCIA VACIO");
			}
			if (provincia.getProvincia() == null) {
				fail("NOMBRE DE PROVINCIA VACIO");
			}
		}
	}
}
