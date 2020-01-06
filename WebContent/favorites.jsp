<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
     <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Favorites</title>
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
		<h1 class="cont1">Movies</h1>
			   <table class="cont2">
			<tr>
				<th class="title">Title</th>
				<th class="BoxOffice">Box Office</th>
				<th class="genre">Genre</th>
			</tr>
			<c:forEach items="${movieList}" var="x">
			<tr>
				<td class="title">${x.title}</td>
				<td class="boxOffice">${x.boxOffice}</td>
				<td class="genre">${x.genre}</td>
				<td class="hasTeaser"><c:if test="${x.hasTeaser}">Yes</c:if>
					<c:if test="${!x.hasTeaser}">No</c:if></td>
				<td class="action"><a href="RemoveMovie?id=${x.id}">Delete</a></td>
			</tr>
			</c:forEach>
				</table>
					<h3 id="cont12"><b>No. of favorites:${fn.length(movieList)}</b></h3>
		</div>
					<footer><span id="foot">Copyright @ 2019</span></footer>
	 </body>
</html>		
			