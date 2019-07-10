// TRATAMIENTO DE LOS FORMULARIOS VIA JAVASCRIPT

/**
 * Funcion de alto nivel para la validacion de campos en formularios via DOM.
 * 
 * @return
 */
function validar_formulario() {
	var valido = true;
	var campo1 = document.getElementById("codigo_cliente");
	var campo2 = document.getElementById("nombre_cliente");
	if (campo_vacio(campo1)) {
		valido = false;
		alert("El campo codigo es obligatorio");
	}
	if (campo_vacio(campo2)) {
		valido = false;
		alert("el campo nombre es obligatorio");
	}
	if (!comprobar_tamaño(nombre, 20)) {
		valido = false;
	}
	if (!comprobar_tamaño(clave, 10)) {
		valido = false;
	}
	return valido;
}

// ***** CONJUNTO DE FUNCIONES AUXILIARES PARA LA VALIDACION DE FORMULARIOS
/**
 * Proceso de validacion de campos vacios.
 * 
 * @param campo
 *            Cadena a comprobar.
 * @returns Indicador del resultado del proceso.
 */
function campo_vacio(campo) {
	if (campo.value == "") {
		return true;
	} else {
		return false;
	}

	/**
	 * Proceso de validacion de tamaño en las cadenas de caracteres.
	 * 
	 * @param campo
	 *            Cadena a comprobar.
	 * @param tamaño
	 *            Tamaño maximo de la cadena.
	 * @returns {Boolean} Indicador del proceso.
	 */
	function comprobar_tamaño(campo, tamaño) {
		var valido = true;
		if (campo.length > tamaño) {
			valido = false;
		}
		return valido;
	}

	/**
	 * Validacion numerica del contenido de un campo mediante el uso de
	 * expresiones regulares.
	 * 
	 * @param campo
	 * @returns {Boolean}
	 */
	function isNumero(campo) {
		var texto = campo.value;
		var expresion = /^[-]?\d*\.?\d*$/;
		texto = texto.toString();
		if (!texto.match(expresion)) {
			alert("Solo se admiten numero para el campo.");
			setTimeout("focusElement('" + campo.form.name + "', '" + campo.name
					+ "')", 0);
			return false;
		}
		if (texto == NaN) {
			return false;
		}
		return true;
	}

	/**
	 * Validacion de un Email. Solo que el formato sea correcto no si existe
	 * realmente.
	 * 
	 * @param campo
	 * @returns {Boolean}
	 */
	function isEMailAddr(campo) {
		var texto = campo.value;
		var expresion = /^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]{2,7}$/;
		if (!texto.match(expresion)) {
			alert("No es un email correcto");
			setTimeout("focusElement('" + campo.form.name + "', '" + campo.name
					+ "')", 0);
			return false;
		} else {
			return true;
		}
	}

	function validar_Telefono(campo) {
		var valido = true;
		// EXPRESION REGULAR PARA TELEFONOS
		var expresion_telefono = /(?:\d{3}|\(\d{3}\))([-\/\.])\d{3}\1\d{4}/;
		var numero = campo.value;
		if (!numero.match(expresion_telefono)) {
			valido = false;
		}
		return valido;
	}

	function validar_TelefonoInternacional() {
		var valido = true;
		// EXPRESION REGULAR PARA TELEFONOS DE CUALQUIER PAIS
		var expresion_telefono = /	^\+?\d{1,3}?[- .]?\(?(?:\d{2,3})\)?[- .]?\d\d\d[- .]?\d\d\d\d$/;
		var numero = campo.value;
		if (!numero.match(expresion_telefono)) {
			valido = false;
		}
		return valido;
	}

	function validar_CodigoPostal(campo) {
		var valido = true;
		// EXPRESION REGULAR PARA CODIGOS POSTALES
		var expresion_cp = /^([1-9]{2}|[0-9][1-9]|[1-9][0-9])[0-9]{3}$/;
		var codigo = campo.value;
		if (!codigo.match(expresion_cp)) {
			valido = false;
		}
		return valido;
	}

	/**
	 * Funcion auxiliar para pasar el foco al campo elegido.
	 * 
	 * @param formName
	 * @param elemName
	 */
	function focusElement(formName, elemName) {
		var elem = document.forms[formName].elements[elemName];
		elem.focus();
		elem.select();
	}

}
