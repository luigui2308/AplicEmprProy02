<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
  <head>
    <title>Sistema de Tiquetes</title>
	<link href="/styles.css" rel="stylesheet" type="text/css"/>
  </head>
  <body>
  <h2>Detalle de Promotor</h2>
  <form method="GET" action="/promoter.htm">
	  <input type="hidden" name="mode" value="update"/>
	  <table>
		<input type="hidden" name="txtPromoterCode" value="<c:out value="${model.promoter.code}"/>"/>
		<tr>
			<td>Nombre:</td>
			<td><input type="text" value="<c:out value="${model.promoter.name}"/>" name="txtPromoterName"></td>
		</tr>
		<tr>
			<td>Direccion:</td>
			<td><input type="text" value="<c:out value="${model.promoter.address}"/>" name="txtPromoterAddress"></td>
		</tr>
		<tr>
			<td>Telefono:</td>
			<td><input type="text" value="<c:out value="${model.promoter.telephone}"/>" name="txtPromoterTelephone"></td>
		</tr>
		<tr>
			<td>Numero de Cuenta:</td>
			<td><input type="text" value="<c:out value="${model.promoter.account}"/>" name="txtPromoterAccount"></td>
		</tr>
		<tr>
			<td>Banco:</td>
			<td><input type="text" value="<c:out value="${model.promoter.bank}"/>" name="txtPromoterBank"></td>
		</tr>
		<tr>
			<td>Comision:</td>
			<td><input type="text" value="<c:out value="${model.promoter.comission}"/>" name="txtPromoterComission"></td>
		</tr>
		<tr>
			<td>Username:</td>
			<td><input readonly="readonly" type="text" value="<c:out value="${model.user.username}"/>" name="txtUserUserName"></td>
		</tr>	
		<tr>
			<td>Contrase&ntilde;a:</td>
			<td><input type="password" value="<c:out value="${model.user.password}"/>" name="txtUserPass"></td>
		</tr>		
		<tr><td colspan="2"><input type="submit" value="Actualizar"/></td></tr>
	  </table>
  </form>
  </body>
</html>