package com.app.jdbc.guest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.jdbc.guest.config.Configuration;
import com.app.jdbc.guest.vo.GuestVO;

public class GuestDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

//	전체 게스트 회원 조회
	public List<GuestVO> selectAll() {
		String query = "SELECT ID, GUEST_NAME, GUEST_BIRTH FROM TBL_GUEST";
		GuestVO guestVO = null;
		List<GuestVO> guests = new ArrayList<>();
		try {
			connection = Configuration.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				guestVO = new GuestVO();
				guestVO.setId(resultSet.getLong(1));
				guestVO.setGuestName(resultSet.getString(2));
				guestVO.setGuestBirth(resultSet.getString(3));
				guestVO.setGuestBirth(guestVO.getGuestBirth().split(" ")[0]);
				guests.add(guestVO);
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

		return guests;
	}

//	게스트 회원 추가
	public void insert(GuestVO guest) {
		String query = "INSERT INTO TBL_GUEST(ID, GUEST_NAME, GUEST_BIRTH) " 
				+ "VALUES(SEQ_GUEST.NEXTVAL, ?, ?)";
		try {
			connection = Configuration.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, guest.getGuestName());
			preparedStatement.setString(2, guest.getGuestBirth());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("insert(GuestVO) SQL 오류");
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

//	게스트 회원 조회
	public GuestVO selectById(Long id) {
		String query = "SELECT ID, GUEST_NAME, GUEST_BIRTH FROM TBL_GUEST " 
						+ "WHERE ID = ?";
		GuestVO guestVO = null;
		try {
			connection = Configuration.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				guestVO = new GuestVO();
				guestVO.setId(resultSet.getLong(1));
				guestVO.setGuestName(resultSet.getString(2));
				guestVO.setGuestBirth(resultSet.getString(3));
				guestVO.setGuestBirth(guestVO.getGuestBirth().split(" ")[0]);
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

		return guestVO;
	}

//	게스트 회원 정보 수정
	public void update(GuestVO guestVO) {
		String query = "UPDATE TBL_GUEST SET GUEST_NAME = ?, GUEST_BIRTH = ? WHERE ID = ?";
		try {
			connection = Configuration.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, guestVO.getGuestName());
			preparedStatement.setString(2, guestVO.getGuestBirth());
			preparedStatement.setLong(3, guestVO.getId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("update(GuestVO) SQL 오류");
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

//	게스트 회원 정보 삭제
	public void delete(Long id) {
		String query = "DELETE FROM TBL_GUEST WHERE ID = ?";
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
