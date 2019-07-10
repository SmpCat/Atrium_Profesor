package com.atrium.eventos;

import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.event.spi.AutoFlushEvent;
import org.hibernate.event.spi.AutoFlushEventListener;
import org.hibernate.event.spi.EvictEvent;
import org.hibernate.event.spi.EvictEventListener;
import org.hibernate.event.spi.FlushEvent;
import org.hibernate.event.spi.FlushEventListener;
import org.hibernate.event.spi.LockEvent;
import org.hibernate.event.spi.LockEventListener;
import org.hibernate.event.spi.MergeEvent;
import org.hibernate.event.spi.MergeEventListener;
import org.hibernate.event.spi.PersistEvent;
import org.hibernate.event.spi.PersistEventListener;
import org.hibernate.event.spi.RefreshEvent;
import org.hibernate.event.spi.RefreshEventListener;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.event.spi.SaveOrUpdateEventListener;

/**
 * Conjunto de eventos de acciones concretas de hibernate.<br/>
 * Cada de los metodos de la sesion lanza el correpondiente evento.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0
 * @since 7-2-2018.
 * 
 */
public class Otros_Eventos implements AutoFlushEventListener,
		EvictEventListener, FlushEventListener, MergeEventListener,
		PersistEventListener, SaveOrUpdateEventListener, LockEventListener,
		RefreshEventListener {

	/**
	 * Evento al llamar al metodo {@link Session#saveOrUpdate(Object)} de
	 * hibernate.
	 */
	@Override
	public void onSaveOrUpdate(SaveOrUpdateEvent event)
			throws HibernateException {
		// TODO Auto-generated method stub
	}

	/**
	 * Evento al llamar al metodo {@link Session#persist(Object)} de hibernate.
	 */
	@Override
	public void onPersist(PersistEvent event) throws HibernateException {
		// TODO Auto-generated method stub
	}

	/**
	 * Evento al llamar al metodo {@link Session#persist(Object)} de hibernate.
	 */
	@Override
	public void onPersist(PersistEvent event, Map createdAlready)
			throws HibernateException {
		// TODO Auto-generated method stub
	}

	/**
	 * Evento al llamar al metodo {@link Session#merge(Object)} de hibernate.
	 */
	@Override
	public void onMerge(MergeEvent arg0) throws HibernateException {
		// TODO Auto-generated method stub
	}

	/**
	 * Evento al llamar al metodo {@link Session#merge(Object)} de hibernate.
	 */
	@Override
	public void onMerge(MergeEvent arg0, Map arg1) throws HibernateException {
		// TODO Auto-generated method stub
	}

	/**
	 * Evento al llamar al metodo {@link Session#flush()} de hibernate.
	 */
	@Override
	public void onFlush(FlushEvent event) throws HibernateException {
		// TODO Auto-generated method stub
	}

	/**
	 * Evento al llamar al metodo {@link Session#evict(Object)} de hibernate.
	 */
	@Override
	public void onEvict(EvictEvent arg0) throws HibernateException {
		// TODO Auto-generated method stub
	}

	/**
	 * Evento al llamar al metodo {@link Session#flush()} de hibernate.
	 */
	@Override
	public void onAutoFlush(AutoFlushEvent arg0) throws HibernateException {
		// TODO Auto-generated method stub
	}

	/**
	 * Evento al llamar al metodo {@link Session#refresh(Object)} de hibernate.
	 */
	@Override
	public void onRefresh(RefreshEvent event) throws HibernateException {
		// TODO Auto-generated method stub
	}

	/**
	 * Evento al llamar al metodo {@link Session#refresh(Object)} de hibernate.
	 */
	@Override
	public void onRefresh(RefreshEvent event, Map refreshedAlready)
			throws HibernateException {
		// TODO Auto-generated method stub
	}

	/**
	 * Evento al llamar al metodo
	 * {@link Session#lock(Object, org.hibernate.LockMode)} de hibernate.
	 */
	@Override
	public void onLock(LockEvent event) throws HibernateException {
		// TODO Auto-generated method stub
	}

}
