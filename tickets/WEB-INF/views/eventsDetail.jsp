<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.lang.String" %>

<html>
  <head>
    <title>Sistema de Tiquetes</title>
	<link href="/styles.css" rel="stylesheet" type="text/css"/>
  </head>
	<br/>
	<h2>Detalle de Evento</h2>
	<table>
		<form method="GET" action="/event.htm" >
		<input type="hidden" name="mode" value="update"/>
		<tr>
			<td>
				<table>
					<input type="hidden" name="code" value="<c:out value="${model.event.code}"/>"/>
					<tr>
						<td>Nombre:</td><td><input type="text" name="name" value="<c:out value="${model.event.name}"/>"/></td>
					</tr>
					<tr>
						<td>Tipo Evento:</td>
						<td>
							<select name="eventType">
								<c:forEach items="${model.eventTypes}" var="eventType">
								<option value="<c:out value="${eventType.code}"/>" <c:out value="${model.event.eventTypeCode == eventType.code ? 'selected' : ''}"/>>
									<c:out value="${eventType.description}"/>
								</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>Artistas:</td><td><input type="text" name="artists" value="<c:out value="${model.event.artists}"/>"/></td>
					</tr>
					<tr>
						<td>Fecha:</td><td><input type="text" name="date" value="<c:out value="${model.event.date}"/>"/></td>
					</tr>
					<tr>
						<td>Lugar:</td><td><input type="text" name="place" value="<c:out value="${model.event.place}"/>"/></td>
					</tr>
				</table>
			</td>
			<td>
				<table align="top">
					<tr>
						<th colspan="3">Localidades</th>
					</tr>
					<c:set var="encontrado" scope="page" value="false"/>
					<c:forEach items="${model.locationTypes}" var="location">
						<c:set var="encontrado" scope="page" value="false"/>
						<c:forEach items="${model.locationsEvent}" var="locationActual">
							<c:if test="${location.code == locationActual.locationTypeId}">
								<c:set var="encontrado" scope="page" value="true"/>
								<tr>
									<td><input type="checkbox" name="locationType<c:out value="${location.code}"/>" checked><c:out value="${location.description}"/></input></td>
									<td><input type="checkbox" name="locationNumbered<c:out value="${location.code}"/>" <c:out value="${locationActual.numbered ? 'checked' : ''}"/>>Numerada&nbsp;&nbsp;&nbsp;</input></td>
									<td>Precio:<input type="text" value="<c:out value="${locationActual.price}"/>" name="locationPrice<c:out value="${location.code}"/>"/></td>
									<td>Cantidad:<input type="text" value="<c:out value="${locationActual.quantity}"/>" name="locationQuantity<c:out value="${location.code}"/>"/></td>
								</tr>
							</c:if>
						</c:forEach>
						<c:if test="${encontrado == 'false'}">
							<tr>
								<td><input type="checkbox" name="locationType<c:out value="${location.code}"/>"><c:out value="${location.description}"/></input></td>
								<td><input type="checkbox" name="locationNumbered<c:out value="${location.code}"/>">Numerada&nbsp;&nbsp;&nbsp;</input></td>
								<td>Precio:<input type="text" name="locationPrice<c:out value="${location.code}"/>"/></td>
								<td>Cantidad:<input type="text" name="locationQuantity<c:out value="${location.code}"/>"/></td>
							</tr>
						</c:if>
					</c:forEach>
				</table>
				
			</td>
		</tr>
		<tr><td colspan="2"><input type="submit" value="Guardar"/></td></tr>
		</form>
		<tr>
			<td colspan="2">
				<table width="50%">
					<tr><td colspan="3"><h2>Tiquetes Vendidos<h2></td></tr>
					<c:forEach items="${model.locationTypes}" var="locationType">
						<tr><th colspan="3"><c:out value="${locationType.description}"/></th></tr>
						<tr><th>Numero Tiquete</th><th>Fecha</th><th>Monto Total</th><th>Detalle</th></tr>
						<c:forEach items="${model.ticketsEvent}" var="tickets">
							<c:if test="${locationType.code == tickets.locationTypeId}">
								<tr>
									<td align="center"><c:out value="${tickets.code}"/></td>
									<td align="center"><c:out value="${tickets.date}"/></td>
									<td align="center"><c:out value="${tickets.amount}"/></td>
									<td align="center">
										<a href="/ticket.htm?mode=invoice&code=<c:out value="${tickets.code}"/>&event=<c:out value="${model.event.code}"/>">
											<button>Factura</button>
										</a>
									</td>
								</tr>
							</c:if>
						</c:forEach>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
</html>