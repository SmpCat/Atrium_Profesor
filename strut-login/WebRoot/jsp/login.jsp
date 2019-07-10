<%@ page language="java" pageEncoding="ISO-8859-1"%>
<!-- CONJUNTO DE DIRECTIVAS PARA HABILITAR EL USO DE LAS ETIQUETAS DE STRUT -->
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
<html:base />
</head>
<body>
	<html:form action="login_accion" method="post" focus="nombre">
		<table border="0">
			<tr>
				<td>Nombre:</td>
				<td><html:text property="nombre" /></td>
			</tr>
			<tr>
				<td>Clave:</td>
				<td><html:password property="clave" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><html:submit value="Comprobar" /></td>
			</tr>
		</table>
	</html:form>
</body>
</html:html>
