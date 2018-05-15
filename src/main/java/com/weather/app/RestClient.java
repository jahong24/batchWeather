package com.weather.app;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.model.WeatherResponse;

public class RestClient {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	public WeatherResponse getCurrentWeather(String request) throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(request);
		CloseableHttpResponse httpResponse = client.execute(httpGet);
		HttpEntity responseEntity = httpResponse.getEntity();
		String responseString = EntityUtils.toString(responseEntity);
		WeatherResponse response = MAPPER.readValue(responseString, WeatherResponse.class);

		return response;
	}

}
