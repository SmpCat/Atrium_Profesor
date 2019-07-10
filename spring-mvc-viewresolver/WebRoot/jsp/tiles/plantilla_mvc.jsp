<!-- Plantilla general aplicacion, formato portal-->
<!-- fecha: 10-11-2017. -->
<!-- version: 3.0-->

<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!-- DIRECTIVAS DE JSP -->
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'plantilla_mvc.jsp' starting page</title>

<!-- CARGA DE ESTILOS PARA LAS PAGINAS -->
<!-- ESTILO DE LA PLANTILLA PRINCIPAL -->
<link rel="stylesheet" type="text/css" href="css/estilos_plantilla.css">
<!-- ESTILO DE LA PLANTILLA SECUNDARIA -->
<link rel="stylesheet" type="text/css" href="css/estilos_bannermenu.css">
<!-- ESTILO DE LA PARTE DEL LOGIN -->
<link rel="stylesheet" type="text/css" href="css/estilos_login.css">

</head>

<body>
	<!-- DEFINICION DE ZONAS Y CONTENIDOS DE LA PLANTILLA PRINCIPAL-->
	<div id="capa_banner">
		<tiles:insertAttribute name="banner" />
	</div>
	<div id="capa_menu">
		<tiles:insertAttribute name="menu" />
	</div>
	<div id="capa_contenido">
		<tiles:insertAttribute name="contenido" />
	</div>
</body>
</html>
