package com.atrium.util;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.hibernate.exception.GenericJDBCException;
import org.hibernate.exception.JDBCConnectionException;
import org.hibernate.exception.LockAcquisitionException;
import org.hibernate.exception.LockTimeoutException;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.jdbc.datasource.lookup.DataSourceLookupFailureException;
import org.springframework.stereotype.Component;

/**
 * Clase comun para el tratamiento de excpeciones en acceso a base de datos para
 * conocer la informacion que nos puedan aportar.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 14-2-2018.
 * 
 */
@Component("error_bd")
@Scope("prototype")
public class Tratamiento_ErroresBD implements ITratamiento_ErroresBD {
	// ESTRUCTURA DE DATOS PARA DEVOLVER LA INFORMACION OBTENIDA DE LA
	// EXCEPCION
	private Map<Integer, Map<String, String>> mapa_errores;

	private Map<String, String> mapa_datos;

	private int tipo_error;

	/**
	 * Inicio de propiedades de clase.
	 */
	public Tratamiento_ErroresBD() {
		mapa_errores = new HashMap<Integer, Map<String, String>>(0);
		mapa_datos = new HashMap<>(0);
	}

	/**
	 * Tratamiento de las {@link SQLException} genericas de jdbc.
	 * 
	 * @param e
	 *            Excepcion producida.
	 * @return Mapa con la informacion obtenida de la excepcion.
	 * 
	 */
	@Override
	public Map<Integer, Map<String, String>> tratar_SQLException(Exception e) {
		if (e instanceof SQLException) {
			SQLException sqle = (SQLException) e;
			// CAPTURA DE INFORMACION DEL ERROR PRODUCIDO
			int codigo_errorbd = sqle.getErrorCode();
			String mensaje_bd = sqle.getLocalizedMessage();
			String texto = sqle.getSQLState();
			// CARGA DE ERRORES EN EL MAPA
			mapa_datos.put("codigo_errorjdbc", String.valueOf(codigo_errorbd));
			mapa_datos.put("mensaje_errorjdbc", mensaje_bd);
			mapa_datos.put("texto_errorjdbc", texto);
			mapa_errores.put(JDBC, mapa_datos);
		}
		return mapa_errores;
	}

	/**
	 * Tratamiento de las {@link HibernateException} para conocer la informacion
	 * que nos puedan ofrecer del error producido.
	 * 
	 * @param e
	 *            Excepcion ocurrida.
	 * @return Mapa con la informacion obtenida de la excepcion.
	 */
	@Override
	public Map<Integer, Map<String, String>> tratar_HibernateException(
			Exception e) {
		// CLASE PADRE DE TODAS LAS EXCEPCIONES DE HIBERNATE
		if (e instanceof HibernateException) {
			int codigo_errorbd = 0;
			String mensaje_bd = null;
			String texto = null;
			String codigo_sqlerroneo = null;
			SQLException sqle = null;
			String constraint_violada = null;
			// DISTINTOS TIPOS DE EXCEPCIONES DE HIBERNATE
			if (e instanceof JDBCConnectionException) {
				// ERROR DE CONEXION CON LA BASE DE DATOS
				JDBCConnectionException jdbce = (JDBCConnectionException) e;
				codigo_errorbd = jdbce.getErrorCode();
				mensaje_bd = jdbce.getLocalizedMessage();
				texto = jdbce.getSQLState();
				codigo_sqlerroneo = jdbce.getSQL();
				sqle = jdbce.getSQLException();
				tipo_error = HIBERNATE_CONEXION;
			}
			if (e instanceof SQLGrammarException) {
				// ERROR EN AL SENTENCIA SQL
				SQLGrammarException sqlgramar = (SQLGrammarException) e;
				codigo_errorbd = sqlgramar.getErrorCode();
				mensaje_bd = sqlgramar.getLocalizedMessage();
				texto = sqlgramar.getSQLState();
				codigo_sqlerroneo = sqlgramar.getSQL();
				sqle = sqlgramar.getSQLException();
				tipo_error = HIBERNATE_SQL;
			}
			if (e instanceof ConstraintViolationException) {
				// ERROR EN ALGUN CONSTRAINT
				ConstraintViolationException conse = (ConstraintViolationException) e;
				codigo_errorbd = conse.getErrorCode();
				mensaje_bd = conse.getLocalizedMessage();
				texto = conse.getSQLState();
				codigo_sqlerroneo = conse.getSQL();
				sqle = conse.getSQLException();
				constraint_violada = conse.getConstraintName();
				tipo_error = HIBERNATE_CONSTRAINT;
			}
			if (e instanceof LockAcquisitionException) {
				// ERROR EN LA ADJUDICACION DEL BLOQUEO
				LockAcquisitionException locke = (LockAcquisitionException) e;
				codigo_errorbd = locke.getErrorCode();
				mensaje_bd = locke.getLocalizedMessage();
				texto = locke.getSQLState();
				codigo_sqlerroneo = locke.getSQL();
				sqle = locke.getSQLException();
				tipo_error = HIBERNATE_BLOQUEO;
			}
			if (e instanceof GenericJDBCException) {
				// ERROR NO ADJUDICABLE A LOS ANTERIORES
				GenericJDBCException gene = (GenericJDBCException) e;
				codigo_errorbd = gene.getErrorCode();
				mensaje_bd = gene.getLocalizedMessage();
				texto = gene.getSQLState();
				codigo_sqlerroneo = gene.getSQL();
				sqle = gene.getSQLException();
				tipo_error = HIBERNATE_GENERICO;
			}
			if (e instanceof LockTimeoutException) {
				// ERROR DE TIMEOUT
				GenericJDBCException gene = (GenericJDBCException) e;
				codigo_errorbd = gene.getErrorCode();
				mensaje_bd = gene.getLocalizedMessage();
				texto = gene.getSQLState();
				codigo_sqlerroneo = gene.getSQL();
				sqle = gene.getSQLException();
				tipo_error = HIBERNATE_TIMEOUT;
			}
			if (e instanceof DataException) {
				// ERROR EN LOS DATOS DEL SQL. TIPOS ERRONEOS, ORDEN ERRONEO,
				// ETC.
				GenericJDBCException gene = (GenericJDBCException) e;
				codigo_errorbd = gene.getErrorCode();
				mensaje_bd = gene.getLocalizedMessage();
				texto = gene.getSQLState();
				codigo_sqlerroneo = gene.getSQL();
				sqle = gene.getSQLException();
				tipo_error = HIBERNATE_DATA;
			}
			// CARGA DE ERRORES EN EL MAPA
			mapa_datos.put("codigo_error", String.valueOf(codigo_errorbd));
			mapa_datos.put("mensaje", mensaje_bd);
			mapa_datos.put("sqlstate", texto);
			mapa_datos.put("codigo_sql", codigo_sqlerroneo);
			mapa_datos.put("constraint", constraint_violada);
			mapa_errores.put(tipo_error, mapa_datos);
			if (sqle != null) {
				this.tratar_SQLException(sqle);
			}
		}
		return mapa_errores;
	}

