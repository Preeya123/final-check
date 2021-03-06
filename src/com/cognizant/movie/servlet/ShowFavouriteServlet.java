package com.cognizant.movie.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.FavouriteDao;
import com.cognizant.moviecruiser.dao.FavouriteDaoCollectionImpl;
import com.cognizant.moviecruiser.dao.FavouriteEmptyException;
import com.cognizant.moviecruiser.model.Movie;



/**
 * Servlet implementation class ShowFavouriteServlet
 */
@WebServlet({ "/ShowFavouriteServlet", "/ShowFavourite" })
public class ShowFavouriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowFavouriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			FavouriteDao favouriteDao = new FavouriteDaoCollectionImpl();
			List<Movie> favouriteList = favouriteDao.getAllFavouriteList(1);
			request.setAttribute("movieList", favouriteList);
			RequestDispatcher rd=request.getRequestDispatcher("favorites.jsp");
			rd.forward(request,response);
		}catch(FavouriteEmptyException | SQLException e) {
			RequestDispatcher rd=request.getRequestDispatcher("favorites-empty.jsp");
		    rd.forward(request,response);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
