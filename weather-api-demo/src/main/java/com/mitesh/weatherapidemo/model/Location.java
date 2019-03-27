package com.mitesh.weatherapidemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {

	private String name;
	private String region;
	private String country;
	private double lat;
	private double lon;
	private String localtime;
	
	@JsonProperty(value="tz_id")
	private String tzId;
	public String getTzId() {
		return tzId;
	}

	public void setTzId(String tzId) {
		this.tzId = tzId;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}

	public String getLocaltime() {
		return localtime;
	}

	public void setLocaltime(String localtime) {
		this.localtime = localtime;
	}

}
