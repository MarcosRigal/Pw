<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean  id="customerBean" scope="session" class="es.uco.pw.display.javabean.CustomerBean"></jsp:useBean>
<%@ page import ="java.text.SimpleDateFormat,es.uco.pw.data.dtos.UserDTO,es.uco.pw.business.managers.DataBaseManager,es.uco.pw.business.managers.UserManager,java.util.ArrayList" %>
<html>
<%SimpleDateFormat formatter6 = new SimpleDateFormat("dd-MM-yyyy");
request.setCharacterEncoding("UTF-8");
SimpleDateFormat formatter5 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
UserManager userManager = UserManager.getInstance();%>
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
    <link rel="stylesheet" href='http://fonts.googleapis.com/css?family=Dosis:400,700,500|Nunito:300,400,600' />
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
    <img class="logo" src="/JSPMVC/images/logo1.png" alt="" width="119" height="58">
    <div id="status">
        <span></span>
        <span></span>
    </div>
</div>
<!--end of preloading-->
<!-- BEGIN | Header -->
<header class="ht-header">
	<div class="container">
		<nav class="navbar navbar-default navbar-custom">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header logo">
				    <div class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					    <span class="sr-only">Toggle navigation</span>
					    <div id="nav-icon1">
							<span></span>
							<span></span>
							<span></span>
						</div>
				    </div>
				    <a href="index-2.html"><img class="logo" src="images/logo1.png" alt="" width="119" height="58"></a>
			    </div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse flex-parent" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav flex-child-menu menu-left">
						<li class="hidden">
							<a href="#page-top"></a>
						</li>
						<li class="dropdown first">
							<a class="btn btn-default dropdown-toggle lv1" data-toggle="dropdown">
							Espect&aacute;culos <i class="fa fa-angle-down" aria-hidden="true"></i>
							</a>
							<ul class="dropdown-menu level1">
								<li><a href="index-2.html">Home 01</a></li>
								<li><a href="homev2.html">Home 02</a></li>
								<li><a href="homev3.html">Home 03</a></li>
							</ul>
						</li>
						<li class="dropdown first">
							<a class="btn btn-default dropdown-toggle lv1" data-toggle="dropdown" data-hover="dropdown">
							Cr&iacute;ticas<i class="fa fa-angle-down" aria-hidden="true"></i>
							</a>
							<ul class="dropdown-menu level1">
								<li class="dropdown">
									<a href="#" class="dropdown-toggle" data-toggle="dropdown" >Movie grid<i class="ion-ios-arrow-forward"></i></a>
									<ul class="dropdown-menu level2">
										<li><a href="moviegrid.html">Movie grid</a></li>
										<li><a href="moviegridfw.html">movie grid full width</a></li>
									</ul>
								</li>			
								<li><a href="movielist.html">Movie list</a></li>
								<li><a href="moviesingle.html">Movie single</a></li>
								<li class="it-last"><a href="seriessingle.html">Series single</a></li>
							</ul>
						</li>
					</ul>
					<ul class="nav navbar-nav flex-child-menu menu-right">
						<li class="loginLink"><a href="#">Cerrar sesi&oacute;n</a></li>
					</ul>
				</div>
			<!-- /.navbar-collapse -->
	    </nav>
	    
	    <!-- top search form -->
	    <div class="top-search">
	    	<select>
				<option value="saab">T&iacute;tulo</option>
				<option value="united">Categor&iacute;a</option>
			</select>
			<input type="text" placeholder="Busque un espect&aacute;culo por t&iacute;tulo o por categor&iacute;a">
	    </div>
	</div>
</header>
<!-- END | Header -->

<div class="hero common-hero">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="hero-ct">
					<h1>Bienvenido de nuevo: <jsp:getProperty property="nickUser" name="customerBean"/></h1>
					<ul class="breadcumb">
						<li class="active"><a href="#">Hoy es: </a></li>
						<li><%= formatter6.format(new java.util.Date())%></li>
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
				<div class="topbar-filter">
					<p class="pad-change">Usuarios del sistema</p>
				</div>
				<%ArrayList<UserDTO> users = userManager.getUsers(); %>
				<div class="row">
					<%for (int i = 0; i < users.size(); i++) {%>
						<div class="col-md-12">
							<div class="ceb-item-style-2">
								<div class="ceb-infor">
									<h2><a href="#"><%= users.get(i).getName() + " " + users.get(i).getSurname()%></a></h2>
									<span><%= users.get(i).getType()%></span>
									<p><%= formatter5.format(users.get(i).getRegisterDate())%></p>
									<p><%= formatter5.format(users.get(i).getLastLogin())%></p>
								</div>
							</div>
						</div>
					<%}%>
				</div>
			</div>
			<div class="col-md-3 col-xs-12 col-sm-12">
				<div class="sidebar">
						<div class="searh-form">
						<h4 class="sb-title">Search celebrity</h4>
						<form class="form-style-1 celebrity-form" action="#">
							<div class="row">
								<div class="col-md-12 form-it">
									<label>Celebrity name</label>
									<input type="text" placeholder="Enter keywords">
								</div>
								<div class="col-md-12 form-it">
									<label>Celebrity Letter</label>
									<select>
									  <option value="range">A</option>
									  <option value="saab">B</option>
									</select>
								</div>
								<div class="col-md-12 form-it">
									<label>Category</label>
									<select>
									  <option value="range">Actress</option>
									  <option value="saab">Others</option>
									</select>
								</div>
								<div class="col-md-12 form-it">
									<label>Year of birth</label>
									<div class="row">
										<div class="col-md-6">
											<select>
											  <option value="range">1970</option>
											  <option value="number">Other</option>
											</select>
										</div>
										<div class="col-md-6">
											<select>
											  <option value="range">1990</option>
											  <option value="number">others</option>
											</select>
										</div>
									</div>
								</div>
								<div class="col-md-12 ">
									<input class="submit" type="submit" value="submit">
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
				 <p>Av. de Medina Azahara, 5,<br>14071 C&oacute;rdoba</p>
				<p>Ll&aacute;manos: <a href="#">(+34) 957 218 000</a></p>
			</div>
		</div>
	</div>
</footer>
<!-- end of footer section-->
<script src="/JSPMVC/js/jquery.js"></script>
<script src="/JSPMVC/js/plugins.js"></script>
<script src="/JSPMVC/js/plugins2.js"></script>
<script src="/JSPMVC/js/custom.js"></script>
</body>

<!-- userfavoritelist14:04-->
</html>