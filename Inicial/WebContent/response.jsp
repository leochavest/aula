<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello Web</title>
</head>
<body>
	<jsp:useBean id="usuario" scope="session"
		class="org.itstep.javaee.modelo.Usuario" />
	<h1>
		Hello,
		<jsp:getProperty name="usuario" property="name" />, seu CPF �
		<jsp:getProperty name="usuario" property="cpf" />,seu email �
		<jsp:getProperty name="usuario" property="email" /> seu endere�o �
		<jsp:getProperty name="usuario" property="endereco" />
		?
	</h1>
</body>
</html>