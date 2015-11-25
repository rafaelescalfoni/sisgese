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

	<script  language="JavaScript">

						document.write("<font color='black' size='2' face='arial'>")
						var mydate=new Date()
						var year=mydate.getYear()
						if (year<2000)
						year += (year < 1900) ? 1900 : 0
						var day=mydate.getDay()
						var month=mydate.getMonth()
						var daym=mydate.getDate()
						if (daym<10)
						daym="0"+daym
						var dayarray=new Array("Domingo","Segunda-feira","Terça-feira","Quarta-feira","Quinta-feira","Sexta-feira","Sábado")
						var montharray=new Array(" de Janeiro de "," de Fevereiro de "," de Março de ","de Abril de ","de Maio de ","de Junho de","de Julho de ","de Agosto de ","de Setembro de "," de Outubro de "," de Novembro de "," de Dezembro de ")
						document.write("   "+dayarray[day]+", "+daym+" "+montharray[month]+year+" ")
						document.write("</b></i></font>")
			</script>

 </head>
<script>
function funcao1() {
alert("Soliciatação cadastrada com sucesso!");
}
</script>
	<body>

		<!-- Aqui começa o conteudo -->
		<div class="wrapper" role="main">
			<div class="container">
				
				<h3 class="page-header">Solicitação de Empregado</h3>
		        
		        <form action="<c:url value="/solicitacao/formulario"/>" method="post" role="form">								
				
				  	<div class="row col-md-12">
				  	  <div class="form-group col-md-3">
						  <label for="text">Tipo de Recrutamento</label>
						  	<div class="control-label">
		                    	<select id="solicitacao.tipoRecrutamento" name="solicitacao.tipoRecrutamento" class="form-control">
		                         	<option value=""></option>
						            <option value="Interno">Interno</option>
						            <option value="Externo">Externo</option>
						        </select>
		                    </div>
					  </div>
					  				 
					  
					<!--    <div class="form-group col-md-2">
				  	  	<label for="text">Motivo da Solicitação</label>
				  	  	<input id="motivo" type="text" class="form-control" name="solicitacao.motivo" value="${solicitacao.motivo_id}" placeholder="">
				  	  </div>
					  -->
					  <div class="form-group col-md-3">
				  	  	<label for="date">Data Criação</label>
				  	  	<input id="dataCriacao" type="date" class="form-control" name="solicitacao.dataCriacao" value="${solicitacao.dataCriacao}" placeholder="">
				  	  </div>
					  <div class="form-group col-md-3">
				  	  	<label for="date">Data Fim</label>
				  	  	<input id="dataFim" type="date" class="form-control" name="solicitacao.dataFim" value="${solicitacao.dataFim}" placeholder="">
				  	  </div>
					  
					  <div class="form-group col-md-3">
				  	  	<label for="text">Mat. Funcionário</label>
				  	  	<input id="mat_func" type="text" class="form-control" name="funcionario.matricula" value="${funcionario.matricula}" placeholder="">
				  	  </div>
					  
					  
				  	</div>
					
					
				<div class="row col-md-12">
				  	  
					 <div class="row col-md-12">
				  	  <div class="form-group col-md-2">
						  <label for="text">Motivo da Solicitacao</label>
						  	<div class="control-label">
		                    	<select id="motivo.nome" name="motivo.nome" class="form-control">
		                         	<option value=""></option>
		                         	 <option value="promocao">Promocao</option>
						            <option value="Transferencia">Transferencia</option>
						            <option value="Aumento de Quadro">Aumento de Quadro</option>
						            <option value="Demissao">Demissao</option>
						            <option value="Substituicao">Substituicao</option>
						            <option value="Outros">Outros</option>
						        </select>
		                    </div>
					  </div>
					  <div class="form-group col-md-2">
				  	  	<label for="text">Desc. da Solicitação</label>
				  	  	<input id="setor" type="text" class="form-control" name="motivo.descricao" value="${motivo.descricao}" placeholder="">
				  	  </div>
				  	  <div class="form-group col-md-2">
				  	  	<label for="text">Cód. do Cargo</label>
				  	  	<input id="cod_cargo" type="text" class="form-control" name="cargo.id" value="${cargo.id}" placeholder="">
				  	  </div>
					  
					  <div class="form-group col-md-4">
				  	  	<label for="text"> Desc. do Cargo</label>
				  	  	<input id="desc_cargo" type="text" class="form-control" name="cargo.descricao" value="${cargo.descricao}" placeholder="">
				  	  </div>
					  <div class="form-group col-md-2">
				  	  	<label for="text">Horario</label>
				  	  	<input id="horario" type="text" class="form-control" name="horario.entrada" value="${horario.entrada}" placeholder="">
				  	  </div>
					  
					  
				  	</div>
					
					<div class="row col-md-12">
				  	  <div class="form-group col-md-2">
				  	  	<label for="date">CC</label>
				  	  	<input id="c_custo" type="date" class="form-control" name="setor.id" value="${setor.id}" placeholder="">
				  	  </div>
					  
					   <div class="form-group col-md-2">
				  	  	<label for="date">Nome Setor</label>
				  	  	<input id="n_setor" type="date" class="form-control" name="setor.nome" value="${setor.nome}" placeholder="">
				  	  </div>
					  <div class="form-group col-md-2">
				  	  	<label for="date">Idade</label>
				  	  	<input id="idade" type="date" class="form-control" name="candidato_selecionado.idade" value="${candidato_selecionado.idade}" placeholder="">
				  	  </div>
					  <div class="form-group col-md-2">
				  	  	<label for="date">Sexo</label>
				  	  	<input id="sexo" type="date" class="form-control" name="candidato_selecionado.sexo" value="${candidato_selecionado.sexo}" placeholder="">
				  	  </div>
					  <div class="form-group col-md-2">
				  	  	<label for="date">Peso</label>
				  	  	<input id="peso" type="date" class="form-control" name="candidato_selecionado.peso" value="${candidato_selecionado.peso}" placeholder="">
				  	  </div>
					  <label for="text">Grau de Instrução</label>
						  	<div class="control-label col-md-2">
		                    	<select id="candidato_selecionado.grau_instrucao" name="candidato_selecionado.grau_instrucao" class="form-control">
		                         	<option></option>
										<option>Analfabeto, inclusive o que, embora tenha recebido instrucao, nao se alfabetizou</option>
										<option>Até a 4a.serie incomp.do 1o.grau(primario incompleto)ou alfabetizado sem frequentar escola regular</option>
										<option>Com a 4a. serie completa do 1o.grau (primario completo)</option>
										<option>Da 5a. a 8a. serie incompleta do 1o.grau (ginasio incompleto)</option>
										<option>Primeiro grau (ginasio) completo</option>
										<option>Segundo grau (colegial) incompleto</option>
										<option>Segundo grau (colegial) completo</option>
										<option>Superior incompleto</option>
										<option>Superior completo</option>
						        </select>
		                    </div>
					  
				  	</div>
					
					<div class="row col-md-12">
				  	  
					  <div class="form-group col-md-12">
						<label for="contrib" >Informações Adicionais:</label>
						<textarea class="form-control" rows="4" id="descricao" type="text" class="form-control" name="competencia.descricao" value="${competencia.descricao}" placeholder=""></textarea>
					</div>
				  	</div>
			
					<div class="row col-md-12">
					<br/>
					  <div class="col-md-10">
					  	<input type="submit" onclick="funcao1()" class="btn btn-info" col-md-1"  value="Salvar">
					  	<a class="btn btn-default col-md-1"  href="<c:url value="/index/home"/>" >Cancelar</a>
					  </div>
					</div>
					
					
					
					
				
				  </form>
				
			</div>
		</div>
		<!-- Fim do conteudo -->
	</body>
</html>