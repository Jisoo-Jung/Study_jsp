package com.app.jdbc.user.vo;

import java.util.Objects;

public class UserVO {
	private Long id;
	private String userName;
	private String userEmail;
	private String userNickname;
	private String userPhone;
	private String userSportKind;
	private String userBirth;
	
	public UserVO() {;}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserSportKind() {
		return userSportKind;
	}

	public void setUserSportKind(String userSportKind) {
		this.userSportKind = userSportKind;
	}

	public String getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", userName=" + userName + ", userEmail=" + userEmail + ", userNickname="
				+ userNickname + ", userPhone=" + userPhone + ", userSportKind=" + userSportKind + ", userBirth="
				+ userBirth + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserVO other = (UserVO) obj;
		return Objects.equals(id, other.id);
	}

}
