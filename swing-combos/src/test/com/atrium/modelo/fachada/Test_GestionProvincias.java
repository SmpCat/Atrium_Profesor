package test.com.atrium.modelo.fachada;

import java.util.List;

import com.atrium.modelo.Provincia;
import com.atrium.modelo.fachada.Gestion_Provincias;

import junit.framework.TestCase;

public class Test_GestionProvincias extends TestCase {

	private Gestion_Provincias gestion_provincias;

	@Override
	protected void setUp() throws Exception {
		gestion_provincias = new Gestion_Provincias();
	}

	public void testGestion_Provincias() {
		assertNotNull("ERROR DE CREACION DE GESTION PROVINCIAS",
				gestion_provincias);
		assertNotNull("ERROR EN LA CREACION DE LA PROPIEDAD PROVICNIA_DAO",
				gestion_provincias.getProvincia_dao());
	}

	public void testConsultar_Todas() {
		List<Provincia> lista = gestion_provincias.consultar_Todas();

		assertEquals("ERROR EN EL NUMERO DE ELEMENTOS DE LA CONSULTA", 4,
				lista.size());
	}

}
