package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

public class MovieListDaoSqlImpl implements MovieDao {

	@Override
	public List<Movie> getMovieListAdmin() throws SQLException {
		List<Movie> movieList = new ArrayList<Movie>();
		String sql = "select * from movie";
		Connection con = ConnectionHandler.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Movie mo = new Movie();
				mo.setId(rs.getInt(1));
				mo.setTitle(rs.getString(2));
				mo.setBoxOffice(rs.getLong(3));
				mo.setActive(rs.getString(4).equalsIgnoreCase("Yes"));
				mo.setDateOfLaunch(rs.getDate(5));
				mo.setGenre(rs.getString(6));
				mo.setHasTeaser(rs.getString(7).equalsIgnoreCase("Yes"));
				movieList.add(mo);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			con.close();
		}
		return movieList;
	}

	@Override
	public List<Movie> getMovieCustomer() throws SQLException {
		List<Movie> customerList = new ArrayList<Movie>();
		String sql = "select * from movie where mo_active='Yes'and mo_date_of_launch<?";
		Connection con = ConnectionHandler.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(3, "Yes");
			ps.setDate(2, new java.sql.Date(System.currentTimeMillis()));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Movie mo = new Movie();
				mo.setId(rs.getInt(1));
				mo.setTitle(rs.getString(2));
				mo.setBoxOffice(rs.getLong(3));
				mo.setActive(rs.getString(4).equalsIgnoreCase("Yes"));
				mo.setDateOfLaunch(rs.getDate(5));
				mo.setGenre(rs.getString(6));
				mo.setHasTeaser(rs.getString(7).equalsIgnoreCase("Yes"));
				customerList.add(mo);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			con.close();
		}
		return customerList;
	}

	@Override
	public void modifyMovie(Movie movie) throws SQLException {
		List<Movie> movieList = new ArrayList<Movie>();
		String sql = "update movie set mo_title='Stree',mo_boxOffice='57375967963',mo_active='Yes',mo_date_Of_launch='2017-07-07',mo_genre='Haunted',mo_has_Teaser='Yes' where mo_id='1'";
		Connection con = ConnectionHandler.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Movie mo = new Movie();
				ps.setString(1, movie.getTitle());
				ps.setLong(2, movie.getBoxOffice());
				ps.setString(6, movie.isActive() ? "Yes" : "No");
				ps.setDate(4, new java.sql.Date(movie.getDateOfLaunch().getTime()));
				ps.setString(5, movie.getGenre());
				ps.setString(6, movie.isHasTeaser() ? "Yes" : "No");
				ps.setLong(7, movie.getId());
                int count=ps.executeUpdate();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			con.close();
		}

	}

	@Override
	public Movie getMovie(long movieId) {
		Movie movieList = new Movie();
		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "select  * from  movie";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Movie mo = new Movie();
				mo.setId(rs.getInt(1));
				mo.setTitle(rs.getString(2));
				mo.setBoxOffice(rs.getLong(3));
				mo.setActive(rs.getString(4).equalsIgnoreCase("Yes"));
				mo.setDateOfLaunch(rs.getDate(5));
				mo.setGenre(rs.getString(6));
				mo.setHasTeaser(rs.getString(7).equalsIgnoreCase("Yes"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return movieList;
	}

}
