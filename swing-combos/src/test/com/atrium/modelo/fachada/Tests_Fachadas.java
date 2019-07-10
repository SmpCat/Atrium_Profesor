package test.com.atrium.modelo.fachada;

import junit.framework.Test;
import junit.framework.TestSuite;

public class Tests_Fachadas {

	public static Test suite() {
		TestSuite suite = new TestSuite(Tests_Fachadas.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(Test_GestionProvincias.class);
		//$JUnit-END$
		return suite;
	}

}
