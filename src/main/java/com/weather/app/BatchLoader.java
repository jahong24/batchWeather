package com.weather.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BatchLoader {
	
	private static final String URL = "http://api.openweathermap.org/data/2.5/weather?q=";
	private static final String KEY = "&appid=c3e98a7f936a0d72b16a7719e41123ce";

	public List<String> loadFile(String fileName) {

		List<String> contents = new ArrayList<>();

		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			contents = stream.collect(Collectors.toList());
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return contents;
	}
	
	public List<String> loadRequests(List<String> cities) {
		
		List<String> requests = new ArrayList<>();
		
		for (String city : cities) {
			StringBuilder sb = new StringBuilder(URL);
			sb.append(city.replaceAll(" ", "%20")).append(KEY);
			requests.add(sb.toString());
		}
		return requests; 
	}
	
}
