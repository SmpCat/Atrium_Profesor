<!-- Pagina de llamada a la accion para provocar el error.  -->
<!-- fecha: 6-11-2017. -->
<!-- version: 2.7-->

<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

</head>

<body>
	<table>
		<tr>
			<!-- PETICION  A LA ACCION -->
			<td><html:link action="/navegacion">Prueba accion de navegacion</html:link></td>
			<!-- PETICION A ERROR -->
			<td><html:link action="/accion_erronea">Prueba gestion error</html:link></td>
		</tr>
	</table>
</body>
</html>
