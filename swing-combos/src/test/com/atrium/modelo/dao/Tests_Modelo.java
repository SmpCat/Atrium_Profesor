package test.com.atrium.modelo.dao;

import test.com.atrium.modelo.fachada.Tests_Fachadas;
import junit.framework.Test;
import junit.framework.TestSuite;

public class Tests_Modelo {

	public static Test suite() {
		TestSuite suite = new TestSuite(Tests_Modelo.class.getName());
		// $JUnit-BEGIN$
		suite.addTest(Tests_DAOS.suite());
		suite.addTest(Tests_Fachadas.suite());
		// $JUnit-END$
		return suite;
	}

}
