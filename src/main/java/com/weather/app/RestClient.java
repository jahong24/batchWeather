package com.weather.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.model.Response;

public class RestClient {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	public List<Response> getCurrentWeather(List<String> requests)
			throws InterruptedException, ClientProtocolException, IOException {

		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();

		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();

		List<Response> responses = new ArrayList<Response>();
		CloseableHttpClient client = HttpClients.createDefault();

		// create a thread for each URI
		GetThread[] threads = new GetThread[requests.size()];
		for (int i = 0; i < threads.length; i++) {
			HttpGet httpget = new HttpGet(requests.get(i));
			threads[i] = new GetThread(httpClient, httpget);
		}

		// start the threads
		for (int j = 0; j < threads.length; j++) {
			threads[j].start();
		}

		// join the threads
		for (int j = 0; j < threads.length; j++) {
			threads[j].join();
		}

		/*
		for (String request : requests) {
			HttpGet httpGet = new HttpGet(request);
			CloseableHttpResponse httpResponse = client.execute(httpGet);
			HttpEntity responseEntity = httpResponse.getEntity();
			String responseString = EntityUtils.toString(responseEntity);
			System.out.println(responseString);
			Response response = MAPPER.readValue(responseString, Response.class);
			responses.add(response);
		} */
		return responses;
	}

}
