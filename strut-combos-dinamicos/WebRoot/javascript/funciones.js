//-- Funciones usadas en la pagina de ejemplo_listas --
// autor: Juan Antonio Solves Garcia.
//-- fecha: 3-11-2017.
//-- version: 2.0--

// ************ FUNCIONES PARA LA PETICION DE PROVINCIAS ************
/**
 * Funcion para realizar la peticion de provincias al servidor.
 */
function actualizar_provincias() {
	if (window.XMLHttpRequest) {
		peticion_provincia = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		peticion_provincia = new ActiveXObject("Microsoft.XMLHTTP");
	}
	// PREPARAR LA FUNCION DE RESPUESTA
	peticion_provincia.onreadystatechange = respuesta_provincias;
	// REALIZAR PETICION HTTP
	var paises = document.getElementsByName("pais_seleccionado")[0];
	var pais_seleccionado = paises.options[paises.selectedIndex].value;
	peticion_provincia.open('GET', crear_URL(1) + "&pais_seleccionado="
			+ pais_seleccionado, true);
	peticion_provincia.send(null);
}

/**
 * Funcion que recoge la respuesta mandada por el servidor.
 */
function respuesta_provincias() {
	if (peticion_provincia.readyState == 4) {
		if (peticion_provincia.status == 200) {
			cargar_Provincias(peticion_provincia.responseText);
		}
	}
}
/**
 * Funcion para actualizar la pagina con la respuesta del servidor.
 * 
 * @param datos_provincias
 */
function cargar_Provincias(datos_provincias) {
	var texto_aconvertir = "{'provincias':" + datos_provincias + "}";
	// CREACION DE OBJETO DE NAVEGADOR
	var objeto_respuesta = eval('(' + texto_aconvertir + ')');
	var lista_pro = document.getElementsByName("provincia_seleccionada")[0];
	// BORRAMOS EL CONTENIDO PREVIO PONIENDO A CERO LA TABLA DE OPTIONS DEL
	// SELECT
	lista_pro.options.length = 0;
	var posiciones = objeto_respuesta.provincias.length;
	// CARGA DE INFORMACION EN EL SELECT
	for (var i = 0; i < posiciones; i++) {
		// CREACION DE OPTIONS PARA EL SELECT
		opcion = document.createElement('option');
		texto_opcion = document
				.createTextNode(objeto_respuesta.provincias[i].provincia);
		opcion.appendChild(texto_opcion);
		opcion.value = objeto_respuesta.provincias[i].codigoProvincia;
		lista_pro.appendChild(opcion);
	}
}
// ************ FIN FUNCIONES PARA LA PETICION DE PROVINCIAS ************

/**
 * Calculamos dinamicamente los valores de la url de la peticion a realizar.
 * 
 * @return {TypeName} URL Creada para la peticion a falta de parametros
 */
function crear_URL(tipo_peticion) {
	// VALORES DE LA URL.
	var puerto_servidor = location.port;
	var servidor_web = location.hostname;
	var aplicacion = location.pathname;
	var valor_parametro;
	if (tipo_peticion == 1) {
		valor_parametro = "cargar_provincias";
	}
	if (tipo_peticion == 2) {
		valor_parametro = "cargar_municipios";
	}
	aplicacion = aplicacion.substring(0, aplicacion.lastIndexOf("/"));
	var url_pattern = "/listas_accion.do";
	var url_peticion = "http://" + servidor_web + ":" + puerto_servidor
			+ aplicacion + url_pattern + "?tipo_peticion=" + valor_parametro;
	return url_peticion;
}