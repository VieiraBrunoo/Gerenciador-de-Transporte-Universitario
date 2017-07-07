<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Relatório Aluno</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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

<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- The fav icon -->
<link rel="shortcut icon" href="img/logo 2.png">

<link rel="stylesheet"
	href="motorista_files/formoid1/formoid-solid-blue.css" type="text/css" />
<script type="text/javascript"
	src="motorista_files/formoid1/jquery.min.js"></script>
</head>
<body>
	<!-- topbar starts -->
	<div class="navbar navbar-default" role="navigation">

		<div class="navbar-inner">
			<img alt="Universrty Manager" src="img/logo.png " width="300px"
				height="50px" />


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

			<!-- theme selector ends -->


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

				<div class="row">
					<div class="box col-md-12">
						<div class="box-inner">
							<div class="box-header well">
								<h2>
									<i class="glyphicon glyphicon-info-sign"></i> Gerar Relatorio
									Aluno
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
							<div class="box-content row">
								<div class="col-lg-7 col-md-12"></div>







								<form class="formoid-solid-blue"
									style="background-color: #FFFFFF; font-size: 14px; font-family: 'Roboto', Arial, Helvetica, sans-serif; color: #34495E; max-width: 600px; min-width: 150px"
									action="RelatorioAluno">


									<div align="left" class="submit">
										<input type="submit" name="rela" value="Gerar Relatorio" />

									</div>
								</form>
								<p class="frmd">
									<a href="http://formoid.com/v29.php">html contact form</a>
									Formoid.com 2.9
								</p>
								<script type="text/javascript"
									src="motorista_files/formoid1/formoid-solid-blue.js"></script>
								<!-- Stop Formoid form-->
</body>
</html>
