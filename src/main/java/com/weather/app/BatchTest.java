package com.weather.app;

import java.io.IOException;
import java.util.List;

public class BatchTest {
	
	private static final BatchLoader BATCH_LOADER = new BatchLoader();
	private static final RestClient REST_CLIENT = new RestClient();
	
	public static void main(String args[]) {
		String file = "src/main/resources/request.txt";
		List<String> requests = BATCH_LOADER.loadRequests(BATCH_LOADER.loadFile(file));
		try {
			System.out.println(REST_CLIENT.getCurrentWeather(requests));
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
