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
<!--login form popup-->
<div class="login-wrapper" id="login-content">
    <div class="login-content">
        <a href="#" class="close">x</a>
        <h3>Login</h3>
        <form method="post" action="login">
        	<div class="row">
        		 <label for="useremail">
                    Email:
                    <input type="text" name="email" placeholder="jhond@uco.es" required="required" />
                </label>
        	</div>
           
            <div class="row">
            	<label for="password">
                    Contraseña:
                    <input type="password" name="password" id="password" placeholder="******" required="required" />
                </label>
            </div>
            <div class="row">
            	<div class="remember">
					<div>
						<input type="checkbox" name="remember" value="Remember me"><span>Remember me</span>
					</div>
            	</div>
            </div>
           <div class="row">
           	 <button type="submit">Login</button>
           </div>
        </form>
    </div>
</div>
<!--end of login form popup-->
<!--signup form popup-->
<div class="login-wrapper"  id="signup-content">
    <div class="login-content">
        <a href="#" class="close">x</a>
        <h3>sign up</h3>
        <form method="post" action="register">
            <div class="row">
                 <label for="name">
                    Nombre:
                    <input type="text" name="name" id="username" required="required" />
                </label>
            </div>
            <div class="row">
                 <label for="surname">
                    Apellidos:
                    <input type="text" name="surname" id="usersurname" required="required" />
                </label>
            </div>
            <div class="row">
                 <label for="nick">
                    Nick:
                    <input type="text" name="nick" id="usernick" required="required" />
                </label>
            </div>            
            <div class="row">
                <label for="email">
                    Email:
                    <input type="text" name="email" id="useremail" pattern="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{1,63}$" required="required" />
                </label>
            </div>
             <div class="row">
                <label for="password">
                    Contraseña:
                    <input type="password" name="password" id="userpassword" required="required" />
                </label>
            </div>
           <div class="row">
             <button type="submit">sign up</button>
           </div>
        </form>
    </div>
</div>
<!--end of signup form popup-->

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
						<li class="dropdown first">
							<a class="btn btn-default dropdown-toggle lv1" data-toggle="dropdown" data-hover="dropdown">
							pages <i class="fa fa-angle-down" aria-hidden="true"></i>
							</a>
							<ul class="dropdown-menu level1">
								<li><a href="landing.html">Landing</a></li>
								<li><a href="404.html">404 Page</a></li>
								<li class="it-last"><a href="comingsoon.html">Coming soon</a></li>
							</ul>
						</li>                
						<li><a href="#">Help</a></li>
						<li class="loginLink"><a href="#">LOG In</a></li>
						<li class="btn signupLink"><a href="#">sign up</a></li>
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

