<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient Register</title>
<style type="text/css">

body {
	font-family: "Times New Roman", Times, serif;
	background-image: url("6.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	
}

.container {
font-size: 1.1em;
font-weight: 600;
width: 60%;
position: absolute;
margin-top: 2em;
margin-left: 5em;
color:#122255;

}

.pure-button {
    background: #505f89 none repeat scroll 0 0;
    border: medium none;
    color: #fff;
    font-size: 16px;
    height: 35px;
    margin-bottom: -2%;
    margin-left: 2em;
    margin-top: 6%;
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
    margin-bottom: -2%;
    margin-left: 2em;
    margin-top: 6%;
    width: 110px;
	cursor:pointer;
	border:1px thin #505f89;
}



input[type="text"], input[type="password"], .states {
    width: 100px;
	height: 22px;
	font-size: 0.65em;
	margin-right:5px;
	margin-bottom:3px;
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
margin-left: 25em;
color: #600000;
}
/*=======New CSS====*/
fieldset {
    background: rgba(240,240,240, 0.8) none repeat scroll 0 0;
	margin-bottom: 1%;
	
}
legend {
    background: rgba(255, 255, 255, 0.6) none repeat scroll 0 0;
    border: 1px solid #000;
	color: #82163f;
	padding:3px;
}


</style>

<script>
function register_user()
{
	var VisiterFName=document.getElementById("txtFName").value; 
	var VisiterLName=document.getElementById("txtLName").value;
	var VisiterSSN=document.getElementById("SSN").value;  
	
	var VisiterDOBMonth=document.getElementById("DOBMonth").value;
	var VisiterDOBDay=document.getElementById("DOBDay").value;
	var VisiterDOBYear=document.getElementById("DOBYear").value;

	var VisiterAge=document.getElementById("Age").value;
	var VisiterAddress=document.getElementById("txtarAddress").value;
	var VisiterCity=document.getElementById("City").value;
	var VisiterStates=document.getElementById("cboStates").value;
	var VisiterEmail=document.getElementById("txtEmail").value;
	var VisiterPassword=document.getElementById("txtPassword").value;
	
	var VisiterEmgFName=document.getElementById("EmgFName").value; 
	var VisiterEmgLName=document.getElementById("EmgLName").value;
	var VisiterRealtion=document.getElementById("txtRelation").value;
	var Visitermobile=document.getElementById("txtContact").value;  
	
	var VisiterPhyName=document.getElementById("txtPhyName").value;  
	var VisiterHeight=document.getElementById("txtHeight").value;  
	var Visiterweight=document.getElementById("txtWeight").value;  

	var VisiterBloodGroup=document.getElementById("BloodGroup").value;
	var VisiterMedication=document.getElementById("txtMedication").value;
	

	if(VisiterFName=="" || VisiterFName==" "|| VisiterFName=="Username*" )
	{
	 alert("Please enter your first name");  /*uneFName - this is id from font div*/
		return false;
	}
	if(!isNaN(VisiterFName))
	{
		alert("Please enter your proper First name");
		return false;
	}
	if(VisiterLName=="" || VisiterLName==" "|| VisiterLName=="Enter Last Name*" )
	{
	 alert("Please enter your Last name");  
		return false;
	}
	if(!isNaN(VisiterLName))
	{
		alert("Please enter your proper Last name");
		return false;
	}
	if(VisiterSSN=="" || VisiterSSN==" "|| VisiterSSN=="SSN*" )
	{
		alert("Please Enter SSN");
		return false;
	}
	if(isNaN(VisiterSSN)|| VisiterSSN.indexOf(" ")!=-1)
	{
		alert("SSN must be in numerics only");
		return false;
	}
	if(VisiterDOBMonth=="" || VisiterDOBMonth==" " || VisiterDOBMonth==" - Month - ")
	{
	 alert("Please Enter your Birth Month");  
		return false;
	}
	if(VisiterDOBDay=="" || VisiterDOBDay==" " || VisiterDOBDay==" - Day - ")
	{
	 alert("Please Enter your Birth Day date");  
		return false;
	}
	if(VisiterDOBYear=="" || VisiterDOBYear==" " || VisiterDOBYear==" - Year - ")
	{
	 alert("Please Enter your Birth year");  
		return false;
	}
	if(VisiterAge=="" || VisiterAge==" " || VisiterAge=="Enter Age")
	{
	alert("Please Enter the Age");  
		return false;
	}
	if(isNaN(VisiterAge)|| VisiterAge.indexOf(" ")!=-1)
	{
		alert("Age must be in numerics only");
		return false;
	}
	if (VisiterAge.length > 2 )
	{
	alert("Please Enter proper Age(e.g 28)");
		return false;
	}
	if(VisiterAddress=="" || VisiterAddress==" " || VisiterAddress=="Enter Address")
	{
	 alert("Please Enter your Address");  
		return false;
	}
	if(VisiterCity=="" || VisiterCity==" " || VisiterCity=="Enter City")
	{
	 alert("Please Enter your City");  
		return false;
	}
	if(VisiterStates=="" || VisiterStates==" "|| VisiterStates=="Select")
	{
	alert("Please Select State");  
		return false;
	}
	if(VisiterEmail=="" || VisiterEmail==" "|| VisiterEmail=="Enter E-mail")
	{
		alert("Please enter your email address");
		return false;
	}
	else
	{
		var atpos=VisiterEmail.indexOf("@");
		var dotpos=VisiterEmail.lastIndexOf(".");
		if (atpos<1 || dotpos<atpos+2 || dotpos+2>=VisiterEmail.length)
		{
			alert("You entered invalid e-mail address");
			return false;
		}	
	}
	if(VisiterPassword=="" || VisiterPassword==" "|| VisiterPassword=="Enter Password")
	{
	 alert("Please Enter Password");  
		return false;
	}
	if(VisiterEmgFName=="" || VisiterEmgFName==" "|| VisiterEmgFName=="Username*" )
	{
	 alert("Please enter your first name in Emergency Contact");  /*uneFName - this is id from font div*/
		return false;
	}
	if(!isNaN(VisiterEmgFName))
	{
		alert("Please enter your proper First name in Emergency Contact");
		return false;
	}
	if(VisiterEmgLName=="" || VisiterEmgLName==" "|| VisiterEmgLName=="Enter Last Name*" )
	{
	 alert("Please enter your Last name in Emergency Contact");  
		return false;
	}
	if(!isNaN(VisiterEmgLName))
	{
		alert("Please enter your proper Last name in Emergency Contact");
		return false;
	}
	if(VisiterRealtion=="" || VisiterRealtion==" " || VisiterRealtion=="Enter Relationship")
	{
	 alert("Please Enter your Relationship");  
		return false;
	}
	if(Visitermobile=="" || Visitermobile==" "|| Visitermobile=="Enter Contact No" )
	{
		alert("Please Enter Your Mobile number");
		return false;
	}
	if(isNaN(Visitermobile)|| Visitermobile.indexOf(" ")!=-1)
	{
		alert("mobile Number must be in numerics only");
		return false;
	}
	if(VisiterPhyName=="" || VisiterPhyName==" "|| VisiterPhyName=="Physian Name" )
	{
	 alert("Please enter your Phsian name");  /*uneFName - this is id from font div*/
		return false;
	}
	if(!isNaN(VisiterPhyName))
	{
		alert("Please enter proper Physian name");
		return false;
	}
	if(VisiterHeight=="" || VisiterHeight==" "|| VisiterHeight=="Enter Height" )
	{
		alert("Please Enter Your height in cm");
		return false;
	}
	if(isNaN(VisiterHeight)|| VisiterHeight.indexOf(" ")!=-1)
	{
		alert("Height must be in numerics only");
		return false;
	}
	if(Visiterweight=="" || Visiterweight==" "|| Visiterweight=="Enter Weight" )
	{
		alert("Please Enter Weight");
		return false;
	}
	if(isNaN(Visiterweight)|| Visiterweight.indexOf(" ")!=-1)
	{
		alert("Weight must be in numerics only");
		return false;
	}
	if(VisiterBloodGroup=="" || VisiterBloodGroup==" "|| VisiterBloodGroup=="Select")
	{
	 alert("Please Select your Blood Group");  
		return false;
	}
	if(VisiterMedication=="" || VisiterMedication==" " || VisiterMedication=="Enter Medication")
	{
	alert("Please Enter your Medication");  
		return false;
	}
	var ask = window.confirm("Register Confirmation..");
    if (ask) {
        window.alert("Records successfully added.");

        document.location.href = "plogin.jsp";

    }
	document.getElementById("submit").style.display = 'none';
	
	document.getElementById("submit").style.display = 'none';
	
}
</script>
</head>
<body>
<div class = "container">

<form name="PatientRegistration" onsubmit="return register_user();" action="PregServlet" method="post">
<input type="hidden" name="pagename1" value="register"/>

<fieldset>

<legend>Personal Information</legend>
<table cellpadding="1" cellspacing="1">
<tr>
	<td>First Name</td>
	<td><input type="text" name="txtFName" id="txtFName" placeholder="Enter First Name"/> </td>
	<td>Last Name</td>
	<td><input type="text" name="txtLName" id="txtLName" placeholder="Enter Last Name"/></td>
</tr>
<tr>
	<td>SSN</td>
	<td><input type="text" name="SSN"  id="SSN" placeholder="Enter SSN"/></td>
		<td>Birthdate</td>
	<td>
	<select name="DOBMonth" id="DOBMonth">
	<option value=" - Month - "> - Month - </option>
	<option value="January">January</option>
	<option value="Febuary">Febuary</option>
	<option value="March">March</option>
	<option value="April">April</option>
	<option value="May">May</option>
	<option value="June">June</option>
	<option value="July">July</option>
	<option value="August">August</option>
	<option value="September">September</option>
	<option value="October">October</option>
	<option value="November">November</option>
	<option value="December">December</option>
	</select></td>

<td>	<select name="DOBDay" id="DOBDay">
	<option value=" - Day - "> - Day - </option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
	<option value="6">6</option>
	<option value="7">7</option>
	<option value="8">8</option>
	<option value="9">9</option>
	<option value="10">10</option>
	<option value="11">11</option>
	<option value="12">12</option>
	<option value="13">13</option>
	<option value="14">14</option>
	<option value="15">15</option>
	<option value="16">16</option>
	<option value="17">17</option>
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
	</select></td>

<td>	<select name="DOBYear" id="DOBYear">
	<option value=" - Year - "> - Year - </option>
	<option value="1993">1993</option>
	<option value="1992">1992</option>
	<option value="1991">1991</option>
	<option value="1990">1990</option>
	<option value="1989">1989</option>
	<option value="1988">1988</option>
	<option value="1987">1987</option>
	<option value="1986">1986</option>
	<option value="1985">1985</option>
	<option value="1984">1984</option>
	<option value="1983">1983</option>
	<option value="1982">1982</option>
	<option value="1981">1981</option>
	<option value="1980">1980</option>
	<option value="1979">1979</option>
	<option value="1978">1978</option>
	<option value="1977">1977</option>
	<option value="1976">1976</option>
	<option value="1975">1975</option>
	<option value="1974">1974</option>
	<option value="1973">1973</option>
	<option value="1972">1972</option>
	<option value="1971">1971</option>
	<option value="1970">1970</option>
	<option value="1969">1969</option>
	<option value="1968">1968</option>
	<option value="1967">1967</option>
	<option value="1966">1966</option>
	<option value="1965">1965</option>
	<option value="1964">1964</option>
	<option value="1963">1963</option>
	<option value="1962">1962</option>
	<option value="1961">1961</option>
	<option value="1960">1960</option>
	<option value="1959">1959</option>
	<option value="1958">1958</option>
	<option value="1957">1957</option>
	<option value="1956">1956</option>
	<option value="1955">1955</option>
	<option value="1954">1954</option>
	<option value="1953">1953</option>
	<option value="1952">1952</option>
	<option value="1951">1951</option>
	<option value="1950">1950</option>
	<option value="1949">1949</option>
	<option value="1948">1948</option>
	<option value="1947">1947</option>
	</select></td>

	<td>Age</td>
	<td><input type="text" name="Age" id="Age" placeholder="Enter Age"/></td>
	
	</td>
</tr>	
<tr>
	<td>Gender</td>
	<td><input type="radio" name="rdoGender" id="Male" value="Male"><label for="Male">Male</label><input type="radio" name="rdoGender" id="Female" value="Female"><label for="Female">Female</label></td>
</tr>

<tr>
	<td>Address</td>
	<td>
		<textarea class="txtarAddress" name="txtarAddress" id="txtarAddress" placeholder="Enter Address"></textarea></td>

	
	<td>City</td>
	<td>
		<input type="text" name="city" id="City" placeholder="Enter City"/></td>


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
	</select></td>
</tr>


<tr>
	<td>E-mail</td>
	<td><input type="text" name="txtEmail" id="txtEmail" placeholder="Enter E-mail"></td>
</tr>
<tr>
	<td>Password</td>
	<td><input type="password" name="txtPassword" id="txtPassword" placeholder="Enter Password"></td>
</tr>

</table>
</fieldset>


<fieldset>
<legend>Emergency Contact</legend>
<table cellpadding="1" cellspacing="1">
<tr>
	<td>First Name</td>
	<td><input type="text" name="EtxtFName" id="EmgFName" placeholder="Enter First Name"/></td>
	<td>Last Name</td>
	<td><input type="text" name="EtxtLName" id="EmgLName" placeholder="Enter Last Name"/></td>
</tr>
<tr>
	<td>Relationship</td>
	<td><input type="text" name="Erelationship" id="txtRelation" placeholder="Enter Relationship"/></td>
</tr>
<tr>
	<td>Contact No</td>
	<td><input type="text" name="Econtact" id="txtContact" placeholder="Enter Contact No"/></td>
</tr>
</table>
</fieldset>


<fieldset>

<legend>Medical History</legend>
<table cellpadding="1" cellspacing="1">

<tr>
	<td>Do u have personal physian?</td><td>
	<input type="radio" name="Anyphy" id="Yes" value="Yes"><label for="Yes">Yes</label><input type="radio" name="rdoGender" id="No" value="No"><label for="No">No</label>
	</td>

	<td>Physian Name</td>
	<td><input type="text" name="txtPhyname" id="txtPhyName" placeholder="Physian Name"/></td>
</tr>
<tr>
	<td>Height</td>
	<td>
	<input type="text" name="txtHeight" id="txtHeight" placeholder="Enter Height"/>cm</td>
	<td>&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp&nbsp;&nbsp;Weight</td>
	<td>
	<input type="text" name="txtWeight" id="txtWeight" placeholder="Enter Weight"/>kgs &nbsp;&nbsp;</td>
	
	<td>Blood Group</td>
	<td>
	<select class ="states" name="BloodGroup" id="BloodGroup" placeholder="">
	<option value="Select">Select</option>
                <option value="O+">O+</option>
                <option value="O-">O-</option>
                <option value="A+">A+</option>
                <option value="A-">A-</option>
                <option value="B+">B+</option>
                <option value="B-">B-</option>
                <option value="AB+">AB+</option>	
				<option value="AB-">AB-</option>
	</select>
	<font color='red' size="2px"> 
             <DIV id="uneBloodGroup"> </DIV> 
        </font>
	</td>
</tr>
<tr>
	<td>Current Medication</td>
	<td>
	<textarea class="txtarMedication" name="Medication" id="txtMedication" placeholder="Enter Medication if any"></textarea>
	<font color='red' size="2px"> 
             <DIV id="uneMedication"> </DIV> 
        </font>
	</td>
</tr>
<tr> 
	<td><input type="submit" value="Submit" class ="pure-button" id="submit" onsubmit="return register_user();"> </td> <td><input type="reset" value="Reset" class ="pure-button"></td>
</tr>	

</table>
</fieldset>
</div>
</form>
</div>
</body>
</html>