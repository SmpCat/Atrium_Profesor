<!-- Pagina de arranque -->
<!-- fecha: 14-1-2018. -->
<!-- version: 2.7-->

<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://com.atrium.jsg" prefix="jsg"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<!-- CALCULO DINAMICO DE LA RUTA DE LA APLICACION -->
<jsg:ruta_servidor>
</jsg:ruta_servidor>

<jsg:ruta-parametro contexto_peticion="${pageContext.request}">
</jsg:ruta-parametro>

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	Pagina de ejemplo de etiquetas personalizadas en JSP.
	<br>
</body>
</html>
