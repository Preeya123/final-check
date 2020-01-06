<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	 <head>
		<title>Edit movie</title>
		<link rel="stylesheet" type="text/css" href="./style/style.css"/>
		<script src="./js/script.js" type="text/javascript"></script>
	 </head>
	 <body>
	  <header>
	  <span id="head">Movie Cruiser</span>
	  <img src="./images/logo.png"/>
	  <a class="cont" href="ShowMovieListAdmin">Movies</a>
	  </header>
	  <div>
	      <h1 class="cont1">Edit Movie</h1>
		  <form name="Form" method="post" action="EditMovie?id=${movie.id}" onsubmit="return validate()">
		  <table class="cont2">
		  <tr rowspan="4">
		  <td>Title</td>
		  </tr>
		  <tr rowspan="4">
		   <td>
			     <input type="textbox" name="title" value="${movieList.title}"/>
			 </td>
		 </tr>
		 <tr>
		    <td>Gross($)</td>
			<td>Active</td>
			<td>Date of Launch</td>
			<td>Genre</td>
		</tr>
		<tr>
		    <td>
			     <input type="text" name="gross" value="${movieList.boxOffice}"/>
			  </td>
			  <td>
			      <input type="radio" name="rb" id="rb1" value="Yes"<c:if test="${movieList.active eq 'true'}">checked</c:if>/>Yes
				  <input type="radio" name="rb" id="rb2" value="Yes"<c:if test="${movieList.active eq 'false'}">checked</c:if>/>No
			  </td>
			  <td>
			    <input type="text" name="dol" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${movieList.dateOfLaunch}"></fmt:formatDate>"/>
			  </td>
			  <td>
			     <select>
				 <option><c:if test="${movieList.genre eq ScienceFiction}"></c:if>ScienceFiction</option>
				 <option><c:if test="${movieList.genre eq SuperHero}"></c:if>SuperHero</option>
				 <option><c:if test="${movieList.genre eq Romance}"></c:if>Romance</option>
				 <option><c:if test="${movieList.genre eq Comedy}"></c:if>Comedy</option>
				 <option><c:if test="${movieList.genre eq Adventure}"></c:if>Adventure</option>
				 <option><c:if test="${movieList.genre eq Thriller}"></c:if>Thriller</option>
				 </select>
			 </td>
			 <tr rowspan="4">
			 <td>
			    <input type="checkbox" name="ch" <c:if test="${movieList.hasTeaser eq 'true'}">checked</c:if>
			    <c:if test="${movieList.hasTeaser eq 'false'}">checked</c:if>/>HasTeaser
			 </td>
			 </tr>
			 <tr>
				<td>
					<input type="Submit" id="cont6" value="Save"/>
				</td>
			 </tr>
			 </table>
			 </form>
		</div>
			<footer class="foot"><h5>Copyright @ 2019</h5></footer>
	 </body>
</html>