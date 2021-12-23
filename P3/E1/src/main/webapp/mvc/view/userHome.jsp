<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean  id="customerBean" scope="session" class="es.uco.pw.display.javabean.CustomerBean"></jsp:useBean>
<%@ page import ="java.text.SimpleDateFormat,es.uco.pw.data.dtos.UserDTO,es.uco.pw.business.managers.DataBaseManager,es.uco.pw.business.managers.UserManager,java.util.ArrayList" %>
<!DOCTYPE html>
<!--[if IE 7]>
<html class="ie ie7 no-js" lang="en-US">
<![endif]-->
<!--[if IE 8]>
<html class="ie ie8 no-js" lang="en-US">
<![endif]-->
<!--[if !(IE 7) | !(IE 8)  ]><!-->
<html lang="en" class="no-js">
<%SimpleDateFormat formatter6 = new SimpleDateFormat("dd-MM-yyyy");%>
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
				    <a href="index-2.html"><img class="logo" src="/JSPMVC/images/logo1.png" alt="" width="119" height="58"></a>
			    </div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse flex-parent" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav flex-child-menu menu-left">
						<li class="hidden">
							<a href="#page-top"></a>
						</li>
						<li class="dropdown first">
							<a class="btn btn-default dropdown-toggle lv1" data-toggle="dropdown">
							Home <i class="fa fa-angle-down" aria-hidden="true"></i>
							</a>
							<ul class="dropdown-menu level1">
								<li><a href="index-2.html">Home 01</a></li>
								<li><a href="homev2.html">Home 02</a></li>
								<li><a href="homev3.html">Home 03</a></li>
							</ul>
						</li>
						<li class="dropdown first">
							<a class="btn btn-default dropdown-toggle lv1" data-toggle="dropdown" data-hover="dropdown">
							movies<i class="fa fa-angle-down" aria-hidden="true"></i>
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
						<li class="dropdown first">
							<a class="btn btn-default dropdown-toggle lv1" data-toggle="dropdown" data-hover="dropdown">
							celebrities <i class="fa fa-angle-down" aria-hidden="true"></i>
							</a>
							<ul class="dropdown-menu level1">
								<li><a href="celebritygrid01.html">celebrity grid 01</a></li>
								<li><a href="celebritygrid02.html">celebrity grid 02 </a></li>
								<li><a href="celebritylist.html">celebrity list</a></li>
								<li class="it-last"><a href="celebritysingle.html">celebrity single</a></li>
							</ul>
						</li>
						<li class="dropdown first">
							<a class="btn btn-default dropdown-toggle lv1" data-toggle="dropdown" data-hover="dropdown">
							news <i class="fa fa-angle-down" aria-hidden="true"></i>
							</a>
							<ul class="dropdown-menu level1">
								<li><a href="bloglist.html">blog List</a></li>
								<li><a href="bloggrid.html">blog Grid</a></li>
								<li class="it-last"><a href="blogdetail.html">blog Detail</a></li>
							</ul>
						</li>
						<li class="dropdown first">
							<a class="btn btn-default dropdown-toggle lv1" data-toggle="dropdown" data-hover="dropdown">
							community <i class="fa fa-angle-down" aria-hidden="true"></i>
							</a>
							<ul class="dropdown-menu level1">
								<li><a href="userfavoritegrid.html">user favorite grid</a></li>
								<li><a href="userfavoritelist.html">user favorite list</a></li>
								<li><a href="userprofile.html">user profile</a></li>
								<li class="it-last"><a href="userrate.html">user rate</a></li>
							</ul>
						</li>
					</ul>
					<ul class="nav navbar-nav flex-child-menu menu-right">            
						<li><a><%= formatter6.format(new java.util.Date())%></a></li>
					</ul>
				</div>
			<!-- /.navbar-collapse -->
	    </nav>
	    
	    <!-- top search form -->
	    <div class="top-search">
	    	<select>
				<option value="united">TV show</option>
				<option value="saab">Others</option>
			</select>
			<input type="text" placeholder="Search for a movie, TV Show or celebrity that you are looking for">
	    </div>
	</div>
</header>
<!-- END | Header -->

