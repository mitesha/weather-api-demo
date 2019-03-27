package com.mitesh.weatherapidemo.service;

import com.mitesh.weatherapidemo.common.WeatherReportEnum;
import com.mitesh.weatherapidemo.model.WeatherReportDTO;

public interface WeatherReportService {
	
	WeatherReportDTO getWeatherReportData(WeatherReportEnum reportEnum, String region, Integer days);
}
