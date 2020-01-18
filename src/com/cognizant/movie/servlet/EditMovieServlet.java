package com.cognizant.movie.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.dao.MovieListDaoCollectionImpl;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

/**
 * Servlet implementation class EditMovieServlet
 */
@WebServlet({ "/EditMovieServlet", "/EditMovie" })
public class EditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			  long id=Long.parseLong(request.getParameter("id"));
		      String title=request.getParameter("title");
		      long boxOffice=Long.parseLong(request.getParameter("gross"));
		      boolean active=request.getParameter("rb").equalsIgnoreCase("Yes");
		      String dateOfLaunch=request.getParameter("dol");
		      String genre=request.getParameter("genre");
		      boolean hasTeaser=request.getParameter("ch")!=null;
		    
			    Movie item = new Movie(id,title,boxOffice,active,DateUtil.convertToDate(dateOfLaunch),genre,hasTeaser);
				MovieDao movieDao = new MovieListDaoCollectionImpl();
				
				movieDao.modifyMovie(item);
				request.setAttribute("msg","Movie List Edited successfully");
				RequestDispatcher rd=request.getRequestDispatcher("edit-movie-status.jsp");
				rd.forward(request,response);
	          } catch (ParseException | SQLException e) {
				e.printStackTrace();
			}
	}

}

