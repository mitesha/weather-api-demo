package com.mitesh.weatherapidemo.service;

import com.mitesh.weatherapidemo.model.WeatherReportDTO;

public interface WeatherReportService {

	WeatherReportDTO getWeaterForecastReport(String region, Integer days);
	
	WeatherReportDTO getCurrentWeatherReport(String region);
}
