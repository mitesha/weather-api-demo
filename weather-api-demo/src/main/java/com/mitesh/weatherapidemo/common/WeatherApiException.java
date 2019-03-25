package com.mitesh.weatherapidemo.common;

public class WeatherApiException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4142709527356178735L;
	
	public WeatherApiException(String message) {
		super(message);
	}

}
