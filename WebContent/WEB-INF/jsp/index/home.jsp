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

						document.write("<font color='red' size='2' face='arial'>")
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
	<body>

		
<br>
			<br>
			<br>
		<!-- Aqui começa o conteudo -->
		<div class="wrapper" role="main">
			<div class="container-fluid">
			<h4 align = "center">SISTEMA DE GERENCIAMENTO PARA AUTOMATIZAÇÃO NO PROCESSO DE EMISSÃO DE SE</h4>
				<div class="row col-md-6 col-md-offset-3">
					<div id="conteudo" >
						

					<div id="caixa_selecao" style="margin-top:50px;" >


						<div class="panel panel-info">
							<div class="panel-heading">
							<div class="panel-body">
								<div class="container">
									<div class="col-lg-4 col-lg-offset-1  panel-title">Escolha  uma opção e acesse o sistema</div>
											<div style="padding-top:20px" class="panel-body" >
												
													
														
														<div class="form-group" style="padding-left:110px">
															<br><br>
															<input class="label label-success" id="n_se" >
															<label for="nova_se">Solicitação de Empregado(SE)</label>
															<span><a class="label label-success" href="<c:url value="/formulario/formulario"/>" >Nova!</a></span>
															<br><br>
															<input class="label label-warning"  id="rel_se"  >
															<label for="relatorio_se">Relátorios Solicitação Empregados(SE)</label>
															<span><a class="label label-warning" href="<c:url value="/telaRelatorio/tela_relatorio"/>" >Gerar!</a></span>
															<br><br>
															<input class="label label-default"  id="ed_se">
															<label for="editar_se">Editar Solicitação Empregados(SE)</label>
															<span><a class="label label-default" href="<c:url value="/telaMotivoSolicitacao/motivo_solicitacao"/>" >Editar!</a></span>
  															<br><br>
  															<input class="label label-danger" id="del_se">
															<label for="excluir_se">Excluir Solicitação Empregados(SE)</label>
															<span><a class="label label-danger" href="<c:url value="/telaMotivoSolicitacao/motivo_solicitacao"/>" >Excluir!</a></span>
														</div>
														
														
												
														<!--  <div align="center" class="col-lg-8 col-lg-offset-2 col-lg-2 ">
														<input type="submit" id="btn-acessar" class="btn btn-lg btn-info btn-block" value="Acessar">
														</div>-->
														
												</form>
										</div>
										
									</div><!-- Fim contener-->
								</div><!--fim panel-body -->
								
								<a href="<c:url value="/login/login"/>"><span class="glyphicon glyphicon-off"></span>&nbspSair</a>
								
							</div>
							
							
							 
						</div><!-- Fim panel-->

					</div><!--caixa_selecao-->
					

					</div><!-- fim conteudo-->
					</div><!-- row geral-->
					</div><!-- Fim do container-fluid -->
					</div><!-- wrapper-->


			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
					<ul class="nav navbar-nav">

					</ul>


		</div>



	</body>
</html>