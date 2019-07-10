<!-- Pagina de ejemplo de definicion de etiquetas de spring MVC -->
<!-- fecha: 15-11-2017.. -->
<!-- version: 2.0-->

<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<!-- CARGA DE TLDS PARA EL USO DE ETIQUETAS DE SPRING -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'etiquetas_spring.jsp' starting page</title>
</head>

<body>
	<!-- DEFINICION DE FORMULARIO -->
	<form:form action="URL DEL CONTROLLER" method="TIPO PETICION HTTP"
		commandName="IDENTIFICADOR COMMAND"
		cssClass="ATRIBUTO CLASS PARA ESTILOS">
		<!-- ETIQUETAS DE TEXTO -->
		<form:label path="NOMBRE PROPIEDAD COMMAND" />
		<form:errors path="IDENTIFICADOR MENSAJE DE ERROR" />
		<!-- CAMPOS DE TEXTOS -->
		<form:input path="NOMBRE PROPIEDAD COMMAND"
			type="CUALQUIER TIPO DE HTML 5" />
		<form:textarea path="NOMBRE PROPIEDAD COMMAND" />
		<form:hidden path="NOMBRE PROPIEDAD COMMAND" />

		<!-- ELEMENTOS DE SELECCION -->
		<!-- RADIO BUTTON -->
		<form:radiobutton
			path="NOMBRE PROPIEDAD COMMAND -- LOGICO -- TEXTO -- OBJETO"
			label="TEXTO DE LA OPCION" value="VALOR DE LA OPCION" />
		<form:radiobuttons path="NOMBRE PROPIEDAD COMMAND -- COLECCION"
			items="COLECCION DE OBJETOS A MOSTRAR" itemLabel="TEXTO DE LA OPCION"
			itemValue="VALOR DE LA OPCION" />
		<!-- CHECKBOX -->
		<form:checkbox
			path="NOMBRE PROPIEDAD COMMAND -- LOGICO -- TEXTO -- OBJETO"
			label="TEXTO DE LA OPCION" value="VALOR DE LA OPCION" />
		<form:checkboxes path="NOMBRE PROPIEDAD COMMAND -- COLECCION"
			items="COLECCION DE OBJETOS A MOSTRAR" itemLabel="TEXTO DE LA OPCION"
			itemValue="VALOR DE LA OPCION" />
		<!-- COMBOS -->
		<form:select
			path="NOMBRE PROPIEDAD COMMAND -- VALOR UNICO -- COLECCION"
			items="COLECCION DE OBJETOS A MOSTRAR" itemLabel="TEXTO DE LA OPCION"
			itemValue="VALOR DE LA OPCION">
			<form:option value="VALOR DE LA OPCION" label="TEXTO DE LA OPCION" />
			<form:options items="COLECCION DE OBJETOS A MOSTRAR"
				itemLabel="TEXTO DE LA OPCION" itemValue="VALOR DE LA OPCION" />
		</form:select>
		<!-- BOTON DE LLAMADA A PROCESO DE JAVASCRIPT -->
		<form:button></form:button>
	</form:form>

	<!-- ELEMENTOS ADICIONALES -->
	<!-- GESTION DE TEXTOS -->
	<spring:message code="CLAVE DE PROPERTIES" text="TEXTO FIJO" />
	<!-- GESTION DINAMICA DE RECURSOS -->
	<spring:theme code="CLAVE DE PROPERTIES" />

</body>
</html>
