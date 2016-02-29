<!DOCTYPE html>
<html lang="en" class="no-js">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title>Welcome: Patient</title>
		<meta name="description" content="Welcome: Patient" />
		<meta name="keywords" content="horizontal menu, microsoft menu, drop-down menu, mega menu, javascript, jquery, simple menu" />
		<meta name="author" content="Codrops" />
		<link rel="shortcut icon" href="fonts/favicon.ico">
		<link rel="stylesheet" type="text/css" href="css/default1.css" />
		<link rel="stylesheet" type="text/css" href="css/component.css" />
		<script src="modernizr.custom.js"></script>
		<style type="text/css">
		.copy {
			text-align: center;
			margin-top: 23em;
			font-size: 15px;
			padding: 2% 0;
			}
		.copy p a {
			color:#D9155C;
			font-size:13px;
			}
		.footer-top {
			padding-top: 2%;
			border-bottom: 1px solid #DADADA
		}
		.copy p a:hover {
			color:#333;
		}
		</style>
	</head>
	<body>
		<div class="container">
			<header class="clearfix">
				<span>Welcome</span>
				<h1>Patient</h1>
				
				<%-- <h1><%= request.getSession().getAttribute("user") %></h1> --%>
				
				<nav>
					
					<a href="plogout.jsp" class="icon-arrow-left" data-info="Logout">Logout</a>
				</nav>
			</header>	
			<div class="main">
				<nav id="cbp-hrmenu" class="cbp-hrmenu">
					<ul>
						<li>
							<a href="#">Appointment</a>
							<div class="cbp-hrsub">
								<div class="cbp-hrsub-inner">
									<div>	
										<h4>Schedule an Appointment</h4>
										<form name="login" method="post" action="javacalender.jsp">
										<ul>
											<li><input type="submit" value="Schedule Appointment" /></li>
										</ul>		
										</form>								
									</div>
									
								</div><!-- /cbp-hrsub-inner -->
							</div><!-- /cbp-hrsub -->
						</li>
						
						<li>
							<a href="#">Prescription</a>
							<div class="cbp-hrsub">
								<div class="cbp-hrsub-inner"> 
								<form name="admin" action="FileDownloadServlet" method="get">
									<div>
										<h4>Download Prescription</h4>
										<ul>											
											<li><input type="submit" name="submit" value="Download"></li>
										</ul>
									</div>
								</form>	
								</div><!-- /cbp-hrsub-inner -->
							</div><!-- /cbp-hrsub -->
						</li>
						<li>
							<a href="#">Profile</a>
							<div class="cbp-hrsub">
								<div class="cbp-hrsub-inner"> 
								<form action="Controller" method="get">
     							   <input type="hidden" name="oper" value="list"/>
									<div>
										<h4>Edit Profile</h4>
										<ul>											
											<li><input type="submit" name="submit" value="Edit Profile"></li>
										</ul>
									</div>
								</form>	
								</div><!-- /cbp-hrsub-inner -->
							</div><!-- /cbp-hrsub -->
						</li>
						
					</ul>
				</nav>
			</div>
			<footer>
			<div class="copy">
				<p>Design by <a href="#">Dhaval<sup>&copy;</sup> Aakash<sup>&copy;</sup></a></p>
			</div>
			</footer>
		</div>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
		<script src="css/cbpHorizontalMenu.min.js"></script>
		<script>
			$(function() {
				cbpHorizontalMenu.init();
			});
		</script>
	</body>
</html>
