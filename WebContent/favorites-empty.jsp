<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Favorites empty</title>
		<link rel="stylesheet" type="text/css" href="./style/style.css"/>
	</head>
	<body>
	  <header>
		<span id="head">Movie Cruiser</span>
		<img src="./images/logo.png"/>
		<a class="cont" href="ShowFavourite">Favorites</a>
		<a class="cont" href="ShowMovieListCustomer">Movies</a>
	  </header>
	  <div>
	      <h1 class="cont1">Favorites</h1>
		  <h3 class="cont9">No items in Favorites. Use'Add to Favorite' option in<a id="cont10" href="ShowMovieListCustomer">Movie List</a></h3>
	  </div>
			<footer><span id="foot">Copyright @ 2019</span></footer>
	 </body>
</html>