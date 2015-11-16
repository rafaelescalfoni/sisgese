<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Confirma exclusão?</h2>
	<h3>Tipo de Avaliação</h3>
		Nome: ${tipoAvaliacao.nome} <br />
		Duração: ${tipoAvaliacao.duracao} <br />
		Descrição: ${tipoAvaliacao.descricao}
		 <br />
		<form action="<c:url value="/tipoAvaliacao/${tipoAvaliacao.id}"/>" method="post">
			<button name="_method" value="DELETE">Remover</button>
			<a href="<c:url value="/tipoAvaliacao/${tipoAvaliacao.id}"/>">Cancelar</a>
		</form>
</body>
</html>