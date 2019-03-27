package com.mitesh.weatherapidemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DayWeather {

	@JsonProperty(value = "maxtemp_c")
	private double maxtempc;
	@JsonProperty(value = "mintemp_c")
	private double mintempc;
	public double getMaxtempc() {
		return maxtempc;
	}
	public void setMaxtempc(double maxtempc) {
		this.maxtempc = maxtempc;
	}
	public double getMintempc() {
		return mintempc;
	}
	public void setMintempc(double mintempc) {
		this.mintempc = mintempc;
	}
	
}
