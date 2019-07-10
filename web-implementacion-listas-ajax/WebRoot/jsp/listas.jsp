<!-- Pagina de ejemplo listas -->
<!-- fecha: 11-1-2018. -->
<!-- version: 2.7-->

<!-- DIRECTIVAS DE JSP -->
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<!-- PARTE DINAMICA DE LA RUTA PARA LOS RECURSOS ESTATICOS -->
<base href="<%=basePath%>">

<!-- CARGA LIBRERIA JAVASCRIPT -->
<script type="text/javascript" src="javascript/funciones_listas.js"></script>

</head>

<!-- EVENTO DE CARGA AUTOMATICA -->
<body onload="actualizar_paises()">
	<!-- FORMULARIO DE PRUEBA SIN SUMIT-->
	<form action="jsp/listas.jsp" method="post">
		<table>
			<tr>
				<td>Paises</td>
				<!-- LISTA DE PAISES -->
				<td><select name="pais" id="pais" 
					onchange="actualizar_provincias()">
						<!-- NINGUN CONTENIDO DE ETIQUETAS -->
				</select></td>
				<td>Provincias</td>
				<!-- LISTA DE PROVINCIAS -->
				<td><select name="provincias" id="provincias"
					onchange="actualizar_municipios()">
						<option>Seleccione un pais</option>
				</select></td>
				<td>Municipios</td>
				<!-- LISTA DE MUNICIPIOS -->
				<td><select name="municipios" id="municipios">
						<option>Seleccione una provincia</option>
				</select></td>
			</tr>
		</table>
	</form>
</body>
</html>
