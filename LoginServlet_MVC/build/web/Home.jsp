<%-- 
    Document   : JSP2
    Created on : Sep 22, 2009, 3:39:59 PM
    Author     : spring
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>CW</title>
        <jsp:useBean id="ub" class="mbs.myBean" scope="session" />
    </head>
    <body>
        <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="#active"><a href="#home">Home</a></li>
		<li><a href="LogoutServlet">Logout</a></li>
      </ul>
    </div>
  </div>
</nav>
    
    <div class="container">
  
  <div class="text-center">
    <h2>Welcome
        <jsp:getProperty name="ub" property="name" />
        </h2>
    <p class="lead">Your Login status is  <jsp:getProperty name="ub" property="status" /> </p>
  </div>
  
</div><!-- /.container -->
    </body>
</html>
