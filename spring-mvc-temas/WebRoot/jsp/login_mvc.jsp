<!-- Pagina de ejemplo para el uso de temas en spring -->
<!-- fecha: 10-11-2017. -->
<!-- version: 2.0-->
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!-- CARGA DE TLDS PARA EL USO DE ETIQUETAS DE SPRING -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<!-- CARGA DINAMICA DE TEXTO ASOCIADO A UN ESTILO SEGUN SPRING -->
<title><spring:theme code="login.titulo" /></title>
<!-- CARGA DINAMICA DE HOJA DE ESTILOS SEGUN EL TEMA DEFINIDO VIA SPRING -->
<link rel="stylesheet" href="<spring:theme code='css'/>" type="text/css" />
</head>

<body>
	<!-- LLAMADA AL FRAGMENTO DE CONTROL DE TEMAS -->
	<jsp:include page="/jsp/temas_spring.jsp" />
	<!-- FORMULARIO DE LOGIN -->
	<form:form action="login_mvc.htm" commandName="datos_login"
		method="post">
		<table>
			<tr>
				<td>Nombre:</td>
				<td><form:input path="nombre_usuario" /></td>
				<td><form:errors path="nombre_usuario" /></td>
			</tr>
			<tr>
				<td>Clave:</td>
				<td><form:input path="clave" /></td>
				<td><form:errors path="clave" /></td>
			</tr>
			<tr>
				<td colspan="3" align="center"><input type="submit"
					value="Comprobar" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