	/**
	 * Tratamiento de las {@link DataAccessException} para conocer la
	 * informacion que nos puedan ofrecer del error producido.
	 * 
	 * @param e
	 *            Excepcion ocurrida.
	 * 
	 * @return Mapa con la informacion obtenida de la excepcion.
	 */
	@Override
	public Map<Integer, Map<String, String>> tratar_SpringException(Exception e) {
		// LA CLASE PADRE DE TODAS LAS EXCEPCIONES DE BASE DE DATOS EN SPRING
		if (e instanceof DataAccessException) {
			String mensaje_bd = null;
			Throwable causa_especifica = null;
			Throwable causa_raiz = null;
			if (e instanceof DataIntegrityViolationException) {
				// ERROR EN ALGUNA CONSTRAINT DE LA BASE DE DATOS
				DataIntegrityViolationException datae = (DataIntegrityViolationException) e;
				mensaje_bd = datae.getLocalizedMessage();
				causa_especifica = datae.getMostSpecificCause();
				causa_raiz = datae.getRootCause();
				tipo_error = SPRING_CONSTRAINT;
			}
			if (e instanceof DataSourceLookupFailureException) {
				// ERROR AL CONECTAR CON EL DATASOURCE
				DataSourceLookupFailureException datase = (DataSourceLookupFailureException) e;
				mensaje_bd = datase.getLocalizedMessage();
				causa_especifica = datase.getMostSpecificCause();
				causa_raiz = datase.getRootCause();
				tipo_error = SPRING_DATASOURCE;
			}
			if (e instanceof DeadlockLoserDataAccessException) {
				// ERROR GENERICO EN TRANSACCION - ROLLBACK
				DeadlockLoserDataAccessException deade = (DeadlockLoserDataAccessException) e;
				mensaje_bd = deade.getLocalizedMessage();
				causa_especifica = deade.getMostSpecificCause();
				causa_raiz = deade.getRootCause();
				tipo_error = SPRING_TRANSACCION;
			}
			if (e instanceof DuplicateKeyException) {
				// ERROR CLAVE PRIMARIA DUPLICADA
				DuplicateKeyException duplie = (DuplicateKeyException) e;
				mensaje_bd = duplie.getLocalizedMessage();
				causa_especifica = duplie.getMostSpecificCause();
				causa_raiz = duplie.getRootCause();
				tipo_error = SPRING_PK;
			}
			if (e instanceof OptimisticLockingFailureException) {
				// ERROR GENERICO (PARA TODAS LAS TECNICAS) EN ACCESO OPTIMISTA
				OptimisticLockingFailureException duplie = (OptimisticLockingFailureException) e;
				mensaje_bd = duplie.getLocalizedMessage();
				causa_especifica = duplie.getMostSpecificCause();
				causa_raiz = duplie.getRootCause();
				tipo_error = SPRING_OPTIMISTA;
			}
			if (e instanceof PessimisticLockingFailureException) {
				// ERROR GENERICO (PARA TODAS LAS TECNICAS) EN ACCESO PESIMISTA
				PessimisticLockingFailureException pesie = (PessimisticLockingFailureException) e;
				mensaje_bd = pesie.getLocalizedMessage();
				causa_especifica = pesie.getMostSpecificCause();
				causa_raiz = pesie.getRootCause();
				tipo_error = SPRING_PESIMISTA;
			}
			// FALTAN MAS EXCEPCIONES, POR EJEMPLO LAS PARTICULARES DE
			// HIBERNATE,JPA,IBATIS,ETC.
			mapa_datos.put("mensaje_errorspring", mensaje_bd);
			mapa_errores.put(tipo_error, mapa_datos);
			if (causa_especifica != null) {
				this.tratar_SQLException((Exception) causa_especifica);
			}
		}
		return mapa_errores;
	}
}
