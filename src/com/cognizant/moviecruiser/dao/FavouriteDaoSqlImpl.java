package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cognizant.moviecruiser.model.Favourite;
import com.cognizant.moviecruiser.model.Movie;

public class FavouriteDaoSqlImpl implements FavouriteDao {

	@Override
	public void addFavouriteList(long userId, long movieId) {
		Connection con = ConnectionHandler.getConnection();

		try {
			String sql = "insert into favorite(fv_us_id,fv_pr_id) values (?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, userId);
			ps.setLong(2, movieId);
			int result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public List<Movie> getAllFavouriteList(long userId) throws FavouriteEmptyException, SQLException {
		Connection con = ConnectionHandler.getConnection();
		Favourite favourite = new Favourite();
		try {
			String sql = "SELECT  mo_id,mo_title ,mo_boxOffice,mo_active,mo_date_of_launch,mo_genre,mo_has_Teaser FROM movie  INNER JOIN favorite ON fv_pr_id=mo_id WHERE fv_us_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, userId);
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
				favourite.getMovieList().add(mo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				con.close();
			}
		return favourite.getMovieList();
	}

	@Override
	public void removeFavouiteList(long userId, long movieId) {
		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "delete from favorite where fv_us_id=? and fv_pr_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, userId);
			ps.setLong(2, movieId);
			int count = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
