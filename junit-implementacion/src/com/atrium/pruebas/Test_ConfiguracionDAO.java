/**
 * 
 */
package com.atrium.pruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.atrium.configuracion.Configuracion_DAO;

import junit.framework.TestCase;

/**
 * @author profesor
 *
 */
public class Test_ConfiguracionDAO {
	
	private Configuracion_DAO configuracion;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		configuracion=new Configuracion_DAO();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.atrium.configuracion.Configuracion_DAO#Configuracion_DAO()}.
	 */
	@Test
	public void testConfiguracion_DAO() {
		
	}

	/**
	 * Test method for {@link com.atrium.configuracion.Configuracion_DAO#Configuracion_DAO(java.lang.String)}.
	 */
	@Test
	public void testConfiguracion_DAOString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.atrium.configuracion.Configuracion_DAO#cargar_Configuracion()}.
	 */
	@Test
	public void testCargar_Configuracion() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.atrium.configuracion.Configuracion_DAO#modificar_Configuracion(com.atrium.configuracion.Configuracion_DTO)}.
	 */
	@Test(timeout=25)
	@Ignore("")
	public void testModificar_Configuracion() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.atrium.configuracion.Configuracion_DAO#establecer_OpcionesDefecto()}.
	 */
	@Test
	public void testEstablecer_OpcionesDefecto() {
		fail("Not yet implemented");
	}

}
