var peticion_paises;
var peticion_provincias;
var peticion_municipios;

// ************ FUNCIONES PARA LA PETICION DE PAISES ************
/**
 * Funcion para realizar la peticion de paises al servidor.
 */
function actualizar_paises() {
	if (window.XMLHttpRequest) {
		peticion_paises = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		peticion_paises = new ActiveXObject("Microsoft.XMLHTTP");
	}
	// PREPARAR LA FUNCION DE RESPUESTA
	peticion_paises.onreadystatechange = respuesta_paises;
	// REALIZAR PETICION HTTP
	peticion_paises.open('GET', crear_URL(3), true);
	peticion_paises.send(null);
}

/**
 * Funcion que recoge la respuesta mandada por el servidor.
 */
function respuesta_paises() {
	if (peticion_paises.readyState == 4) {
		if (peticion_paises.status == 200) {
			cargar_Paises(peticion_paises.responseText);
		}
	}
}
/**
 * Proceso de actualizacion de pagina con la informacion recibida del servidor.
 * 
 * @param respuesta
 *            Texto en formato JSON.
 */
function cargar_Paises(lista_paises) {
	// PREPARAMOS TEXTOS PARA CREAR UN OBJETO DE NAVEGADOR
	var texto_aconvertir = "{'paises':" + lista_paises + "}";
	// CREAMOS EL OBJETO DE NAVEGADOR
	var objeto_paises = eval('(' + texto_aconvertir + ')');
	// ACCEDEMOS AL SELECT DE LA PAGINA PARA MODIFICARLO
	var lista_paises = document.getElementById("pais");
	// CREAMOS TANTOS OPTIONS COMO PAISES
	var numero_paises = objeto_paises.paises.length;
	for (i = 0; i < numero_paises; i++) {
		opcion = document.createElement('option');
		texto_opcion = document
				.createTextNode(objeto_paises.paises[i].paisNombre);
		opcion.appendChild(texto_opcion);
		opcion.value = objeto_paises.paises[i].codigoPais;
		lista_paises.appendChild(opcion);
	}
}

// ************ FIN FUNCIONES PARA LA PETICION DE PAISES ************

// ************ FUNCIONES PARA LA PETICION DE PROVINCIAS ************
/**
 * Funcion para realizar la peticion de provincias al servidor.
 */
function actualizar_provincias() {
	if (window.XMLHttpRequest) {
		peticion_provincias = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		peticion_provincias = new ActiveXObject("Microsoft.XMLHTTP");
	}
	// PREPARAR LA FUNCION DE RESPUESTA
	peticion_provincias.onreadystatechange = respuesta_provincias;
	// REALIZAR PETICION HTTP
	paises = document.getElementById("pais");
	var pais_seleccionado = paises.options[paises.selectedIndex].value;
	peticion_provincias.open('GET', crear_URL(1) + "&pais_seleccionado="
			+ pais_seleccionado, true);
	peticion_provincias.send(null);
}

/**
 * Funcion que recoge la respuesta mandada por el servidor.
 */
function respuesta_provincias() {
	if (peticion_provincias.readyState == 4) {
		if (peticion_provincias.status == 200) {
			cargar_Provincias(peticion_provincias.responseText);
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
	var objeto_provincias = eval('(' + texto_aconvertir + ')');
	var lista_provincias = document.getElementById("provincias");
	lista_provincias.options.length = 0;
	var posiciones = objeto_provincias.provincias.length;
	for (var i = 0; i < posiciones; i++) {
		opcion = document.createElement('option');
		texto_opcion = document
				.createTextNode(objeto_provincias.provincias[i].provincia);
		opcion.appendChild(texto_opcion);
		opcion.value = objeto_provincias.provincias[i].codigoProvincia;
		lista_provincias.appendChild(opcion);
	}
	// REINICIO DE LOS MUNICIPIOS SI SE CAMBIA DE PAIS
	if (objeto_provincias.provincias[0].codigoProvincia = -1) {
		var lista_municipios = document.getElementById("municipios");
		lista_municipios.options.length = 0;
		opcion = document.createElement('option');
		texto_opcion = document.createTextNode("Seleccione una provincia");
		opcion.appendChild(texto_opcion);
		opcion.value = -1;
		lista_municipios.appendChild(opcion);
	}
}
// ************ FIN FUNCIONES PARA LA PETICION DE PROVINCIAS ************

// ************ FUNCIONES PARA LA PETICION DE MUNICIPIOS ************

/**
 * Funcion para realizar la peticon de provincias al servidor.
 */
function actualizar_municipios() {
	if (window.XMLHttpRequest) {
		peticion_municipios = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		peticion_municipios = new ActiveXObject("Microsoft.XMLHTTP");
	}
	// PREPARAR LA FUNCION DE RESPUESTA
	peticion_municipios.onreadystatechange = respuesta_municipios;
	// REALIZAR PETICION HTTP
	provincias = document.getElementById("provincias");
	var provincia_seleccionada = provincias.options[provincias.selectedIndex].value;
	peticion_municipios.open('GET', crear_URL(2) + "&provincia_seleccionada="
			+ provincia_seleccionada, true);
	peticion_municipios.send(null);
}

/**
 * Funcion que recoge la respuesta mandada por el servidor.
 */
function respuesta_municipios() {
	if (peticion_municipios.readyState == 4) {
		if (peticion_municipios.status == 200) {
			cargar_municipios(peticion_municipios.responseText);
		}
	}
}

/**
 * Funcion para actualizar la pagina con la respuesta del servidor.
 * 
 * @param datos_provincias
 */
function cargar_municipios(datos_municipios) {
	var texto_aconvertir = "{'municipios':" + datos_municipios + "}";
	var objeto_respuesta = eval('(' + texto_aconvertir + ')');
	var lista_muni = document.getElementById("municipios");
	lista_muni.options.length = 0;
	var posiciones = objeto_respuesta.municipios.length;
	for (var i = 0; i < posiciones; i++) {
		opcion = document.createElement('option');
		texto_opcion = document
				.createTextNode(objeto_respuesta.municipios[i].municipio);
		opcion.appendChild(texto_opcion);
		opcion.value = objeto_respuesta.municipios[i].codigoMunicipio;
		lista_muni.appendChild(opcion);
	}
}
// ************ FIN FUNCIONES PARA LA PETICION DE MUNICIPIOS ************

/**
 * CALCULAMOS DINAMICAMENTE LOS VALORES DE LA URL DE LA PETICION A REALIZAR.
 * 
 * @return {TypeName} URL CREADA PARA LA PETICION A FALTA DE PARAMETROS
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
	if (tipo_peticion == 3) {
		valor_parametro = "cargar_paises";
	}
	aplicacion = aplicacion.substring(0, aplicacion.lastIndexOf("/"));
	var url_pattern = "/Controlador_ListasAJAX";
	var url_peticion = "http://" + servidor_web + ":" + puerto_servidor
			+ aplicacion + url_pattern + "?tipo_peticion=" + valor_parametro;
	return url_peticion;
}

/**
 * Ejemplo basico inicial de uso de DOM en javascript.
 */
function buscar_paisseleccionado() {
	var pais_seleccionado = document.getElementById("pais").value;
	alert("Pais seleccionado " + pais_seleccionado);

}