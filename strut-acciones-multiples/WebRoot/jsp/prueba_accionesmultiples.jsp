<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<!-- Pagina de prueba de acciones multiples -->
<!-- autor: Juan Antonio Solves Garcia -->
<!-- fecha: 6-11-2017. -->
<!-- version: 2.7-->

<!-- LLAMADA/PUESTA A DISPOSICION DE TLD  -->
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>

<body>
	<label>PRUEBA TIPO UNO DE ACCION MULTIPLE</label>
	<!-- FORMULARIO DE LA ACCION MULTIPLE DE USUARIOS-->
	<html:form action="usuario" method="post">
		<table>
			<tr>
				<td><html:submit property="boton"
						disabled="${requestScope.habilitaralta}" styleId="boton_alta">
						<bean:message key="bot.usuario.alta" />
					</html:submit></td>
				<td><html:submit property="boton"
						disabled="${requestScope.habilitar}" styleId="boton_baja">
						<bean:message key="bot.usuario.baja" />
					</html:submit></td>
				<td><html:button property="boton"
						onclick="consultar_usuarios(),establecer_boton(this),mostrar_ayuda(true)">
						<bean:message key="bot.usuario.consulta" />
					</html:button></td>
				<td><html:submit property="boton"
						disabled="${requestScope.habilitar}" styleId="boton_modificacion">
						<bean:message key="bot.usuario.modificacion" />
					</html:submit></td>
				<td><html:reset property="boton">
						<bean:message key="bot.usario.limpiar" />
					</html:reset></td>
				<td><html:submit property="boton">
						<bean:message key="bot.usuario.salir" />
					</html:submit></td>
			</tr>
		</table>
	</html:form>
	<label>PRUEBA TIPO DOS DE ACCION MULTIPLE</label>

	<!-- FORMULARIO DE LA ACCION MULTIPLE DE FICHEROS-->
	<html:form method="post" action="subir_fichero"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td><html:file property="fichero_subido" size="40" /></td>
			</tr>
			<tr>
				<td><html:submit value="Subida"></html:submit></td>
				<td><html:link action="descarga">Bajar fichero</html:link></td>
				<td><html:link action="eliminar">Eliminar fichero</html:link></td>
			</tr>
		</table>
	</html:form>
</body>
</html>
