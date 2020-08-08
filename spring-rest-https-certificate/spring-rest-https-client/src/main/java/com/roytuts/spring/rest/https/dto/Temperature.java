package com.roytuts.spring.rest.https.dto;

import com.roytuts.spring.rest.https.enums.TemperatureUnit;

public class Temperature {

	private double value;
	private TemperatureUnit unit;

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public TemperatureUnit getUnit() {
		return unit;
	}

	public void setUnit(TemperatureUnit unit) {
		this.unit = unit;
	}

}
