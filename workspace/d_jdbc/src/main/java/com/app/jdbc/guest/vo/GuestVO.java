package com.app.jdbc.guest.vo;

import java.util.Objects;

public class GuestVO {
	private Long id;
	private String guestName;
	private String guestBirth;
	
	public GuestVO() {;}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getGuestBirth() {
		return guestBirth;
	}

	public void setGuestBirth(String guestBirth) {
		this.guestBirth = guestBirth;
	}

	@Override
	public String toString() {
		return "GuestVO [id=" + id + ", guestName=" + guestName + ", guestBirth=" + guestBirth + "]";
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
		GuestVO other = (GuestVO) obj;
		return Objects.equals(id, other.id);
	}
}
