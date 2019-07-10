<!-- Pagina de gestion de temas -->
<!-- fecha: 10-11-2017. -->
<!-- version: 2.0-->

<!-- LLAMADA A LIBRERIA DE TLD PARA ETIQUETAS DE SPRING -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- CARGA DE FICHERO JAVASCRIPT SEGUN TEMA -->
<script type="text/javascript" src='<spring:theme code="js"/>'>
	
</script>

<table>
	<tbody>
		<tr>
			<td>Cambiar tema:</td>
			<td><form:form action="formu_cambiotema.htm"
					commandName="datos_temas" name="formu_cambiotema"
					id="formu_cambiotema" method="post">
					<select name="tema" onchange="submitform()">
						<option selected="sin seleccion">Seleccione un tema</option>
						<option value="explorer">Tema explorer</option>
						<option value="chrome">Tema Chrome</option>
					</select>
				</form:form></td>
		</tr>
	</tbody>
</table>