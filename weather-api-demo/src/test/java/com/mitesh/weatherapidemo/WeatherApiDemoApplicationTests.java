package com.mitesh.weatherapidemo;

import org.json.JSONException;
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

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WeatherApiDemoApplication.class, 
				webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WeatherApiDemoApplicationTests {

	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherApiDemoApplicationTests.class);
	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();
	
	@Test
	public void testCurrentWeatherReport() throws JSONException {
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		ResponseEntity<CustomResponse> response = restTemplate.exchange(
				createURLWithPort("/current/india"),
				HttpMethod.GET, entity, CustomResponse.class);

		CustomResponse customResponse = response.getBody();
		Assert.assertTrue(customResponse.getStatus().equals("SUCCESS"));
		Assert.assertTrue(customResponse.getData() != null);
	}
	
	private String createURLWithPort(String uri) {
		String url = "http://localhost:" + port + uri;
		LOGGER.info(" URL Generated is {} " ,url);
		return url;
	}
	
	@Test
	public void testForecastReport() throws JSONException {
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		ResponseEntity<CustomResponse> response = restTemplate.exchange(
				createURLWithPort("/forecast/india"),
				HttpMethod.GET, entity, CustomResponse.class);

		CustomResponse customResponse = response.getBody();
		Assert.assertTrue(customResponse.getData() != null);
	}
}
