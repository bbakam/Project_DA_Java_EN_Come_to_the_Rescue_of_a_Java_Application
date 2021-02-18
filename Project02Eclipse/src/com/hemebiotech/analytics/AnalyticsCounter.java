package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private String inputFilePath;
	private String outputFilePath;
	Map<String, Integer> symptomsOccurence = new TreeMap<String, Integer>();
	// TreeMap permet de classer les éléments de ma map dans l'ordre alphabétique

	public void saveResult() {
		try {
			FileWriter writer = new FileWriter(outputFilePath);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public Map<String, Integer> readSymptoms() {
		try (BufferedReader reader = new BufferedReader(new FileReader(this.inputFilePath));) {
			String line = reader.readLine();
			while (line != null) {
				if (symptomsOccurence.containsKey(line)) {
					symptomsOccurence.put(line, symptomsOccurence.get(line) + 1);
				} else {
					symptomsOccurence.put(line, 1);
				}
				line = reader.readLine();
			}
		} catch (IOException e) {
			System.out.println("Le fichier n'a pas pu être lu" + e.getMessage());
		}
		return symptomsOccurence;
	}

	public AnalyticsCounter(String inputFilePath, String outputFilePath) {
		super();
		this.inputFilePath = inputFilePath;
		this.outputFilePath = outputFilePath;
	}
}

// next generate output
// FileWriter writer = new FileWriter("result.out");

// writer.close();
