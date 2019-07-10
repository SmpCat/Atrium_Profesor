/**
 * 
 */
package test.com.atrium.configuracion;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.PropertyResourceBundle;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.atrium.configuracion.Configuracion_DAO;
import com.atrium.configuracion.Configuracion_DTO;

/**
 * Conjunto de pruebas de la clase configuracion_dao.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 8-11-2016.
 *
 */
public class Test_ConfiguracionDAO {
	// OBJETO A COMPROBAR
	private Configuracion_DAO confi_dao;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// CREACION DEL OBJETO A TESTEAR
		confi_dao = new Configuracion_DAO();
		// DATOS DE LA PRUEBA
		confi_dao.setRuta_properties("/test/recursos/prueba_configuracion.properties");
	}

	/**
	 * Test method for
	 * {@link com.atrium.configuracion.Configuracion_DAO#Configuracion_DAO()}.
	 * <br/>
	 * Comprobacion de creacion de propiedades de clase.
	 */
	@Test
	public void testConfiguracion_DAO() {
		// OBTENCION DE PROPIEDADES PARA EL TESTEO INDIRECTO
		Properties lector_fichero = confi_dao.getDatos_configuracion();
		Configuracion_DTO dto_datos = confi_dao.getConfi_dto();
		// COMPROBACION DE LOS OBJETOS
		assertNotNull("ERROR EN LA CREACION DEL PROPERTIES", lector_fichero);
		assertNotNull("ERROR EN LA CREACION DEL DTO - CONFIGURACION_DTO", dto_datos);
	}

	/**
	 * Test method for
	 * {@link com.atrium.configuracion.Configuracion_DAO#Configuracion_DAO(java.lang.String)}
	 * <br/>
	 * Comprabacion de creacion de propiedades de clase.
	 */
	@Test
	public void testConfiguracion_DAOString() {
		String ruta_constructor = "Prueba de creacion";
		confi_dao = new Configuracion_DAO(ruta_constructor);
		// OBTENCION DE PROPIEDADES PARA EL TESTEO INDIRECTO
		Properties lector_fichero = confi_dao.getDatos_configuracion();
		Configuracion_DTO dto_datos = confi_dao.getConfi_dto();
		String ruta_nombre = confi_dao.getRuta_properties();
		// COMPROBACION DE LOS OBJETOS
		assertNotNull("ERROR EN LA CREACION DEL PROPERTIES", lector_fichero);
		assertNotNull("ERROR EN LA CREACION DEL DTO - CONFIGURACION_DTO", dto_datos);
		// COMPROBACION DE LA RUTA DEL FICHERO
		assertNotNull("ERROR EN LA CREACION DE LA RUTA DEL PROPERTIES", ruta_nombre);
		assertEquals("EL VALOR DE LA PROPIEDAD NO ES CORRECTO", ruta_constructor, ruta_nombre);
	}

	/**
	 * Test method for
	 * {@link com.atrium.configuracion.Configuracion_DAO#cargar_Configuracion()}
	 * . <br/>
	 * Prueba de creacion de objeto. .
	 */
	@Test
	public void testCargar_Configuracion() {
		// LLAMADA AL METODO A COMPROBAR
		Configuracion_DTO datos_prueba = confi_dao.cargar_Configuracion();
		// COMPROBACION DE EL RETORNO DEL METODO
		assertNotNull("EL OBJETO RESULTANTE DE LA LECTURA DE LOS DATOS DE CONFIGURACION ES ERRONEO", datos_prueba);
	}

	/**
	 * Test method for
	 * {@link com.atrium.configuracion.Configuracion_DAO#cargar_Configuracion()}
	 * . <br/>
	 * Prueba de contenido de datos leuidos. .
	 */
	@Test
	public void testCargar_ConfiguracionDOS() {
		// LLAMADA AL METODO A COMPROBAR
		Configuracion_DTO datos_prueba = confi_dao.cargar_Configuracion();
		// COMPROBACION DE LAS PROPIEDADES DE LA PRUEBA
		assertEquals("ERROR EN EL DATO VERSION", new Float(1.8), datos_prueba.getVersion());
		assertEquals("ERROR EN EL DATO FECHA CREACION", "03/noviembre/2016",
				new SimpleDateFormat("dd/MMMM/yyyy").format(datos_prueba.getFecha_actualizacion()));
		assertEquals("ERROR EN EL DATO AUTOR", "Profesor - Juan Antonio Solves Garcia", datos_prueba.getAutor());
	}

	/**
	 * Test method for
	 * {@link com.atrium.configuracion.Configuracion_DAO#cargar_Configuracion()}
	 * . <br/>
	 * Prueba de gestion de errores en la lectura.
	 */
	@Test
	public void testCargar_ConfiguracionTRES() {
		// CARGA DE UNA RUTA ERRONEA PARA LA COMPROBACION DE LA GESTION DEL
		// ERROR
		confi_dao.setRuta_properties("ruta erronea de carga");
		// LLAMADA AL METODO A COMPROBAR
		Configuracion_DTO datos_prueba = confi_dao.cargar_Configuracion();
		// COMPROBACION DE LA GESTION DE ERROR
		assertNull("ERROR EN LA GESTION DE LA RUTA ERRONEA", datos_prueba);
	}

	/**
	 * Test method for
	 * {@link com.atrium.configuracion.Configuracion_DAO#modificar_Configuracion(com.atrium.configuracion.Configuracion_DTO)}
	 * .
	 */
	@Test
	public void testModificar_Configuracion() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.atrium.configuracion.Configuracion_DAO#establecer_OpcionesDefecto()}
	 * .
	 */
	@Test
	public void testEstablecer_OpcionesDefecto() {
		fail("Not yet implemented");
	}

}
