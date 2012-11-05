<html>
	<head>
		<title>Error</title>
		<link href="/styles.css" rel="stylesheet" type="text/css"/>
		<jsp:useBean id="error" scope="request" class="java.lang.Exception" type="java.lang.Exception"/>
	</head>
	<body>
		<h1><%=error.getMessage()%></h1>
		Localized message: <%=error.getLocalizedMessage()%>
		<br/>
		Cause: <%=error.getCause()%>
		<br/>
		<h2>Stack trace</h2>
		<% for (java.lang.StackTraceElement stackElement : error.getStackTrace()) {%>
			<%=stackElement.toString()%>
			<br/>
		<%}%>
		<br/>
		<br/>
	</body>
</html>