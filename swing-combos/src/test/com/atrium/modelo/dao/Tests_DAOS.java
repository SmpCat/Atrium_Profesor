package test.com.atrium.modelo.dao;

import junit.framework.Test;
import junit.framework.TestSuite;

public class Tests_DAOS {

	public static Test suite() {
		TestSuite suite = new TestSuite(Tests_DAOS.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(Test_MunicipioDAO.class);
		suite.addTestSuite(Test_ProvinciasDAO.class);
		//$JUnit-END$
		return suite;
	}

}
