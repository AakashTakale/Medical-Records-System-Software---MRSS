<!--%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<style type="text/css">

body {
	font-family: "Times New Roman", Times, serif;
	background-image: url("6.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}

.container {
font-size: 1.15em;
font-weight: 600;
border: 1.3px solid black;
width: 25%;
position: absolute;
margin-top: 4.7em;
margin-left: 21em;
box-shadow: 7px 7px 5px #888888;
opacity: 1;
color: #600000;
}

.pure-button {
	background: #505f89 none repeat scroll 0 0;
    border: medium none;
    color: #fff;
    font-size: 16px;
    height: 35px;
    margin-left: 15%;
  	width: 110px;
	cursor:pointer;
}
.pure-button:hover {
	background: #fff none repeat scroll 0 0;
    border: 1px solid #505f89;
    box-shadow: 4px 4px 5px #505f89;
    color: #505f89;
    font-size: 16px;
    height: 35px;
    margin-left: 15%;
    width: 110px;
	cursor:pointer;
	border:1px thin #505f89;
}

input[type="text"], input[type="password"], .states {
    width: 150px;
	height: 22px;
	font-size: 0.65em;
}
 .txtarAddress{
 font-family: "Times New Roman", Times, serif;
 width: 150px;
 height: 30px;
 font-size: 0.75em;
 }
 
#registration
{
position:absolute;
margin-top: 3em;
margin-left: 34%;
color: #600000;
}

/*====New CSS===*/

form {
	background: rgba(255, 255, 255, 0.5) none repeat scroll 0 0;
	color:#122255;
}
</style>


<!--Copy these script-->
<script>
function register_user()
{
	var VisiterFName=document.getElementById("txtFName").value; /*txtFName-this is id from input field change this during another field..if field is same then no need */
	var VisiterLName=document.getElementById("txtLName").value;
	/*var VisiterGenderM=document.getElementById("gender_Male").value;
	var VisiterGenderF=document.getElementById("gender_Female").value;*/
	var VisiterSpeci=document.getElementById("Specialization").value;
	var VisiterEmail=document.getElementById("txtEmail").value;
	var VisiterPassword=document.getElementById("txtPassword").value;  
	var VisiterStates=document.getElementById("cboStates").value;
	var VisiterAge=document.getElementById("cboAge").value;
	var VisiterAddress=document.getElementById("txtarAddress").value;														
	

	if(VisiterFName=="" || VisiterFName==" "|| VisiterFName=="Enter First Name*" )
	{
	 document.getElementById('uneFName').innerHTML = "Please enter your first name";  /*uneFName - this is id from font div*/
		return false;
	}
	if(!isNaN(VisiterFName))
	{
		document.getElementById('uneFName').innerHTML = "Please enter your proper First name";
		return false;
	}
	
	if(VisiterLName=="" || VisiterLName==" "|| VisiterLName=="Enter Last Name*" )
	{
	 document.getElementById('uneLName').innerHTML = "Please enter your Last name";  
		return false;
	}
	if(!isNaN(VisiterLName))
	{
		document.getElementById('uneLName').innerHTML = "Please enter your proper Last name";
		return false;
	}
	
	/*if(VisiterGenderM.checked) 
	{	
		document.getElementById('uneMale').innerHTML = "Please Select Gender";
		return false;
 		 //Male radio button is checked
	}else if(VisiterGenderF.checked)
	 {	
		document.getElementById('uneFemale').innerHTML = "Please Select Gender";
		return false;
 		 //Female radio button is checked
	}*/
	
	if(VisiterSpeci=="" || VisiterSpeci==" "|| VisiterSpeci=="Select")
	{
	 document.getElementById('uneSpeci').innerHTML = "Please Select Specialization";  
		return false;
	}
	
	if(VisiterEmail=="" || VisiterEmail==" "|| VisiterEmail=="Enter E-mail")
	{
		document.getElementById('uneEmail').innerHTML = "Please enter your email address";
		return false;
	}
	else
	{
		var atpos=VisiterEmail.indexOf("@");
		var dotpos=VisiterEmail.lastIndexOf(".");
		if (atpos<1 || dotpos<atpos+2 || dotpos+2>=VisiterEmail.length)
		{
			document.getElementById('uneEmail').innerHTML = "You entered invalid e-mail address";
			return false;
		}	
	}
	if(VisiterPassword=="" || VisiterPassword==" "|| VisiterPassword=="Enter Password")
	{
	 document.getElementById('unePass').innerHTML = "Please Enter Password";  
		return false;
	}
	if(VisiterStates=="" || VisiterStates==" "|| VisiterStates=="Select")
	{
	 document.getElementById('uneState').innerHTML = "Please Select State";  
		return false;
	}
	
	if(VisiterAge=="" || VisiterAge==" ")
	{
	 document.getElementById('uneAge').innerHTML = "Please Select Your Age";  
		return false;
	}
	if(VisiterAddress=="" || VisiterAddress==" " || VisiterAddress=="Enter Address")
	{
	 document.getElementById('uneAddress').innerHTML = "Please Enter your Address";  
		return false;
	}
	var ask = window.confirm("Register Confirmation..");
    if (ask) {
        window.alert("Records successfully added.");

        document.location.href = "login.jsp";

    }
	document.getElementById("submit").style.display = 'none';

	document.getElementById("submit").style.display = 'none';
}
</script>
</head>
<body>
<h3 id="registration"> Registration Form </h3>
<div class = "container">
<form  method="post"  name="registration" id="Candidate" action="RegServlet" onsubmit="return register_user();">
<input type="hidden" name="pagename" value="register"/>
<table cellpadding="5" cellspacing="7">
<tr>
	<td>First Name</td>
	<td><input name="txtFName" id="txtFName" type="text" placeholder="Enter First Name"/>
    <font color='red' size="2px"> <!--copy this font div after input field-->
        <DIV id="uneFName"> </DIV> 
     </font> 
	</td>
</tr>
<tr>
	<td>Last Name</td>
	<td><input type="text" name="txtLName" id="txtLName" placeholder="Enter Last Name"/>
    	<font color='red' size="2px"> 
             <DIV id="uneLName"> </DIV> 
        </font>
    </td>
</tr>
<tr>
	<td>Gender</td>
	<td><input type="radio" name="rdoGender" id="gender_Male" value="Male"><label for="Male">Male</label>
       <input type="radio" name="rdoGender" id="gender_Female" value="Female"><label for="Female">Female</label></td>
</tr>
<tr>
	<td>Age</td>
	<td>
	<select name="cboAge" id ="cboAge">
		<option value="18">18</option>
		<option value="19">19</option>
		<option value="20">20</option>
		<option value="21">21</option>
		<option value="22">22</option>
		<option value="23">23</option>
		<option value="24">24</option>
		<option value="25">25</option>		
		<option value="26">26</option>
		<option value="27">27</option>
		<option value="28">28</option>
		<option value="29">29</option>
		<option value="30">30</option>
		<option value="31">31</option>
		<option value="32">32</option>
		<option value="33">33</option>
		<option value="34">34</option>
		<option value="35">35</option>
		<option value="36">36</option>
		<option value="37">37</option>
		<option value="38">38</option>
		<option value="39">39</option>
		<option value="40">40</option>
	</select><font color='red' size="2px"> 
             <DIV id="uneAge"> </DIV> 
        </font>
	</td>
</tr>
<tr>
	<td>Specialization</td>
	<td><select class ="states" name="cboSpec" id="Specialization">
	<option value="Select">Select</option>
				<option value="Orthopaedic Surgeon">Orthopaedic Surgeon</option>
                <option value="Cardiologist">Cardiologist</option>
                <option value="Dermatologist">Dermatologist</option>
                <option value="Radiologist">Radiologist</option>
                <option value="General Surgery">General Surgery</option>
                <option value="Gynaecologist">Gynaecologist</option>
		</select>
        <font color='red' size="2px"> 
             <DIV id="uneSpeci"> </DIV> 
        </font></td>
</tr>
<tr>
	<td>E-mail</td>
	<td><input type="text" name="txtEmail" id="txtEmail" placeholder="Enter E-mail">
	<font color='red' size="2px"> 
             <DIV id="uneEmail"> </DIV> 
        </font></td>
</tr>
<tr>
	<td>Password</td>
	<td><input type="password" name="txtPassword" id="txtPassword" placeholder="Enter Password">
	<font color='red' size="2px"> 
             <DIV id="unePass"> </DIV> 
        </font></td>
</tr>
<tr>
	<td>Address</td>
	<td>
		<textarea class="txtarAddress" name="txtarAddress" id="txtarAddress" placeholder="Enter Address"></textarea>
		<font color='red' size="2px"> 
             <DIV id="uneAddress"> </DIV> 
        </font>
	</td>
</tr>
<tr>
	<td>City</td>
	<td>
		<input type="text" name="txtCity"></input>
	</td>
</tr>
<tr>
	<td>State</td>
	<td>
	<select class ="states" name="cboStates" id="cboStates" placeholder="Enter State">
	<option value="Select">Select</option>
                <option value="AL">Alabama</option>
                <option value="AK">Alaska</option>
                <option value="AZ">Arizona</option>
                <option value="AR">Arkansas</option>
                <option value="CA">California</option>
                <option value="CO">Colorado</option>
                <option value="CT">Connecticut</option>
                <option value="DE">Delaware</option>
                <option value="DC">District of Columbia</option>
                <option value="FL">Florida</option>
                <option value="GA">Georgia</option>
                <option value="HI">Hawaii</option>
                <option value="ID">Idaho</option>
                <option value="IL">Illinois</option>
                <option value="IN">Indiana</option>
                <option value="IA">Iowa</option>
                <option value="KA">Kansas</option>
                <option value="KY">Kentucky</option>
                <option value="LA">Louisiana</option>
                <option value="ME">Maine</option>
                <option value="MD">Maryland</option>
                <option value="MA">Massachusetts</option>
                <option value="MI">Michigan</option>
                <option value="MN">Minnesota</option>
                <option value="MO">Missouri</option>
                <option value="MT">Montana</option>
                <option value="NE">Nebraska</option>
                <option value="NV">Nevada</option>
                <option value="NH">New Hampshire</option>
                <option value="NJ">New Jersey</option>
                <option value="NM">New Mexico</option>
                <option value="NY">New York</option>
                <option value="NC">North Carolina</option>
                <option value="ND">North Dakota</option>
                <option value="OH">Ohio</option>
                <option value="OK">Oklahoma</option>
                <option value="OR">Oregon</option>
                <option value="PA">Pennsylvania</option>
                <option value="RI">Rhode Island</option>
                <option value="SC">South Carolina</option>
                <option value="SD">South Dakota</option>
                <option value="TN">Tennessee</option>
                <option value="TX">Texas</option>
                <option value="UT">Utah</option>
                <option value="VT">Vermont</option>
                <option value="VA">Virginia</option>
                <option value="WA">Washington</option>
                <option value="WV">West Virginia</option>
                <option value="WI">Wisconsin</option>
                <option value="WY">Wyoming</option>
	</select><font color='red' size="2px"> 
             <DIV id="uneState"> </DIV> 
        </font>
    </td>
</tr>

<tr> 
	<td><input type="submit" value="Submit" class ="pure-button" id="submit" onsubmit="return register_user();"> </td> <td><input type="reset" value="Reset" class ="pure-button"></td>
</tr>

</table>
</form>
</div>

</body>
</html>
