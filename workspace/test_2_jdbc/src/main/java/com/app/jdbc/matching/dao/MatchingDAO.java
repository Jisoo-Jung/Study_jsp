package com.app.jdbc.matching.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.jdbc.matching.config.Configuration;
import com.app.jdbc.matching.vo.MatchingVO;

public class MatchingDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
//전체 조희
	public List<MatchingVO> selectAll() {
		String query = "SELECT ID, MATCHING_STATUS "
				+ "FROM TBL_MATCHING";
		MatchingVO matchingVO = null;
		List<MatchingVO> matchings = new ArrayList<>();
		
		try {
			connection = Configuration.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				matchingVO = new MatchingVO();
				matchingVO.setId(resultSet.getLong(1));
				matchingVO.setMatchingStatus(resultSet.getString(2));
				matchings.add(matchingVO);
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
		return matchings;
	}

//매칭상태 추가
	public void insert(MatchingVO matching) {
		String query = "INSERT INTO TBL_MATCHING"
				+ "(ID, MATCHING_STATUS) "
				+ "VALUES(SEQ_GUEST.NEXTVAL, ?)";
		try {
			connection = Configuration.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, matching.getMatchingStatus());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("insert(MatchingVO) SQL 오류");
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
	
//매칭상태 조희
	public MatchingVO selectById(Long id) {
		String query = "SELECT ID, MATCHING_STATUS "
				+ "FROM TBL_MATCHING WHERE ID = ?";
		MatchingVO matchingVO = null;
		try {
			connection = Configuration.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				matchingVO = new MatchingVO();
				matchingVO.setId(resultSet.getLong(1));
				matchingVO.setMatchingStatus(resultSet.getString(2));
			}
			
		} catch (SQLException e) {
			System.out.println("selectById(Long) SQL 오류");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("알 수 없는 오류");
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) {
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
		return matchingVO;
	}
	
//매칭 상태 수정
	public void update(MatchingVO matchingVO) {
		String query = "UPDATE TBL_MATCHING "
				+ "SET MATCHING_STATUS = ? "
				+ "WHERE ID = ?";
		
		try {
			connection = Configuration.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, matchingVO.getMatchingStatus());
			preparedStatement.setLong(2, matchingVO.getId());
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("update(matchingVO) SQL 오류");
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
	
//매칭 정보 삭제
	public void delete(Long id) {
		String query = "DELETE FROM TBL_MATCHING WHERE ID = ?";
		
		try {
			connection = Configuration.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, id);
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("delete(Long) SQL 오류");
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
}
