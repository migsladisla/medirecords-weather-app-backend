package com.medirecords.weather;

import com.medirecords.weather.controllers.StatusController;
import com.medirecords.weather.controllers.WeatherController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class WeatherApplicationTests {

	@Autowired
	StatusController statusController;

	@Test
	void health() {
		assertEquals("UP", statusController.getHealthCheckStatus().getBody());
	}
	@Test
	void version() {
		assertEquals( "The current version is 1.0.0", statusController.getApiVersion().getBody());
	}

}
