<!DOCTYPE html>
<html lang="en" class="no-js">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title>Welcome: Nurse</title>
		<meta name="description" content="Welcome: Nurse" />
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
	<script>
	function register_user()
	{
	
        window.alert("Records successfully added.");
        document.location.href = "Nwelcome.jsp";
    }
	function register_user1()
	{
	
        window.alert("The E-mail was sent Successfully.");
        document.location.href = "Nwelcome.jsp";
    }
	</script>
	</head>
	<body>
		<div class="container">
			<header class="clearfix">
				<span>Welcome</span>
				<h1>Nurse</h1>
				<nav>
					
					<a href="nlogout.jsp" class="icon-arrow-left" data-info="Logout">Logout</a>
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
							<a href="#">Send Alert</a>
							<div class="cbp-hrsub">
								<div class="cbp-hrsub-inner"> 
								<form method="post" action="#" enctype="multipart/form-data" onsubmit="return register_user1();">
									<div>
										<h4>Send Alert via Email</h4>
									<table border="0" width="35%" >
           							 
            						<tr>
            					    <td><label><font color="white">Recipient address</font></label> </td>
          					      <td><input type="text" name="recipient" placeholder="Enter Emailid" required="" size="50"/></td>
           						 </tr>
         							  <tr>
           							     <td><label><font color="white">Subject</font></label> </td>
           							     <td><input type="text" name="subject" placeholder="Enter Subject" required="" size="50"/></td>
          							  </tr>
         							   <tr>
         							       <td><label><font color="white">Content</font></label> </td>
         							       <td><textarea rows="10" cols="39" placeholder="Enter Content" required="" name="content"></textarea> </td>
         							   </tr>
         							   <tr>
        							        <td colspan="2" align="center"><input type="submit" value="Send" onsubmit="return register_user1();"/></td>
       							     </tr>
       								 </table>
									</div>
								</form>	
								</div><!-- /cbp-hrsub-inner -->
							</div><!-- /cbp-hrsub -->
						</li>						
						<li>
							<a href="#">Upload</a>
							<div class="cbp-hrsub">
								<div class="cbp-hrsub-inner"> 
								<form action="UploadImageServlet" method="post" enctype="multipart/form-data" onsubmit="return register_user();">
									<div>
										<h4>Scan Report Upload</h4>
										<table border="0">
               						 <tr>
                  				 	 <td><label><font color="white">First Name:</font></label> </td>
               				    	 <td><input type="text" placeholder="Enter FirstName" required="" name="firstName" size="50"/></td>
            			    		</tr>
           						    <tr>
           				        	 <td><label><font color="white">Last Name:</font></label></td>
            			       		 <td><input type="text" placeholder="Enter LastName" required="" name="lastName" size="50"/></td>
         				       		</tr>
         				      	 <tr>
          		        		  <td><label><font color="white">Portrait Photo:</font></label> </td>
         		    	     	  <td><input type="file" name="photo" placeholder="" required="" size="50"/></td>
         		  	   			  </tr>
          		 		   		  <tr>
           		       			  <td colspan="2">
           	    	     	    <input type="submit" value="Save" onsubmit="return register_user();">
           			     	    </td>
           			  		   </tr>
          					  </table>
							</div>
								</form>	
								</div><!-- /cbp-hrsub-inner -->
							</div><!-- /cbp-hrsub -->
						</li>
						<li>
							<a href="#">Profile</a>
							<div class="cbp-hrsub">
								<div class="cbp-hrsub-inner"> 
								<form action="NController" method="get">
     							   <input type="hidden" name="oper" value="list"/>
									<div>
										<h4>Edit Profile</h4>
										<ul>											
											<li><input type="submit" value="Edit Profile"></li>
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
