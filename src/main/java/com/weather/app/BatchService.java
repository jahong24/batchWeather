package com.weather.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.model.WeatherResponse;

public class BatchService {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	public String process(WeatherResponse weather) throws JsonProcessingException {

		Response response = new Response();
		response.setCity(weather.getName());
		response.setDescription(weather.getWeather().get(0).getDescription());
		response.setCurrent(WeatherUtils.convertToFarenheit(weather.getMain().getTemp()));
		response.setHigh(WeatherUtils.convertToFarenheit(weather.getMain().getTempMax()));
		response.setLow(WeatherUtils.convertToFarenheit(weather.getMain().getTempMin()));
		String jsonString = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(response);

		return jsonString;
	}

}
