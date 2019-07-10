package com.atrium.hibernate.modelo;

import org.springframework.transaction.annotation.Transactional;

import com.atrium.hibernate.Tareas;

public interface IGestion_Tareas {

	public void alta_Tarea(Tareas tarea_nueva);

	public void baja_Tarea(Tareas tarea_nueva);

	public void modificacion_Tarea(Tareas tarea_nueva);

}