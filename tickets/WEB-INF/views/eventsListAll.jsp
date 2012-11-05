<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
	<head>
		<title>Listado de eventos</title>
		<link href="/styles.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>
		<h2>Listado de eventos</h2>
		<table width="100%">
			<tr><th>Nombre</th><th>Tipo</th><th>Artistas</th><th>Fecha</th><th>Lugar</th></tr>
			<c:forEach items="${model.events}" var="event">
			<tr>
				<td><c:out value="${event.name}"/></td>
				<td>
					<c:forEach items="${model.eventTypes}" var="eventTypes">
						<c:if test="${event.eventTypeCode == eventType.code}">
							<c:out value="${eventType.description}"/>
						</c:if>
					</c:forEach>
				</td>
				<td><c:out value="${event.artists}"/></td>
				<td><c:out value="${event.date}"/></td>
				<td><c:out value="${event.place}"/></td>
				<td>
					<a href="/ticket.htm?mode=new&event=<c:out value="${event.code}"/>">
						<button>Comprar</button>
					</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>