<!-- Pagina de links para las pruebas  -->
<!-- fecha: 7-11-2017. -->
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
			<td><html:link action="/config-uno">Prueba configuracion uno</html:link></td>
			<td><html:link action="/config-dos">Prueba configuracion dos</html:link></td>
			<td><html:link action="/admin/config-admin">Prueba configuracion admin</html:link></td>
			<td><html:link action="/usuarios/config-usuarios">Prueba configuracion usuarios</html:link></td>
		</tr>
	</table>
</body>
</html>
