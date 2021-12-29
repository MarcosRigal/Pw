<%@page import="es.uco.pw.data.dtos.SesionDTO"%>
<%@page import="es.uco.pw.business.managers.SesionManager"%>
<%@page import="es.uco.pw.data.dtos.SpectacleDTO"%>
<%@page import="es.uco.pw.business.managers.SpectacleManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="customerBean" scope="session"
	class="es.uco.pw.display.javabean.CustomerBean"></jsp:useBean>
<%@ page
	import="java.text.SimpleDateFormat,es.uco.pw.data.dtos.UserDTO,es.uco.pw.business.managers.DataBaseManager,es.uco.pw.business.managers.UserManager,java.util.ArrayList"%>
<html>
<%
	SimpleDateFormat formatter6 = new SimpleDateFormat("dd-MM-yyyy");
	request.setCharacterEncoding("UTF-8");
	SimpleDateFormat formatter5 = new SimpleDateFormat(
			"dd-MM-yyyy HH:mm");
	SesionManager sesionManager = SesionManager.getInstance();
	SpectacleManager spectacleManager = SpectacleManager.getInstance();
%>
<!-- moviegridfw07:38-->
<head>
<!-- Basic need -->
<title>UCOspectacles</title>
<meta charset="UTF-8">
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="author" content="">
<link rel="profile" href="#">
<link rel="icon" type="image/x-icon" href="/JSPMVC/images/favicon.ico">

<!--Google Font-->
<link rel="stylesheet"
	href='http://fonts.googleapis.com/css?family=Dosis:400,700,500|Nunito:300,400,600' />
<!-- Mobile specific meta -->
<meta name=viewport content="width=device-width, initial-scale=1">
<meta name="format-detection" content="telephone-no">

<!-- CSS files -->
<link rel="stylesheet" href="/JSPMVC/css/plugins.css">
<link rel="stylesheet" href="/JSPMVC/css/style.css">


