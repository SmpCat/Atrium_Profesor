<!-- Pagina de ejemplo para el uso de la idiomatizacion -->
<!-- fecha: 10-11-2017.. -->
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

<!-- CARGA DINAMICA DE HOJA DE ESTILOS SEGUN EL TEMA DEFINIDO VIA SPRING -->
<link rel="stylesheet" href="css/estilos_login.css" type="text/css" />

</head>

<body>
	<!-- LLAMADA AL FRAGMENTO DE CONTROL DE IDIOMAS -->
	<jsp:include page="/jsp/idioma.jsp" />
	<!-- FORMULARIO DE LOGIN -->
	<form:form action="login_mvc.htm" commandName="datos_login"
		method="post">
		<table>
			<tr>
				<td><spring:message code="login.nombre" /></td>
				<td><form:input path="nombre_usuario" /></td>
				<td><form:errors path="nombre_usuario" /></td>
			</tr>
			<tr>
				<td><spring:message code="login.clave" /></td>
				<td><form:input path="clave" /></td>
				<td><form:errors path="clave" /></td>
			</tr>
			<tr>
				<td colspan="3" align="center"><spring:message
						code="login.boton" var="boton" /><input type="submit"
					value="${boton}" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
