package test.com.atrium.modelo.dao;

import java.util.List;

import com.atrium.modelo.Municipio;
import com.atrium.modelo.dao.Municipio_DAO;

import junit.framework.TestCase;

public class Test_MunicipioDAO extends TestCase {

	public void testConsultar_PorProvincia() {
		Municipio_DAO municipio_dao = new Municipio_DAO();
		List<Municipio> lista = municipio_dao.consultar_PorProvincia(new Byte(
				(byte) 28));
		assertEquals("ERROR EN EL TAMAÑO DE LA COLECCION", 3, lista.size());
	}

}
