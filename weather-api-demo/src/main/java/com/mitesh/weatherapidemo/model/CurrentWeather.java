package com.mitesh.weatherapidemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentWeather {

	@JsonProperty(value="wind_dir")
	private String windDir;
	
	@JsonProperty(value="pressure_in")
	private String pressureIn;
	
	@JsonProperty(value="precip_mm")
	private String precipMm;
	private Integer humidity;
	private Integer cloud;
	public Integer getHumidity() {
		return humidity;
	}
	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}
	public Integer getCloud() {
		return cloud;
	}
	public String getWindDir() {
		return windDir;
	}
	public void setWindDir(String windDir) {
		this.windDir = windDir;
	}
	public String getPressureIn() {
		return pressureIn;
	}
	public void setPressureIn(String pressureIn) {
		this.pressureIn = pressureIn;
	}
	public String getPrecipMm() {
		return precipMm;
	}
	public void setPrecipMm(String precipMm) {
		this.precipMm = precipMm;
	}
	public void setCloud(Integer cloud) {
		this.cloud = cloud;
	}
}
