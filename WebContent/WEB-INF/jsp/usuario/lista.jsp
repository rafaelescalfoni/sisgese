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
 
 <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
 <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
 <!--[if lt IE 9]>
 <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
 <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
 <![endif]-->
 </head>
	<body>
	

		  	
		<!-- Aqui começa o conteudo -->
		<div class="wrapper" role="main">
			<div class="container">

				<div class="row">	
					<div class="col-sm-4"><h3>Controle de Usuários</h3></div>
					<div class="col-sm-5">
					<form action="<c:url value="/usuario/pesquisa" />" method="get">
						<div class="input-group h2">
							
							<input name="palavraChave" class="form-control" id="search" type="text" placeholder="Pesquisar Usuários">
								<span class="input-group-btn">
									<button class="btn btn-default" type="submit">Pesquisar!</button>
										<span class="glyphicon glyphicon-search"></span>
									</button>
								</span>
								
						</div>
					</form>	
					</div>
					<div class="col-sm-4">
							<a class="btn label label-success " href="<c:url value="/usuario/formulario"/>">Novo Usuário!</a>
					</div>
				</div> <!-- /#top -->
				<hr/>	
<div id="list" class="row col-md-12">
	
	<div class="table col-md-12">
		<table class="table table-striped" cellspacing="0" cellpadding="0">
			<thead>
				<tr>
					<th>ID</th>
					<th>Login</th>
					<th>Nome</th>
					<th>Perfil</th>
					<th>Senha</th>
					
					<th class="actions">Ações</th>
				</tr>
			</thead>
			<tbody>
				
							
				<c:forEach items="${usuarioList}" var="usuario">
				
					<tr>
						<td>${usuario.id}</td>
						<td>${usuario.matricula}</td>
						<td>${usuario.nome}</td>
						<td>${usuario.perfil}</td>
						<td>${usuario.senha}</td>
						<td class="actions">
							<a class="btn btn-success btn-xs"  href="<c:url value=""/>" >Visualizar</a>
							<a class="btn btn-warning btn-xs" href="<c:url value="/usuario/edicao/${usuario.id}"/>">Editar</a>
							<a class="btn btn-danger btn-xs" href="<c:url value="/usuario/exclui/${usuario.id}"/>">Excluir</a>
						</td>
					</tr>

				</c:forEach>
				
				
				<!-- IMPLEMENTACAO DO PESQUISAR USUARIO -->
				<c:forEach items="${usuariosEncontrados}" var="usuario">
				
					<tr>
						<td>${usuario.id}</td>
						<td>${usuario.matricula}</td>
						<td>${usuario.nome}</td>
						<td>${usuario.perfil}</td>
						<td>${usuario.senha}</td>
						
						<td class="actions">
							<a class="btn btn-success btn-xs"  href="<c:url value=""/>" >Visualizar</a>
							<a class="btn btn-warning btn-xs" href="<c:url value="/usuario/edicao/${usuario.id}"/>">Editar</a>
							<a class="btn btn-danger btn-xs"  href="<c:url value="/usuario/exclui/${usuario.id}"/>">Excluir</a>
						</td>
					</tr>

				</c:forEach>
				
				 
				
			</tbody>
		</table>
	</div>
	
	</div> <!-- /#list -->
	<div id="bottom" class="row">
		<div class="col-md-12">
			<span class="glyphicon glyphicon-hand-left"></span><a href="<c:url value="/index/home"/>">&nbspVoltar</a>
		</div>
	</div> <!-- /#bottom -->			
			
			</div><!-- Fim do container -->
		</div><!-- Fim do conteudo -->
	<!-- Modal -->
<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="modalLabel">Excluir Item</h4>
      </div>
      <div class="modal-body">
        Deseja realmente excluir este item?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">Sim</button>
		<button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
      </div>
    </div>
  </div>
</div>

 <script src="js/jquery.min.js"></script>
 <script src="js/bootstrap.min.js"></script>
	</body>
</html>