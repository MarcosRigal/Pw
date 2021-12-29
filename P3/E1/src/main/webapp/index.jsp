<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="customerBean" scope="session"
	class="es.uco.pw.display.javabean.CustomerBean"></jsp:useBean>
<%@ page
	import="java.text.SimpleDateFormat,es.uco.pw.data.dtos.UserDTO,es.uco.pw.business.managers.DataBaseManager,es.uco.pw.business.managers.UserManager,java.util.ArrayList"%>
<!DOCTYPE html>
<!--[if IE 7]>
<html class="ie ie7 no-js" lang="en-US">
<![endif]-->
<!--[if IE 8]>
<html class="ie ie8 no-js" lang="en-US">
<![endif]-->
<!--[if !(IE 7) | !(IE 8)  ]><!-->
<html lang="en" class="no-js">

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
			String properties = application.getInitParameter("properties");
			java.io.InputStream myIO = application
					.getResourceAsStream(properties);
			DataBaseManager dataBaseManager = DataBaseManager.getInstance(
					application.getInitParameter("url"),
					application.getInitParameter("user"),
					application.getInitParameter("password"), myIO);
			dataBaseManager.getConnected();
			if (customerBean == null || customerBean.getEmailUser().equals("")) {
		%>
	</div>
	<!--end of preloading-->
	<!--login form popup-->
	<div class="login-wrapper" id="login-content">
		<div class="login-content">
			<a href="#" class="close">x</a>
			<h3>Inicie sesión</h3>
			<form autocomplete="off" method="post" action="login">
				<input autocomplete="off" name="hidden" type="text"
					style="display: none;">
				<div class="row">
					<label for="useremail"> Email: <input type="text"
						name="email" required="required" />
					</label>
				</div>

				<div class="row">
					<label for="password"> Contraseña: <input type="password"
						name="password" required="required" />
					</label>
				</div>
				<div class="row">
					<div class="remember">
						<div>
							<input type="checkbox" name="remember" value="Remember me"><span>Recuérdame</span>
						</div>
						<a class="btn signupLink" href="#">Regístrate</a>
					</div>
				</div>
				<div class="row">
					<button type="submit">Acceder</button>
				</div>
			</form>
		</div>
	</div>
	<!--end of login form popup-->
	<!--signup form popup-->
	<div class="login-wrapper" id="signup-content">
		<div class="login-content">
			<a href="#" class="close">x</a>
			<h3>Regístrese</h3>
			<form method="post" autocomplete="off" action="register">
				<input autocomplete="off" name="hidden" type="text"
					style="display: none;"> <input autocomplete="off"
					name="type" type="text" value="Spectator" style="display: none;">
				<div class="row">
					<label for="name"> Nombre: <input type="text" name="name"
						required="required" />
					</label>
				</div>
				<div class="row">
					<label for="surname"> Apellidos: <input type="text"
						name="surname" required="required" />
					</label>
				</div>
				<div class="row">
					<label for="nick"> Nick: <input type="text" name="nick"
						required="required" />
					</label>
				</div>
				<div class="row">
					<label for="email"> Email: <input type="text" name="email"
						required="required" />
					</label>
				</div>
				<div class="row">
					<label for="password"> Contraseña: <input type="password"
						name="password" required="required" />
					</label>
				</div>
				<div class="row">
					<button type="submit">Registrarse</button>
				</div>
			</form>
		</div>
	</div>
	<!--end of signup form popup-->

	<!-- BEGIN | Header -->
	<div class="landing-hero">
		<img src="/JSPMVC/images/logo1.png" alt="Logo">
		<h2>GESTIONA LAS REVIEWS DE</h2>
		<h2 class="text-yellow">PELÍCULAS, ESPECTÁCULOS Y SERIES</h2>
		<h2>HECHO POR Y PARA CÓRDOBA</h2>
		<br></br> <a class="redbtn signupLink" href="#" style="color: white">Registrate</a>
		<a class="redbtn loginLink" href="#"
			style="color: white; margin-left: 4em">Inicia sesión</a> <br></br> <br></br>
	</div>
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
						<li><a href="#">Politica de privacidad</a></li>
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
						<li><a href="#">Guia del usuario</a></li>
					</ul>
				</div>
				<div class="flex-child-ft item5">
					<br></br>
					<h4>Contacto</h4>
					<p>
						Av. de Medina Azahara, 5,<br>14071 Córdoba
					</p>
					<p>
						Llámanos: <a href="#">(+34) 957 218 000</a>
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
			if (customerBean.getTypeUser().equals("Spectator")) {
				nextPage = "/mvc/view/userHome.jsp";
	%>
	<jsp:forward page="<%=nextPage%>">
		<jsp:param value="<%=mensajeNextPage%>" name="message" />
	</jsp:forward>
	<%
		} else {
				nextPage = "/mvc/view/adminHome.jsp";
	%>
	<jsp:forward page="<%=nextPage%>">
		<jsp:param value="<%=mensajeNextPage%>" name="message" />
	</jsp:forward>
	<%
		}
		}
	%>
</body>

<!-- landing14:38-->
</html>