<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
  <head>
    <title>Sistema de Tiquetes</title>
	<link href="/styles.css" rel="stylesheet" type="text/css"/>
  </head>
  <body>
	<form method="GET" action="/ticket.htm">
		<input type="hidden" name="mode" value="insert"/>
		<h2>Compra de ticket para <c:out value="${model.event.name}"/></h2>
		C&eacute;dula<br/>
		<input type="text" name="txtCostumerId"/><br/>
		Nombre<br/>
		<input type="text" name="txtCostumerName"/><br/>
		Direci&oacute;n<br/>
		<input type="text" name="txtCostumerAddress"/><br/>
		Telefono<br/>
		<input type="text" name="txtCostumerTelephone"/><br/>
		N&uacute;mero de tarjeta<br/>
		<input type="text" name="txtCostumerCardNumber"/><br/>
		Tipo de tarjeta<br/>
		<input type="text" name="txtCostumerCardType"/><br/>
		Ticket<br/>
		<select name="txtLocationTypeId">
			<c:forEach items="${model.locations}" var="location">
			<option value="<c:out value="${location.code}"/>">
				<c:out value="${location.description}"/><c:out value="${location.numbered}"/> <c:out value="${location.available}"/>/<c:out value="${location.quantity}"/>
			</option>
			</c:forEach>
		</select>
		Numerada:
		<input type="text" name="txtNumberedTicked"/>
		Cantidad:
		<input type="text" name="txtTicketQuantity"/>
		<input type="hidden" name="txtTicketEventId" value="<c:out value="${model.event.code}"/>"/>
		<br/>
		<input type="submit" value="Comprar"/>
	</form>
  </body>
</html>