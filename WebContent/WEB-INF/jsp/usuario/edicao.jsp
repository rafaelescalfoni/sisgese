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
				
				<h3 class="page-header">Edição de Usuários</h3>
				<form action="<c:url value="/usuario/update/${usuario.id}"/>" method="post">
				
				  	<div class="row col-md-12 col-md-offset-1">
				  	  <div class="form-group col-md-3">
				  	  	
				  	  	
				  	  	<label for="text">Login</label>
		
				  	  	<input id="login" type="text" class="form-control" name="usuario.login" value="${usuario.matricula}"/>
				  	  </div>
					  <div class="form-group col-md-3">
				  	  	<label for="text">Senha</label>
				  	  	<input id="senha" type="password" class="form-control" name="usuario.senha" value="${usuario.senha}">
				  	  </div>
				  	  
				  	   <div class="form-group col-md-4">
				  	  	<label for="text">Nome</label>
				  	  	<input id="nome" type="text" class="form-control" name="usuario.nome" value="${usuario.nome}" placeholder="Digite seu nome...">
				  	  </div>
				  	  
				  	   <div class="form-group col-md-2">
						  <label for="text">Perfil</label>
						  	<div class="control-label">
		                    	<select id="usuario.perfil" name="usuario.perfil" class="form-control">
		                         	<option value=""></option>
						            <option value="Administrador">administrador</option>
						            <option value="Chefe">chefe</option>
						            <option value="Usuario_adm">usuario_adm</option>
		                        </select>
		                    </div>
					  </div>
					  <!--
					  <div class="form-group col-md-2">
						  <label for="text">Status</label>
						  	<div class="control-label">
		                    	<select id="usuario.status" name="usuario.status" class="form-control">
		                         	<option value=""></option>
						            <option value="1">Ativo</option>
						            <option value="0">Inativo</option>
						            
		                        </select>
		                    </div>
					  </div>
				  	  
				  	   -->
				  	  
				  	  
					  
				  	</div>
					
					<hr />
					
					<div class="row col-md-12 col-md-offset-1">
					<br/>
					  <div class="col-md-12">
					  
					  
						<input type="submit" class="btn btn-primary col-md-1" value="Salvar">
					  	<a class="btn btn-default col-md-1"  href="<c:url value="/usuario/lista"/>">Cancelar</a>
					  </div>
					</div>
				
				  </form>
				
			</div>
		</div>
		<!-- Fim do conteudo -->
	
	</body>
</html>