<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><html>  <head>    <title>Sistema de Tiquetes</title>	<link href="/styles.css" rel="stylesheet" type="text/css"/>  </head>  <body>	<br/>	<br/>	<br/>	<fieldset align="center">		<legend>Factura de Tiquete</legend>		<table width="100%">			<tr>				<td>Nombre: <c:out value="${model.customer.name}"/></td>				<td>N&uacute;mero de C&eacute;dula: <c:out value="${model.customer.id}"/></td>			</tr>			<tr>				<td>Tel&eacute;fono:<c:out value="${model.customer.telephone}"/></td>				<td>Direci&oacute;n: <c:out value="${model.customer.address}"/></td>			</tr>			<tr>				<td>Tipo de tarjeta: <c:out value="${model.customer.cardType}"/></td>				<td>N&uacute;mero de tarjeta: <c:out value="${model.customer.cardNumber}"/></td>			</tr>			<tr>				<td>Tiquete: <c:out value="${model.ticket.code}"/></td>				<td>Evento: <c:out value="${model.event.name}"/></td>			</tr>			<tr>				<td>Fecha de compra: <c:out value="${model.ticket.date}"/></td>				<td>					<c:if test="${!empty model.numberedLocations}">						Numeradas: 						<c:forEach items="${model.numberedLocations}" var="numberedLocation">							<c:out value="${numberedLocation.locationNumber}"/>						</c:forEach>					</c:if>				</td>			</tr>			<tr>				<td>Cantidad: <c:out value="${model.ticket.quantity}"/></td>				<td>Total a pagar: <c:out value="${model.ticket.amount}"/></td>			</tr>			<tr>				<td colspan="2" align="center">					<a href="<c:out value="${model.link}"/>" >						<button>Regresar</button>					</a>				</td>			</tr>		</table>	</fieldset>  </body></html>