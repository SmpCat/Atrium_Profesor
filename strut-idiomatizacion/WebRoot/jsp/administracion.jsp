<!-- Pagina de administracion -->
<!-- fecha: 3-11-2017. -->
<!-- version: 2.7-->

<!-- LLAMADA/PUESTA A DISPOSICION DE TLD  -->
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html>
<head>
<!-- DEFINICION DE RECURSOS ESTATICOS EN EL SERVIDOR -->
<link rel="stylesheet" type="text/css" href="css/estilo_usuarios.css" />
</head>

<body>
	<table>
		<tr>
			<td><a href="cambio_idioma.do?idioma=es"><img
					src="imagenes/Spain.png" height="35" width="35" /> </a></td>
			<td><a href="cambio_idioma.do?idioma=en"><img
					src="imagenes/United Kingdom.png" height="35" width="35" /> </a></td>
			<td><a href="cambio_idioma.do?idioma=fr"><img
					src="imagenes/France.png" height="35" width="35" /> </a></td>
		</tr>
	</table>

	<!-- FORMULARIO DE LA ACCION -->
	<div id="capa_formulario">
		<html:form action="usuario" method="post">
			<table>
				<tr>
					<td><bean:message key="usuario.eti.nombre" /></td>
					<td><html:text property="nombre" /></td>
					<td><html:errors property="nombre" /></td>
				</tr>
				<tr>
					<td><bean:message key="usuario.eti.clave" /></td>
					<td><html:password property="clave" /></td>
					<td><html:errors property="clave" /></td>
				</tr>
				<tr>
					<td><bean:message key="usuario.eti.fechaalta" /></td>
					<td><html:text property="fecha_alta" /></td>
					<td><html:errors property="fecha_alta" /></td>
				</tr>
				<tr>
					<td><bean:message key="usuario.eti.fechabaja" /></td>
					<td><html:text property="fecha_baja" /></td>
					<td><html:errors property="fecha_baja" /></td>
				</tr>
				<tr>
					<td><bean:message key="usuario.eti.carpeta" /></td>
					<td><html:text property="carpeta" /></td>
					<td><html:errors property="carpeta" /></td>
				</tr>
				<tr>
					<td><bean:message key="usuario.eti.idioma" /></td>
					<td><html:radio property="idioma" value="es">
							<bean:message key="usuario.eti.idioma.español" />
						</html:radio> <html:radio property="idioma" value="fr">
							<bean:message key="usuario.eti.idioma.frances" />
						</html:radio> <html:radio property="idioma" value="en">
							<bean:message key="usuario.eti.idioma.ingles" />
						</html:radio></td>
					<td></td>
				</tr>
				<tr>
					<td><bean:message key="usuario.eti.rol" /></td>
					<td><html:select property="rol_usuario">
							<html:optionsCollection value="valor_combo" label="texto_combo"
								property="lista_roles" />
						</html:select></td>
				</tr>
			</table>
			<table>
				<tr>
					<td><html:submit property="boton"
							disabled="${requestScope.habilitaralta}" styleId="boton_alta">
							<bean:message key="bot.usuario.alta" />
						</html:submit></td>
					<td><html:submit property="boton"
							disabled="${requestScope.habilitar}" styleId="boton_baja">
							<bean:message key="bot.usuario.baja" />
						</html:submit></td>
					<td><html:button property="boton"
							onclick="consultar_usuarios(),establecer_boton(this),mostrar_ayuda(true)">
							<bean:message key="bot.usuario.consulta" />
						</html:button></td>
					<td><html:submit property="boton"
							disabled="${requestScope.habilitar}" styleId="boton_modificacion">
							<bean:message key="bot.usuario.modificacion" />
						</html:submit></td>
					<td><html:reset property="boton">
							<bean:message key="bot.usario.limpiar" />
						</html:reset></td>
					<td><html:submit property="boton">
							<bean:message key="bot.usuario.salir" />
						</html:submit></td>
				</tr>
			</table>
		</html:form>
	</div>
</body>
</html>