<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${tipoAvaliacao eq null }" >
			<form action="<c:url value="/tipoAvaliacao"/>" method="post">
		</c:when>
		<c:otherwise>
			<form action="<c:url value="/tipoAvaliacao/${tipoAvaliacao.id}"/>" method="post">
				<input type="hidden" name="_METHOD" value="PUT" />
		</c:otherwise>
	</c:choose>
		Nome: <input type="text" name="tipoAvaliacao.nome" value="${tipoAvaliacao.nome }" /> <br />
		Duração: <input type="number" name="tipoAvaliacao.duracao" value="${tipoAvaliacao.duracao }"/> <br />
		Descrição: <textarea name="tipoAvaliacao.descricao">${tipoAvaliacao.descricao}</textarea> <br />
		<c:choose>
			<c:when test="${tipoAvaliacao eq null }" >
				 <button type="submit">Adicionar</button>
			</c:when>
			<c:otherwise>
				 <button type="submit" name="_method" value="PUT">Editar</button>
			</c:otherwise>
		</c:choose>
	</form>
	
	<h3>Tipos de avaliação cadastrados</h3>
	<ul>
		<c:forEach items="${tipoAvaliacaoList}" var="tipo">
			<li>
				<a href="<c:url value="/tipoAvaliacao/${tipo.id}"/>" >${tipo.nome}</a> 
				<a href="<c:url value="/tipoAvaliacao/remove/${tipo.id}"/>" >Excluir</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>