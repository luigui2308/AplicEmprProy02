<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
	<head>
		<title>Sistema de Tiquetes</title>
		<link href="/styles.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>
		<div id="mnuBackground"/>
		<div id="mnuPrincipal">
			<span class="title">Sistema de tiquetes&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<% HttpSession tester = request.getSession(false); %>
			<% Object Administrator = tester.getAttribute("Administrator"); %>
			<% Object Promoter = tester.getAttribute("Promoter"); %>
			<% String username = (String)tester.getAttribute("Username"); %>
			<% if (Administrator != null && (Boolean)Administrator) { %>
				<div><a href='/promoter.htm?mode=list' target="mainFrame">Promotores</a></div>
			<% } %>
			<% if (Promoter != null && (Boolean)Promoter) { %>
				<div><a href='/event.htm?mode=byPromoter' target="mainFrame">Eventos</a></div>
			<% } %>
			<div><a href='/event.htm?mode=list' target="mainFrame">Compras</a></div>
		</div>
		<div id="lnkLogon">
			<%if (username != null) {%>
			<div><a href="/user.htm?mode=logout">Salir</a></div>
			<%} else {%>
			<div><a href="/user.htm?mode=new">Entrar</a></div>
			<%}%>
		</div>
		<div id="mnuContent">
			<iframe name="mainFrame" src='/event.htm?mode=list'/>
		</div>
	</body>
</html>