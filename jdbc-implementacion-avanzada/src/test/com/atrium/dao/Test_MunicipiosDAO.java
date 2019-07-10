package test.com.atrium.dao;

import java.sql.SQLException;
import java.util.List;

import com.atrium.conexiones.Conexion;
import com.atrium.jdbc.dao.Municipios_DAO;
import com.atrium.jdbc.dto.Municipios;

import junit.framework.TestCase;

public class Test_MunicipiosDAO extends TestCase {

	private Municipios_DAO muni_dao;

	@Override
	protected void setUp() throws Exception {
		muni_dao = new Municipios_DAO();
	}

	public void testMunicipios_DAO() {
		Municipios_DAO muni = new Municipios_DAO();
		assertNotNull("ERROR EN LA CREACION DEL OBJETO", muni);
		assertNotNull("LA CONEXION NO SE HA CREADO", muni.conexion);
	}

	// *** CONJUNTO DE PRUEBAS PARA LA CONEXION SEGUN PETICION, SE PRUEBAN LOS 4
	// CASOS POSIBLES
	/**
	 * Prueba de la conexion a produccion.
	 */
	public void testMunicipios_DAOInt1() {
		Municipios_DAO muni = new Municipios_DAO(Conexion.PRODUCCION);
		assertNotNull("ERROR EN LA CREACION DEL OBJETO", muni);
		assertNotNull("LA CONEXION DE PRODUCCION NO SE HA CREADO",
				muni.conexion);
	}

	/**
	 * La prueba de la conexion es valida sino se crea la conexion puesto que la
	 * ip dada no es accesible desde la red interna
	 */
	public void testMunicipios_DAOInt2() {
		Municipios_DAO muni = new Municipios_DAO(Conexion.CASA);
		assertNotNull("ERROR EN LA CREACION DEL OBJETO", muni);
		assertNull("LA CONEXION DE CASA SE HA CREADO", muni.conexion);
	}

	/**
	 * Prueba de la conexion a preproduccion.
	 */
	public void testMunicipios_DAOInt3() {
		Municipios_DAO muni = new Municipios_DAO(Conexion.PREPRODUCCION);
		assertNotNull("ERROR EN LA CREACION DEL OBJETO", muni);
		assertNotNull("LA CONEXION DE PREPRODUCCION NO SE HA CREADO",
				muni.conexion);
	}

	/**
	 * Prueba de la conexion a desarrollo.
	 */
	public void testMunicipios_DAOInt4() {
		Municipios_DAO muni = new Municipios_DAO(Conexion.DESARROLLO);
		assertNotNull("ERROR EN LA CREACION DEL OBJETO", muni);
		assertNotNull("LA CONEXION DE DESARROLLO NO SE HA CREADO",
				muni.conexion);
	}

	// *** FIN CONJUNTO DE PRUEBAS PARA LA CONEXION SEGUN PETICION

	public void testConsultar_PorProvincia1() {
		List<Municipios> lista = null;
		try {
			lista = muni_dao.consultar_PorProvincia(new Byte((byte) 28));
		} catch (SQLException e) {
			fail("EXCEPCION EN EL ACCESO A LA BASE DE DATOS");
		}
		assertEquals("EL NUMERO DE ELEMENTOS NO ES EL CORRECTO", 179,
				lista.size());
	}

	public void testConsultar_PorProvincia2() {
		List<Municipios> lista = null;
		try {
			lista = muni_dao.consultar_PorProvincia(new Byte((byte) 28));
		} catch (SQLException e) {
			fail("EXCEPCION EN EL ACCESO A LA BASE DE DATOS");
		}
		for (Municipios muni : lista) {
			assertNotNull("LA PROPIEDAD CODIGO MUNICIPIO ESTA VACIA",
					muni.getCodigo_municipio());
			assertNotNull("LA PROPIEDAD MUNICIPIO ESTA VACIA",
					muni.getMunicipio());
			assertNotNull("LA PROPIEDAD PROVINCIA ESTA VACIA",
					muni.getProvincia());
		}
	}
}
