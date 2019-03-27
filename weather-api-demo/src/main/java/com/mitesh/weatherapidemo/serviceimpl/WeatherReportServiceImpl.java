package com.mitesh.weatherapidemo.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mitesh.weatherapidemo.common.WeatherApiException;
import com.mitesh.weatherapidemo.common.WeatherReportEnum;
import com.mitesh.weatherapidemo.config.WeatherApiConfig;
import com.mitesh.weatherapidemo.model.WeatherReportDTO;
import com.mitesh.weatherapidemo.service.WeatherReportService;

/**
 * Service Implementation for WeatherReportService.
 * @author miteshanand
 *
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherReportServiceImpl.class);

	@Autowired
	private WeatherApiConfig weatherApiConfig;
	
	private ResponseEntity<WeatherReportDTO> fetchDataFromApi(String uri) {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<WeatherReportDTO> response = restTemplate.exchange(uri, HttpMethod.GET, null,
				new ParameterizedTypeReference<WeatherReportDTO>() {
				});
		LOGGER.info("Status code for forecast API {}", response.getStatusCodeValue());
		if(response.getStatusCode() != HttpStatus.OK) {
			LOGGER.error("Error while fetching data from Weather API");
			throw new WeatherApiException("Error while fetching data from Weather API");  // should handle using custom exception.
		}
		return response;
	}

	@Override
	public WeatherReportDTO getWeatherReportData(WeatherReportEnum reportEnum, String region, Integer days) {
		LOGGER.info("Fetch weather {} report for region {} for days {}",reportEnum, region, days);
		StringBuilder builder = new StringBuilder();
		builder.append(weatherApiConfig.getBaseUrl());
		switch (reportEnum) {
		case FORECAST:
			builder.append("/forecast.json?key=");
			break;
		case TODAY:
			builder.append("/current.json?key=");
			days = WeatherReportEnum.TODAY.getDays(); //make sure no one set days in request
			break;
		default:
			break;
		}
		builder.append(weatherApiConfig.getKey());
		builder.append("&q=");
		builder.append(region);
		builder.append("&days=");
		builder.append(days);
		
		ResponseEntity<WeatherReportDTO> response = fetchDataFromApi(builder.toString());
		return response.getBody();
	}
}
