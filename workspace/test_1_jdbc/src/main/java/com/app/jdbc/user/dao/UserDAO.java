package com.app.jdbc.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.jdbc.user.config.Configuration;
import com.app.jdbc.user.vo.UserVO;

public class UserDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
//전체 회원 조희
	public List<UserVO> selectAll() {
		String query = "SELECT ID, USER_NAME, USER_EMAIL, USER_NICKNAME, USER_PHONE, "
				+ "USER_SPORT_KIND, USER_BIRTH FROM TBL_USER";
		UserVO userVO = null;
		List<UserVO> users = new ArrayList<>();
		try {
			connection = Configuration.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				userVO = new UserVO();
				userVO.setId(resultSet.getLong(1));
				userVO.setUserName(resultSet.getString(2));
				userVO.setUserEmail(resultSet.getString(3));
				userVO.setUserNickname(resultSet.getString(4));
				userVO.setUserPhone(resultSet.getString(5));
				userVO.setUserSportKind(resultSet.getString(6));
				userVO.setUserBirth(resultSet.getString(7));
				userVO.setUserBirth(userVO.getUserBirth().split(" ")[0]);
				users.add(userVO);
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
		return users;
	}
// 회원 추가
	public void insert(UserVO user) {
		String query = "INSERT INTO TBL_USER"
				+ "(ID, USER_NAME, USER_EMAIL, USER_NICKNAME, USER_PHONE, USER_SPORT_KIND, USER_BIRTH) "
				+ "VALUES(SEQ_GUEST.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		try {
			connection = Configuration.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getUserEmail());
			preparedStatement.setString(3, user.getUserNickname());
			preparedStatement.setString(4, user.getUserPhone());
			preparedStatement.setString(5, user.getUserSportKind());
			preparedStatement.setString(6, user.getUserBirth());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("insert(UserVO) SQL 오류");
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
	
//회원 조회
	public UserVO selectById(Long id) {
		String query = "SELECT ID, USER_NAME, USER_EMAIL, USER_NICKNAME, USER_PHONE, USER_SPORT_KIND, USER_BIRTH FROM TBL_USER "
				+ "WHERE ID = ?";
		UserVO userVO = null;
		try {
			connection = Configuration.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				userVO = new UserVO();
				userVO.setId(resultSet.getLong(1));
				userVO.setUserName(resultSet.getString(2));
				userVO.setUserEmail(resultSet.getString(3));
				userVO.setUserNickname(resultSet.getString(4));
				userVO.setUserPhone(resultSet.getString(5));
				userVO.setUserSportKind(resultSet.getString(6));
				userVO.setUserBirth(resultSet.getString(7));
				userVO.setUserBirth(userVO.getUserBirth().split(" ")[0]);
			}
			
		} catch (SQLException e) {
			System.out.println("selectById(Long) SQL 오류");
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
		return userVO;
	}	
	
//	회원 정보 수정
	public void update(UserVO userVO) {
		String query = "UPDATE TBL_USER "
				+ "SET USER_NAME = ?, USER_EMAIL = ?, USER_NICKNAME = ?, USER_PHONE = ?, USER_SPORT_KIND = ?, USER_BIRTH = ? "
				+ "WHERE ID = ?";
		try {
			connection = Configuration.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userVO.getUserName());
			preparedStatement.setString(2, userVO.getUserEmail());
			preparedStatement.setString(3, userVO.getUserNickname());
			preparedStatement.setString(4, userVO.getUserPhone());
			preparedStatement.setString(5, userVO.getUserSportKind());
			preparedStatement.setString(6, userVO.getUserBirth());
			preparedStatement.setLong(7, userVO.getId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("update(userVO) SQL 오류");
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
	
//	회원 정보 삭제
	public void delete(Long id) {
		String query = "DELETE FROM TBL_USER WHERE ID = ?";
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
