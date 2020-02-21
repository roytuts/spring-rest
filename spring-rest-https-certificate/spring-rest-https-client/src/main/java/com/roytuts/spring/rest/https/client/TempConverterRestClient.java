package com.roytuts.spring.rest.https.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.roytuts.spring.rest.https.dto.Temperature;
import com.roytuts.spring.rest.https.enums.TemperatureUnit;

@Component
public class TempConverterRestClient {

	@Autowired
	private RestTemplate restTemplate;

	public void temperature() {
		Temperature temperature = new Temperature();
		temperature.setValue(32.0);
		temperature.setUnit(TemperatureUnit.CELSIUS);

		// final String url = "http://localhost:8080/temperature";
		final String url = "https://localhost:8443/temperature";

		Temperature temp = restTemplate.postForObject(url, temperature, Temperature.class);

		System.out.println(temp.getValue() + " " + temp.getUnit().name());

		temperature = new Temperature();
		temperature.setValue(89.6);
		temperature.setUnit(TemperatureUnit.FAHRENHEIT);

		temp = restTemplate.postForObject(url, temperature, Temperature.class);

		System.out.println(temp.getValue() + " " + temp.getUnit().name());
	}

}
