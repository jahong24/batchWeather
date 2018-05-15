package com.weather.app;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class BatchTest {

	private static final BatchLoader BATCH_LOADER = new BatchLoader();
	private static final BatchService BATCH_SERVICE = new BatchService(); 
	private static final RestClient REST_CLIENT = new RestClient();

	public static void main(String args[]) throws IOException {
		String file = "src/main/resources/request.txt";
		List<String> requests = BATCH_LOADER.loadRequests(BATCH_LOADER.loadFile(file));
		
		FileWriter fileWriter = new FileWriter("src/main/resources/info.txt");

		for (String request : requests) {
			try {
				fileWriter.write(BATCH_SERVICE.process(REST_CLIENT.getCurrentWeather(request)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		fileWriter.flush();
		fileWriter.close();
	}
}
