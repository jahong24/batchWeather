package com.weather.app;

public final class WeatherUtils {

	/**
	 * Convert temperature from kelvin to farenheit and round to nearest degree
	 * 
	 * @param kelvin
	 * @return
	 */
	public static int convertToFarenheit(double kelvin) {
		return (int) Math.round(1.8 * (kelvin - 273.15) + 32);
	}

}
