package com.cognizant.movie.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.FavouriteDao;
import com.cognizant.moviecruiser.dao.FavouriteDaoCollectionImpl;

/**
 * Servlet implementation class RemoveMovieServlet
 */
@WebServlet({ "/RemoveMovieServlet", "/RemoveMovie" })
public class RemoveMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	try {
		FavouriteDao favouriteDao = new FavouriteDaoCollectionImpl();
		long id=Long.parseLong(request.getParameter("id"));
		favouriteDao.removeFavouiteList(1,id);
		request.setAttribute("msg", "Item Remove to Favourites Successfully");
		RequestDispatcher rd=request.getRequestDispatcher("ShowFavourite");
		rd.forward(request,response);
	} catch (Exception e) {
	
		RequestDispatcher rd=request.getRequestDispatcher("favorite-empty");
		rd.forward(request,response);
	}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
