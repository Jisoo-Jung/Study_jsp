package com.app.jdbc.place.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.jdbc.place.config.Configuration;
import com.app.jdbc.place.vo.PlaceVO;

public class PlaceDAO {
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
//전체 장소 조회
	public List<PlaceVO> selectAll() {
		String query = "SELECT ID, PLACE_DISTRICT, PLACE_PRICE "
				+ "FROM TBL_PLACE";		
		PlaceVO placeVO = null;
		List<PlaceVO> places = new ArrayList<>();
		
		try {
			connection = Configuration.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				placeVO = new PlaceVO();
				placeVO.setId(resultSet.getLong(1));
				placeVO.setPlaceDistrict(resultSet.getString(2));
				placeVO.setPlacePrice(resultSet.getInt(3));
				places.add(placeVO);
			}
		} catch (SQLException e) {
			System.out.println("selectAll() SQL 오류");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("알 수 없는 오류");
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}
		return places;
	}
//장소 추가
	public void insert(PlaceVO place) {
		String query = "INSERT INTO FROM TBL_PLACE (ID, PLACE_DISTRICT, PLACE_PRICE) "
				+ "VALUES(SEQ_GUEST.NEXTVAL, ?, ?)";		
		
		try {
			connection = Configuration.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, place.getPlaceDistrict());
			preparedStatement.setInt(2, place.getPlacePrice());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert(PlaceVO) SQL 오류");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("알 수 없는 오류");
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}
	}
//장소 조회
//장소 수정
//장소 삭제
}
