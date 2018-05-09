package com.weather.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BatchLoader {

	public static void main(String args[]) {
		String file = "src/main/resources/request.txt";
		System.out.println(loadFile(file));
	}

	public static List<String> loadFile(String fileName) {

		List<String> contents = new ArrayList<>();

		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			contents = stream.collect(Collectors.toList());
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return contents;
	}

}