<div class="hero user-hero">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="hero-ct">
					<h1>Edward kennedy’s profile</h1>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="page-single userfav_list">
	<div class="container">
		<div class="row ipad-width2">
			<div class="col-md-3 col-sm-12 col-xs-12">
				<div class="user-information">
					<div class="user-img">
						<a href="#"><img src="/JSPMVC/images/uploads/user-img.png" alt=""><br></a>
						<a href="#" class="redbtn">Change avatar</a>
					</div>
					<div class="user-fav">
						<p>Account Details</p>
						<ul>
							<li><a href="userprofile.html">Profile</a></li>
							<li class="active"><a href="userfavoritelist.html">Favorite movies</a></li>
							<li><a href="userrate.html">Rated movies</a></li>
						</ul>
					</div>
					<div class="user-fav">
						<p>Others</p>
						<ul>
							<li><a href="#">Change password</a></li>
							<li><a href="#">Log out</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-md-9 col-sm-12 col-xs-12">
				<div class="topbar-filter user">
					<p>Found <span>1,608 movies</span> in total</p>
					<label>Sort by:</label>
					<select>
						<option value="range">-- Choose option --</option>
						<option value="saab">-- Choose option 2--</option>
					</select>
					<a href="userfavoritelist.html" class="list"><i class="ion-ios-list-outline active"></i></a>
					<a  href="userfavoritegrid.html" class="grid"><i class="ion-grid "></i></a>
				</div>
				<div class="flex-wrap-movielist user-fav-list">
					<div class="movie-item-style-2">
						<img src="/JSPMVC/images/uploads/mv1.jpg" alt="">
						<div class="mv-item-infor">
							<h6><a href="#">oblivion <span>(2012)</span></a></h6>
							<p class="rate"><i class="ion-android-star"></i><span>8.1</span> /10</p>
							<p class="describe">Earth's mightiest heroes must come together and learn to fight as a team if they are to stop the mischievous Loki and his alien army from enslaving humanity...</p>
							<p class="run-time"> Run Time: 2h21’    .     <span>MMPA: PG-13 </span>    .     <span>Release: 1 May 2015</span></p>
							<p>Director: <a href="#">Joss Whedon</a></p>
							<p>Stars: <a href="#">Robert Downey Jr.,</a> <a href="#">Chris Evans,</a> <a href="#">  Chris Hemsworth</a></p>
						</div>
					</div>
					<div class="movie-item-style-2">
						<img src="/JSPMVC/images/uploads/mv2.jpg" alt="">
						<div class="mv-item-infor">
							<h6><a href="#">into the wild <span>(2014)</span></a></h6>
							<p class="rate"><i class="ion-android-star"></i><span>7.8</span> /10</p>
							<p class="describe">As Steve Rogers struggles to embrace his role in the modern world, he teams up with a fellow Avenger and S.H.I.E.L.D agent, Black Widow, to battle a new threat...</p>
							<p class="run-time"> Run Time: 2h21’    .     <span>MMPA: PG-13 </span>    .     <span>Release: 1 May 2015</span></p>
							<p>Director: <a href="#">Anthony Russo,</a><a href="#">Joe Russo</a></p>
							<p>Stars: <a href="#">Chris Evans,</a> <a href="#">Samuel L. Jackson,</a> <a href="#">  Scarlett Johansson</a></p>
						</div>
					</div>
					<div class="movie-item-style-2">
						<img src="/JSPMVC/images/uploads/mv3.jpg" alt="">
						<div class="mv-item-infor">
							<h6><a href="#">blade runner  <span>(2015)</span></a></h6>
							<p class="rate"><i class="ion-android-star"></i><span>7.3</span> /10</p>
							<p class="describe">Armed with a super-suit with the astonishing ability to shrink in scale but increase in strength, cat burglar Scott Lang must embrace his inner hero and help...</p>
							<p class="run-time"> Run Time: 2h21’    .     <span>MMPA: PG-13 </span>    .     <span>Release: 1 May 2015</span></p>
							<p>Director: <a href="#">Peyton Reed</a></p>
							<p>Stars: <a href="#">Paul Rudd,</a> <a href="#"> Michael Douglas</a></p>
						</div>
					</div>
					<div class="movie-item-style-2">
						<img src="/JSPMVC/images/uploads/mv4.jpg" alt="">
						<div class="mv-item-infor">
							<h6><a href="#">Mulholland pride<span> (2013)  </span></a></h6>
							<p class="rate"><i class="ion-android-star"></i><span>7.2</span> /10</p>
							<p class="describe">When Tony Stark's world is torn apart by a formidable terrorist called the Mandarin, he starts an odyssey of rebuilding and retribution.</p>
							<p class="run-time"> Run Time: 2h21’    .     <span>MMPA: PG-13 </span>    .     <span>Release: 1 May 2015</span></p>
							<p>Director: <a href="#">Shane Black</a></p>
							<p>Stars: <a href="#">Robert Downey Jr., </a> <a href="#">  Guy Pearce,</a><a href="#">Don Cheadle</a></p>
						</div>
					</div>
					<div class="movie-item-style-2">
						<img src="/JSPMVC/images/uploads/mv5.jpg" alt="">
						<div class="mv-item-infor">
							<h6><a href="#">skyfall: evil of boss<span> (2013)  </span></a></h6>
							<p class="rate"><i class="ion-android-star"></i><span>7.0</span> /10</p>
							<p class="describe">When Tony Stark's world is torn apart by a formidable terrorist called the Mandarin, he starts an odyssey of rebuilding and retribution.</p>
							<p class="run-time"> Run Time: 2h21’    .     <span>MMPA: PG-13 </span>    .     <span>Release: 1 May 2015</span></p>
							<p>Director: <a href="#">Alan Taylor</a></p>
							<p>Stars: <a href="#">Chris Hemsworth,  </a> <a href="#">  Natalie Portman,</a><a href="#">Tom Hiddleston</a></p>
						</div>
					</div>
				</div>		
				<div class="topbar-filter">
					<label>Movies per page:</label>
					<select>
						<option value="range">5 Movies</option>
						<option value="saab">10 Movies</option>
					</select>
					
					<div class="pagination2">
						<span>Page 1 of 2:</span>
						<a class="active" href="#">1</a>
						<a href="#">2</a>
						<a href="#">3</a>
						<a href="#">...</a>
						<a href="#">78</a>
						<a href="#">79</a>
						<a href="#"><i class="ion-arrow-right-b"></i></a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- footer section-->
