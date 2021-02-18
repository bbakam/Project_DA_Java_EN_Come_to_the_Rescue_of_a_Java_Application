package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private String inputFilePath;
	private String outputFilePath;
	Map<String, Integer> symptomsOccurence = new TreeMap<String, Integer>();

	public static void main(String args[]) throws Exception {

		BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));

		String line = reader.readLine();
		reader.close();
	}
}

// line = reader.readLine(); // get another symptom

// while (line != null) {

// next generate output
// FileWriter writer = new FileWriter("result.out");

// writer.close();
