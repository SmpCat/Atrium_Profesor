<!-- Pagina de ejemplo listas -->
<!-- fecha: 2-6-2018. -->
<!-- version: 2.7-->

<!-- DIRECTIVAS DE JSP -->
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://com.atrium.jsg" prefix="jsg"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'listas.jsp' starting page</title>
</head>

<body>
	<!-- FORMULARIO DE PRUEBA -->
	<form action="index.jsp" method="post">
		<table>
			<tr>
				<td>Paises</td>
				<!-- LISTA DE PAISES -->
				<td><select name="pais" id="pais">
						<!-- CREACION DINAMICA DE CONTENIDO VIA ETIQUETA PERSONALIZADA -->
						<jsg:listas_paises campo="c" sentido="d"
							pais_seleccionado="${param.pais}">
						</jsg:listas_paises>
				</select></td>
				<td>Provincias</td>
				<!-- LISTA DE PROVINCIAS -->
				<td><select name="provincias" id="provincias">
						<!-- CREACION DINAMICA DE CONTENIDO VIA ETIQUETA PERSONALIZADA -->
						<jsg:lista_provincias pais_seleccionado="${param.pais}"
							provincia_seleccionado="${param.provincias}">
						</jsg:lista_provincias>
				</select></td>
				<td>Municipios</td>
				<!-- LISTA DE MUNICIPIOS -->
				<td><select name="municipios" id="municipios">
						<!-- CREACION DINAMICA DE CONTENIDO VIA ETIQUETA PERSONALIZADA -->
						<jsg:lista_municipios provincia_seleccionado="${param.provincias}">
						</jsg:lista_municipios>
				</select></td>
			</tr>
			<tr>
				<td colspan="6" align="center"><input type="submit"
					value="comprobar"></td>
			</tr>
		</table>
	</form>
</body>
</html>
