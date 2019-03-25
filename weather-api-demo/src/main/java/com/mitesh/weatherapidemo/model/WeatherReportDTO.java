package com.mitesh.weatherapidemo.model;

public class WeatherReportDTO {

	private Location location;

	private CurrentWeather current;
	
	private Forecast forecast;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Forecast getForecast() {
		return forecast;
	}

	public void setForecast(Forecast forecast) {
		this.forecast = forecast;
	}

	public CurrentWeather getCurrent() {
		return current;
	}

	public void setCurrent(CurrentWeather current) {
		this.current = current;
	}

}
