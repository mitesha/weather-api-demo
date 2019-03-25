package com.mitesh.weatherapidemo.model;

import java.util.List;

public class Forecast {
	public List<Forecastday> getForecastday() {
		return forecastday;
	}

	public void setForecastday(List<Forecastday> forecastday) {
		this.forecastday = forecastday;
	}

	private List<Forecastday> forecastday;
}
