<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Movie List Admin</title>
		<link rel="stylesheet" type="text/css" href="./style/style.css"/>
	</head>
	<body>
	  <header>
	  <span id="head">Movie Cruiser</span>
	  <img src="./images/logo.png"/>
	  <a class="cont" href="ShowMovieListAdmin">Movies</a>
	 </header>
	  <div>
	    <h1 class="cont1">Movies</h1>
		<table class="cont2">
		  <tr>
				<th class="title">Title</th>
				<th class="boxOffice">Box Office</th>
				<th class="active">Active</th>
				<th class="dateOfLaunch">Date of Launch</th>
				<th class="Genre">Genre</th>
				<th class="HasTeaser">Has Teaser</th>
				<th class="action">Action</th>
		  </tr>
		  <c:forEach items="${movieList}" var="movie">
		  <tr>
				<td class="title">${movie.title}</td>
				<td class="boxOffice">${movie.boxOffice}</td>
				<td class="active"><c:if test="${movie.active}">Yes</c:if>
				<c:if test="${!movie.active}">No</c:if></td>
				<td class="date"><fmt:formatDate pattern="dd/MM/yyyy" value="${movie.dateOfLaunch}"></fmt:formatDate></td>
				<td class="Genre">${movie.genre}</td>
				<td class="hasTeaser"><c:if test="${movie.hasTeaser}">Yes</c:if>
				<c:if test="${!movie.hasTeaser}">No</c:if></td>
				<td class="action"><a href="ShowEditMovie?id=${movie.id}">Edit</a></td>
			</tr>
			</c:forEach>
			</table>
			</div>
			<footer><span id="foot">Copyright @ 2019</span></footer>
	  </body>
</html>		
			
			