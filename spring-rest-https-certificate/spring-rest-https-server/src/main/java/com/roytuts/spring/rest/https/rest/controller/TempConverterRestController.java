package com.roytuts.spring.rest.https.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.roytuts.spring.rest.https.dto.Temperature;
import com.roytuts.spring.rest.https.enums.TemperatureUnit;

@RestController
public class TempConverterRestController {

	@PostMapping("/temperature")
	public ResponseEntity<Temperature> getTemperature(@RequestBody Temperature temperature) {
		Temperature temp = new Temperature();

		if (TemperatureUnit.CELSIUS == temperature.getUnit()) {
			double fahrenheit = (9.0 / 5.0) * temperature.getValue() + 32;

			temp.setValue(fahrenheit);
			temp.setUnit(TemperatureUnit.FAHRENHEIT);
		} else if (TemperatureUnit.FAHRENHEIT == temperature.getUnit()) {
			double celsius = (5.0 / 9.0) * (temperature.getValue() - 32);

			temp.setValue(celsius);
			temp.setUnit(TemperatureUnit.CELSIUS);
		} else {
			throw new IllegalArgumentException("Illegal Argument");
		}

		return new ResponseEntity<Temperature>(temp, HttpStatus.OK);
	}

}