</head>
<body>
	<!--preloading-->
	<div id="preloader">
		<img class="logo" src="/JSPMVC/images/logo1.png" alt="" width="119"
			height="58">
		<div id="status">
			<span></span> <span></span>
		</div>
		<%
			String nextPage = "";
			String mensajeNextPage = "";
			if (customerBean != null
					&& customerBean.getTypeUser().equals("Spectator")) {
		%>
	</div>
	<!--end of preloading-->
	<!-- BEGIN | Header -->
	<header class="ht-header">
		<div class="container">
			<nav class="navbar navbar-default navbar-custom">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header logo">
					<div class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<div id="nav-icon1">
							<span></span> <span></span> <span></span>
						</div>
					</div>
					<a href="index.jsp"><img class="logo" src="images/logo1.png"
						alt="" width="119" height="58"></a>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse flex-parent"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav flex-child-menu menu-left">
						<li class="hidden"><a href="#page-top"></a></li>
						<li><a style="color: #DCF836" href="index.jsp">Inicio</a></li>
						<li><a href="userProfile">Perfil</a></li>
						<li><a href="searchSpectacle">Espectáculos</a></li>
						<li><a href="listSesions">Sesiones</a></li>
						<li><a href="userReviews">Mis críticas</a></li>
					</ul>
					<form method="get" autocomplete="off" action="logout">
						<ul class="nav navbar-nav flex-child-menu menu-right">
							<li><button class="redbtn" style="border: none"
									type="submit">Cerrar sesión</button></li>
						</ul>
					</form>
				</div>
				<!-- /.navbar-collapse -->
			</nav>

			<!-- top search form -->
			<form method="post" autocomplete="off" action="searchSpectacle">
				<div class="top-search">
					<select name="filter">
						<option value="title">T&iacute;tulo</option>
						<option value="category">Categor&iacute;a</option>
					</select> <input type="text" name="search"
						placeholder="Busque un espect&aacute;culo por t&iacute;tulo o por categor&iacute;a">
					<input name="hidden" type="submit" style="display: none;">
				</div>
			</form>
		</div>
	</header>
	<!-- END | Header -->

	<div class="hero common-hero">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="hero-ct">
						<h1>
							Bienvenido de nuevo:
							<jsp:getProperty property="nickUser" name="customerBean" /></h1>
						<ul class="breadcumb">
							<li class="active"><a href="#">Hoy es: </a></li>
							<li><%=formatter6.format(new java.util.Date())%></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- celebrity list section-->
	<div class="page-single">
		<div class="container">
			<div class="row ipad-width2">
				<div class="col-md-9 col-sm-12 col-xs-12">
					<h1 style="color: white">Próximas sesiones con entradas</h1>
					<br></br>
					<%
						ArrayList<SesionDTO> sesions = sesionManager.getSesions();
							SpectacleDTO spectacle = null;
							ArrayList<SpectacleDTO> spectacles = spectacleManager
									.getSpectacles();
					%>
					<div class="row">
						<%
							for (int i = 0; i < sesions.size(); i++) {
									if (sesions.get(i).getPlacesLeft() > 0
											&& (sesions.get(i).getDate()
													.compareTo(new java.util.Date())) > 0) {
										for (int j = 0; j < spectacles.size(); j++) {
											if (spectacles.get(j).getSpectacleId() == sesions
													.get(i).getSpectacleId()) {
												spectacle = spectacles.get(j);
						%>
						<div class="col-md-12">
							<div class="ceb-item-style-2">
								<div class="ceb-infor">
									<h2>
										<a
											href=<%="listSpectacleReviews?spectacleId="
										+ spectacle.getSpectacleId()%>><%=spectacle.getTitle()%></a>
									</h2>
									<p />
									<p><%="Fecha: "
										+ formatter5.format(sesions.get(i)
												.getDate())%></p>
									<p><%="Plazas libres: "
										+ sesions.get(i).getPlacesLeft()%></p>
								</div>
							</div>
						</div>
						<%
							break;
											}
										}
									}
								}
						%>
					</div>
				</div>
				<div class="col-md-3 col-xs-12 col-sm-12">
					<div class="sidebar">
						<div class="searh-form">
							<h4 class="sb-title">Registrar crítica</h4>
							<form class="form-style-1 celebrity-form" method="post"
								autocomplete="off" action="registerReview">
								<div class="row">
									<div class="col-md-12 form-it">
										<label>Espectáculo</label> <select name="spectacleId">
											<%
												for (int i = 0; i < spectacles.size(); i++) {
											%>
											<option value=<%=spectacles.get(i).getSpectacleId()%>><%=spectacles.get(i).getTitle()%></option>
											<%
												}
											%>
										</select>
									</div>
									<div class="col-md-12 form-it">
										<label>Título</label> <input type="text" name="title"
											required="required" />
									</div>
									<div class="col-md-12 form-it">
										<label>Review</label> <input type="text" name="review"
											required="required" />
									</div>
									<div class="col-md-12 form-it">
										<label>Puntuación</label> <select name="score">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
										</select>
									</div>
									<div class="col-md-12 ">
										<input class="submit" type="submit" value="registrar">
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end of celebrity list section-->
	<!-- footer section-->
	<footer class="ht-footer">
		<br></br>
		<div class="container">
			<div class="flex-parent-ft">
				<a><img class="logo" src="/JSPMVC/images/logo1.png" alt=""></a>
				<div class="flex-child-ft item2">
					<br></br>
					<h4>Recursos</h4>
					<ul>
						<li><a href="#">Acerca de</a></li>
						<li><a href="#">Foros</a></li>
						<li><a href="#">Blog</a></li>
						<li><a href="#">Centro de ayuda</a></li>
					</ul>
				</div>
				<div class="flex-child-ft item3">
					<br></br>
					<h4>Legal</h4>
					<ul>
						<li><a href="#">Terminos de uso</a></li>
						<li><a href="#">Pol&iacute;tica de privacidad</a></li>
						<li><a href="#">Seguridad</a></li>
					</ul>
				</div>
				<div class="flex-child-ft item4">
					<br></br>
					<h4>Cuenta</h4>
					<ul>
						<li><a href="#">Mi cuenta</a></li>
						<li><a href="#">Lista de seguimiento</a></li>
						<li><a href="#">Colecciones</a></li>
						<li><a href="#">Gu&iacute;a del usuario</a></li>
					</ul>
				</div>
				<div class="flex-child-ft item5">
					<br></br>
					<h4>Contacto</h4>
					<p>
						Av. de Medina Azahara, 5,<br>14071 C&oacute;rdoba
					</p>
					<p>
						Ll&aacute;manos: <a href="#">(+34) 957 218 000</a>
					</p>
				</div>
			</div>
		</div>
	</footer>
	<!-- end of footer section-->
	<script src="/JSPMVC/js/jquery.js"></script>
	<script src="/JSPMVC/js/plugins.js"></script>
	<script src="/JSPMVC/js/plugins2.js"></script>
	<script src="/JSPMVC/js/custom.js"></script>
	<%
		} else {
			if (customerBean.getTypeUser().equals("Admin")) {
				nextPage = "/mvc/view/adminHome.jsp";
	%>
	<jsp:forward page="<%=nextPage%>">
		<jsp:param value="<%=mensajeNextPage%>" name="message" />
	</jsp:forward>
	<%
		} else {
				nextPage = "../../index.jsp";
	%>
	<jsp:forward page="<%=nextPage%>">
		<jsp:param value="<%=mensajeNextPage%>" name="message" />
	</jsp:forward>
	<%
		}
		}
	%>
</body>

<!-- userfavoritelist14:04-->
</html>