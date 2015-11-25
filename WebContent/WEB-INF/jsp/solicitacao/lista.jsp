<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="utf-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="decription" content="">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 
 <!-- Bootstrap -->
 <link rel="stylesheet" href="<c:url value="/css/bootstrap-responsive.css"/> "/>
 <link rel="stylesheet" href="<c:url value="/css/bootstrap.css"/> " />
 
 <!-- Styles -->
 <link  rel="stylesheet" href="<c:url value="css/style.css"/> " />
 
 <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
 
 <!-- Include all compiled plugins (below), or include individual files as needed -->
 <script type="text/javascript" src="<c:url value="/js/bootstrap.js" />"></script>
 
 <title>SGAPES</title>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Aqui começa o conteudo -->
		<div class="wrapper" role="main">
			<div class="container">

				<div class="row">	
					<div class="col-sm-4"><h3>Solicitação</h3></div>
					<div class="col-sm-5">
					<form action="<c:url value="/solicitacao/pesquisa" />" method="get">
						<div class="input-group h2">
						
							<input name="palavraChave" class="form-control" id="search" type="text" placeholder="Pesquisar SE">
								<span class="input-group-btn">
									<button class="btn btn-default" type="submit">Pesquisar!</button>
										<span class="glyphicon glyphicon-search"></span>
									</button>
								</span>
								
						</div>
					</form>	
					</div>
					<div class="col-sm-4">
						<c:if test="${userSession.usuario.perfil ne 'usuario_adm'}">
						<a class="btn label label-success " href="<c:url value="/solicitacao/formulario"/>">Nova Solicitação!</a>
						</c:if>
						<a class="btn label label label-warning " href="<c:url value="/index/home"/>">Página Inicial!</a>
					</div>
				</div> <!-- /#top -->
				<hr/>	
<div id="list" class="row col-md-12">
	
	<div class="table col-md-12">
		<table class="table table-striped" cellspacing="0" cellpadding="0">
			<thead>
				<tr>
					<th>Número</th>
					<th>Usuário</th>
					<th>Motivo</th>
					<th>Setor</th>
					<th>Motivo do Recrutamento</th>
					<th>Data da Criação</th>
					<th>Data do Fim</th>
					<th class="actions">Ações</th>
				</tr>
			</thead>
			<tbody>
				
							
				<c:forEach items="${solicitacaoList}" var="solicitacao">
				
					<tr>
						<td>${solicitacao.id}</td>
						<td>${solicitacao.usuarioId}</td>
						<td>${solicitacao.motivoId}</td>
						<td>${solicitacao.setorId}</td>
						<td>${solicitacao.tipoRecrutamento}</td>
						<td>${solicitacao.dataCriacao}</td>
						<td>${solicitacao.dataFim}</td>
						<td class="actions">
							<a class="btn btn-success btn-xs"  href="<c:url value=""/>" >Visualizar</a>
							<c:if test="${userSession.usuario.perfil ne 'usuario_adm'}">
							<a class="btn btn-warning btn-xs" href="<c:url value="/solicitacao/edicao/${solicitacao.id}"/>">Editar</a>
							<a class="btn btn-danger btn-xs" href="<c:url value="/solicitacao/exclui/${solicitacao.id}"/>">Excluir</a>
						    </c:if>
						</td>
					</tr>

				</c:forEach>
				
				
				<!-- IMPLEMENTACAO DO PESQUISAR SE -->
				<c:forEach items="${solicitacoesEncontradas}" var="solicitacao">
				
					<tr>
						<td>${solicitacao.id}</td>
						<td>${usuario.id}</td>
						<td>${motivo.motivoid}</td>
						<td>${solicitacao.setorid}</td>
						<td>${solicitacao.tipoRecrutamento}</td>
						<td>${solicitacao.dataCriacao}</td>
						<td>${solicitacao.dataFim}</td>
						<td class="actions">
							<a class="btn btn-success btn-xs"  href="<c:url value=""/>" >Visualizar</a>
							<a class="btn btn-warning btn-xs" href="<c:url value="/solicitacao/edicao/${solicitacao.id}"/>">Editar</a>
							<a class="btn btn-danger btn-xs"  href="<c:url value="/solicitacao/exclui/${solicitacao.id}"/>">Excluir</a>
						</td>
					</tr>

				</c:forEach>
				
				 
				
			</tbody>
		</table>
	</div>
	
	</div> <!-- /#list -->
	 <!-- /#bottom -->			
			
			</div><!-- Fim do container -->
		</div><!-- Fim do conteudo -->
</body>
</html>