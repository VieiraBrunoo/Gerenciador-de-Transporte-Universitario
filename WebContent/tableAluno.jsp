<!DOCTYPE html>
<html lang="en">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="h"%>
<head>
<!--
        ===
        This comment should NOT be removed.

        Charisma v2.0.0

        Copyright 2012-2014 Muhammad Usman
        Licensed under the Apache License v2.0
        http://www.apache.org/licenses/LICENSE-2.0

        http://usman.it
        http://twitter.com/halalit_usman
        ===
    -->
<meta charset="utf-8">
<title>Alunos Cadastrados</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
<meta name="author" content="Muhammad Usman">

<!-- The styles -->
<link id="bs-css" href="css/bootstrap-cerulean.min.css" rel="stylesheet">

<link href="css/charisma-app.css" rel="stylesheet">
<link href='bower_components/fullcalendar/dist/fullcalendar.css'
	rel='stylesheet'>
<link href='bower_components/fullcalendar/dist/fullcalendar.print.css'
	rel='stylesheet' media='print'>
<link href='bower_components/chosen/chosen.min.css' rel='stylesheet'>
<link href='bower_components/colorbox/example3/colorbox.css'
	rel='stylesheet'>
<link href='bower_components/responsive-tables/responsive-tables.css'
	rel='stylesheet'>
<link
	href='bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css'
	rel='stylesheet'>
<link href='css/jquery.noty.css' rel='stylesheet'>
<link href='css/noty_theme_default.css' rel='stylesheet'>
<link href='css/elfinder.min.css' rel='stylesheet'>
<link href='css/elfinder.theme.css' rel='stylesheet'>
<link href='css/jquery.iphone.toggle.css' rel='stylesheet'>
<link href='css/uploadify.css' rel='stylesheet'>
<link href='css/animate.min.css' rel='stylesheet'>

<!-- jQuery -->
<script src="bower_components/jquery/jquery.min.js"></script>


<!-- The fav icon -->
<link rel="shortcut icon" href="img/logo 2.png">

</head>