<div class="hero common-hero">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="hero-ct">
					<h1>Movie Listing - Grid Fullwidth</h1>
					<ul class="breadcumb">
						<li class="active"><a href="#">Home</a></li>
						<li> <span class="ion-ios-arrow-right"></span> movie listing</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="page-single">
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="topbar-filter fw">
					<p>Found <span>1,608 movies</span> in total</p>
					<label>Sort by:</label>
					<select>
						<option value="popularity">Popularity Descending</option>
						<option value="popularity">Popularity Ascending</option>
						<option value="rating">Rating Descending</option>
						<option value="rating">Rating Ascending</option>
						<option value="date">Release date Descending</option>
						<option value="date">Release date Ascending</option>
					</select>
					<a href="movielist.html" class="list"><i class="ion-ios-list-outline "></i></a>
					<a  href="moviegridfw.html" class="grid"><i class="ion-grid active"></i></a>
				</div>
				<div class="flex-wrap-movielist mv-grid-fw">
						<div class="movie-item-style-2 movie-item-style-1">
							<img src="/JSPMVC/images/uploads/mv1.jpg" alt="">
							<div class="hvr-inner">
	            				<a  href="moviesingle.html"> Read more <i class="ion-android-arrow-dropright"></i> </a>
	            			</div>
							<div class="mv-item-infor">
								<h6><a href="#">oblivion</a></h6>
								<p class="rate"><i class="ion-android-star"></i><span>8.1</span> /10</p>
							</div>
						</div>					
						<div class="movie-item-style-2 movie-item-style-1">
							<img src="/JSPMVC/images/uploads/mv2.jpg" alt="">
							<div class="hvr-inner">
	            				<a  href="moviesingle.html"> Read more <i class="ion-android-arrow-dropright"></i> </a>
	            			</div>
							<div class="mv-item-infor">
								<h6><a href="#">into the wild</a></h6>
								<p class="rate"><i class="ion-android-star"></i><span>7.8</span> /10</p>
							</div>
						</div>					
						<div class="movie-item-style-2 movie-item-style-1">
	            			<img src="/JSPMVC/images/uploads/mv-item3.jpg" alt="">
	            			<div class="hvr-inner">
	            				<a  href="moviesingle.html"> Read more <i class="ion-android-arrow-dropright"></i> </a>
	            			</div>
	            			<div class="mv-item-infor">
	            				<h6><a href="#">Die hard</a></h6>
	            				<p class="rate"><i class="ion-android-star"></i><span>7.4</span> /10</p>
	            			</div>
	            		</div>					
						<div class="movie-item-style-2 movie-item-style-1">
	            			<img src="/JSPMVC/images/uploads/mv-item4.jpg" alt="">
	            			<div class="hvr-inner">
	            				<a  href="moviesingle.html"> Read more <i class="ion-android-arrow-dropright"></i> </a>
	            			</div>
	            			<div class="mv-item-infor">
	            				<h6><a href="#">The walk</a></h6>
	            				<p class="rate"><i class="ion-android-star"></i><span>7.4</span> /10</p>
	            			</div>
	            		</div>
	            		<div class="movie-item-style-2 movie-item-style-1">
							<img src="/JSPMVC/images/uploads/mv3.jpg" alt="">
							<div class="hvr-inner">
	            				<a  href="moviesingle.html"> Read more <i class="ion-android-arrow-dropright"></i> </a>
	            			</div>
							<div class="mv-item-infor">
								<h6><a href="#">blade runner  </a></h6>
								<p class="rate"><i class="ion-android-star"></i><span>7.3</span> /10</p>
							</div>
						</div>
						<div class="movie-item-style-2 movie-item-style-1">
							<img src="/JSPMVC/images/uploads/mv4.jpg" alt="">
							<div class="hvr-inner">
	            				<a  href="moviesingle.html"> Read more <i class="ion-android-arrow-dropright"></i> </a>
	            			</div>
							<div class="mv-item-infor">
								<h6><a href="#">Mulholland pride</a></h6>
								<p class="rate"><i class="ion-android-star"></i><span>7.2</span> /10</p>
							</div>
						</div>
						<div class="movie-item-style-2 movie-item-style-1">
							<img src="/JSPMVC/images/uploads/mv5.jpg" alt="">
							<div class="hvr-inner">
	            				<a  href="moviesingle.html"> Read more <i class="ion-android-arrow-dropright"></i> </a>
	            			</div>
							<div class="mv-item-infor">
								<h6><a href="#">skyfall: evil of boss</a></h6>
								<p class="rate"><i class="ion-android-star"></i><span>7.0</span> /10</p>
							</div>
						</div>
						<div class="movie-item-style-2 movie-item-style-1">
	            			<img src="/JSPMVC/images/uploads/mv-item1.jpg" alt="">
	            			<div class="hvr-inner">
	            				<a  href="moviesingle.html"> Read more <i class="ion-android-arrow-dropright"></i> </a>
	            			</div>
	            			<div class="mv-item-infor">
	            				<h6><a href="#">Interstellar</a></h6>
	            				<p class="rate"><i class="ion-android-star"></i><span>7.4</span> /10</p>
	            			</div>
	            		</div>
	            		<div class="movie-item-style-2 movie-item-style-1">

	            			<img src="/JSPMVC/images/uploads/mv-item2.jpg" alt="">
	            			<div class="hvr-inner">
	            				<a  href="moviesingle.html"> Read more <i class="ion-android-arrow-dropright"></i> </a>
	            			</div>
	            			<div class="mv-item-infor">
	            				<h6><a href="#">The revenant</a></h6>
	            				<p class="rate"><i class="ion-android-star"></i><span>7.4</span> /10</p>
	            			</div>
	            		</div>
	            		<div class="movie-item-style-2 movie-item-style-1">
	            			<img src="/JSPMVC/images/uploads/mv-it10.jpg" alt="">
	            			<div class="hvr-inner">
	            				<a  href="moviesingle.html"> Read more <i class="ion-android-arrow-dropright"></i> </a>
	            			</div>
	            			<div class="mv-item-infor">
	            				<h6><a href="#">harry potter</a></h6>
	            				<p class="rate"><i class="ion-android-star"></i><span>7.4</span> /10</p>
	            			</div>
	            		</div>
						<div class="movie-item-style-2 movie-item-style-1">
	            			<img src="/JSPMVC/images/uploads/mv-it11.jpg" alt="">
	            			<div class="hvr-inner">
	            				<a  href="moviesingle.html"> Read more <i class="ion-android-arrow-dropright"></i> </a>
	            			</div>
	            			<div class="mv-item-infor">
	            				<h6><a href="#">guardians galaxy</a></h6>
	            				<p class="rate"><i class="ion-android-star"></i><span>7.4</span> /10</p>
	            			</div>
	            		</div>
	            		<div class="movie-item-style-2 movie-item-style-1">
	            			<img src="/JSPMVC/images/uploads/mv-it12.jpg" alt="">
	            			<div class="hvr-inner">
	            				<a  href="moviesingle.html"> Read more <i class="ion-android-arrow-dropright"></i> </a>
	            			</div>
	            			<div class="mv-item-infor">
	            				<h6><a href="#">the godfather</a></h6>
	            				<p class="rate"><i class="ion-android-star"></i><span>7.4</span> /10</p>
	            			</div>
	            		</div>
						<div class="movie-item-style-2 movie-item-style-1">
	            			<img src="/JSPMVC/images/uploads/mv-item6.jpg" alt="">
	            			<div class="hvr-inner">
	            				<a  href="moviesingle.html"> Read more <i class="ion-android-arrow-dropright"></i> </a>
	            			</div>
	            			<div class="mv-item-infor">
	            				<h6><a href="#">blue velvet</a></h6>
	            				<p class="rate"><i class="ion-android-star"></i><span>7.4</span> /10</p>
	            			</div>
	            		</div>
	            		<div class="movie-item-style-2 movie-item-style-1">
	            			<img src="/JSPMVC/images/uploads/mv-item7.jpg" alt="">
	            			<div class="hvr-inner">
	            				<a  href="moviesingle.html"> Read more <i class="ion-android-arrow-dropright"></i> </a>
	            			</div>
	            			<div class="mv-item-infor">
	            				<h6><a href="#">gravity</a></h6>
	            				<p class="rate"><i class="ion-android-star"></i><span>7.4</span> /10</p>
	            			</div>
	            		</div>
	            		<div class="movie-item-style-2 movie-item-style-1">
	            			<img src="/JSPMVC/images/uploads/mv-item8.jpg" alt="">
	            			<div class="hvr-inner">
	            				<a  href="moviesingle.html"> Read more <i class="ion-android-arrow-dropright"></i> </a>
	            			</div>
	            			<div class="mv-item-infor">
	            				<h6><a href="#">southpaw</a></h6>
	            				<p class="rate"><i class="ion-android-star"></i><span>7.4</span> /10</p>
	            			</div>
	            		</div>
	            		<div class="movie-item-style-2 movie-item-style-1">
	            			<img src="/JSPMVC/images/uploads/mv-it9.jpg" alt="">
	            			<div class="hvr-inner">
	            				<a  href="moviesingle.html"> Read more <i class="ion-android-arrow-dropright"></i> </a>
	            			</div>
	            			<div class="mv-item-infor">
	            				<h6><a href="#">jurassic park</a></h6>
	            				<p class="rate"><i class="ion-android-star"></i><span>7.4</span> /10</p>
	            			</div>
	            		</div>
	            		<div class="movie-item-style-2 movie-item-style-1">
	            			<img src="/JSPMVC/images/uploads/mv-item9.jpg" alt="">
	            			<div class="hvr-inner">
	            				<a  href="moviesingle.html"> Read more <i class="ion-android-arrow-dropright"></i> </a>
	            			</div>
	            			<div class="mv-item-infor">
	            				<h6><a href="#">the forest</a></h6>
	            				<p class="rate"><i class="ion-android-star"></i><span>7.4</span> /10</p>
	            			</div>
	            		</div>
	            		<div class="movie-item-style-2 movie-item-style-1">
	            			<img src="/JSPMVC/images/uploads/mv-item10.jpg" alt="">
	            			<div class="hvr-inner">
	            				<a  href="moviesingle.html"> Read more <i class="ion-android-arrow-dropright"></i> </a>
	            			</div>
	            			<div class="mv-item-infor">
	            				<h6><a href="#">spectre</a></h6>
	            				<p class="rate"><i class="ion-android-star"></i><span>7.4</span> /10</p>
	            			</div>
	            		</div>
	            		<div class="movie-item-style-2 movie-item-style-1">
	            			<img src="/JSPMVC/images/uploads/mv-item11.jpg" alt="">
	            			<div class="hvr-inner">
	            				<a  href="moviesingle.html"> Read more <i class="ion-android-arrow-dropright"></i> </a>
	            			</div>
	            			<div class="mv-item-infor">
	            				<h6><a href="#">strager things</a></h6>
	            				<p class="rate"><i class="ion-android-star"></i><span>7.4</span> /10</p>
	            			</div>
	            		</div>
	            		<div class="movie-item-style-2 movie-item-style-1">
	            			<img src="/JSPMVC/images/uploads/mv-item12.jpg" alt="">
	            			<div class="hvr-inner">
	            				<a  href="moviesingle.html"> Read more <i class="ion-android-arrow-dropright"></i> </a>
	            			</div>
	            			<div class="mv-item-infor">
	            				<h6><a href="#">la la land</a></h6>
	            				<p class="rate"><i class="ion-android-star"></i><span>7.4</span> /10</p>
	            			</div>
	            		</div>
	            		<div class="movie-item-style-2 movie-item-style-1">
							<img src="/JSPMVC/images/uploads/mv1.jpg" alt="">
							<div class="hvr-inner">
	            				<a  href="moviesingle.html"> Read more <i class="ion-android-arrow-dropright"></i> </a>
	            			</div>
							<div class="mv-item-infor">
								<h6><a href="#">oblivion</a></h6>
								<p class="rate"><i class="ion-android-star"></i><span>8.1</span> /10</p>
							</div>
						</div>					
						<div class="movie-item-style-2 movie-item-style-1">
							<img src="/JSPMVC/images/uploads/mv2.jpg" alt="">
							<div class="hvr-inner">
	            				<a  href="moviesingle.html"> Read more <i class="ion-android-arrow-dropright"></i> </a>
	            			</div>
							<div class="mv-item-infor">
								<h6><a href="#">into the wild</a></h6>
								<p class="rate"><i class="ion-android-star"></i><span>7.8</span> /10</p>
							</div>
						</div>
						
				</div>		
				<div class="topbar-filter">
					<label>Movies per page:</label>
					<select>
						<option value="range">20 Movies</option>
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

<!-- moviegridfw07:38-->
</html>