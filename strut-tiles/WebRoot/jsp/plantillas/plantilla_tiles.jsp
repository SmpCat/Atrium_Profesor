<!-- Plantilla general aplicacion, formato portal-->
<!-- autor: Juan Antonio Solves Garcia. -->
<!-- fecha: 6-11-2017. -->
<!-- version: 3.0-->

<%@ page language="java" pageEncoding="ISO-8859-15"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
<html:base ref="site" />

<title>plantilla_tiles.jsp</title>

<!-- CARGA DE ESTILOS PARA LAS PAGINAS -->
<!-- ESTILO DE LA PLANTILLA PRINCIPAL -->
<link rel="stylesheet" type="text/css" href="css/estilos_plantilla.css">
<!-- ESTILO DE LA PLANTILLA SECUNDARIA -->
<link rel="stylesheet" type="text/css" href="css/estilos_bannermenu.css">
<!-- ESTILO DE LA PARTE DEL LOGIN -->
<link rel="stylesheet" type="text/css" href="css/estilos_login.css">

</head>

<body>
	<!-- DEFINICION DE ZONAS Y CONTENIDOS -->
	<div id="capa_banner">
		<tiles:insert attribute="banner" />
	</div>
	<div id="capa_menu">
		<tiles:insert attribute="menu" />
	</div>
	<div id="capa_contenido">
		<tiles:insert attribute="contenido" />
	</div>
</body>
</html:html>