<body>

	<!-- topbar starts -->
	<div class="navbar navbar-default" role="navigation">

		<div class="navbar-inner">


			<img alt="Universrty Manager" src="img/logo.png " width="300px"
				height="50px" /> <span> </span>


			<!-- user dropdown starts -->
			<div class="btn-group pull-right">
				<button class="btn btn-default dropdown-toggle"
					data-toggle="dropdown">
					<i class="glyphicon glyphicon-user"></i><span
						class="hidden-sm hidden-xs"> admin</span> <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="#">Profile</a></li>
					<li class="divider"></li>
					<li><a href="login.html">Logout</a></li>
				</ul>
			</div>
			<!-- user dropdown ends -->



		</div>
	</div>
	<!-- topbar ends -->
	<div class="ch-container">
		<div class="row">

			<!-- left menu starts -->
			<div class="col-sm-2 col-lg-2">
				<div class="sidebar-nav">
					<div class="nav-canvas">
						<div class="nav-sm nav nav-stacked"></div>
						<ul class="nav nav-pills nav-stacked main-menu">
							<li class="nav-header">Menu</li>
							<li><a class="ajax-link" href="index.jsp"><i
									class="glyphicon glyphicon-home"></i><span> Inicio</span></a></li>
							<li><a class="ajax-link" href="MotoristaCadastro.jsp"><i
									class="glyphicon glyphicon-edit"></i><span> Cadastrar
										Motorista </span></a></li>

							<li><a class="ajax-link" href="Visualizar.jsp"
								action="MotoristaListaController.li" method="post"><i
									class="glyphicon glyphicon-eye-open"></i><span>
										Motorista Cadastrados</span></a></li>

							<li><a class="ajax-link" href="Relatorio.jsp"><i
									class="glyphicon glyphicon-list-alt"></i><span> Gerar
										Relatorio Motorista</span></a></li>

							<li><a class="ajax-link" href="AlunoCadastro.jsp"><i
									class="glyphicon glyphicon-edit"></i><span> Cadastrar
										Aluno</span></a></li>

							<li><a class="ajax-link" href="VisualizarAluno.jsp"><i
									class="glyphicon glyphicon-eye-open"></i><span> Alunos
										Cadastrados</span></a></li>

							<li><a class="ajax-link" href="RelatorioAluno.jsp"><i
									class="glyphicon glyphicon-list-alt"></i><span> Gerar
										Relatorio Aluno</span></a></li>

							<li><a class="ajax-link" href="OnibusCadastro.jsp"><i
									class="glyphicon glyphicon-edit"></i><span> Cadastrar
										Onibus </span></a></li>

							<li><a class="ajax-link" href="VisualizarOnibus.jsp"><i
									class="glyphicon glyphicon-list-alt"></i><span> Onibus
										Cadastrados </span></a></li>

							<li><a class="ajax-link" href="RelatorioOnibus.jsp"><i
									class="glyphicon glyphicon-edit"></i><span> Gerar
										Relatorio O”nibus </span></a></li>


							<li><a class="ajax-link" href="RotaCadastro.jsp"><i
									class="glyphicon glyphicon-edit"></i><span> Cadastrar
										Rota </span></a></li>

							<li><a class="ajax-link" href="VisualizarRota.jsp"><i
									class="glyphicon glyphicon-eye-open"></i><span> Rotas
										Cadastradas </span></a></li>
							<li><a class="ajax-link" href="RelatorioRotas.jsp"><i
									class="glyphicon glyphicon-list-alt"></i><span> Gerar
										Relatorio Rota</span></a></li>
					</div>
				</div>
			</div>





			<div id="content" class="col-lg-10 col-sm-10">
				<!-- content starts -->
				<div>
					
				</div>
				<div class="row">
					<div class="box col-md-12">
						<div class="box-inner">
							<div class="box-header well" data-original-title="">
								<h2>
									<i class="glyphicon glyphicon-user"></i> Alunos Cadastrados
								</h2>

								<div class="box-icon">
									<a href="#" class="btn btn-setting btn-round btn-default"><i
										class="glyphicon glyphicon-cog"></i></a> <a href="#"
										class="btn btn-minimize btn-round btn-default"><i
										class="glyphicon glyphicon-chevron-up"></i></a> <a href="#"
										class="btn btn-close btn-round btn-default"><i
										class="glyphicon glyphicon-remove"></i></a>
								</div>
							</div>

							<table
								class="table table-striped table-bordered bootstrap-datatable datatable responsive">

								<thead>
									<tr>
										<th>Id Aluno</th>
										<th>Nome</th>
										<th>Rg</th>
										<th>Data Nascimento</th>
										<th>Telefone</th>
										<th>Endereco</th>
										<th>Bairro</th>
										<th>Cidade</th>
										<th>Sexo</th>
										<th>Estado Civil</th>
										<th>Titulo Eleitor</th>
										<th>Faculdade</th>
										<th>Id Rota</th>
										<th>Acao</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${alunos}" var="aluno">

										<tr>


											<td class="center"><c:out value="${aluno.idAluno}" /></td>
											<td class="center"><c:out value="${aluno.nome}" /></td>
											<td class="center"><c:out value="${aluno.rg}" /></td>
											<td class="center"><c:out
													value="${aluno.dataNascimento}" /></td>
											<td class="center"><c:out value="${aluno.telefone}" /></td>
											<td class="center"><c:out value="${aluno.endereco}" /></td>
											<td class="center"><c:out value="${aluno.bairro}" /></td>
											<td class="center"><c:out value="${aluno.cidade}" /></td>
											<td class="center"><c:out value="${aluno.sexo}" /></td>
											<td class="center"><c:out value="${aluno.estadoCivil}" /></td>
											<td class="center"><c:out value="${aluno.tituloEleitor}" /></td>
											<td class="center"><c:out value="${aluno.faculdade}" /></td>
											<td class="center"><c:out value="${aluno.idRota}" /></td>


											<td class="center"><a class="btn btn-info"
												href="AlunoListaController.alc?action=editar&idAluno=<c:out value="${aluno.idAluno}"/>">
													<i class="glyphicon glyphicon-edit icon-white"></i> Editar
											</a> <a class="btn btn-danger"
												href="AlunoListaController.alc?action=delete&idAluno=<c:out value="${aluno.idAluno}"/>">
													<i class="glyphicon glyphicon-trash icon-white"></i>
													Deletar
											</a></td>
										</tr>
										<tr>

										</tr>
									</c:forEach>


								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>

		</div>

		<!--/span-->


		<!-- external javascript -->


		<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

		<!-- library for cookie management -->
		<script src="js/jquery.cookie.js"></script>
		<!-- calender plugin -->
		<script src='bower_components/moment/min/moment.min.js'></script>
		<script src='bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
			<!-- select or dropdown enhancer -->
		<script src="bower_components/chosen/chosen.jquery.min.js"></script>
		<!-- plugin for gallery image view -->
		<script src="bower_components/colorbox/jquery.colorbox-min.js"></script>
		<!-- notification plugin -->
		<script src="js/jquery.noty.js"></script>
		<!-- library for making tables responsive -->
		<script src="bower_components/responsive-tables/responsive-tables.js"></script>
		<!-- tour plugin -->
		<script
			src="bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
		<!-- star rating plugin -->
		<script src="js/jquery.raty.min.js"></script>
		<!-- for iOS style toggle switch -->
		<script src="js/jquery.iphone.toggle.js"></script>
		<!-- autogrowing textarea plugin -->
		<script src="js/jquery.autogrow-textarea.js"></script>
		<!-- multiple file upload plugin -->
		<script src="js/jquery.uploadify-3.1.min.js"></script>
		<!-- history.js for cross-browser state change on ajax -->
		<script src="js/jquery.history.js"></script>
		<!-- application script for Charisma demo -->
		<script src="js/charisma.js"></script>
		<script>
oTable = $("#bigtable").dataTable({
  "columnDefs": [{
    "defaultContent": "-",
    "targets": "_all"
  }]
});
 Executar fragment
 </script>
</body>
</html>
