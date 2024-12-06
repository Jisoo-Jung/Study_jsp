package com.app.jdbc.place.vo;

import java.util.Objects;

public class PlaceVO {
//	ID NUMBER CONSTRAINT PK_PLACE PRIMARY KEY,
//	   PLACE_DISTRICT VARCHAR2(500) NOT NULL,
//	   PLACE_PRICE NUMBER DEFAULT 0 NOT NULL
	
	private Long id;
	private String placeDistrict;
	private int placePrice;
	
	public PlaceVO() { ; }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaceDistrict() {
		return placeDistrict;
	}

	public void setPlaceDistrict(String placeDistrict) {
		this.placeDistrict = placeDistrict;
	}

	public int getPlacePrice() {
		return placePrice;
	}

	public void setPlacePrice(int placePrice) {
		this.placePrice = placePrice;
	}

	@Override
	public String toString() {
		return "PlaceVO [id=" + id + ", placeDistrict=" + placeDistrict + ", placePrice=" + placePrice + "]";
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
		PlaceVO other = (PlaceVO) obj;
		return Objects.equals(id, other.id);
	}
}
	
	
