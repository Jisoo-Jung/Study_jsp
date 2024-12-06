package com.app.jdbc.matching.vo;

import java.util.Objects;

public class MatchingVO {
	private Long id;
	private String matchingStatus;
	
	public MatchingVO() {;}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatchingStatus() {
		return matchingStatus;
	}

	public void setMatchingStatus(String matchingStatus) {
		this.matchingStatus = matchingStatus;
	}

	@Override
	public String toString() {
		return "MatchingVO [id=" + id + ", matchingStatus=" + matchingStatus + "]";
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
		MatchingVO other = (MatchingVO) obj;
		return Objects.equals(id, other.id);
	}
}
