package com.mitesh.weatherapidemo.model;

public class CurrentWeather {

	private String wind_dir;
	private String pressure_in;
	private String precip_mm;
	private Integer humidity;
	private Integer cloud;
	public String getWind_dir() {
		return wind_dir;
	}
	public void setWind_dir(String wind_dir) {
		this.wind_dir = wind_dir;
	}
	public String getPressure_in() {
		return pressure_in;
	}
	public void setPressure_in(String pressure_in) {
		this.pressure_in = pressure_in;
	}
	public String getPrecip_mm() {
		return precip_mm;
	}
	public void setPrecip_mm(String precip_mm) {
		this.precip_mm = precip_mm;
	}
	public Integer getHumidity() {
		return humidity;
	}
	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}
	public Integer getCloud() {
		return cloud;
	}
	public void setCloud(Integer cloud) {
		this.cloud = cloud;
	}
}
