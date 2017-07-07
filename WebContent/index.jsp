<!DOCTYPE html>
<html lang="en">
<head>


<meta charset="utf-8">
<title>University Script Manager</title>
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
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	width: 100%;
	margin: auto;
}
</style>



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
										Relatorio Motorista</span> </a></li>

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
			<!--/span-->
			<!-- left menu ends -->


			<div id="content" class="col-lg-10 col-sm-10">
				<!-- content starts -->
				<div align="center">


					<div>
						<div class="container">
							<br>
							<div id="myCarousel" class="carousel slide" data-ride="carousel">
								<!-- Indicators -->
								<ol class="carousel-indicators">
									<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
									<li data-target="#myCarousel" data-slide-to="1"></li>
									<li data-target="#myCarousel" data-slide-to="2"></li>
								</ol>

								<!-- Wrapper for slides -->
								<div class="carousel-inner" role="listbox">

									<div class="item active">
										<img src="img/onibus.jpg" alt="Chania" width="460"
											height="345">
										<div class="carousel-caption">
											<h3>Onibus</h3>
											<b>
												<p>Nossos Veiculos de Qualidade.</p>
											</b>
										</div>
									</div>

									<div class="item">
										<img src="img/onibus1.jpg" alt="Chania" width="460"
											height="345">
										<div class="carousel-caption">
											<h3>Novos Onibus</h3>
											<b>
												<p>Nossos Estudantes irão desfrutar dos melhores onibus.</p>
											</b>
										</div>
									</div>

									<div class="item">
										<img src="img/onibus2.jpg" alt="Chania" width="460"
											height="345">
										<div class="carousel-caption">
											<h3>Eles Voltaram</h3>
											<b>
												<p>Conforto e Qualidades.</p>
											</b>
										</div>
									</div>


								</div>

								<!-- Left and right controls -->
								<a class="left carousel-control" href="#myCarousel"
									role="button" data-slide="prev"> <span
									class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
									<span class="sr-only">Previous</span>
								</a> <a class="right carousel-control" href="#myCarousel"
									role="button" data-slide="next"> <span
									class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
									<span class="sr-only">Next</span>
								</a>
							</div>
						</div>


					</div>




				</div>
			</div>


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
		</div>
	</div>


</body>
</html>
