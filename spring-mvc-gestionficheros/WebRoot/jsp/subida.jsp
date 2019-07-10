<!-- Pagina de subida -->
<!-- fecha: 8-2-2018. -->
<!-- version: 3.0-->

<!-- LLAMADA A LAS LIBRERIAS DE ETIQUETAS DE SPRING -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://com.atrium.jsg" prefix="jsg"%>

<!-- FORMULARIO DE SUBIDA DE FICHEROS -->
<form:form action="subida.htm" method="post"
	enctype="multipart/form-data" commandName="datos_subida">
	<table>
		<tr>
			<td><spring:message code="subida.eti.fichero" /></td>
			<td><input type="file" name="fichero_subido"
				value="<spring:message code="subida.bot.fichero" />"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"
				value="<spring:message code="subida.bot.servidor" />" /></td>
		</tr>
	</table>
	<form:errors path="fichero_subido" />
</form:form>
<!-- TABLA DE FICHEROS EN EL SERVIDOR -->
<table border="1">
	<thead align="center">
		<tr>
			<td colspan="5"><spring:message code="tabla.cabecera.general" /></td>
		</tr>
		<tr>
			<td><spring:message code="tabla.colum.nombre" /></td>
			<td><spring:message code="tabla.colum.fecha" /></td>
			<td><spring:message code="tabla.colum.tamaño" /></td>
			<td><spring:message code="tabla.colum.descarga" /></td>
			<td><spring:message code="tabla.colum.eliminacion" /></td>
		</tr>
	</thead>

	<tbody>
		<jsg:calculo_ficherossubidos
			nombre_usuario="${sessionScope.usuario.nombreUsuario}"
			clave_usuario="${sessionScope.usuario.password}">
			</jsg:calculo_ficherossubidos>
	</tbody>
</table>
