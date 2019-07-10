<!-- PLANTILLA EJEMPLO ETIQUETAS STRUT -->
<!-- fecha: 12-12-2016. -->
<!-- version: 2.0-->

<%@ page language="java" pageEncoding="ISO-8859-1"%>

<!-- CONJUNTO DE DIRECTIVAS PARA HABILITAR EL USO DE LAS ETIQUETAS DE STRUT -->
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
<!-- EMULACION DE LA ETIQUETA BASE DE HTML PARA LA GENERACION DINAMICA DE URLS PARA LOS RECURSOS ESTATICOS -->
<html:base ref="site" />

</head>

<body>
	<!-- APERTURA DE FORMULARIO -->
	<html:form action="nombre de la accion" method="post">
		<!-- CAMPOS DE TEXTO -->
		<html:text property="" />
		<html:textarea property="" />
		<html:password property="" />
		<html:hidden property="" />
		<!-- SELECCION -->
		<html:radio property="" value="" />
		<html:checkbox property="" />

		<!-- BOTONES -->
		<!-- PETICIONES AL SERVIDOR (SUBMIT) -->
		<html:submit />
		<html:reset />
		<html:cancel />
		<!-- LLAMADA A JAVASCRIPT -->
		<html:button property="" />

		<!-- COMBOS -->
		<html:select property="">
			<!-- CONTENIDO DE COMBOS -->
			<!-- CONTENIDO ESTATICO (FIJO) -->
			<html:option value="" />
			<!-- CONTENIDO DINAMICO -->
			<html:optionsCollection value="" />
		</html:select>
		<!-- SUBIDA DE FICHEROS -->
		<html:file property="" />
	</html:form>

	<!-- OTRAS OPCIONES DE INTERES -->
	<!-- CARGA DE UNA IMAGEN -->
	<html:img />
	<!-- HIPERVINCULO A UNA NAVEGACION -->
	<html:link action="" forward="" />
	<!-- GESTION DE ACTIONERRORS MENSAJES DE ERROR PARA EL USUARIO -->
	<html:errors property="" bundle="" />
	<!-- GESTION DE TEXTO DE UNA PANTALLA CON OPCION DE IDIOMATIZACION -->
	<bean:message property="" bundle="" />

</body>
</html:html>
