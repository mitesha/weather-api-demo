/**
 * 
 */
package com.mitesh.weatherapidemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mitesh.weatherapidemo.common.CustomResponse;
import com.mitesh.weatherapidemo.common.CustomResponseHelper;
import com.mitesh.weatherapidemo.common.WeatherReportEnum;
import com.mitesh.weatherapidemo.model.WeatherReportDTO;
import com.mitesh.weatherapidemo.service.WeatherReportService;

/**
 * This controller is used for weather reports
 * 
 * @author miteshanand
 *
 */
@RestController
public class WeatherReportController {
	
	private static final Logger log = LoggerFactory.getLogger(WeatherReportController.class);

	@Autowired
	private WeatherReportService weatherForecastService;

	/*@GetMapping("/forecast/{region}")
	public CustomResponse forecastReport(@PathVariable String region, @RequestParam(value="days", defaultValue="5") Integer days) {
		log.info("Get forecast report for Region {}", region);
		WeatherReportDTO weatherReportDTO = weatherForecastService.getWeatherForecastReport(region, days);
		CustomResponse customResponse = CustomResponseHelper.getSuccessResponse();
		customResponse.setData(weatherReportDTO);
		return customResponse;
	}
	
	@GetMapping("/current/{region}")
	public CustomResponse currentWeatherReport(@PathVariable String region) {
		log.info("Get forecast report for Region {}", region);
		WeatherReportDTO weatherReportDTO = weatherForecastService.getCurrentWeatherReport(region);
		CustomResponse customResponse = CustomResponseHelper.getSuccessResponse();
		customResponse.setData(weatherReportDTO);
		return customResponse; 
	}*/
	
	@GetMapping("/{weatherType}/{region}")
	public CustomResponse getWeatherReport(@PathVariable WeatherReportEnum weatherType,@PathVariable String region,
			@RequestParam(value = "days", defaultValue = "1") Integer days) {
		log.info("Get forecast report for Region {}", region);
		WeatherReportDTO weatherReportDTO = weatherForecastService.getWeatherReportData(weatherType, region, days);
		CustomResponse customResponse = CustomResponseHelper.getSuccessResponse();
		customResponse.setData(weatherReportDTO);
		return customResponse;
	}
	
	@InitBinder
	public void initBinder(final WebDataBinder webdataBinder) {
		webdataBinder.registerCustomEditor(WeatherReportEnum.class, new WeatherReportEnumConverter());
	}
}
