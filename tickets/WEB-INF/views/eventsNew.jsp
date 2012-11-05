<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
  <head>
    <title>Sistema de Tiquetes</title>
	<link href="/styles.css" rel="stylesheet" type="text/css"/>
  </head>
  <body>
	<h2>Agregar un Evento</h2>
	<form method="GET" action="/event.htm">
	<input type="hidden" name="mode" value="insert"/>
	<table>
		<tr>
			<td>
				<table>
					<tr>
						<td>Nombre:</td><td><input type="text" name="name"/></td>
					</tr>
					<tr>
						<td>Tipo Evento:</td>
						<td>
							<select name="eventType">
								<c:forEach items="${model.eventTypes}" var="eventType">
									<option value="<c:out value="${eventType.code}"/>"><c:out value="${eventType.description}"/></option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>Artistas:</td><td><input type="text" name="artists"/></td>
					</tr>
					<tr>
						<td>Fecha:</td><td><input type="text" name="date"/></td>
					</tr>
					<tr>
						<td>Lugar:</td><td><input type="text" name="place"/></td>
					</tr>
				</table>
			</td>
			<td>
				<table align="top">
					<tr>
						<th colspan="3">Localidades</th>
					</tr>
					<c:forEach items="${model.locationTypes}" var="location">
						<tr>
							<td><input type="checkbox" name="locationType<c:out value="${location.code}"/>"><c:out value="${location.description}"/></input></td>
							<td><input type="checkbox" name="locationNumbered<c:out value="${location.code}"/>">Numerada&nbsp;&nbsp;&nbsp;</input></td>
							<td>Precio:<input type="text" name="locationPrice<c:out value="${location.code}"/>"/></td>
							<td>Cantidad:<input type="text" name="locationQuantity<c:out value="${location.code}"/>"/></td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		<tr><td colspan="2"><input type="submit" value="Guardar"/></td></tr>
	</table>
	</form>
  </body>
</html>