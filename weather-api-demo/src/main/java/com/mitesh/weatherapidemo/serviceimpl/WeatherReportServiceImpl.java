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
import com.mitesh.weatherapidemo.config.WeatherApiConfig;
import com.mitesh.weatherapidemo.model.WeatherReportDTO;
import com.mitesh.weatherapidemo.service.WeatherReportService;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherReportServiceImpl.class);

	@Autowired
	private WeatherApiConfig weatherApiConfig;

	public WeatherReportDTO getWeaterForecastReport(String region, Integer days) {
		LOGGER.info("Fetch Weatherforecast report for region {}", region);
		String uri = weatherApiConfig.getBaseUrl() +"/forecast.json?key=" + 
						weatherApiConfig.getKey() + "&q=" + region + "&days="+days;
		ResponseEntity<WeatherReportDTO> response = fetchDataFromApi(uri);
		return response.getBody();
	}

	public WeatherReportDTO getCurrentWeatherReport(String region) {
		LOGGER.info("Fetch Weatherforecast report for region {}", region);
		String uri = weatherApiConfig.getBaseUrl() +"/current.json?key=" 
						+ weatherApiConfig.getKey() + "&q=" + region;
		ResponseEntity<WeatherReportDTO> response = fetchDataFromApi(uri);
		return response.getBody();
	}
	
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
}
