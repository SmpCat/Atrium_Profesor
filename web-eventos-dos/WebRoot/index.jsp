<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<%
		application.setAttribute("prueba aplicacion", new Integer(100));
		application.setAttribute("prueba aplicacion", new Integer(200));
		application.removeAttribute("prueba aplicacion");

		session.setAttribute("prueba sesion", new Date());
		session.setAttribute("prueba sesion", "dato cambiado");
		session.removeAttribute("prueba sesion");

		request.setAttribute("prueba peticion", new Double(25.6));
		request.setAttribute("prueba peticion", new Double(10.0));
		request.removeAttribute("prueba peticion");

		session.setMaxInactiveInterval(5);
	%>
	SOY INDEX.JSP
</body>
</html>
