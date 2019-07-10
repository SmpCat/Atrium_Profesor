<!-- EJEMPLO DE CARGA DINAMICA Y CARGA CRUZADA DE COMBOS -->
<!-- fecha: 3-11-2017.. -->
<!-- version: 2.0-->

<%@ page language="java" pageEncoding="ISO-8859-1"%>
<!-- LLAMADA A TLD DE STRUT PARA EL USO DE ETIQUETAS PERSONALIZADAS -->
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
<html:base ref="site" />

<title>ejemplo_listas.jsp</title>
<!-- CARGA DE FUNCIONES DE JAVASCRIPT -->
<script type="text/javascript" src="javascript/funciones.js"></script>

</head>

<body>
	<!-- FORMULARIO DE EJEMPLO DE USO DE LISTAS EN STRUT -->
	<html:form action="listas_accion" method="post">
		<table>
			<tr>
				<td>Paises</td>
				<!-- COMBO DINAMICO CON CARGA AUTOMAMATICA -->
				<td><html:select property="pais_seleccionado"
						onchange="actualizar_provincias();">
						<html:optionsCollection property="lista_paises"
							label="texto_combo" value="valor_combo" />
					</html:select></td>
				<td>Provincias</td>
				<!-- COMBO DINAMICO CON CARGA CRUZADA -->
				<td><html:select property="provincia_seleccionada">
						<html:optionsCollection property="lista_provincias"
							value="valor_combo" label="texto_combo" />
					</html:select></td>
		</table>
	</html:form>
</body>
</html:html>
