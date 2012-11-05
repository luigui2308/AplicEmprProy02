<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
	<head>
		<title>Sistema de Tiquetes</title>
		<link href="/styles.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>
	<h2>Listado de Promotores</h2>
	<table width="75%">
		<tr>
			<th>Nombre</th><th>Tel&eacute;fono</th><th>Direcci&oacute;n</th><th>Comision</th>
		</tr>
		<c:forEach items="${model.promoters}" var="promoter">
		<tr>
			<td><c:out value="${promoter.name}"/></td>
			<td><c:out value="${promoter.telephone}"/></td>
			<td><c:out value="${promoter.address}"/></td>
			<td><c:out value="${promoter.comission}"/></td>
			<td>
				<a href='/promoter.htm?mode=detail&promoter=<c:out value="${promoter.code}"/>&user=<c:out value="${promoter.username}"/>'>
					<input type="submit" value="Detalle"/>
				</a>
				<a href='/promoter.htm?mode=delete&promoter=<c:out value="${promoter.code}"/>&user=<c:out value="${promoter.username}"/>'>
					<input type="submit" value="Eliminar"/>
				</a>
			</td>	
		</tr>
		</c:forEach>
	</table>
	<a href='/promoter.htm?mode=new'>
		<input type="submit" name="action" value="Agregar"/>
	</a>
	</body>
</html>