package com.mitesh.weatherapidemo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.mitesh.weatherapidemo.common.CustomResponse;
import com.mitesh.weatherapidemo.model.WeatherReportDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WeatherApiDemoApplication.class, 
				webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WeatherApiDemoApplicationTests {

	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherApiDemoApplicationTests.class);
	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();
	
	private String createURLWithPort(String uri) {
		String url = "http://localhost:" + port + uri;
		LOGGER.info(" URL Generated is {} " ,url);
		return url;
	}
	
	@Test
	public void testCurrentWeatherReport() {
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		ResponseEntity<CustomResponse> response = restTemplate.exchange(
				createURLWithPort("/today/india"),
				HttpMethod.GET, entity, CustomResponse.class);

		CustomResponse customResponse = response.getBody();
		Assert.assertTrue(customResponse.getStatus().equals("SUCCESS"));
		Assert.assertTrue(customResponse.getData() != null);
		
		WeatherReportDTO reportDTO = customResponse.getData();
		Assert.assertEquals("New Delhi", reportDTO.getLocation().getName());
	}
	
	@Test
	public void testForecastReport() {
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		ResponseEntity<CustomResponse> response = restTemplate.exchange(
				createURLWithPort("/forecast/india?days=5"),
				HttpMethod.GET, entity, CustomResponse.class);

		CustomResponse customResponse = response.getBody();
		Assert.assertTrue(customResponse.getData() != null);
		
		WeatherReportDTO reportDTO = customResponse.getData();
		Assert.assertEquals("New Delhi", reportDTO.getLocation().getName());
		LOGGER.info("Size forecast days {}", reportDTO.getForecast().getForecastday().size());
		Assert.assertTrue(reportDTO.getForecast().getForecastday().size() == 5);
	}
	
	@Test
	public void testForecastReportWithoutDays() {
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		ResponseEntity<CustomResponse> response = restTemplate.exchange(
				createURLWithPort("/forecast/india"),
				HttpMethod.GET, entity, CustomResponse.class);

		CustomResponse customResponse = response.getBody();
		Assert.assertTrue(customResponse.getData() != null);
		
		WeatherReportDTO reportDTO = customResponse.getData();
		Assert.assertEquals("New Delhi", reportDTO.getLocation().getName());
		LOGGER.info("Size forecast days {}", reportDTO.getForecast().getForecastday().size());
		Assert.assertTrue(reportDTO.getForecast().getForecastday().size() == 1);
	}
}
