<!-- Pagina de tratamiento de error  -->
<!-- fecha: 6-11-2017. -->
<!-- version: 2.7-->

<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@taglib uri="http://struts.apache.org/tags-html-el" prefix="html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

</head>

<body>
	Pagina de error llamada.
	<br />
	<!-- COMPONENTE DE STRUT QUE VISUALIZA EL TEXTO DEL ERROR -->
	<html:errors />

</body>
</html>
