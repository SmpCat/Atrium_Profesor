<!-- Pagina de arranque -->
<!-- fecha: 16-11-2016. -->
<!-- version: 2.7-->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

</head>

<body>
	This is my JSP page.
	<br>
	<%
		session.setAttribute("prueba", "prueba evento sesion");
		session.setAttribute("prueba", "cambio de valor");
		session.removeAttribute("prueba");
		request.setAttribute("prueba", "prueba evento peticion");
		request.setAttribute("prueba", "cambiamos el atributo de peticion");
		request.removeAttribute("prueba");
	%>

</body>
</html>
