<!-- Pagina de administracion -->
<!-- fecha: 17-11-2017. -->
<!-- version: 2.7-->

<!-- DIRECTIVAS DE JSP -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- FORMULARIO DE USUARIOS -->
<form:form action="usuario.htm" method="post"
	commandName="usuario_peticion">
	<!-- MAQUETACION FORMULARIO -->
	<table>
		<tr>
			<td>Nombre usuario:</td>
			<td><form:input path="nombreUsuario" /></td>
			<td><form:errors path="nombreUsuario" /></td>
		</tr>
		<tr>
			<td>Clave usuario:</td>
			<td><form:input path="password" /></td>
			<td><form:errors path="password" /></td>
		</tr>
		<tr>
			<td>Idioma:</td>
			<td><form:input path="idioma" /></td>
			<td><form:errors path="idioma" /></td>
		</tr>
		<tr>
			<td>Carpeta:</td>
			<td><form:input path="carpetaDocumentacion" /></td>
		</tr>
		<tr>
			<td>Fecha alta:</td>
			<td><form:input path="fechaAlta" /></td>
		</tr>
		<tr>
			<td>Fecha baja:</td>
			<td><form:input path="fechaBaja" /></td>
		</tr>
		<tr>
			<td>rol usuario:</td>
			<td><form:select path="roles">
					<form:option value="0" label="Seleccione un rol" />
					<form:options items="${usuario_peticion.lista_roles}"
						itemLabel="descripcionRol" itemValue="codigoRol" />
				</form:select></td>
			<td><form:errors path="roles" /></td>
		</tr>
	</table>
	<!-- CONJUNTO DE BOTONES PARA LA GESTION DEL FORMULARIO -->
	<table>
		<tr>
			<td><input type="submit" value="Alta" name="boton_alta"></td>
		</tr>
	</table>
	<!-- PROPIEDAD PARA LOS MENSAJES A LOS USUARIOS -->
	<form:errors />
</form:form>
