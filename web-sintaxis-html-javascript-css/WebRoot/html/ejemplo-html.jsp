<!-- Pagina de ejemplo HTML -->
<!-- fecha: 10-1-2018. -->
<!-- version: 2.7-->


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<!-- PARTE NO VISIBLE EN LA PAGINA -->
<head>
<!-- PARTE EXTERNA DE LA RUTA DE RECURSOS ESTATICOS-->
<base href="ruta externa a la aplicacion -- dinamico" />
<!-- LLAMADA A FICHEROS DE ESTILOS (CSS) -->
<link href="ruta interna y nombre del fichero"
	type="text/css (type MIME de http)" />
<!-- LLAMADA A FICHEROS DE JAVASCRIPT (JS) -->
<script type="text/javascript (type MIME de http)"
	src="ruta interna y nombre del fichero"></script>
<!-- CONFIGURACION DEL TRATAMIENTO DEL NAVEGADOR -->
<meta content="">
</head>
<!-- PARTE VISIBLE DE LA PAGINA -->
<body>
	<!-- DEFINICION DE FORMULARIO -->
	<form action="nombre componente de servidor"
		method="post (tipo peticion http)"
		enctype="application/x-www-form-urlencoded (tipo MIME formulario de datos)">
		<!-- COMPONENTES DE TEXTO -->
		<input type="text" value="valor del campo">
		<!-- CAJA DE TEXTO BASICA -->
		<input type="password">
		<!-- CAJA DE TEXTO PARA CLAVES -->
		<input type="hidden">
		<!-- CAMPO OCULTO NO SE VE EN LA PAGINA -->
		<textarea rows="" cols="" />
		<!-- AREA DE TEXTO CON FILAS Y COLUMNAS -->
		<!-- COMPONENTES DE SELECCION -->
		<input type="radio">
		<!-- POSIBILIDAD DE SER MUTUAMENTE EXCLUYENTES -->
		<input type="checkbox">
		<!-- OPCIONES TOTALMENTE SEPARADAS -->
		<select name="">
			<option label="texto de la opcion" value="valor para el servidor">
		</select>
		<!-- SELECCION UNICA/MULTIPLE -->
		<!-- SELECCION DE FICHEROS PARA LA DESCARGA EN EL SERVIDOR -->
		<input type="file">
		<!-- BOTONES PARA EL CONTROL DE FORMULARIO -->
		<input type="submit">
		<!-- MANDA LA PETICION AL SERVIDOR -->
		<input type="reset">
		<!-- REINICIA LOS CAMPOS DEL FORMULARIO -->
		<input type="button">
		<!-- EJECUTA/LLAMA A JAVASCRIPT -->
	</form>
	<!-- HIPERVINCULOS (PETICION TIPO GET) -->
	<a href="componente del servidor">texto / imgen</a>
	<!-- PETICION DE FICHERO CON LA IMAGEN -->
	<img alt="" src="ruta interna y nombre de fichero">
	<!-- MAQUETACION/POSICIONAMIENTO -->
	<!-- TABLA -->
	<table>
		<thead>
			<!-- CABECERA DE TABLA -->
			<!-- FILA -->
			<tr>
				<!-- COLUMNA -->
				<th></th>
			</tr>
		</thead>
		<tbody>
			<!-- CUERPO DE LA TABLA -->
			<!-- FILA -->
			<tr>
				<!-- COLUMNA -->
				<td></td>
			</tr>
		</tbody>
		<tfoot>
			<!-- PIE DE TABLA -->
			<!-- FILA -->
			<tr>
				<!-- COLUMNA -->
				<td></td>
			</tr>
		</tfoot>
	</table>
	<!-- POSICION Y TAMAÑO -->
	<!-- CAPA O VENTANA -->
	<div></div>
</body>
</html>
