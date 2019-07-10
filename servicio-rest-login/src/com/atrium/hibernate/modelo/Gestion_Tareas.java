package com.atrium.hibernate.modelo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.atrium.hibernate.Tareas;
import com.atrium.hibernate.dao.TareasDAO;

@Component("gestion_tareas")
@Scope("prototype")
public class Gestion_Tareas implements IGestion_Tareas {

	private TareasDAO tarea_dao;

	@Override
	@Transactional
	public void alta_Tarea(Tareas tarea_nueva) {
		tarea_dao.save(tarea_nueva);
	}

	@Override
	@Transactional
	public void baja_Tarea(Tareas tarea_nueva) {
		tarea_dao.delete(tarea_nueva);
	}

	@Override
	@Transactional
	public void modificacion_Tarea(Tareas tarea_nueva) {
		tarea_dao.attachDirty(tarea_nueva);
	}

	// ACCSORES PARA SPRING
	public TareasDAO getTarea_dao() {
		return tarea_dao;
	}

	public void setTarea_dao(TareasDAO tarea_dao) {
		this.tarea_dao = tarea_dao;
	}

}
