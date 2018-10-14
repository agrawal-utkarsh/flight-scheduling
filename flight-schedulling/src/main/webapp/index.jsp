<html>
<head>
<script>
var request;var i=0;
function view()
{
	var date=document.vinform.date.value;
	var time=document.vinform.time.value;
	var name=document.vinform.name.value;
	var phone=document.vinform.phone.value;
	var url="webapi/by/view/"+date
	if(window.XMLHttpRequest)
	{
		request=new XMLHttpRequest();
	}
	
	try
	{
		request.onreadystatechange=getinfo;
		request.open("GET",url,true);
		request.send();
	}
	catch(e)
	{
		alert("unable to connect to server\n");
	}
}
function insert()
{
	var date=document.vinform.date.value;
	var time=document.vinform.time.value;
	var name=document.vinform.name.value;
	var phone=document.vinform.phone.value;
	var url="webapi/by/insert/"+date+"/"+time+"/"+name+"/"+phone;
	if(window.XMLHttpRequest)
	{
		request=new XMLHttpRequest();
	}
	
	try
	{
		request.onreadystatechange=getinfo;
		request.open("GET",url,true);
		request.send();
	}
	catch(e)
	{
		alert("unable to connect to server\n");
	}
	
}
function getinfo()
{
	if(request.readyState==4)
	{
		var val=request.responseText;
		document.getElementById('amit').innerHTML=val;
	}
}
</script>
</head>
<body>
    <h2>flight scheduling</h2>
    <p>1.view using ajax as soon as date and time entered</p>
 	<p>2.implement jaxrs by date</p>
 	<p>looks like view will call servlet which will call jax which will call jdbc, but then what the use of jax</p>
	<p>ans - separation of concerns</p>
	<p>else look like view will call jax. now jax provide url so good(this url can be called by my view as well 
		as 3rd party people) but then view cant be plain html. either jsp or javascript required to handle 
		response of the ajax request which would be json object</p>
	<p>ans - servlet also can provide url just like jax. for now jax is just better. yes javascript is required
			for ajax</p>
	<p>but what the use of servlet as jax can do work of servlet. is it just good code division</p>
	<p>yes, separation of concerns</p>	
    <form name="vinform">
	    <table>
		    <tr>
			    <td>enter your flight date:</td>
			    <td><input type="text" name="date"/></td>
		    </tr>
		    <tr>
		    	<td>enter your flight time:</td>
		    	<td><input type="text" name="time"/></td>
		    </tr>
		    <tr>
		    	<td>enter your name:</td>
		    	<td><input type="text" name="name"/></td>
		    </tr>
		    <tr>
		    	<td>enter your phone no:</td>
		    	<td><input type="text" name="phone"/></td>
		    </tr>
		    <tr>
		    	<td><input type="button" value="view" onClick="view()"/></td>
		    	<td><input type="button" value="insert" onClick="insert()"/></td>
		    </tr>
	    </table>
    </form>
    <span id="amit"></span>
    </body>
</html>