<footer class="ht-footer">
	<div class="container">
		<div class="flex-parent-ft">
			<div class="flex-child-ft item1">
				 <a href="index-2.html"><img class="logo" src="/JSPMVC/images/logo1.png" alt=""></a>
				 <p>5th Avenue st, manhattan<br>
				New York, NY 10001</p>
				<p>Call us: <a href="#">(+01) 202 342 6789</a></p>
			</div>
			<div class="flex-child-ft item2">
				<h4>Resources</h4>
				<ul>
					<li><a href="#">About</a></li> 
					<li><a href="#">Blockbuster</a></li>
					<li><a href="#">Contact Us</a></li>
					<li><a href="#">Forums</a></li>
					<li><a href="#">Blog</a></li>
					<li><a href="#">Help Center</a></li>
				</ul>
			</div>
			<div class="flex-child-ft item3">
				<h4>Legal</h4>
				<ul>
					<li><a href="#">Terms of Use</a></li> 
					<li><a href="#">Privacy Policy</a></li>	
					<li><a href="#">Security</a></li>
				</ul>
			</div>
			<div class="flex-child-ft item4">
				<h4>Account</h4>
				<ul>
					<li><a href="#">My Account</a></li> 
					<li><a href="#">Watchlist</a></li>	
					<li><a href="#">Collections</a></li>
					<li><a href="#">User Guide</a></li>
				</ul>
			</div>
			<div class="flex-child-ft item5">
				<h4>Newsletter</h4>
				<p>Subscribe to our newsletter system now <br> to get latest news from us.</p>
				<form action="#">
					<input type="text" placeholder="Enter your email...">
				</form>
				<a href="#" class="btn">Subscribe now <i class="ion-ios-arrow-forward"></i></a>
			</div>
		</div>
	</div>
	<div class="ft-copyright">
		<div class="ft-left">
			<p><a target="_blank" href="https://www.templateshub.net">Templates Hub</a></p>
		</div>
		<div class="backtotop">
			<p><a href="#" id="back-to-top">Back to top  <i class="ion-ios-arrow-thin-up"></i></a></p>
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